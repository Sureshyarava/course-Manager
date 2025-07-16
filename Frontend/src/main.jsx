import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { AuthProvider } from './contexts/AuthContext.jsx'
import { ReviewProvider } from './contexts/ReviewContext.jsx'
import App from './App.jsx'
import { Toaster } from "react-hot-toast";
import "./tailwind.css";

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <AuthProvider>
      <ReviewProvider>
        <App />
        <Toaster position="top-right" />
      </ReviewProvider>
    </AuthProvider>
  </StrictMode>,
)
