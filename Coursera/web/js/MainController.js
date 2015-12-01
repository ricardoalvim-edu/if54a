app.controller('MainController', ['$scope', 'cursos', function($scope, cursos) {
  cursos.success(function(data) {
      $scope.cursos = data;
  });
}]);