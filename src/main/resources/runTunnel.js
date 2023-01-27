const localtunnel = require('localtunnel');

(async () => {
  const tunnel = await localtunnel({ port: 8080, subdomain: process.argv[2] });

  tunnel.url;
  console.log('Instance run on address: ', tunnel.url);

  tunnel.on('close', () => {
    console.error('Tunnel ' + tunnel.url + ' closed.')
  });
})();