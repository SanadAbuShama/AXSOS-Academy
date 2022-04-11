import React from "react";
import { useParams } from "react-router";
const Content = () => {
  const { param, bgColor, color } = useParams();
  return (
    <div className="row my-5">
      <div className="col-6 offset-3 text-center">
        {isNaN(+param) ? (
          <h3 style={{ backgroundColor: bgColor, color: color }}>
            The word is: {param}{" "}
          </h3>
        ) : (
          <h3>The Number is: {param} </h3>
        )}
      </div>
    </div>
  );
};
export default Content;
