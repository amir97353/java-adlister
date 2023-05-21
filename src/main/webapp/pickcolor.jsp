<%--
  Created by IntelliJ IDEA.
  User: amir.saunders
  Date: 5/17/23
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Pick Color</title>
</head>
<body>

<form action="/colorPick" method="post">
    <label for="userColor">Enter Color </label>
    <input type="text" name="userColor" id="userColor">
    <button>Submit</button>
</form>

</body>
</html>
