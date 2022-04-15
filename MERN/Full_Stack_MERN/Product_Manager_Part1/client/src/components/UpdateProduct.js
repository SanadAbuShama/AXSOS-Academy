import axios from "axios";
import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

const UpdateProduct = () => {
  const [title, setTitle] = useState("");
  const [price, setPrice] = useState("");
  const [desc, setDesc] = useState("");
  const { id } = useParams();

  useEffect(() => {
    axios.get(`http://localhost:8000/api/products/${id}`).then((res) => {
      setTitle(res.data.title);
      setPrice(res.data.price);
      setDesc(res.data.description);
    });
  }, [id]);

  const updateProduct = (e) => {
    axios
      .put(`http://localhost:8000/api/products/${id}`, {
        title,
        price,
        desc,
      })
      .then((res) => console.log(res))
      .catch((err) => console.error(err));
  };

  return (
    <div className="row my-5">
      <div className="col-6 offset-3">
        <form onSubmit={updateProduct}>
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
          <button className="btn btn-success float-end">Update Product</button>
        </form>
      </div>
    </div>
  );
};

export default UpdateProduct;
