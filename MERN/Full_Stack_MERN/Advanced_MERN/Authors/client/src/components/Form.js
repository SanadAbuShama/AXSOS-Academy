import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { TextField, Button, Box, Paper } from "@mui/material";
const Form = (props) => {
  const { initialName, submitAction } = props;
  const [name, setName] = useState(initialName);
  const navigate = useNavigate();

  const submitHandler = (e) => {
    e.preventDefault();
    submitAction({ name });
  };

  return (
    <>
      <Paper style={{ padding: "2rem" }}>
        <form onSubmit={submitHandler}>
          <TextField
            id="outlined-basic"
            label="Name"
            variant="outlined"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <Box mt={2}>
            <Button
              style={{ marginRight: "1rem" }}
              type="button"
              variant="outlined"
              color="error"
              onClick={() => navigate("/")}
            >
              Cancel
            </Button>
            <Button type="submit" variant="outlined">
              Submit
            </Button>
          </Box>
        </form>
      </Paper>
    </>
  );
};

export default Form;
