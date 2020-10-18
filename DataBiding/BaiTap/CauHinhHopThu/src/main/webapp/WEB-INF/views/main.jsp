<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HK
  Date: 15/10/2020
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form method="post" action="/edit" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="language">Language</form:label></td>
            <td><form:select path="language">
                <form:option value="Enghlish">English</form:option>
                <form:option value="Vietnamese">Vietnamese</form:option>
                <form:option value="Janpanese">Janpanese</form:option>
                <form:option value="Chinese">Chinese</form:option>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size</form:label></td>
            <td>
               <b>show</b> <form:select path="pageSize">
                <form:option value="5">5</form:option>
                <form:option value="10">10</form:option>
                <form:option value="15">15</form:option>
                <form:option value="25">25</form:option>
                <form:option value="50">50</form:option>
                <form:option value="100">100</form:option>
            </form:select>
                <b>Email per Page</b>
            </td>
        </tr>
        <tr>
            <td><form:label path="spams">Spams Filter:</form:label></td>
            <td><form:checkbox path="spams"/>Enable spam filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature:</form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"/>
                <input type="submit" value="cancel">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
