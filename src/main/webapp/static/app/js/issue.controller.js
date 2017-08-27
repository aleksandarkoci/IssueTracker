var issueApp = angular.module('issueApp');

issueApp.controller('issueCtrl', function ($scope, $http, $location) {

	var url_base_user = "http://localhost:8080/api/user";

	$scope.users = [];
	
	var getUsers = function() {
		$http.get(url_base_user).then(
			function success(data) {
				$scope.users = data.data;
				console.log(data);
			},
			function error(data) {
				console.log(data);
			}
		);
	}

	getUsers();

	$scope.addUser = function(path) {
        $location.path('/newuser');            
	}
	
});