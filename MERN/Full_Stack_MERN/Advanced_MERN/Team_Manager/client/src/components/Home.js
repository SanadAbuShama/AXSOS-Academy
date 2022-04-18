import React from "react";
import { Link } from "react-router-dom";
import { Grid } from "@mui/material";
import { useLocation } from "react-router-dom";
const Home = (props) => {
  const { pathname } = useLocation();

  return (
    <Grid container mb={5} style={{ justifyContent: "center" }}>
      <Grid
        container
        item
        style={{ justifyContent: "center", backgroundColor: "#eeeeee" }}
        mt={10}
        xs={8}
        p={3}
      >
        <Grid container item mb={3} xs={10}>
          <Grid item style={{ textAlign: "left" }} xs={10}>
            {pathname.includes("/players") ? (
              <>
                <span style={{ fontWeight: "bold" }}>Manage Players</span> |{" "}
                <Link to="/status/game/1">Manage Player Status</Link>
              </>
            ) : (
              <>
                <Link to="/players/list">Manage Players</Link> |{" "}
                <span style={{ fontWeight: "bold" }}>Manage Player Status</span>
              </>
            )}
          </Grid>
        </Grid>
        <Grid item xs={10} style={{ backgroundColor: "white" }} p={4}>
          {props.children}
        </Grid>
      </Grid>
    </Grid>
  );
};

export default Home;
