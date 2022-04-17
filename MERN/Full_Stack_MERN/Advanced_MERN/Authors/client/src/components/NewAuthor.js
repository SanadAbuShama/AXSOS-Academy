import React, { useState } from "react";
import Form from "./Form";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { Alert, Button } from "@mui/material";
import { Link } from "react-router-dom";
const NewAuthor = () => {
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const createAuthor = (author) => {
    axios
      .post("http://localhost:8000/api/authors", author)
      .then((res) => {
        console.log("Response, ", res);
        navigate("/");
      })
      .catch((err) => {
        console.log("Error, ", err.response.data.errors.name.message);
        setError(err.response.data.errors.name.message);
      });
  };

  return (
    <>
      <Link style={{ textDecoration: "none", marginRight: "1rem" }} to="/">
        <Button size="small" color="primary" variant="outlined">
          Home
        </Button>
      </Link>
      <p className="mt-3">Add new author:</p>
      {error && (
        <Alert variant="outlined" severity="error">
          {error}
        </Alert>
      )}
      <Form submitAction={createAuthor} initialName="" />
    </>
  );
};

export default NewAuthor;
