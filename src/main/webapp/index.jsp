<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title> Таблица юзеров </title>
<body>


<c:forEach var="c" items="${users}">
    <c:set var="qry" value="?id=${c.id}"/>

</c:forEach>

    </table>

    </body>
    </html>
