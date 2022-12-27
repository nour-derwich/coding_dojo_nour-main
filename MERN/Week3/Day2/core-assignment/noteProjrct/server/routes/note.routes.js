// import the controller 
const noteController = require("../controllers/note.controller")




module.exports = app => {
    app.get('/api/notes', noteController.findAllNotes);
    app.post('/api/notes', noteController.createNote);
    app.get('/api/notes/:id', noteController.findOneNote);
    app.put('/api/notes/:id', noteController.updateExistingNote);
    app.delete('/api/notes/:id', noteController.deleteAnExistingNote);

}