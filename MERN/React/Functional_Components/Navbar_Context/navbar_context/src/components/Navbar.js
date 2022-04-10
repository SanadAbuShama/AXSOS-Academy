import React, { useContext } from "react";
import MyContext from "../context/MyContext";

const Navbar = () => {
  const context = useContext(MyContext);
  return (
    <nav class="navbar navbar-dark bg-dark">
      <div class="container-fluid">
        <span class="navbar-brand ms-auto mb-0 h1">Hi,{context.name} </span>
      </div>
    </nav>
  );
};

export default Navbar;
