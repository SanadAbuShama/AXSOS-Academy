import React from "react";
import axios from "axios";
const DeleteButton = (props) => {
  const { successCallBack, productId } = props;
  const deleteProduct = () => {
    axios
      .delete(`http://localhost:8000/api/products/${productId}`)
      .then((res) => {
        console.log(res);
      })
      .then(() => successCallBack())
      .catch((err) => console.error(err));
  };
  return (
    <button onClick={deleteProduct} className="btn btn-sm btn-danger mx-2">
      Delete
    </button>
  );
};

export default DeleteButton;
