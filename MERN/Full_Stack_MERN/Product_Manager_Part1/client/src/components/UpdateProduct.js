import axios from "axios";
import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import ProductForm from "./ProductForm";

const UpdateProduct = () => {
  const [product, setProduct] = useState({});
  const [loaded, setLoaded] = useState(false);
  const { id } = useParams();

  useEffect(() => {
    axios.get(`http://localhost:8000/api/products/${id}`).then((res) => {
      console.log(res);
      setProduct(res.data);
      setLoaded(true);
    });
  }, [id]);

  const updateProduct = (updatedProduct) => {
    axios
      .put(`http://localhost:8000/api/products/${id}`, updatedProduct)
      .then((res) => {
        console.log(res);
      })
      .catch((err) => console.error(err));
  };

  return (
    <>
      {loaded && (
        <ProductForm
          initialTitle={product.title}
          initialPrice={product.price}
          initialDesc={product.description}
          onSubmitProp={updateProduct}
          updateForm={true}
        />
      )}
    </>
  );
};

export default UpdateProduct;
