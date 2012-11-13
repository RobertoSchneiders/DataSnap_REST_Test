var http = require('http');
http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/plain'});
  res.end('{"result":["Hello World!"]}\n');
}).listen(777);
console.log('Server running at http://192.168.3.134:777/');