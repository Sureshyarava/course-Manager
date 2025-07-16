import { createContext, useContext, useEffect, useState } from "react";
import { api } from "../lib/api";
import { useAuth } from "./AuthContext";

const ReviewContext = createContext();
export const useReviews = () => useContext(ReviewContext);

export const ReviewProvider = ({ children }) => {
  const [reviews, setReviews] = useState([]);
  const { user } = useAuth();

  const fetchReviews = async () => {
    if (!user) return;
    const { data } = await api.get(`/api/v1/users/${user.id}`);
    setReviews(data.reviews);
  };

  const addReview = async (courseId, payload) => {
  const { data } = await api.post(`/api/v1/courses/${courseId}/reviews`, payload);
  setReviews((prev) => [data, ...prev]);
};

  useEffect(() => {
    if (user) fetchReviews();
  }, [user]);

  return (
    <ReviewContext.Provider value={{ reviews, addReview, fetchReviews }}>
      {children}
    </ReviewContext.Provider>
  );
};