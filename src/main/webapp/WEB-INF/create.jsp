<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${string}"/></title>
</head>
<body>
<b> <c:out value="${string}"/> <c:out value="${suffix}"/> </b>
<br/>
<form method="post" action="${string.toLowerCase()}">
    Enter User Name <input type="text" name="name" value=${user.name}> <br>
    Enter Password <input type="text" name="password" value=${user.password}> <br>
    <input type="submit" value="${string}">
</form>
</body>
</html>