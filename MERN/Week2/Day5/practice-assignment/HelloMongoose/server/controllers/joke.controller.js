const Joke = require("../models/joke.model");

module.exports.findJokes=async(req,res)=>{
    const jokes =await Joke.find();
    res.send({data:jokes});

};
module.exports.createNewUser = (req, res) => {
    Joke.create(req.body)
      .then(newlyCreatedUser => res.json({ joke: newlyCreatedUser }))
      .catch(err => res.json({ message: "Something went wrong", error: err }));
  };
  

module.exports.findOneSingleJokes = (req, res) => {
	Joke.findOne({ _id: req.params.id })
		.then(oneSingleJoke => res.json({ joke: oneSingleJoke }))
		.catch(err => res.json({ message: "Something went wrong", error: err }));
};


module.exports.updateExistingJoke = (req, res) => {
  Joke.findOneAndUpdate({ _id: req.params.id }, req.body, { new: true })
    .then(updatedJoke => res.json({ joke: updatedJoke }))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};

module.exports.deleteAnExistingJoke = (req, res) => {
    Joke.deleteOne({ _id: req.params.id })
    .then(result => res.json({ result: result }))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};
