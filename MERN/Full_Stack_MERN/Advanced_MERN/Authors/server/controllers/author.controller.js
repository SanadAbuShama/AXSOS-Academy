const { Author } = require("../models/author.model");

module.exports.index = (request, response) => {
  response.json({
    message: "Hello World",
  });
};

module.exports.createAuthor = (req, res) => {
  const { name } = req.body;
  Author.create({
    name,
  })
    .then((author) => res.json(author))
    .catch((err) => {
      res.status(400).send(err);
    });
};

module.exports.getAllAuthors = (req, res) => {
  Author.find({})
    .sort({ name: "asc" })
    .then((authors) => res.json(authors))
    .catch((err) => {
      res.status(400).send(err);
    });
};

module.exports.updateAuthor = (req, res) => {
  const { id } = req.params;
  Author.findOneAndUpdate(
    {
      _id: id,
    },
    req.body,
    { runValidators: true, new: true }
  )
    .then((updatedAuthor) => res.json(updatedAuthor))
    .catch((err) => res.status(400).send(err));
};

module.exports.getAuthor = (req, res) => {
  const { id } = req.params;
  Author.findOne({
    _id: id,
  })
    .then((author) => res.json(author))
    .catch((err) => {
      res.status(400).send(err);
    });
};

module.exports.deleteAuthor = (req, res) => {
  const { id } = req.params;
  Author.deleteOne({
    _id: id,
  })
    .then((author) => res.json(author))
    .catch((err) => {
      res.status(400).send(err);
    });
};
