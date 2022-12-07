const express = require("express")
const app = express()
const cors = require("cors");
const PORT = 8000
const DB_NAME = "prodects";
app.use(cors());
app.use(express.json(), express.urlencoded({ extended: true }));
require("./config/mongoose.config")(DB_NAME)
require("./routes/person.route")(app)
app.listen(PORT, () => { console.log(`Server started on PORT ${PORT} 🚀🚀`) })