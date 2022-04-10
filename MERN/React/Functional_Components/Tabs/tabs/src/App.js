import "./App.css";
import Tabs from "./components/Tabs";

function App() {
  const items = [
    { name: "Item1", content: "This is item 1" },
    { name: "Item2", content: "This is item 2" },
    { name: "Item3", content: "This is item 3" },
  ];
  return (
    <div className="App">
      <Tabs items={items} />
    </div>
  );
}

export default App;
