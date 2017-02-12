/**
 * Created by ismailrei on 1/24/17.
 */
var appUser = angular.module('appUser', []);

appUser.controller('UserController', ['$scope', '$http', function ($scope, $http) {

    var refrech = function () {
        $http({
            method: 'GET',
            url: 'listUser'
        }).then(function (success) {
            $scope.users = success.data;
        }, function (error) {

        });
    };
    $scope.getDataFromServer=refrech();
    refrech();

    $scope.addorUpdateUser = function () {
        var params = {
            "id": $scope.user.id,
            "login": $scope.user.login,
            "email":$scope.user.email,
            "admin":$scope.user.admin,
            "password":$scope.user.password
        };
        var data = angular.toJson(params);
        $http({
            method: 'POST',
            url: 'addOrUpdateUser',
            data: "newU=" + data,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (success) {
            refrech();
        }, function (error) {

        });
    }

    $scope.deleteUser = function (id) {
        $http({
            method: 'DELETE',
            url: 'deleteUser?id=' + id,

        }).then(function (success) {
            refrech();
        }, function (error) {

        });
    }

    $scope.get = function (id) {
        $http({
            method: 'GET',
            url: 'editUser?id=' + id
        }).then(function (response) {
            $scope.user=response.data;
        }, function (error) {
        });

    };


    $scope.deselect = function() {
        $scope.user = "";
    }

}]);