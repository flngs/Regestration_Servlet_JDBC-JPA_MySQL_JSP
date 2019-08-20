
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
    <title>Success getting user by username</title>
</head>
<body>
<h1>User successfully gotten!</h1>
<br/>
<p><h3>Username: <c:out value="${getUserObject.username}"/></h3><p/>
<br/>
INFO:
<br/>
firstName: <c:out value="${getUserObject.firstName}"/>
<br/>
lastName: <c:out value="${getUserObject.lastName}"/>
<br/>
password: <c:out value="${getUserObject.password}"/>
<br/>
address: <c:out value="${getUserObject.address}"/>
<br/>
contact: <c:out value="${getUserObject.contact}"/>
<br/>
<input type="submit" value="MENU" onclick="window.location='index.jsp';"/>
</body>
</html>
