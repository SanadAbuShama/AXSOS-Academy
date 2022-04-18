import Table from "../components/Table";
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import PlayerForm from "../components/PlayerForm";
import Home from "../components/Home";
import GameStatus from "../components/GameStatus";

const Main = () => {
  return (
    <BrowserRouter>
      <Home>
        <Routes>
          <Route path="/players/list" element={<Table />} />
          <Route path="/players/addplayer" element={<PlayerForm />} />
          <Route path="/status/game/:id" element={<GameStatus />} />
        </Routes>
      </Home>
    </BrowserRouter>
  );
};

export default Main;
