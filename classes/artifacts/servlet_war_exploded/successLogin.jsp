
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 19.07.2019
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удачное логирование</title>
</head>
<body>
<h1>User successfully authorization!</h1>
<br/>
<p><h3>Username: <c:out value="${loginObject.username}"/></h3><p/>
<br/>
INFO:
<br/>
firstName: <c:out value="${loginObject.firstName}"/>
<br/>
lastName: <c:out value="${loginObject.lastName}"/>
<br/>
password: <c:out value="${loginObject.password}"/>
<br/>
address: <c:out value="${loginObject.address}"/>
<br/>
contact: <c:out value="${loginObject.contact}"/>
<br/>
<input type="submit" value="MENU" onclick="window.location='index.jsp';"/>
</body>
</html>
