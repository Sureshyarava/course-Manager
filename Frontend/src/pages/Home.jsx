import { useEffect, useState } from "react";
import { api } from "../lib/api";
import { useAuth } from "../contexts/AuthContext";
import { Button} from "@/components/ui/button";
import {Input} from "@/components/ui/input"

export default function Home() {
  const { logout } = useAuth();

 
  const [courses, setCourses] = useState([]);
  const [selectedCourseId, setSelectedCourseId] = useState("");
  const [rating, setRating] = useState(5);

  
  useEffect(() => {
    api.get("/api/v1/courses").then(({ data }) => {
      setCourses(data);
      if (data.length) setSelectedCourseId(data[0].id);
    });
  }, []);

  
  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!selectedCourseId) return;
    await api.post(`/api/v1/courses/${selectedCourseId}/reviews`, {
      rating: Number(rating),
    });
    
    const { data } = await api.get("/api/v1/courses");
    setCourses(data);
    setRating(5);
  };

  
  const selectedCourse = courses.find((c) => c.id === selectedCourseId);

  return (
    <div className="p-6 space-y-6">
      {/* logout */}
      <div className="flex justify-end">
        <Button variant="outline" onClick={logout}>
          Logout
        </Button>
      </div>

      
      <form
        onSubmit={handleSubmit}
        className="flex items-end gap-2 max-w-sm"
      >
        <select
          value={selectedCourseId}
          onChange={(e) => setSelectedCourseId(Number(e.target.value))}
          className="border rounded px-2 py-1"
        >
          {courses.map((c) => (
            <option key={c.id} value={c.id}>
              {c.name}
            </option>
          ))}
        </select>

        <Input
          type="number"
          min="1"
          max="5"
          value={rating}
          onChange={(e) => setRating(e.target.value)}
          className="w-16"
        />

        <Button>Add</Button>
      </form>

      
      {selectedCourse?.reviews?.length ? (
        <div className="space-y-2">
          {selectedCourse.reviews.map((r) => (
            <div
              key={r.id}
              className="flex items-center justify-between w-32 p-2 border rounded shadow"
            >
              <span className="text-xs">Review {r.id}</span>
              <span className="text-yellow-600 font-bold">★ {r.rating}</span>
            </div>
          ))}
        </div>
      ) : (
        <p className="text-sm text-gray-500">No ratings yet for this course.</p>
      )}
    </div>
  );
}