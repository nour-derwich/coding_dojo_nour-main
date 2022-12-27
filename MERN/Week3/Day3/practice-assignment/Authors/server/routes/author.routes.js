// import the controller 
const authorController = require("../controllers/author.controllers")
module.exports = app => {
    app.get('/api/authors', authorController.findAllAuthor);
    app.post('/api/authors', authorController.createAuthor);
    app.get('/api/authors/:id', authorController.findOneAuthor);
    app.put('/api/authors/:id', authorController.updateExistingAuthor);
    app.delete('/api/authors/:id', authorController.deletExistingAuthor);
    app.put('/api/authors/books/:id', authorController.addBokk);

}