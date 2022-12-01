const express = require('express');
const faker=require('@faker-js/faker');
const app = express();
const port = 8000;
class User {
  constructor(){
        this._id = faker.random.number();
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
    if(req.params.users === "users"){
      res.send(`User First Name: ${newUser.firstName}; User Last Name: ${newUser.lastName}`);
    }
   
  console.log(newUser);  });




app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
