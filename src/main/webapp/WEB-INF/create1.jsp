<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 15.08.2018
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreateUser</title>
</head>
<body>
<section>
    <table class="table table-striped">
        <form role="form" method="post" action="create" class="well">
            <div class="form-group">
                <label for="name">User name</label>
                <input class="form-control" id="name" name="name" placeholder="username">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input class="form-control" id="password" name="password" placeholder="password">
            </div>
            <input type="submit" name="action" value="Add new user"/>
        </form>
    </table>
</section>
</body>
</html>
