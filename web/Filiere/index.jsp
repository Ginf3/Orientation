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
    <title>Filieres</title>
</head>
<body>
<div data-ng-app="appFiliere">
    <div data-ng-controller="filiereController">
        <tbody>
        <tr>
            <td><input class="form-control"  ng-model="filiere.id"/></td>
            <td><input class="form-control" ng-model="filiere.nom"/></td>
            <td><input class="form-control" ng-model="filiere.effictif"/></td>
            <td>
                <button data-ng-click="addorUpdateFiliere()">Add Filiere</button>
            </td>
            <td>
                <button data-ng-click="addorUpdateFiliere()">update</button>
            </td>
            <td>
                &nbsp;&nbsp;
                <button class="btn btn-info" ng-click="deselect()">Clear</button>
            </td>
        </tr>
        </tr>
        </tbody>

        <button data-ng-click="getDataFromServer()">
            get filieres
        </button>
        <div ng-repeat="filiere in filieres">
            <td>id : {{filiere.id}}</td>
            <td> Name : {{filiere.nom}}</td>
            <td> effectif : {{filiere.effictif}}</td>
            <td>
                <button class="btn btn-warning" ng-click="get(filiere.id)">Edit</button>
            </td>
            <td>
                <button class="btn btn-warning" ng-click="deleteFiliere(filiere.id)">Delete</button>
            </td>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-resource.min.js"></script>
<script src="/js/controller/filiere.js"></script>
</body>
</html>