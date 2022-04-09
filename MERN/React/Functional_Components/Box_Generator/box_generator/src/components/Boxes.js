import React from "react";

const Boxes = (props) => {
  return (
    <div className="row">
      <div className="col-8 offset-2">
        <div className="row row-cols-1 row-cols-md-3 g-4">
          {props.boxes.map((box, i) => (
            <div
              key={i}
              className="col"
              style={{
                backgroundColor: box.color,
                height: `${box.dim}px`,
                width: `${box.dim}px`,
              }}
            ></div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Boxes;
