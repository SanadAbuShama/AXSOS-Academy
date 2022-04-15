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
