// CRUD operations

const Prodect = require("../models/person.model")

module.exports.findAllProdects = (req, res) => {
    Prodect.find()
        .then((allProdects) => {
            res.json(allProdects) // what it returns will be recieved in react
        })
        .catch(err => {
            res.json({ message: "Something went worng", serverError: err })
        })
}

module.exports.createProdect = (request, response) => {
    console.log(request.body);
    Prodect.create(request.body)
        .then(newCreatedProdect => {
            response.json(newCreatedProdect )
        })
        .catch(err => response.json({ message: 'Something went wrong', error: err }))
}

module.exports.findOneProdect = (req, res) => {
    Prodect.findOne({ _id: req.params.id })
        .then(oneProdect => {
            res.json(oneProdect)
        })
        .catch(err => response.json({ message: 'Something went wrong', error: err }))
}

module.exports.updateExistingProdect = (req, res) => {
    Prodect.findOneAndUpdate(
        { _id: req.params.id },
        req.body,
        { new: true, runValidators: true }
    )
        .then(updatedProdect => res.json({ Prodect: updatedProdect }))
        .catch(err => res.json({ message: 'Something went wrong', error: err }));
}

module.exports.deleteAnExistingProdect = (req, res) => {
    Prodect.deleteOne({ _id: req.params.id })
        .then(result => res.json({ result: result }))
        .catch(err => res.json({ message: 'Something went wrong', error: err }));
}