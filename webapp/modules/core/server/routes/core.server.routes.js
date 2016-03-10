'use strict';

module.exports = function (app) {
	/* GET home page. */
	// app.route('/').get(function(req, res, next) {
	//   res.render('home', { title: 'Express' });
	// });

  // Root routing
  var core = require('../controllers/core.server.controller');

  // Define error pages
  app.route('/server-error').get(core.renderServerError);

  // Return a 404 for all undefined api, module or lib routes
  app.route('/:url(api|modules|lib)/*').get(core.renderNotFound);

  // Define application route
  app.route('/*').get(core.renderIndex);


};