<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<%--    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">--%>
</head>

<body>
<div>
    <table class="table">
        <thead>
        <th scope="col">ID</th>
        <th scope="col">UserName</th>
        <th scope="col">Password</th>
        <th scope="col">Roles</th>
        </thead>
        <c:forEach items="${allUsers}" var="user">
            <tr>
                <td scope="row">${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>
                    <c:forEach items="${user.roles}" var="role">${role.name}; </c:forEach>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin" method="post">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit">Delete</button>
                    </form>

                </td>

            </tr>
        </c:forEach>
    </table>
    <a href="/">Главная</a>
</div>
</body>
</html>