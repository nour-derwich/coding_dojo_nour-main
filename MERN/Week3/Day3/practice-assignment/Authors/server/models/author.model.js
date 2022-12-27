//1. import mongoose
const mongoose = require("mongoose")

const AuthorsSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
        minlength: [3, " must have at least 3 chars, but you entered"]
    },
    books:[
        {
            title:{
                type: String,
        required: true,

            },
            num_page:{
                type: Number,
                required: true,
            }
        }
    ]
    
}, { timestamps: true })
  
const Author = mongoose.model("author", AuthorsSchema);

module.exports = Author;