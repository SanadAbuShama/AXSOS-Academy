import axios from "axios";
import React from "react";
import { Link } from "react-router-dom";
const ProductsList = (props) => {
  const deleteProduct = (id) => {
    axios
      .delete(`http://localhost:8000/api/products/${id}`)
      .then((res) => {
        console.log(res);
        props.removeFromDom(id);
      })
      .catch((err) => console.error(err));
  };

  return props.products.map((product, idx) => {
    return (
      <p key={idx}>
        <Link to={`/${product._id}`}>{product.title}</Link>
        <button
          onClick={() => deleteProduct(product._id)}
          className="btn btn-sm btn-danger mx-2"
        >
          Delete
        </button>
      </p>
    );
  });
};

export default ProductsList;
