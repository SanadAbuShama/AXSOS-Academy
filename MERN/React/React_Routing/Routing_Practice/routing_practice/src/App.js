import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./components/Home";
import Content from "./components/Content";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/:param" element={<Content />} />
        <Route path="/:param/:color/:bgColor" element={<Content />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
