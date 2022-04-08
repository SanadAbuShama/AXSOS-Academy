import PersonCard from "./components/PersonCard";
import "./App.css";

function App() {
  return (
    <div className="App">
      <PersonCard
        firstName="Sanad"
        lastName="Abu Shama"
        age={24}
        hairColor="Black"
      />
      <PersonCard
        firstName="Ahmad"
        lastName="Abdelqader"
        age={27}
        hairColor="Black"
      />
      <PersonCard
        firstName="Mahmoud"
        lastName="Jamil"
        age={29}
        hairColor="Black"
      />
      <PersonCard
        firstName="Chandler"
        lastName="Bing"
        age={28}
        hairColor="Brown"
      />
    </div>
  );
}

export default App;
