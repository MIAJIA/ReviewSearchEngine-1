(function() {
	'use strict';


	angular
	.module('contact_us')
	.run(menuConfig);

	menuConfig.$inject = ['Menus'];

	function menuConfig(Menus) {
		Menus.addMenuItem('topbar', {
			title: 'Contact Us',
			state: 'contact_us',
			roles: ['*']
		});
	}
})();