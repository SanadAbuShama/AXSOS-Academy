import React, { useState } from "react";
import axios from "axios";
const ProductForm = () => {
  const [title, setTitle] = useState("");
  const [price, setPrice] = useState("");
  const [desc, setDesc] = useState("");

  const submitHandler = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8000/api/products", { title, price, desc })
      .then((res) => {
        console.log("Response, ", res);
        setTitle("");
        setPrice("");
        setDesc("");
      })
      .catch((err) => console.log("Error, ", err));
  };

  return (
    <div className="row my-5">
      <div className="col-6 offset-3">
        <form onSubmit={submitHandler}>
          <p>
            <input
              placeholder="Title"
              className="form-control"
              type="text"
              value={title}
              onChange={(e) => setTitle(e.target.value)}
            />
          </p>
          <p>
            <input
              className="form-control"
              type="number"
              placeholder="Price"
              value={price}
              onChange={(e) => setPrice(e.target.value)}
            />
          </p>
          <p>
            <input
              className="form-control"
              type="text"
              placeholder="Description"
              value={desc}
              onChange={(e) => setDesc(e.target.value)}
            />
          </p>
          <button className="btn btn-success float-end">Add Product</button>
        </form>
      </div>
    </div>
  );
};

export default ProductForm;
