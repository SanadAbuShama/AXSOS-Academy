import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import axios from "axios";
const Planet = () => {
  const { id } = useParams();
  const [content, setContent] = useState("");
  const [error, setError] = useState("");
  useEffect(() => {
    setError("");
    axios
      .get(`https://swapi.dev/api/planets/${id}`)
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
            <p>Diameter: {content.diameter}</p>
            <p>Terrain: {content.terrain}</p>
            <p>Population: {content.population}</p>
            <p>Gravity: {content.gravity}</p>
          </>
        )}
      </div>
    </div>
  );
};

export default Planet;
