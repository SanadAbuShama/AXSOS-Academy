import React from "react";
import { Link } from "react-router-dom";
const ProductsList = (props) => {
  return props.products.map((product, idx) => {
    return (
      <p key={idx}>
        <Link to={`/${product._id}`}>{product.title}</Link>
      </p>
    );
  });
};

export default ProductsList;
