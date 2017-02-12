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
</head>
<body>
<div data-ng-app="appUser">
    <div data-ng-controller="UserController">
        <tbody>
        <tr>
            <td><input class="form-control" type="hidden" ng-model="user.id"/></td>
            <td><input class="form-control" ng-model="user.login"/></td>
            <td><input class="form-control" type="password" ng-model="user.password"/></td>
            <td><input class="form-control" ng-model="user.email"/></td>
            <td><input class="form-control" ng-model="user.admin"/></td>
            <td>
                <button data-ng-click="addorUpdateUser()">Add User</button>
            </td>
            <td>
                <button data-ng-click="addorUpdateUser()">update</button>
            </td>
            <td>
                &nbsp;&nbsp;
                <button class="btn btn-info" ng-click="deselect()">Clear</button>
            </td>
        </tr>
        </tr>
        </tbody>

        <button data-ng-click="getDataFromServer()">
            get Users
        </button>
        <div ng-repeat="user in users">
            <td>id : {{user.id}}</td>
            <td> login : {{user.login}}</td>
            <td> login : {{user.email}}</td>
            <td> admin : {{user.admin}}</td>
            <td>
                <button class="btn btn-warning" ng-click="get(user.id)">Edit</button>
            </td>
            <td>
                <button class="btn btn-warning" ng-click="deleteUser(user.id)">Delete</button>
            </td>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-resource.min.js"></script>
<script src="/js/controller/user.js"></script>
</body>
</html>