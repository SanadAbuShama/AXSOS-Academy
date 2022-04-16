import React from "react";
import { Link } from "react-router-dom";
import DeleteButton from "./DeleteButton";
const ProductsList = (props) => {
  const { products, removeFromDom } = props;
  
  return products.map((product, idx) => {
    return (
      <p key={idx}>
        <Link to={`/${product._id}`}>{product.title}</Link>
        <DeleteButton
          productId={product._id}
          successCallBack={() => removeFromDom(product._id)}
        />
      </p>
    );
  });
};

export default ProductsList;
