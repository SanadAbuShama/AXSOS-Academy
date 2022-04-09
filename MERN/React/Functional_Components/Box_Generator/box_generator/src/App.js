import Form from "./components/Form";
import Boxes from "./components/Boxes";
import "./App.css";
import { useState } from "react";

function App() {
  const [boxes, setBoxes] = useState([]);

  const createBox = (color, dim) => {
    console.log(dim);
    setBoxes([...boxes, { color, dim }]);
  };

  return (
    <div className="App">
      <Form onNewBox={createBox} />
      <Boxes boxes={boxes} />
    </div>
  );
}

export default App;
