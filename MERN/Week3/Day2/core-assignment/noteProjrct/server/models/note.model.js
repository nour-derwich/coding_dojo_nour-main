//1. import mongoose
const mongoose = require("mongoose")

const NoteSchema = new mongoose.Schema({
    title: {
        type: String,
        required: true,
        minlength: [3, "{PATH} must have at least 3 chars, but you entered {VALUE}"]
    },
    context: {
        type: String,
        required: true,
    },
    is_inptant: {
        type: Boolean,
        default: false
    }
}, { timestamps: true })

const Note = mongoose.model("notes", NoteSchema);

module.exports = Note;