const { Player } = require("../models/player.model");

module.exports.index = (request, response) => {
  response.json({
    message: "Hello World",
  });
};

module.exports.createPlayer = (req, res) => {
  const { name, position } = req.body;
  Player.create({
    name,
    position,
  })
    .then((player) => res.json(player))
    .catch((err) => res.status(400).json(err));
};

module.exports.getAllPlayers = (req, res) => {
  Player.find({})
    .then((players) => res.json(players))
    .catch((err) => res.status(400).json(err));
};

module.exports.deletePlayer = (req, res) => {
  const { id } = req.params;
  Player.deleteOne({
    _id: id,
  })
    .then((player) => res.json(player))
    .catch((err) => {
      res.status(400).json(err);
    });
};

module.exports.updatePlayer = (req, res) => {
  const { id } = req.params;
  Player.findOneAndUpdate(
    {
      _id: id,
    },
    req.body,
    { new: true }
  )
    .then((updatedAuthor) => res.json(updatedAuthor))
    .catch((err) => res.status(400).send(err));
};
