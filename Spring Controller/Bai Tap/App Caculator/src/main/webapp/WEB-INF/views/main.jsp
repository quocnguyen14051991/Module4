<%--
  Created by IntelliJ IDEA.
  User: HK
  Date: 14/10/2020
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator" method="post">
    <h1>Caculator</h1>
    <input type="text" name="num1" value="${A}">
    <input type="text" name="num2" value="${B}"> </br>
    <input type="submit" value="Addition(+)" name="a">
    <input type="submit" value="Addition(-)" name="a">
    <input type="submit" value="Addition(X)" name="a">
    <input type="submit" value="Addition(/)" name="a">
    <h2>Result Division:<label style="color: red">${result}</label></h2>
</form>
</body>
</html>
