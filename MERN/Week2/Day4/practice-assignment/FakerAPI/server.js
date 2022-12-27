const express = require('express');
const {faker}=require('@faker-js/faker');
const app = express();
const port = 8000;
class User {
  constructor(){
        this._id = faker.datatype.uuid();
        this.firstName = faker.name.firstName();
        this.lastName = faker.name.lastName();
        this.phoneNumber = faker.phone.phoneNumber();
        this.email = faker.internet.email();
        this.password = faker.internet.password();

  }
}
const newUser = new User();
console.log(newUser);

  app.get("/api/:users/:new", (req, res) => {
      res.send(`User First Name: ${newUser.firstName}; User Last Name: ${newUser.lastName}`);
    
   
  console.log(newUser);  });

  class Company {
    constructor() {
      this._id = faker.datatype.uuid();
        this.name= faker.company.companyName();
        this.address = newAdd;
    }
  }
  class Address{
    constructor(){
      this.street = faker.address.streetAddress();
      this.city = faker.address.city();
      this.state = faker.address.state();
      this.zipCode = faker.address.zipCode();
      this.country = faker.address.country();
    }
  }
  const newAdd = new Address();
  const newComp = new Company();
console.log(newComp);

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
