/**
 * Created by ismailrei on 1/24/17.
 */
var appEtudiant = angular.module('appEtudiant', ['ngJsonExportExcel']);

appEtudiant.controller('etudiantController', ['$scope', '$http', function ($scope, $http) {

    var refrech = function () {
        $http({
            method: 'GET',
            url: 'listEtudiant'
        }).then(function (success) {
            $scope.etudiants = success.data;
        }, function (error) {

        });
    };

    refrech();

    $scope.addEtudiant = function () {
        $http({
            method: 'POST',
            url: 'addOrUpdateEtudiant',
            data: $scope.etudiant
        }).then(function (success) {
            refrech();
        }, function (error) {

        });
    }

    $scope.deleteEtudiant = function (id) {
        $http.delete('deleteEtudiant?id=' + id).success(function (response) {
            refrech();
        })
    }

    $scope.update = function () {
        $http({
            method: 'PUT',
            url: 'addOrUpdateEtudiant',
            data: $scope.etudiant
        }).then(function (success) {
            refrech();
        }, function (error) {

        });

    }

    $scope.edit = function (id) {
        $http({
            method: 'GET',
            url: 'editEtudiant?id='+id
        }).then(function (success) {
            $scope.etudiant = success.data;
        }, function (error) {

        });
    }

    $scope.deselect = function() {
        $scope.etudiant = "";
    }

}]);