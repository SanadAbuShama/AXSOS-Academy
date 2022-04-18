import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import {
  TableContainer,
  Table,
  TableHead,
  TableBody,
  TableCell,
  TableRow,
  Paper,
  Box,
} from "@mui/material";
import DeleteButton from "./DeleteButton";
const ContentTable = () => {
  const [players, setPlayers] = useState([]);

  const removeFromDom = (id) => {
    setPlayers(players.filter((player) => player._id !== id));
  };

  useEffect(() => {
    axios
      .get("http://localhost:8000/api/players")
      .then((res) => {
        setPlayers(res.data);
      })
      .catch((err) => console.log(err));
  }, []);
  return (
    <>
      <Box style={{ textAlign: "left" }} mb={3}>
        <span style={{ fontWeight: "bold" }}>List</span> |{" "}
        <Link to="/players/addplayer">Add Player</Link>
      </Box>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Player Name</TableCell>
              <TableCell>Preferred Position</TableCell>
              <TableCell>Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {players.map((player, i) => (
              <TableRow
                key={i}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {player.name}
                </TableCell>
                <TableCell>{player.position}</TableCell>
                <TableCell>
                  <DeleteButton
                    id={player._id}
                    name={player.name}
                    successCallBack={removeFromDom}
                  />
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};

export default ContentTable;
