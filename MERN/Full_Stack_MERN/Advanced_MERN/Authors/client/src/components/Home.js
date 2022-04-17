import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import DeleteButton from "./DeleteButton";
import {
  TableContainer,
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody,
  Paper,
  Button,
} from "@mui/material";

const Home = () => {
  const [authors, setAuthors] = useState([]);

  const removeFromDom = (id) => {
    setAuthors(authors.filter((author) => author._id !== id));
  };

  useEffect(() => {
    axios
      .get("http://localhost:8000/api/authors")
      .then((res) => {
        setAuthors(res.data);
      })
      .catch((err) => console.log(err));
  }, []);

  return (
    <>
      <Link style={{ textDecoration: "none", marginRight: "1rem" }} to="/new">
        <Button size="small" color="primary" variant="outlined">
          Add an Author
        </Button>
      </Link>
      <p className="mt-3">We have quotes by:</p>
      <TableContainer component={Paper}>
        <Table aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Author Name</TableCell>
              <TableCell>Actions Available</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {authors.map((author) => (
              <TableRow
                key={author.name}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {author.name}
                </TableCell>
                <TableCell component="th" scope="row">
                  <Link
                    style={{ textDecoration: "none", marginRight: "1rem" }}
                    to={`/edit/${author._id}`}
                  >
                    <Button size="small" color="secondary" variant="outlined">
                      Edit
                    </Button>
                  </Link>
                  <DeleteButton successCallBack={removeFromDom} id={author._id}>
                    Delete
                  </DeleteButton>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};

export default Home;
