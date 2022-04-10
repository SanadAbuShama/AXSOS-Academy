import FormWrapper from "./components/FormWrapper";
import Wrapper from "./components/Wrapper";
import Navbar from "./components/Navbar";
import MyContext from "./context/MyContext";
import React, { useState } from "react";
import "./App.css";

function App() {
  const [name, setName] = useState("");
  return (
    <MyContext.Provider value={{ name, setName }}>
      <Wrapper>
        <Navbar />
        <FormWrapper />
      </Wrapper>
    </MyContext.Provider>
  );
}

export default App;
