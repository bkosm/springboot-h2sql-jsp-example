<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form:form action="Login" method="post" modelAttribute="user">
    Name:<form:input type="text" name="name" path="name"/><br>
    Password:<form:input type="password" name="password" path="password"/><br>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
