const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;
const eurekaHelper = require('./eureka-helper');
const bodyParser = require('body-parser');
const cors = require("cors");
const mongoose = require("mongoose")
app.use(bodyParser.urlencoded({
  extended: false
}));
app.use(bodyParser.json());
app.use(cors());
app.use(require('./routes/index'));

app.get('/', (req, res) => {
  res.json("I am user-service")
 })

app.listen(PORT, () => {
  console.log(`user-service on ${PORT}`);
  mongoose.connect('mongodb+srv://root:root@cluster0.kyifc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority').then(()=>
    console.log("mongoDB connected")
  ).catch(err => {
    console.log(err)
  })
})


//eurekaHelper.registerWithEureka('user-service', PORT);