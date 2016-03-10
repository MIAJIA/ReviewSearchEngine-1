'use strict';

//Setting up route
angular.module('contact_us').config(['$stateProvider',
  function($stateProvider) {
    // Crawler state routing
    $stateProvider
      .state('contact_us', {
        url: '/contact_us',
        templateUrl: 'modules/contact_us/client/views/contact_us.client.view.html'
      });
  }
]);
