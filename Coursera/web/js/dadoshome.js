app.factory('dadoshome', ['$http', function($http) { 
  return $http.get('http://localhost:8080/Coursera/DadosHome') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);

