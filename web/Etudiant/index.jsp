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
    <title>CSV to JSON</title>
</head>
<body>
<div data-ng-app="appEtudiant">
    <div data-ng-controller="etudiantController">


<div id="csv" class="text ">
    <fieldset>
        <legend>Charger votre fichier de type Csv</legend>
        <input type="file" name="File Upload" id="fileinput" accept=".csv" />
    </fieldset>
</div>

<button id="convert" >Charger</button>
&nbsp;&nbsp;
<button data-ng-click="addCsv()">Confirmer</button>
        <fieldset ng-if="json">
            <tbody>
            <legend>Liste des etudiants</legend>
            <th>id</th>
            <th>id_patient</th>
            <th>id_hopital</th>
            <th>id_cause</th>
            <th>date</th>
        <div class="test" ng-repeat="etudiant in etudiants">
            <td>{{etudiant.id}}</td>
            <td>{{etudiant.id_patient}}</td>
            <td>{{etudiant.id_hopital}}</td>
            <td>{{etudiant.id_cause}}</td>
            <td>{{etudiant.date}}</td>

        </div>
            </tbody>
        </fieldset>

        <div class="test" id="json"/>

        </div>
    </div>
</body>
<style>
    #heading { font-size: x-large; font-weight: bold; }
    .text { width: 99%; height: 200px; }
    .small { font-size: small; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-resource.min.js"></script>
<script src="/js/controller/cvImport.js"></script>
<script src="/js/controller/etudiant.js"></script>
</html>