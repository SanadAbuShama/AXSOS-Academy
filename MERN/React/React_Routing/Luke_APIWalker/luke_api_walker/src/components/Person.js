import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import { Link } from "react-router-dom";
import axios from "axios";
const Person = () => {
  const { id } = useParams();
  const [content, setContent] = useState("");
  const [homeworld, setHomeworld] = useState("");
  const [planetUrl, setPlanetUrl] = useState("");
  const [error, setError] = useState("");
  useEffect(() => {
    setError("");
    axios
      .get(`https://swapi.dev/api/people/${id}`)
      .then((res) => {
        axios
          .get(res.data.homeworld)
          .then((res) => setHomeworld(res.data.name));
        setContent(res.data);
        setPlanetUrl(res.data.homeworld.replace("https://swapi.dev/api", ""));
      })

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
            <p>Mass: {content.mass}</p>
            <p>Height: {content.height}</p>
            <p>Hair Color: {content.hair_color}</p>
            <p>Skin Color: {content.skin_color}</p>
            <p>Homeworld: {homeworld}</p>
            <Link to={planetUrl}>Go to {homeworld}</Link>
          </>
        )}
      </div>
    </div>
  );
};

export default Person;
