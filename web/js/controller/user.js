/**
 * Created by ismailrei on 1/24/17.
 */
var appUser = angular.module('appUser', []);

appUser.controller('userController', ['$scope', '$http', function ($scope, $http) {

    var refrech = function () {
        $http({
            method: 'GET',
            url: 'listUser'
        }).then(function (success) {
            $scope.users = success.data;
        }, function (error) {

        });
    };

    refrech();

    $scope.addUser = function () {
        $http({
            method: 'User',
            url: 'addOrUpdateUser',
            data: $scope.user
        }).then(function (success) {
            refrech();
        }, function (error) {

        });
    }

    $scope.deleteUser = function (id) {
        $http.delete('deleteUser?id=' + id).success(function (response) {
            refrech();
        })
    }

    $scope.update = function () {
        $http({
            method: 'PUT',
            url: 'addOrUpdateUser',
            data: $scope.user
        }).then(function (success) {
            refrech();
        }, function (error) {

        });

    }

    $scope.edit = function (id) {
        $http({
            method: 'GET',
            url: 'editUser?id='+id
        }).then(function (success) {
            $scope.user = success.data;
        }, function (error) {

        });
    }

    $scope.deselect = function() {
        $scope.user = "";
    }

}]);