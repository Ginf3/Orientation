/**
 * Created by ismailrei on 1/24/17.
 */
var appEtudiant = angular.module('appEtudiant', []);

appEtudiant.controller('etudiantController', ['$scope', '$http', function ($scope, $http) {
    $scope.json=null;
    $scope.etudiants={};
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
    $scope.addCsv=function(){
        var id=0;
        $scope.json=JSON.parse($scope.json);
        angular.forEach($scope.json,function(value,key){
           if(value.id)
           {
               $scope.etudiant=value;
               $scope.etudiants[key]=value;
               $scope.addorUpdateEtudiant;
           }




        })

    }
    $scope.addorUpdateEtudiant = function () {
        $http({
            method: 'POST',
            url: 'addOrUpdateEtudiant',
            data: "newEtudiant="+$scope.etudiant
        }).then(function (success) {
            refrech();
        }, function (error) {

        });
    }

    $scope.deleteEtudiant = function (id) {
        $http({
            method: 'DELETE',
            url: 'deleteEtudiant?id=' + id,

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