<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: amir.saunders
  Date: 5/17/23
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login.jsp" method="post">
    <h5>UserName</h5>
    <input type="text" name="username" id="userName">
    <h5>Password</h5>
    <input type="text" name="password" id="password">
    <button type="submit">Submit</button>
</form>
<%--<%--%>
<%--    String userame= request.getParameter("username");--%>
<%--    String password = request.getParameter("password");--%>
<%--%>--%>
<%--<c:choose>--%>
<%--    <c:when test="username = admin " && "password = password>--%>
<%--    response.sendRedirect("/profile");--%>

<%--</c:when>--%>
<%--</c:choose>--%>


</body>



<c:choose>
    <c:when test="${param.username.equals('admin') && param.password.equals('password')}">
        <c:redirect url="profile.jsp" />
    </c:when>
</c:choose>


</body>
</html>
