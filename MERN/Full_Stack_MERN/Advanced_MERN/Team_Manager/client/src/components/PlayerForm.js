import React, { useState } from "react";
import { TextField, Button, Grid, Box, Alert } from "@mui/material";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Form = (props) => {
  const [name, setName] = useState("");
  const [position, setPosition] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const submitHandler = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8000/api/players", { name, position })
      .then((res) => {
        console.log("Response, ", res);
        navigate("/players/list");
      })
      .catch((err) => {
        console.log("Error, ", err.response.data.errors.name.message);
        setError(err.response.data.errors.name.message);
      });
  };

  return (
    <>
      <Box style={{ textAlign: "left" }} mb={3}>
        <Link to="/players/list">List</Link> |{" "}
        <span style={{ fontWeight: "bold" }}>Add Player</span>
      </Box>
      {error && (
        <Alert variant="outlined" severity="error">
          {error}
        </Alert>
      )}
      <form onSubmit={submitHandler}>
        <Grid container my={3}>
          <Grid item xs={12}>
            <TextField
              autoComplete="off"
              id="outlined-basic"
              label="Name"
              variant="outlined"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
          </Grid>
        </Grid>
        <Grid container my={3}>
          <Grid item xs={12}>
            <TextField
              autoComplete="off"
              id="outlined-basic"
              label="Preferred Position"
              variant="outlined"
              onChange={(e) => setPosition(e.target.value)}
            />
          </Grid>
        </Grid>
        <Grid container my={3}>
          <Grid item xs={12}>
            <Button
              disabled={name.length >= 2 ? false : true}
              type="submit"
              variant="contained"
              color="success"
            >
              Add
            </Button>
          </Grid>
        </Grid>
      </form>
    </>
  );
};

export default Form;
