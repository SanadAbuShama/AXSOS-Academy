import React, { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";
import axios from "axios";
import {
  TableContainer,
  Table,
  TableHead,
  TableBody,
  TableCell,
  TableRow,
  Paper,
  Button,
  Grid,
} from "@mui/material";
const GameStatus = () => {
  const { id } = useParams();
  const [players, setPlayers] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8000/api/players")
      .then((res) => {
        setPlayers(res.data);
      })
      .catch((err) => console.log(err));
  }, []);

  const statusUpdate = (player, i, status) => {
    let updatedPlayer = {};

    if (id === "1") {
      updatedPlayer = { ...player, gameOne: status };
    } else if (id === "2") {
      updatedPlayer = { ...player, gameTwo: status };
    } else if (id === "3") {
      updatedPlayer = { ...player, gameThree: status };
    }
    axios
      .put(`http://localhost:8000/api/players/${player._id}`, updatedPlayer)
      .then((res) => {
        updatePlayerInDom(i, status);
        console.log(res);
      })
      .catch((err) => {
        console.error(err);
      });
  };

  const updatePlayerInDom = (i, status) => {
    let playerToChange = players[i];
    if (id === "1") {
      playerToChange.gameOne = status;
    } else if (id === "2") {
      playerToChange.gameTwo = status;
    } else if (id === "3") {
      playerToChange.gameThree = status;
    }

    const newPlayers = [...players];
    newPlayers[i] = playerToChange;
    setPlayers(newPlayers);
  };
  return (
    <>
      <Grid container justifyContent="center">
        {id === "1" ? (
          <h4>Player Status - Game 1</h4>
        ) : id === "2" ? (
          <h4>Player Status - Game 2</h4>
        ) : (
          <h4>Player Status - Game 3</h4>
        )}
      </Grid>
      <Grid container justifyContent="center" spacing={4}>
        <Grid item>
          {id === "1" ? (
            <span style={{ fontWeight: "bold" }}>Game 1</span>
          ) : (
            <Link to="/status/game/1">Game 1</Link>
          )}
        </Grid>
        <Grid item>
          {id === "2" ? (
            <span style={{ fontWeight: "bold" }}>Game 2</span>
          ) : (
            <Link to="/status/game/2">Game 2</Link>
          )}
        </Grid>
        <Grid item>
          {id === "3" ? (
            <span style={{ fontWeight: "bold" }}>Game 3</span>
          ) : (
            <Link to="/status/game/3">Game 3</Link>
          )}
        </Grid>
      </Grid>
      {id === "1" && (
        <TableContainer component={Paper}>
          <Table sx={{ minWidth: 650 }} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell>Player Name</TableCell>
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
                  <TableCell>
                    <Grid container>
                      <Grid item mr={2}>
                        <Button
                          onClick={() => statusUpdate(player, i, "playing")}
                          size="small"
                          variant={
                            player.gameOne === "playing"
                              ? "contained"
                              : "outlined"
                          }
                          color="success"
                        >
                          Playing
                        </Button>
                      </Grid>
                      <Grid item mr={2}>
                        <Button
                          onClick={() => statusUpdate(player, i, "notplaying")}
                          size="small"
                          variant={
                            player.gameOne === "notplaying"
                              ? "contained"
                              : "outlined"
                          }
                          color="error"
                        >
                          Not Playing
                        </Button>
                      </Grid>
                      <Grid item mr={2}>
                        <Button
                          onClick={() => statusUpdate(player, i, "undecided")}
                          size="small"
                          variant={
                            player.gameOne === "undecided"
                              ? "contained"
                              : "outlined"
                          }
                          color="warning"
                        >
                          Undecided
                        </Button>
                      </Grid>
                    </Grid>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      )}
      {id === "2" && (
        <TableContainer component={Paper}>
          <Table sx={{ minWidth: 650 }} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell>Player Name</TableCell>

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
                  <TableCell>
                    <Grid container>
                      <Grid item mr={2}>
                        <Button
                          onClick={() => statusUpdate(player, i, "playing")}
                          size="small"
                          variant={
                            player.gameTwo === "playing"
                              ? "contained"
                              : "outlined"
                          }
                          color="success"
                        >
                          Playing
                        </Button>
                      </Grid>
                      <Grid item mr={2}>
                        <Button
                          onClick={() => statusUpdate(player, i, "notplaying")}
                          size="small"
                          variant={
                            player.gameTwo === "notplaying"
                              ? "contained"
                              : "outlined"
                          }
                          color="error"
                        >
                          Not Playing
                        </Button>
                      </Grid>
                      <Grid item mr={2}>
                        <Button
                          onClick={() => statusUpdate(player, i, "undecided")}
                          size="small"
                          variant={
                            player.gameTwo === "undecided"
                              ? "contained"
                              : "outlined"
                          }
                          color="warning"
                        >
                          Undecided
                        </Button>
                      </Grid>
                    </Grid>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      )}
      {id === "3" && (
        <TableContainer component={Paper}>
          <Table sx={{ minWidth: 650 }} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell>Player Name</TableCell>

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
                  <TableCell>
                    <Grid container>
                      <Grid item mr={2}>
                        <Button
                          onClick={() => statusUpdate(player, i, "playing")}
                          size="small"
                          variant={
                            player.gameThree === "playing"
                              ? "contained"
                              : "outlined"
                          }
                          color="success"
                        >
                          Playing
                        </Button>
                      </Grid>
                      <Grid item mr={2}>
                        <Button
                          onClick={() => statusUpdate(player, i, "notplaying")}
                          size="small"
                          variant={
                            player.gameThree === "notplaying"
                              ? "contained"
                              : "outlined"
                          }
                          color="error"
                        >
                          Not Playing
                        </Button>
                      </Grid>
                      <Grid item mr={2}>
                        <Button
                          onClick={() => statusUpdate(player, i, "undecided")}
                          size="small"
                          variant={
                            player.gameThree === "undecided"
                              ? "contained"
                              : "outlined"
                          }
                          color="warning"
                        >
                          Undecided
                        </Button>
                      </Grid>
                    </Grid>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      )}
    </>
  );
};

export default GameStatus;
