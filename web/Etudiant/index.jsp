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
</head>
<body>
<div data-ng-app="appEtudiant">
    <div data-ng-controller="etudiantController">


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