var issueApp = angular.module('issueApp');

issueApp.controller('loadBugCtrl', function($scope, $http, $location) {

	var url_base_user = "http://localhost:8080/api/user";

	$scope.bags = [];

	$scope.loadDataJson = function() {
		var url_base_bag = "/api/bug";
		$http.get(url_base_bag).then(function success(data) {
			$scope.bags = data.data;
			alert("Send" + data.data);
			console.log(data);
		}, function error(data) {
			console.log(data);
		});

	}
	
	var margin = {
		top : 20,
		right : 20,
		bottom : 70,
		left : 40
	}, width = 600 - margin.left - margin.right, height = 300 - margin.top
			- margin.bottom;

	// set the ranges
	var x = d3.scale.ordinal().rangeRoundBands([ 0, width ], .05);

	var y = d3.scale.linear().range([ height, 0 ]);

	// define the axis
	var xAxis = d3.svg.axis().scale(x).orient("bottom")

	var yAxis = d3.svg.axis().scale(y).orient("left").ticks(10);

	// add the SVG element
	var svg = d3.select("body").append("svg").attr("width",
			width + margin.left + margin.right).attr("height",
			height + margin.top + margin.bottom).append("g").attr("transform",
			"translate(" + margin.left + "," + margin.top + ")");

	// load the data
	var bags = '/api/bug';
	d3.json(bags, function(error, data) {
		alert("diagram");
		data.forEach(function(d) {
			alert(d.dateCreated + ", " + d.bugName);
			d.dateCreated = d.dateCreated;
			d.bugName = 12;  // radi dijagram samo mi je problem sto ne mogu da skontam kako da dodjem do broja prijavljenih bagova!!
 		});
		// scale the range of the data
		x.domain(data.map(function(d) {
			return d.dateCreated;
		}));
		y.domain([ 0, d3.max(data, function(d) {
			return d.bugName;
		}) ]);

		// add axis
		svg.append("g").attr("class", "x axis").attr("transform",
				"translate(0," + height + ")").call(xAxis).selectAll("text")
				.style("text-anchor", "end").attr("dx", "-.8em").attr("dy",
						"-.55em").attr("transform", "rotate(-90)");

		svg.append("g").attr("class", "y axis").call(yAxis).append("text")
				.attr("transform", "rotate(-90)").attr("y", 5).attr("dy",
						".71em").style("text-anchor", "end").text("bugs");

		// Add bar chart
		svg.selectAll("bar").data(data).enter().append("rect").attr("class",
				"bar").attr("x", function(d) {
			return x(d.dateCreated);
		}).attr("width", x.rangeBand()).attr("y", function(d) {
			return y(d.bugName);
		}).attr("height", function(d) {
			return height - y(d.bugName);
		});

	});

});