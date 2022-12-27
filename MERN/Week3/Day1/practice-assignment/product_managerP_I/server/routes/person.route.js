// import the controller 
const prodectController = require("../controllers/person.controller")




module.exports = app => {
    app.get('/api/prodects', prodectController.findAllProdects);
    app.post('/api/prodects', prodectController.createProdect);
    app.get('/api/prodects/:id', prodectController.findOneProdect);
    app.put('/api/prodects/:id', prodectController.updateExistingProdect);
    app.delete('/api/prodects/:id', prodectController.deleteAnExistingProdect);

}