const express = require("express");
const cors = require("cors");
const app = express();

require("./config/mongoose.config");

app.use(cors());

app.use(express.json(), express.urlencoded({ extended: true }));

require("./routes/person.routes")(app);

const server = app.listen(8000, () =>
  console.log("The server is all fired up on port 8000")
);

const io = require("socket.io")(server, { cors: true });

io.on("connection", (socket) => {
  console.log("Nice to meet you");

  socket.emit("Welcome", "Welcome to the server");
});
