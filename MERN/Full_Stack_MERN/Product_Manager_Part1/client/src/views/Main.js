import axios from "axios";
import React, { useEffect, useState } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ProductForm from "../components/ProductForm";
import ProductsList from "../components/ProductsList";
import ProductDetails from "../components/ProductDetails";
const Main = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8000/api/products")
      .then((res) => setProducts(res.data))
      .catch((err) => console.error(err));
  });

  return (
    <BrowserRouter>
      <Routes>
        <Route
          path="/"
          element={
            <>
              <ProductForm />
              <ProductsList products={products} />
            </>
          }
        />
        <Route path="/:id" element={<ProductDetails />} />
      </Routes>
    </BrowserRouter>
  );
};

export default Main;
