<<<<<<< HEAD
app.controller('CursosController', ['$scope', 'cursos', function($scope, cursos) {
  cursos.success(function(data) {
    $scope.cursos = data;
  }); 
}]);

app.controller('HomeController', ['$scope', 'dadoshome', function($scope, dadoshome) {
    dadoshome.success(function(data) {
        $scope.dadoshome = data;
    });
}]);

app.controller('ProgressController', ['$scope', function($scope, ngProgressFactory) {
    $scope.progressbar = ngProgressFactory.createInstance();
    $scope.progressbar.start();
}]);
=======
app.controller('CursosController',['$scope','cursos',function($scope,cursos){cursos.success(function(data){$scope.cursos=data})}]);app.controller('HomeController',['$scope','dadoshome',function($scope,dadoshome){dadoshome.success(function(data){$scope.dadoshome=data})}]);
>>>>>>> 70b34f95082d171e98cfe62948f90ede0b36c851
