import React, { useState } from "react";

const Tabs = (props) => {
  const [isActive, setIsActive] = useState("Item1");
  const [content, setContent] = useState(props.items[0].content);

  const onClickHandler = (e, item) => {
    setIsActive(item.name);
    setContent(item.content);
  };
  return (
    <>
      <div className="row  my-5">
        <div className="col-6 offset-3">
          <ul className="nav nav-pills">
            {props.items.map((item, i) => {
              return (
                <li key={i} className="nav-item">
                  <button
                    onClick={(e) => onClickHandler(e, item)}
                    className={
                      isActive === item.name ? "nav-link active" : "nav-link"
                    }
                    type="button"
                  >
                    {item.name}
                  </button>
                </li>
              );
            })}
          </ul>
          <div className="text-start border border-1 border-dark p-4 mt-4">
            {content}
          </div>
        </div>
      </div>
    </>
  );
};

export default Tabs;
