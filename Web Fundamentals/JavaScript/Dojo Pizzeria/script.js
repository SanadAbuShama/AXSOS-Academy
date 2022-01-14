function pizzaOven(crustType, sauceType, cheeses, toppings) {
  var pizza = {};
  pizza.crustType = crustType;
  pizza.sauceType = sauceType;
  pizza.cheeses = cheeses;
  pizza.toppings = toppings;
  return pizza;
}

var pizza1 = pizzaOven(
  "deep dish",
  "traditional",
  ["mozzarella"],
  ["pepperoni", "sausage"]
);

var pizza2 = pizzaOven(
  "hand tossed",
  "marinara",
  ["mozzarella", "feta"],
  ["mushrooms", "olives", "onions"]
);

var pizza3 = pizzaOven(
  "stuffed",
  "tomato",
  ["pecorino"],
  ["mushrooms", "pepperoni", "jalapeno"]
);

var pizza4 = pizzaOven(
  "thin",
  "buffalo",
  ["parmigano", "mozarella"],
  ["tomatoes", "chicken", "onions"]
);

function randomPizza() {
  var pizzaNum = Math.floor(Math.random() * 5);
  var randomPizza = {};
  if (pizzaNum == 1) {
    randomPizza = pizza1;
  } else if (pizzaNum == 2) {
    randomPizza = pizza2;
  } else if (pizzaNum == 3) {
    randomPizza = pizza3;
  } else {
    randomPizza = pizza4;
  }
  return randomPizza;
}

var pizza5 = randomPizza();

console.log("Pizza 1: ", pizza1);
console.log("Pizza 2: ", pizza2);
console.log("Pizza 3: ", pizza3);
console.log("Pizza 4: ", pizza4);
console.log("Random pizza: ", pizza5);
