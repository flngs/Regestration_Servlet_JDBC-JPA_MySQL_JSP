<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 01.08.2019
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user by username</title>
</head>
<body>
<form action="/update" method="post">
    <table style="with: 80%">
        <tr>
            <h1><td>UserName</td></h1>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <h2>UPDATEABLE DATA</h2>
        </tr>
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName" /></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" /></td>
        </tr>
        <tr>
            <td>Contact No</td>
            <td><input type="text" name="contact" /></td>
        </tr>
    </table>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
