<<<<<<< HEAD
app.factory('cursos', ['$http', function($http) { 
    return $http.get('http://localhost:8080/Coursera/TodosCursos') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);
=======
app.factory('cursos',['$http',function($http){return $http.get('http://localhost:8080/Coursera/TodosCursos').success(function(data){return data}).error(function(err){return err})}]);
>>>>>>> 70b34f95082d171e98cfe62948f90ede0b36c851
