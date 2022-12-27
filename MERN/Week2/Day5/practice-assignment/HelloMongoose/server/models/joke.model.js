const mongoose = require("mongoose");

const joke = new mongoose.Schema({
	setup:  String,
    punchlin:  String
    
});

const Joke = mongoose.model("joke", JokeSchema);

module.exports = Joke;