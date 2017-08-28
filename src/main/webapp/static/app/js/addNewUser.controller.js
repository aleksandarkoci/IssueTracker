var issueApp = angular.module('issueApp');

issueApp.controller('addUserCtrl', function ($scope, $http, $routeParams, $location) {

	
	var url_base_user = "http://localhost:8080/api/user";

	
	$scope.user = {};
	$scope.user.id = null;
	$scope.user.username = '';
	$scope.user.password = '';
	$scope.user.email = '';
	$scope.user.bug = '';


	$scope.addUser = function() {
		$http.post(url_base_user, $scope.user).then(
			function success(data) {
			  	console.log(data.data);
				$location.path('/allUsers');
				console.log(data);
			},
			function error(data) {
				console.log(data);
				alert('Error !'+data);
			}
		);
	}	
	
});