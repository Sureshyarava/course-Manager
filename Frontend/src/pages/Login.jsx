import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { Button} from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import {Card} from "@/components/ui/card";

export default function Login() {
  const [form, setForm] = useState({ name: "", password: "" });
  const { login, user } = useAuth();
  const navigate = useNavigate();

  if (user) {
    navigate("/", { replace: true });
    return null;
  }

  const handle = async (e) => {
    e.preventDefault();
    const ok = await login(form.name, form.password);
    if (ok) navigate("/");
  };

  return (
    <div className="flex h-screen items-center justify-center bg-gray-100">
      <Card className="w-full max-sm:w-11/12 sm:w-96 p-6">
        <h2 className="mb-4 text-2xl font-bold">Login</h2>
        <form onSubmit={handle} className="space-y-4">
          <Label>User name</Label>
          <Input
            required
            value={form.name}
            onChange={(e) => setForm({ ...form, name: e.target.value })}
          />
          <Label>Password</Label>
          <Input
            type="password"
            required
            value={form.password}
            onChange={(e) => setForm({ ...form, password: e.target.value })}
          />
          <Button className="w-full">Login</Button>
        </form>
        <p className="mt-4 text-center text-sm">
          No account?{" "}
          <Link to="/register" className="text-blue-600 underline">
            Register
          </Link>
        </p>
      </Card>
    </div>
  );
}