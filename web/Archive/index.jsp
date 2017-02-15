<%--
  Created by IntelliJ IDEA.
  User: Hajar
  Date: 13/02/2017
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta charset="ISO-8859-1">
        <title>Posts</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    </head>
<body>
<div data-ng-app="appArchive">
    <div data-ng-controller="ArchiveController">
        <div class="container" >
            <div class="navbar-header">
                <a href="/redirectToFiliere.action" class="navbar-brand">Filiere</a>
                <a href="/redirectToEtudiant.action" class="navbar-brand">Etudiant</a>
                <a href="/redirectToUser.action" class="navbar-brand">User</a>
                <a href="/redirectToPost.action" class="navbar-brand">Post</a>
                <a href="/redirectToArchive.action" class="navbar-brand">Archive</a>
            </div>
        </div>
        <div>
            <table>
                <td> <input class="form-control" ng-model="srch.year" name="annee"/></td>
                <td><button data-ng-click="search()"  class="btn btn-primary">Search</button></td>
            </table>
        </div>
        <div class="col-md-6">
            <table class="table">
                <th>cne</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Note</th>
                <th>Classement</th>
                <th>Filiere affectee</th>
                <th>Annee</th>
                <tr ng-repeat="archive in archives" class="table">
                    <td>{{archive.cne}}</td>
                    <td>{{archive.nom}}</td>
                    <td>{{archive.prenom}}</td>
                    <td>{{archive.note}}</td>
                    <td>{{archive.classement}}</td>
                    <td>{{archive.affected}}</td>
                    <td>{{archive.annee}}</td>
                </tr>

            </table>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-resource.min.js"></script>
<script src="/js/controller/archive.js"></script>
</body>
</html>
