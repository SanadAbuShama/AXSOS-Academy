import "./App.css";
import Form from "./components/Form";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Person from "./components/Person";
import Planet from "./components/Planet";
import Starship from "./components/Starship";
function App() {
  return (
    <BrowserRouter>
      <div className="container my-5">
        <Form />
        <Routes>
          <Route path="/people/:id" element={<Person />} />
          <Route path="/planets/:id" element={<Planet />} />
          <Route path="/starships/:id" element={<Starship />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
