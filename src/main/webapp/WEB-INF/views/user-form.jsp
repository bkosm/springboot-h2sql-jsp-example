<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="UserForm">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="UserServlet">List All Users</a>

    </h2>
</center>
<div align="center">
    <form:form action="SaveUser" method="post" modelAttribute="user">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${user != null}">
                        Edit User
                    </c:if>
                    <c:if test="${user == null}">
                        Add New User
                    </c:if>
                </h2>
            </caption>
            <c:if test="${user != null}">
                <form:input type="hidden" name="id" path="id"  />
            </c:if>
            <tr>
                <th>User Name:</th>
                <td>
                    <form:input type="text" name="name" size="45" path="name"
                           />
                    />
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <form:input type="text" name="email" size="45" path="email"
                           />
                    />
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <form:input type="text" name="country" size="15" path="country"
                           />
                    />
                </td>
            </tr>
            <tr>
                <th>Is administrator:</th>
                <td>
                    <form:checkbox name="isAdmin" size="15" path="isAdmin"/>
                </td>
            </tr>
            <tr>
                <th>Password:</th>
                <td>
                    <form:input type="password" name="password" size="46" path="password"
                          />
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>