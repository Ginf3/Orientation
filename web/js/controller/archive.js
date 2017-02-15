
var appPost = angular.module('appArchive', []);

appPost.controller('ArchiveController', ['$scope', '$http', function ($scope, $http) {

    var refrech = function () {

        $http({
            method: 'GET',
            url: 'listArchive'
        }).then(function (success) {

            $scope.archives = success.data;
            console.log($scope.archives);
        }, function (error) {

        });
    };
    $scope.getDataFromServer = refrech();
    refrech();


    $scope.search = function () {
        /*var params = {
            "id": $scope.srch.year
        };
        console.log(params);*/
       // var data = angular.toJson(params);
        console.log($scope.srch.year);
        $http({
            method: 'GET',
            url: 'searchArchive?syear='+$scope.srch.year
        }).then(function (response) {
            $scope.archives = response.data;
            console.log($scope.archives);
        }, function (error) {
        });

    }
}]);