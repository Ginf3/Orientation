/**
 * Created by ismailrei on 1/24/17.
 */
var appPost = angular.module('appPost', []);

appPost.controller('postController', ['$scope', '$http', function ($scope, $http) {

    var refrech = function () {
        $http({
            method: 'GET',
            url: 'listPost'
        }).then(function (success) {
            $scope.posts = success.data;
        }, function (error) {

        });
    };

    refrech();

    $scope.addPost = function () {
        $http({
            method: 'POST',
            url: 'addOrUpdatePost',
            data: $scope.post
        }).then(function (success) {
            refrech();
        }, function (error) {

        });
    }

    $scope.deletePost = function (id) {
        $http.delete('deletePost?id=' + id).success(function (response) {
            refrech();
        })
    }

    $scope.update = function () {
        $http({
            method: 'PUT',
            url: 'addOrUpdatePost',
            data: $scope.post
        }).then(function (success) {
            refrech();
        }, function (error) {

        });

    }

    $scope.edit = function (id) {
        $http({
            method: 'GET',
            url: 'editPost?id='+id
        }).then(function (success) {
            $scope.post = success.data;
        }, function (error) {

        });
    }

    $scope.deselect = function() {
        $scope.post = "";
    }

}]);