import { createContext, useContext, useState } from "react";
import { api, setBasicAuth, clearBasicAuth } from "../lib/api";

const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);


  const login = async (username, password) => {
    setBasicAuth(username, password);          
    try {
      const { data } = await api.get("/api/v1/me");
      setUser(data);
      return true;
    } catch {
      clearBasicAuth();
      return false;
    }
  };


  const register = async (username, password) => {
    await api.post("/api/v1/register", { name: username, password });
    return login(username, password);          
  };


  const logout = () => {
    clearBasicAuth();
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, login, register, logout }}>
      {children}
    </AuthContext.Provider>
  );
};