<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Hajar
  Date: 25/01/2017
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <a href="listuser">Liste</a>
</head>
<body>
<h1>Bienvenue</h1>
<h2>Ajouter </h2>
<s:actionerror/>
<s:form action="addU" method="post">


    <s:textfield name="user.admin" label="Admin"/>
    <s:textfield name="user.email" label="Email"/>
    <s:textfield name="user.login" label="LOGIN"/>
    <s:textfield name="user.password" label="Pass"/>
    <s:hidden name="user.id"/>
    <s:submit value="Submit" align="center"/>
</s:form>
</body>
</html>
