// CRUD operations

const Note = require("../models/note.model")

module.exports.findAllNotes = (req, res) => {
    Note.find()
        .then((allNotes) => {
            res.json(allNotes) // what it returns will be recieved in react
        })
        .catch(err => {
            res.json({ message: "Something went worng", serverError: err })
        })
}

module.exports.createNote = (request, response) => {
    console.log(request.body);
    Note.create(request.body)
        .then(newCreatedNote => {
            response.json(newCreatedNote )
        })
        .catch(err => response.json({ message: 'Something went wrong', error: err }))
}

module.exports.findOneNote = (req, res) => {
    Note.findOne({ _id: req.params.id })
        .then(oneNote => {
            res.json(oneNote)
        })
        .catch(err => response.json({ message: 'Something went wrong', error: err }))
}

module.exports.updateExistingNote = (req, res) => {
    Note.findOneAndUpdate(
        { _id: req.params.id },
        req.body,
        { new: true, runValidators: true }
    )
        .then(updatedNote => res.json({ note: updatedNote }))
        .catch(err => res.json({ message: 'Something went wrong', error: err }));
}

module.exports.deleteAnExistingNote = (req, res) => {
    Note.deleteOne({ _id: req.params.id })
        .then(result => res.json({ result: result }))
        .catch(err => res.json({ message: 'Something went wrong', error: err }));
}