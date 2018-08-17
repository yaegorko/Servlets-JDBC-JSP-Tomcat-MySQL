<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>TABLE</title>
</head>
<body>

<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Password</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.password}</td>
            <td>
                <form metod = "post" action = "/update">
                <button type="submit" name="update" value=${list.id}> Update</button>
                </form>
            </td>
            <td>
                <form metod = "post" action = "/delete">
                <button type="submit" name="delete" value=${list.id}> Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table>
    <form method="post" action="/table">
        <tr>
            <td><input type="submit" name="action" value="Add new user"/></td>
        </tr>
    </form>
</table>

</body>
</html>
