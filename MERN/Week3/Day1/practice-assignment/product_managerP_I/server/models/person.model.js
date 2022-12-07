//1. import mongoose
const mongoose = require("mongoose")

const ProdectSchema = new mongoose.Schema({
    title: {
        type: String,
        required: true
    },
        
    price: {
        type: Number,
        required: true
    },
    description: {
        type: String,
        required: true
    }
}, { timestamps: true })

const Prodect = mongoose.model("Prodect", ProdectSchema);

module.exports = Prodect;