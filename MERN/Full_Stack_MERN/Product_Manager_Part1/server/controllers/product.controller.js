const { Product } = require("../models/product.model");

module.exports.index = (request, response) => {
  response.json({
    message: "Hello World",
  });
};

module.exports.createProduct = (req, res) => {
  const { title, price, desc } = req.body;
  Product.create({
    title,
    price,
    description: desc,
  })
    .then((product) => res.json(product))
    .catch((err) => res.json(err));
};

module.exports.getAllProducts = (req, res) => {
  Product.find({})
    .then((products) => res.json(products))
    .catch((err) => res.json(err));
};

module.exports.getProduct = (req, res) => {
  const { id } = req.params;
  Product.findOne({ _id: id })
    .then((product) => res.json(product))
    .catch((err) => res.json(err));
};

module.exports.updateProduct = (req, res) => {
  const { id } = req.params;
  const { title, price, desc } = req.body;
  Product.findOneAndUpdate(
    { _id: id },
    { title, price, description: desc },
    { new: true }
  )
    .then((updatedProduct) => res.json(updatedProduct))
    .catch((err) => res.json(err));
};

module.exports.deleteProduct = (req, res) => {
  const { id } = req.params;
  Product.deleteOne({ _id: id })
    .then((deleteConfirm) => res.json(deleteConfirm))
    .catch((err) => res.json(err));
};
