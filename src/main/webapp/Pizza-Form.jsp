<%--
  Created by IntelliJ IDEA.
  User: amir.saunders
  Date: 5/17/23
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pizza Form</title>
</head>
<body>


<form action="/Pizza-Order" method="post">
    <label for="crustType">Enter Crust Type </label>
    <input type="text" name="crustType" id="crustType">

    <label for="sauceType">Enter Sauce Type </label>
    <input type="text" name="sauceType" id="sauceType">

    <label for="pizzaSize">Enter Pizza Size </label>
    <input type="text" name="pizzaSize" id="pizzaSize">
    <button>Submit</button>
</form>

</body>
</html>
