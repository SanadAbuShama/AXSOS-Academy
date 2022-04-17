import React, { useEffect, useState } from "react";
import { useParams, Link, useNavigate } from "react-router-dom";
import Form from "./Form";
import axios from "axios";
import { Alert, Button } from "@mui/material";
const Update = () => {
  const { id } = useParams();
  const [author, setAuthor] = useState("");
  const [loaded, setLoaded] = useState(false);
  const [error, setError] = useState(null);
  const [fetchError, setFetchError] = useState(false);
  const navigate = useNavigate();

  const updateAuthor = (updatedAuthor) => {
    axios
      .put(`http://localhost:8000/api/authors/${id}`, updatedAuthor)
      .then((res) => {
        console.log(res);
        navigate("/");
      })
      .catch((err) => {
        console.error(err);
        setError(err.response.data.errors.name.message);
      });
  };

  useEffect(() => {
    axios
      .get("http://localhost:8000/api/authors/" + id)
      .then((res) => {
        console.log("Response, ", res);
        setAuthor(res.data);
        setLoaded(true);
      })
      .catch((err) => {
        console.log("Error, ", err);
        setFetchError(true);
      });
  }, [id]);
  return (
    <>
      {fetchError ? (
        <Alert variant="outlined" severity="error">
          We're sorry, but we could not find the author you are looking for.
          Would you like to add this author to our database?
          <Link
            style={{ textDecoration: "none", marginLeft: "0.25rem" }}
            to="/new"
          >
            <Button size="small" color="success" variant="outlined">
              Add
            </Button>
          </Link>
        </Alert>
      ) : (
        <>
          <Link style={{ textDecoration: "none", marginRight: "1rem" }} to="/">
            <Button size="small" color="primary" variant="outlined">
              Home
            </Button>
          </Link>
          <p className="mt-3">Edit this author:</p>
          {error && (
            <Alert variant="outlined" severity="error">
              {error}
            </Alert>
          )}
          {loaded && (
            <Form submitAction={updateAuthor} initialName={author.name} />
          )}
        </>
      )}
    </>
  );
};

export default Update;
