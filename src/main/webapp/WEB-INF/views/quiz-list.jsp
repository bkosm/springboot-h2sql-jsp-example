<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Quiz List</title>
</head>
<body>
<center>
    <h1>Quiz list</h1>
    <h2>
        <a href="QuizCreator">Add New Quiz</a>
        <a href="Profile"> Main Page</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of quizes</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Number of questions</th>
            <th>Link</th>
        </tr>
        <c:forEach var="quiz" items="${quizes}">
            <tr>
                <td><c:out value="${quiz.id}"/></td>
                <td><c:out value="${quiz.name}"/></td>
                <td><c:out value="${quiz.questions.size()}"/></td>
                <td><a href="Quiz?id=<c:out value='${quiz.id}' />"> Open</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
