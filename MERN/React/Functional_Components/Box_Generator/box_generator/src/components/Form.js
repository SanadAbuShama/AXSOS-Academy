import React, { useState } from "react";

const Form = (props) => {
  const [color, setColor] = useState("");
  const [dim, setDim] = useState("");

  const submitHandler = (e) => {
    e.preventDefault();
    props.onNewBox(color, dim);
    setColor("");
    setDim("");
  };

  return (
    <div className="container my-5">
      <div className="row">
        <div className="col-6 offset-3">
          <form onSubmit={submitHandler}>
            <div class="mb-3">
              <input
                className="form-control"
                type="text"
                placeholder="Color"
                onChange={(e) => setColor(e.target.value)}
                value={color}
              />
            </div>
            <div class="mb-3">
              <input
                className="form-control"
                type="number"
                placeholder="Dimention (px)"
                onChange={(e) => setDim(e.target.value)}
                value={dim}
              />
            </div>
            <button class="btn btn-primary float-start">Submit</button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Form;
