var boardApp = angular.module('boardApp', [ 'ngRoute', 'ngAnimate', 'boardAppControllers' ]);

boardApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/games', {
		templateUrl : 'view/games.html',
		controller : 'BoardAppCtrl'
	});
} ]);