var boardAppControllers = angular.module('boardAppControllers', []);
boardAppControllers.controller('BoardAppCtrl', [ '$scope', '$http',
		function($scope, $http) {
			$http.get('data/games.json').success(function(data) {
				$scope.games = data;
			});
		} ]);
