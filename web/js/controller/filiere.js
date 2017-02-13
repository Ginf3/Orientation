/**
 * Created by ismailrei on 1/24/17.
 */
var appFiliere = angular.module('appFiliere', []);

appFiliere.controller('filiereController', ['$scope', '$http', function ($scope, $http) {
    $scope.update = false;
    var refrech = function () {
        $http({
            method: 'GET',
            url: 'listFiliere'
        }).then(function (success) {
            $scope.filieres = success.data;
        }, function (error) {

        });
    };
    $scope.getDataFromServer=refrech();
    refrech();

    $scope.addorUpdateFiliere = function () {
        var params = {
            "id": $scope.filiere.id,
            "nom": $scope.filiere.nom,
            "effectif":$scope.filiere.effictif
        };
        var data = angular.toJson(params);
        $http({
            method: 'POST',
            url: 'addOrUpdateFiliere',
            data: "newF=" + data,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (success) {
            $scope.update = false;
            refrech();
        }, function (error) {

        });
    }

    $scope.deleteFiliere = function (id) {
        $http({
            method: 'DELETE',
            url: 'deleteFiliere?id=' + id,

        }).then(function (success) {
            refrech();
        }, function (error) {

        });
    }

    $scope.get = function (id) {
        $scope.update = true;
        $http({
            method: 'GET',
            url: 'editFiliere?id=' + id
        }).then(function (response) {
            $scope.filiere=response.data;

        }, function (error) {
        });

    };


    $scope.deselect = function() {
        $scope.filiere = "";
        $scope.update = false;
    }

}]);