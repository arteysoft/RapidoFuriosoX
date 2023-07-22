const https = require('follow-redirects').http;
const qs = require('querystring');

let obtenerOpciones = (consultaOpciones, onFinish) => {
    let options = {
        'method': 'POST',
        'hostname': 'localhost',
        'port': 8080,
        'path': '/api/opciones',
        'headers': {
          'Content-Type': 'application/json'
        },
        'maxRedirects': 20
      };

    let req = https.request(options, function (res) {
        let chunks = [];
      
        res.on("data", function (chunk) {
          chunks.push(chunk);
        });
      
        res.on("end", function (chunk) {
          var body = Buffer.concat(chunks)
          onFinish(null, body.toString())          
        });
      
        res.on("error", function (error) {
          onFinish(error)
        });
      });

      req.write(JSON.stringify(consultaOpciones))
      req.end();
}

let consultaOpciones = {
    tipo : "call",
	  vencimiento : "ago",
    precio : "15.46",
    strike : "8800",
	  ccl : "539"
}

obtenerOpciones(consultaOpciones, (err, data) => {
  if (err) {
    console.log(err)
    return
  }
  console.log(data)
})

