/**
 * Created by ismailrei on 1/24/17.
 */
var appPost = angular.module('appPost', []);

appPost.controller('PostController', ['$scope', '$http', function ($scope, $http) {

    var refrech = function () {
        $http({
            method: 'GET',
            url: 'listPost'
        }).then(function (success) {
            $scope.posts = success.data.posts;
            $scope.filieres = success.data.filieres;
        }, function (error) {

        });
    };
    $scope.getDataFromServer=refrech();
    refrech();

    $scope.addorUpdatePost = function () {
        var params = {
            "id": $scope.post.id,
            "title": $scope.post.title,
            "content":$scope.post.content,
            "picture":$scope.post.picture,
            "filiere":$scope.filiere
        };
        var data = angular.toJson(params);
        $http({
            method: 'POST',
            url: 'addOrUpdatePost',
            data: "newP=" + data,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (success) {
            refrech();
        }, function (error) {

        });
    }

    $scope.deletePost = function (id) {
        $http({
            method: 'DELETE',
            url: 'deletePost?id=' + id,

        }).then(function (success) {
            refrech();
        }, function (error) {

        });
    }

    $scope.get = function (id) {
        $http({
            method: 'GET',
            url: 'editPost?id=' + id
        }).then(function (response) {
            $scope.post=response.data;
        }, function (error) {
        });

    };


    $scope.deselect = function() {
        $scope.post = "";
    }

}]);