/**
 * Created by ismailrei on 1/24/17.
 */
var appFiliere = angular.module('appFiliere', []);

appFiliere.controller('filiereController', ['$scope', '$http', function ($scope, $http) {

    var refrech = function () {
        $http({
            method: 'GET',
            url: 'listFiliere'
        }).then(function (success) {
            $scope.filieres = success.data;
        }, function (error) {

        });
    };

    refrech();

    $scope.addFiliere = function () {
        $http({
            method: 'POST',
            url: 'addOrUpdateFiliere',
            data: $scope.filiere
        }).then(function (success) {
            refrech();
        }, function (error) {

        });
    }

    $scope.deleteFiliere = function (id) {
        $http.delete('deleteFiliere?id=' + id).success(function (response) {
            refrech();
        })
    }

    $scope.update = function () {
        $http({
            method: 'PUT',
            url: 'addOrUpdateFiliere',
            data: $scope.filiere
        }).then(function (success) {
            refrech();
        }, function (error) {

        });

    }

    $scope.edit = function (id) {
        $http({
            method: 'GET',
            url: 'editFiliere?id='+id
        }).then(function (success) {
            $scope.filiere = success.data;
        }, function (error) {

        });
    }

    $scope.deselect = function() {
        $scope.filiere = "";
    }

}]);