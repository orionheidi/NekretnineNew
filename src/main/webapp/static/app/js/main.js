var wafepaApp = angular.module('wafepaApp', ['ngRoute']);

wafepaApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl : '/static/app/html/partial/proba.html'
    })
    .when('/nekretnine', {
        templateUrl : '/static/app/html/partial/nekretnine.html'
    })
    .when('/nekretnina/:id', {
        templateUrl : '/static/app/html/partial/nekretnina.html'
    })
    .otherwise({
        redirectTo: '/'
    });
}]);


wafepaApp.controller('nekretnineCtrl', function($scope, $http, $location){
	var paramsConfig = {};
	$scope.currentPage = 0;
	$scope.totalPages = 0;

	$scope.configureParameters = function(){
		paramsConfig = { params:{} };
		if($scope.currentPage)
			paramsConfig.params.page = $scope.currentPage;

		$scope.load();
	}

	$scope.filterParameters = function(){
		paramsConfig = { params:{} };
		if($scope.currentPage)
			paramsConfig.params.page = $scope.currentPage;
		if($scope.adresa)
			paramsConfig.params.adresa = $scope.adresa;
		if($scope.cenaOd)
			paramsConfig.params.cenaOd = $scope.cenaOd;
		if($scope.cenaDo)
			paramsConfig.params.cenaDo = $scope.cenaDo;		
		$scope.filter();
	}

	$scope.changePage = function(i){
		if(($scope.currentPage > 0 && i < 0) || (i > 0 && $scope.currentPage < $scope.totalPages)){
			$scope.currentPage += i;
			$scope.configureParameters();
		}
	}
	
	 $scope.prepTip = function(tip){
	       return tip.naziv;
	   }

	$scope.load = function(){
		$http.get('/api/nekretnine', paramsConfig).then(function(response){
			console.log('(Load Nekretnine) Success: ', response.status, response.statusText);
			$scope.nekretnine = response.data;
			$scope.totalPages = response.headers('totalPages');
		}, function(response){
			console.log('(Load Nekretnine) Error: ', response.status, response.statusText);
		});
	}

	$scope.filter = function(){
		$http.get('/api/nekretnine/filterNekretnina', paramsConfig).then(function(response){
			console.log('(Filter Nekretnine) Success: ', response.status, response.statusText);
			$scope.nekretnine = response.data;
		}, function(response){
			console.log('(Filter Nekretnine) Error: ', response.status, response.statusText);
		});
	}

	$scope.load();

	$scope.save = function(){
		$http.post('/api/nekretnine/', $scope.nekretnina).then(function(response){
			console.log('(Add Nekretnina) Success:', response.status, response.statusText);
			$scope.currentPage = 0;
			$scope.configureParameters();
			resetInputValues();
		}, function(response){
			console.log('(Add Nekretnina) Error:', response.status, response.statusText);
		});
	}

	$scope.delete = function(id){
		$http.delete('/api/nekretnine/' + id).then(function(response){
			console.log('(Delete Nekretnina) Success:', response.status, response.statusText);
			$scope.load();
		}, function(response){
			console.log('(Delete Nekretnina) Error:', response.status, response.statusText);
		});
	}

	$scope.printData = function(){
		console.log($scope.adresa + ' ' + $scope.cenaOd + ' ' + $scope.cenaDo + ' ');
	}

	$scope.gotoNekretnina = function(id){
		$location.path('/nekretnina/' + id);
	}

	$scope.setForUpdate = function (nekretnina) {
	       $scope.nekretnina = angular.copy(nekretnina);
	   } 

	var resetInputValues = function(){
		$scope.nekretnina = {};
	}

	var loadTipNekretnine = function(){
		$http.get('/api/tipNekretnine').then(function(response){
			console.log('(Load TipNekretnine) Success:', response.status, response.statusText);
			$scope.tipNekretnine = response.data;
		}, function(response){
			console.log('(Load TipNekretnine) Error:', response.status, response.statusText);
		});
	}

		loadTipNekretnine();
});

wafepaApp.controller('nekretninaCtrl', function($scope, $http, $location, $routeParams){
	
	  $scope.prepTip = function(tip){
	       return tip.naziv;
	   }

	
	$scope.loadNekretnina = function(){
		$http.get('/api/nekretnine/' + $routeParams.id).then(function(response){
			console.log('(Get Nekretnina) Success', response.status, response.statusText);
			$scope.nekretnina = response.data;
		}, function(response){
			console.log('(Get Nekretnina) Error', response.status, response.statusText);
		});
	}

	$scope.loadNekretnina();

	$scope.save = function(){
		$http.post('/api/nekretnine/', $scope.nekretnina).then(function(response){
			console.log('(Add Nekretnina) Success:', response.status, response.statusText);
			$location.url('/nekretnine');
		}, function(response){
			console.log('(Add Nekretnina) Error:', response.status, response.statusText);
		});
	}

	var loadTipNekretnine = function(){
		$http.get('/api/tipNekretnine').then(function(response){
			console.log('(Load TipNekretnine) Success:', response.status, response.statusText);
			$scope.tipNekretnine = response.data;
		}, function(response){
			console.log('(Load TipNekretnine) Error:', response.status, response.statusText);
		});
	}

		loadTipNekretnine();
});

