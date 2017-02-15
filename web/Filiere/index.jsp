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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<div data-ng-app="appFiliere">
    <div data-ng-controller="filiereController">
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
                <th>Nom</th>
                <th>Prenom</th>
                <th>Effectif</th>
                <th>Modify</th>
                <th>Delete</th>

                <tr ng-repeat="filiere in filieres" class="table">
                    <td>{{filiere.id}}</td>
                    <td>{{filiere.nom}}</td>
                    <td>{{filiere.effictif}}</td>
                    <td>
                        <button class="btn btn-warning" ng-click="get(filiere.id)">Edit</button>
                    </td>
                    <td>
                        <button class="btn btn-danger" ng-click="deleteFiliere(filiere.id)">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td><input class="form-control"  ng-model="filiere.id" /></td>
                    <td><input class="form-control" ng-model="filiere.nom"/></td>
                    <td><input class="form-control" ng-model="filiere.effictif"/></td>
                    <td>
                        <button data-ng-click="addorUpdateFiliere()" class="btn btn-primary">
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
<script src="/js/controller/filiere.js"></script>
</body>
</html>