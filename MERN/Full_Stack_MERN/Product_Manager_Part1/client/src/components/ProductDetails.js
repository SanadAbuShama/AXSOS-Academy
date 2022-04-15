import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const ProductDetails = () => {
  const { id } = useParams();
  const [product, setProduct] = useState({});
  useEffect(() => {
    axios
      .get(`http://localhost:8000/api/products/${id}`)
      .then((res) => setProduct(res.data))
      .catch((err) => console.error(err));
  }, [id]);
  return (
    <div className="row my-5">
      <div className="col-6 offset-3">
        <p>Title: {product.title}</p>
        <p>Price: ${product.price}</p>
        <p>Description: {product.description}</p>
      </div>
    </div>
  );
};

export default ProductDetails;
