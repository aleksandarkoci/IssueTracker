var issueApp = angular.module('issueApp');

issueApp.controller('userCtrl', function ($scope, $http, $location) {

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

	$scope.editUserInSinglePage = function(id){
        $location.path("/user/edit/" + id);            
	}
	
	$scope.addUser = function(){
        $location.path("/user/newuser/");            
	}

	$scope.delete = function(id){        
        $http.delete(url_base_user + "/" + id).then( 
            function success(data){
                console.log(data);
                getUsers();                           
            },
            function error(data){
                alert('Nesto je pogresno!');
                console.log(data);
            }
        );
	}
});