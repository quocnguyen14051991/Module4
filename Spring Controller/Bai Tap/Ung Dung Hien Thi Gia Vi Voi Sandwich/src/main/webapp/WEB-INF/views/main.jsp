<%--
  Created by IntelliJ IDEA.
  User: HK
  Date: 14/10/2020
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sanwich" method="post">
    <h1>Sanwich Condiments</h1>
    <input type="checkbox" id="lettuce" name="nameA" value="Lettuce">
    <label for="lettuce"> Lettuce</label>
    <input type="checkbox" id="tomato" name="nameA" value="Tomato">
    <label for="tomato"> Tomato</label>
    <input type="checkbox" id="mustard" name="nameA" value="Mustard">
    <label for="mustard">Mustard </label>
    <input type="checkbox" id="Sprouts" name="nameA" value="Sprouts">
    <label for="mustard">Sprouts </label>
    <hr>
    <input type="submit" value="Save">
</form>
</body>
</html>
