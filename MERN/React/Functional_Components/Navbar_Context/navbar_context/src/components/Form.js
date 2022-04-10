import React, { useContext } from "react";
import MyContext from "../context/MyContext";

const Form = () => {
  const context = useContext(MyContext);
  return (
    <div className="container">
      <div className="row mt-5">
        <div className="col-6 offset-3">
          <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">
              Email address
            </label>
            <input
              type="text"
              onChange={(e) => context.setName(e.target.value)}
              className="form-control"
              placeholder="Name"
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Form;
