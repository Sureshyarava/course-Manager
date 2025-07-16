import axios from "axios";

export const api = axios.create({
  baseURL: "http://localhost:8080",
  withCredentials: false,
});

export const setBasicAuth = (username, password) => {
  const token = btoa(`${username}:${password}`);
  api.defaults.headers.common["Authorization"] = `Basic ${token}`;
  localStorage.setItem("basic", token);
};

export const clearBasicAuth = () => {
  delete api.defaults.headers.common["Authorization"];
  localStorage.removeItem("basic");
};


const token = localStorage.getItem("basic");
if (token) api.defaults.headers.common["Authorization"] = `Basic ${token}`;