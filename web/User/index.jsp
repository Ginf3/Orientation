<%--
  Created by IntelliJ IDEA.
  User: ismailrei
  Date: 1/24/17
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<div data-ng-app="appUser">
    <div data-ng-controller="UserController">
        <div class="container" >
            <div class="navbar-header">
                <a href="/redirectToFiliere.action" class="navbar-brand">Filiere</a>
                <a href="/redirectToEtudiant.action" class="navbar-brand">Etudiant</a>
                <a href="/redirectToUser.action" class="navbar-brand">User</a>
                <a href="/redirectToPost.action" class="navbar-brand">Post</a>
                <a href="" class="navbar-brand">Archive</a>
            </div>
        </div>
        <div class="col-md-6">
            <table class="table">
                <th>Id</th>
                <th>Login</th>
                <th>Password</th>
                <th>Email</th>
                <th>Admin</th>
                <th>Modify</th>
                <th>Delete</th>
                <tr ng-repeat="user in users" class="table">
                    <td>{{user.id}}</td>
                    <td>{{user.login}}</td>
                    <td>{{user.password}}</td>
                    <td>{{user.email}}</td>
                    <td><input type="checkbox" disabled class="form-control" ng-model="user.admin"/></td>
                    <td>
                        <button class="btn btn-warning" ng-click="get(user.id)">Edit</button>
                    </td>
                    <td>
                        <button class="btn btn-danger" ng-click="deleteUser(user.id)">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td><input class="form-control" type="hidden" ng-model="user.id"/></td>
                    <td><input class="form-control" ng-model="user.login"/></td>
                    <td><input class="form-control" type="password" ng-model="user.password"/></td>
                    <td><input class="form-control" ng-model="user.email"/></td>
                    <td><input type="checkbox" class="form-control" ng-model="user.admin"/></td>
                    <td>
                        <button data-ng-click="addorUpdateUser()" class="btn btn-primary">
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
<script src="/js/controller/user.js"></script>
</body>
</html>