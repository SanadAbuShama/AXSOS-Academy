import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
const ProductDetails = (props) => {
  const { id } = useParams();
  const [product, setProduct] = useState({});
  const navigate = useNavigate();

  const deleteProduct = () => {
    axios
      .delete(`http://localhost:8000/api/products/${id}`)
      .then((res) => {
        console.log(res);
        props.removeFromDom(id);
        navigate("/");
      })
      .catch((err) => console.error(err));
  };

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
        <Link to={`/${id}/edit`} className="btn btn-sm btn-primary">
          Edit
        </Link>
        <button onClick={deleteProduct} className="btn btn-sm btn-danger mx-2">
          Delete
        </button>
      </div>
    </div>
  );
};

export default ProductDetails;
