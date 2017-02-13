/**
 * Created by ismailrei on 1/24/17.
 */
var appPost = angular.module('appPost', []);

appPost.controller('PostController', ['$scope', '$http', function ($scope, $http) {
    $scope.update = false;
    var refrech = function () {

        $http({
            method: 'GET',
            url: 'listPost'
        }).then(function (success) {
            $scope.posts = success.data[0];
            $scope.filieres = success.data[1];
        }, function (error) {

        });
    };
    $scope.getDataFromServer=refrech();
    refrech();

    $scope.addorUpdatePost = function () {

        angular.forEach($scope.filieres, function (value,key) {
            if(value.id==$scope.filiere)
            {
                $scope.post.filiere=value;
            }
        });
        console.log( $scope.post.filiere);
        var params = {
            "id": $scope.post.id,
            "title": $scope.post.title,
            "content":$scope.post.content,
            "picture":$scope.post.picture,
            "filiere":$scope.post.filiere
        };
        var data = angular.toJson(params);
        $http({
            method: 'POST',
            url: 'addOrUpdatePost',
            data: "newP=" + data,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (success) {
            $scope.update = false;
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
        $scope.update = true;
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
        $scope.update = false;
    }

}]);