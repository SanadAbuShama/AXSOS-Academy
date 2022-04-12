import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import axios from "axios";
const Starship = () => {
  const { id } = useParams();
  const [content, setContent] = useState("");
  const [error, setError] = useState("");
  useEffect(() => {
    setError("");
    axios
      .get(`https://swapi.dev/api/starships/${id}`)
      .then((res) => setContent(res.data))
      .catch(() => {
        setError("These aren't the droids your looking for!");
      });
  }, [id]);

  return (
    <div className="row">
      <div className="col-6 offset-3">
        {error ? (
          <>
            <h5 style={{ color: "red" }}>{error}</h5>
            <img
              src="https://www.denofgeek.com/wp-content/uploads/2019/08/star-wars-obi-wan-kenobi-1-scaled.jpg?resize=768%2C432"
              alt="Obi Wan"
            />
          </>
        ) : (
          <>
            <h4>{content.name}</h4>
            <p>Cargo Capacity: {content.cargo_capacity}</p>
            <p>Cost (Credits): {content.cost_in_credits}</p>
            <p>Manufacturer: {content.manufacturer}</p>
            <p>Passengers: {content.passengers}</p>
          </>
        )}
      </div>
    </div>
  );
};

export default Starship;
