import React, { useState } from "react";

const ProductForm = (props) => {
  const { onSubmitProp, initialTitle, initialPrice, initialDesc, updateForm } =
    props;
  const [title, setTitle] = useState(initialTitle);
  const [price, setPrice] = useState(initialPrice);
  const [desc, setDesc] = useState(initialDesc);

  const submitHandler = (e) => {
    e.preventDefault();
    onSubmitProp({ title, price, desc });
    if (!updateForm) {
      setTitle("");
      setPrice("");
      setDesc("");
    }
  };

  return (
    <div className="row my-5">
      <div className="col-6 offset-3">
        <form onSubmit={submitHandler}>
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
          <button className="btn btn-success float-end">
            {updateForm ? "Update Product" : "Add Product"}
          </button>
        </form>
      </div>
    </div>
  );
};

export default ProductForm;
