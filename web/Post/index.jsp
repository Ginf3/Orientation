<%--
  Created by IntelliJ IDEA.
  Post: ismailrei
  Date: 1/24/17
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Posts</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<div data-ng-app="appPost">
    <div data-ng-controller="PostController">
        <div class="container" >
            <div class="navbar-header">
                <a href="/redirectToFiliere.action" class="navbar-brand">Filiere</a>
                <a href="/redirectToEtudiant.action" class="navbar-brand">Etudiant</a>
                <a href="/redirectToUser.action" class="navbar-brand">User</a>
                <a href="/redirectToPost.action" class="navbar-brand">Post</a>
                <a href="/redirectToArchive.action" class="navbar-brand">Archive</a>
            </div>
        </div>
        <div class="col-md-6">
            <table class="table">
                <th>Id</th>
                <th>Picture</th>
                <th>Title</th>
                <th>Content</th>
                <th>Filiere</th>
                <th>Modify</th>
                <th>Delete</th>
                <tr ng-repeat="post in posts" class="table">
                    <td>{{post.picture}}</td>
                    <td>{{post.id}}</td>
                    <td>{{post.title}}</td>
                    <td>{{post.content}}</td>
                    <td>{{post.filiere.id}}</td>
                    <td>
                        <button class="btn btn-warning" ng-click="get(post.id)">Edit</button>
                    </td>
                    <td>
                        <button class="btn btn-danger" ng-click="deletePost(post.id)">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td><input class="form-control" type="hidden" ng-model="post.id"/></td>
                    <td><input class="form-control" ng-model="post.picture"/></td>
                    <td><input class="form-control" ng-model="post.title"/></td>
                    <td><input class="form-control" ng-model="post.content"/></td>
                    <td><input class="form-control" ng-model="filiere"/></td>
                    <td>
                        <button data-ng-click="addorUpdatePost()" class="btn btn-primary">
                            <span ng-if="update === true">Update</span>
                            <span ng-if="update === false">Ajout</span>
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-clear" ng-click="deselect()">Clear</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-resource.min.js"></script>
<script src="/js/controller/post.js"></script>
</body>
</html>