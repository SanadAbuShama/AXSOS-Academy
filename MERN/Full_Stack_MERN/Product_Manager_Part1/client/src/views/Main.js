import axios from "axios";
import React, { useEffect, useState } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ProductForm from "../components/ProductForm";
import ProductsList from "../components/ProductsList";
import ProductDetails from "../components/ProductDetails";
import UpdateProduct from "../components/UpdateProduct";
const Main = () => {
  const [products, setProducts] = useState([]);

  const removeFromDom = (id) => {
    setProducts(products.filter((product) => product._id !== id));
  };

  const addToDom = (product) => {
    setProducts([...products, product]);
  };

  useEffect(() => {
    axios
      .get("http://localhost:8000/api/products")
      .then((res) => setProducts(res.data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <BrowserRouter>
      <Routes>
        <Route
          path="/"
          element={
            <>
              <ProductForm addToDom={addToDom} />
              <ProductsList products={products} removeFromDom={removeFromDom} />
            </>
          }
        />
        <Route
          path="/:id"
          element={<ProductDetails removeFromDom={removeFromDom} />}
        />
        <Route path="/:id/edit" element={<UpdateProduct />} />
      </Routes>
    </BrowserRouter>
  );
};

export default Main;
