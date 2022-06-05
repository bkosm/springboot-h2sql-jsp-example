<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Hi, <c:out value="${user.name}"/>!</h1>
<a href="/ShowTable">learning</a><br>
<a href="/quiz_form_serblet">quiz</a><br>
<a href="/Forum">forum</a><br>
<a href="/Achievements">List of achievements</a><br>
<a href="/Account">account</a><br>
<a href="/UserServlet">user-management</a><br>
<a href="/QuizCreator">quiz-creator</a><br>
<a href="/QuizList">quiz-list</a><br>
</body>
</html>