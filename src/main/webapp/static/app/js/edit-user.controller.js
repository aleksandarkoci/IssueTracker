var issueApp = angular.module('issueApp');

issueApp.controller('editUserCtrl', function($scope, $http, $routeParams,
		$location) {

	var url_base_user = "http://localhost:8080/api/user";

	var id = $routeParams.aid;

	$scope.user = {};
	$scope.user.id = '';
	$scope.user.username = '';
	$scope.user.password = '';
	$scope.user.email = '';
	$scope.user.bugName = '';

	$scope.got_user = false;

	var getUser = function() {
		$http.get(url_base_user + "/" + id).then(function success(data) {
			$scope.user = data.data;
			$scope.got_user = true;
			console.log(data);
		}, function error(data) {
			console.log(data)
		});
	}

	getUser();

	$scope.editUser = function(id) {
		$http.put(url_base_user + '/' + $scope.user.id, $scope.user).then(
				function success(data) {
					$scope.user = data.data;
					$location.path('/allUsers');
					console.log(data);
				}, function error(data) {
					console.log(data);
					alert('Nesto je pogresno!');
				});
	}
});