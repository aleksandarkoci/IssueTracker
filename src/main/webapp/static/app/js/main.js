var issueApp = angular.module('issueApp', ['ngRoute']);

issueApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
    	.when('/', {
			templateUrl : '/static/app/html/partial/home.html'
		})
		.when('/issue', {
			templateUrl : '/static/app/html/partial/issue.html'
		})
		.when('/allUsers', {
			templateUrl : '/static/app/html/partial/allUsers.html'
		})
		.when('/user/edit/:aid', {
            templateUrl : '/static/app/html/partial/edit-user.html'
        })
        .when('/newuser/', {
            templateUrl : '/static/app/html/partial/addNewUser.html'
        })
		.otherwise({
            redirectTo: '/'
        });

        
}]);