import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const Form = () => {
  const [selectedOption, setSelectedOption] = useState("people");
  const [id, setId] = useState(0);

  const navigate = useNavigate();

  const submitHandler = (e) => {
    e.preventDefault();
    navigate(`/${selectedOption}/${id}`);
  };

  return (
    <div className="row">
      <div className="col-6 offset-3">
        <form onSubmit={submitHandler}>
          <div className="row align-items-bottom">
            <div className="col">
              <div className="mb-3">
                <div className="row align-items-center">
                  <div className="col-3">
                    <label className="form-label">Search for:</label>
                  </div>
                  <div className="col">
                    <select
                      className="form-select"
                      aria-label="Default select example"
                      value={selectedOption}
                      onChange={(e) => setSelectedOption(e.target.value)}
                    >
                      <option value="people">People</option>
                      <option value="planets">Planets</option>
                      <option value="starships">Starships</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>
            <div className="col-3">
              <div className="mb-3">
                <div className="row align-items-center">
                  <div className="col-4">
                    <label className="form-label">ID:</label>
                  </div>
                  <div className="col">
                    <input
                      className="form-control"
                      type="number"
                      value={id}
                      onChange={(e) => setId(e.target.value)}
                    />
                  </div>
                </div>
              </div>
            </div>
          </div>
          <button className="btn btn-primary float-end">Submit</button>
        </form>
      </div>
    </div>
  );
};

export default Form;
