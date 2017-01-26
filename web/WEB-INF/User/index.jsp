<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Hajar
  Date: 25/01/2017
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="GetAdduser">Ajouter</a> </h3>
<h1>Liste </h1>

<table class="table">
    <thead>
    <tr>
        <th>login</th>
        <th>pass</th>
        <th>email</th>
        <th>admin</th>
        <th>SUPPRESSION</th>
        <th>MODIFICATION</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="Listuser" status="userStatus">
    <tr>

        <td><s:property value="user.login"/></td>
        <td><s:property value="user.password"/></td>
        <td><s:property value="user.email"/></td>
        <td><s:property value="user.admin"/></td>
        <td><a class="btn btn-danger" href="Deleteuser?id=<s:property value='id'/>"> Supprimer </a></td>
        <td><a class="btn btn-warning" href="edituser?id=<s:property value='id'/>"> Modifier </a></td>
    </tr>
    </s:iterator>
</table>
</body>
</html>
