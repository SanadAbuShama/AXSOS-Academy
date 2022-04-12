const express = require("express");
const { faker } = require("@faker-js/faker");
const User = require("./classes/User");
const Company = require("./classes/Company");
const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const createUser = () => {
  const newUser = new User(
    faker.internet.password(),
    faker.internet.email(),
    faker.phone.phoneNumber(),
    faker.name.lastName(),
    faker.name.firstName(),
    faker.datatype.number()
  );
  return newUser;
};

const createCompany = () => {
  const newUser = new Company(
    faker.datatype.number(),
    faker.company.companyName(),
    {
      street: faker.address.streetName(),
      city: faker.address.cityName(),
      state: faker.address.state(),
      zipCode: faker.address.zipCode(),
      country: faker.address.country(),
    }
  );
  return newUser;
};

app.get("/api/users/new", (req, res) => {
  const newUser = createUser();
  res.json(newUser);
});

app.get("/api/companies/new", (req, res) => {
  const newCompany = createCompany();
  res.json(newCompany);
});

const server = app.listen(8000, () =>
  console.log(`Server is locked and loaded on port ${server.address().port}!`)
);
