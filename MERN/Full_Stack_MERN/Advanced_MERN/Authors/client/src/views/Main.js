import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "../components/Home";
import Update from "../components/Update";
import NewAuthor from "../components/NewAuthor";
const Main = () => {
  return (
    <div className="container my-5">
      <div className="row justify-content-center">
        <div className="col-4  text-start">
          <h4>Favorite Authors</h4>
          <BrowserRouter>
            <Routes>
              <Route path="/new" element={<NewAuthor />} />
              <Route path="/" element={<Home />} />
              <Route path="/edit/:id" element={<Update />} />
            </Routes>
          </BrowserRouter>
        </div>
      </div>
    </div>
  );
};

export default Main;
