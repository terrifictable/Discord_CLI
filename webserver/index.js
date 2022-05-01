const bodyParser = require("body-parser");
const express = require("express");
const fs = require("fs");

const app = express();
app.use(bodyParser.json());
let workingDir = "./data/";

app.listen(5000, () => {
  console.log("APP running (http://127.0.0.1:5000)"); // <- change
});

app.get("/:server", (req, res) => {
  let server = req.params.server.replace(":", "").replace("_", "/");
  fs.readFile(workingDir + server + ".txt", "utf-8", (err, content) => {
    if (err) {
      res.send("invalid");
    }

    if (content != undefined) {
      res.send(content); // .replace("\n", "<br>"));
    }
  });
});

app.post("/add", (req, res) => {
  console.log(req.body);
  let server = req.body["server"];
  let content = req.body["content"];

  fs.mkdir(workingDir, () => {});

  if (server != "" && !fs.existsSync(workingDir + server + ".txt")) {
    fs.writeFileSync(workingDir + server + ".txt", content);
    try {
      res.send("success");
    } catch {}
  } else if (fs.existsSync(workingDir + server + ".txt")) {
    fs.appendFile(workingDir + server + ".txt", content + "<br>", (err) => {});
    res.send("success");
  }
});
