<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 01.08.2019
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get user by username</title>
</head>
<body>
<form action="/getUser" method="post">
    <p><h1>Getting a user by username</h1><br/>
    <input type="text" name="username"/><br/>
    <input type="submit" value="OK"/>

</form>
</body>
</html>
