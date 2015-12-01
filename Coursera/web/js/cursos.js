app.factory('cursos', ['$http', function($http) { 
  return $http.get('http://localhost:8080/Coursera/TodosCursos') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);