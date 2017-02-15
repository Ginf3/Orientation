<%--
  Created by IntelliJ IDEA.
  User: ismailrei
  Date: 1/24/17
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>index</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<div data-ng-app="appEtudiant">
    <div data-ng-controller="etudiantController">
        <div class="container" >
            <div class="navbar-header">
                <a href="/redirectToFiliere.action" class="navbar-brand">Filiere</a>
                <a href="/redirectToEtudiant.action" class="navbar-brand">Etudiant</a>
                <a href="/redirectToUser.action" class="navbar-brand">User</a>
                <a href="/redirectToPost.action" class="navbar-brand">Post</a>
                <a href="/redirectToPost.action" class="navbar-brand">Archive</a>
            </div>
        </div>

        <table class="table">
            <th>Premier Choix</th>
            <th>Deuxieme Choix</th>
            <th>Troisieme Choix</th>
            <th>Quatrieme Choix</th>
            <th>Cinquieme Choix</th>
            <tr>
                <td>
                    <select class="selectpicker">
                        <option ng-repeat="filiere in filieres">{{filiere.id}}</option>
                    </select>
                </td>
                <td>
                    <select class="selectpicker">
                        <option ng-repeat="filiere in filieres">{{filiere.id}}</option>
                    </select>
                </td>
                <td>
                    <select class="selectpicker">
                        <option ng-repeat="filiere in filieres">{{filiere.id}}</option>
                    </select>
                </td>
                <td>
                    <select class="selectpicker">
                        <option ng-repeat="filiere in filieres">{{filiere.id}}</option>
                    </select>
                </td>
                <td>
                    <select class="selectpicker">
                        <option ng-repeat="filiere in filieres">{{filiere.id}}</option>
                    </select>
                </td>
            </tr>
        </table>

    </div>
</div>
</body>

<style>
    #heading {
        font-size: x-large;
        font-weight: bold;
    }

    .text {
        width: 99%;
        height: 200px;
    }

    .small {
        font-size: small;
    }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-resource.min.js"></script>
<script src="/js/controller/cvImport.js"></script>
<script src="/js/controller/etudiant.js"></script>
</html>