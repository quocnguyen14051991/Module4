<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HK
  Date: 14/10/2020
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Day Of Birth</th>
        <th>Action</th>
    </tr>
    <c:forEach var="cus" items="${listCus}">
        <tr>
            <td>${cus.idCustomer}</td>
            <td>${cus.nameCustomer}</td>
            <td>${cus.dayOfBirth}</td>
            <td><a href="/${cus.idCustomer}">${cus.nameCustomer}</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
