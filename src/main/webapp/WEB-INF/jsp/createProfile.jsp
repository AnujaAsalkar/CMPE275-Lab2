<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>User's Profile</h1>
<form:form action="profilecreate" method="POST" commandName="profile">
<table>
<tr>
<td>Student ID:</td>
<td>
<input type="text" name="id" id="id">
</td>
</tr>
<tr>
        <td>Firstname:</td>
        <td><input type="text" name="firstname"></td>
    </tr>
<tr>
        <td>Lastname:</td>
        <td><input type="text" name="lastname"></td>
</tr>
<tr>
        <td>Email:</td>
        <td><input type="email" name="email"></td>
</tr>
<tr>
        <td>Address:</td>
        <td><input type="text" name="address"></td>
</tr>
<tr>
        <td>Organization:</td>
        <td><input type="text" name="organization"></td>
</tr>
<tr>
        <td>About myself</td>
        <td><input type="text" name="aboutMyself"></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Create"/>
</td>
</tr>
</table>
</form:form>

</body>
</html>