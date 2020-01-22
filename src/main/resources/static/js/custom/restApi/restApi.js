angular.module('demo', [])
    .controller('Hello', function($scope, $http) {
        $http.get('https://gturnquist-quoters.cfapps.io/api/random').
        then(function(response) {
            $scope.greeting = response.data;
            alert(response.data);
        });
    });