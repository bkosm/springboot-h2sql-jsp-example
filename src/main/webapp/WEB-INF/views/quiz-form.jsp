<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quiz creator</title>
</head>
<body>
<form:form action="QuizCreator" method="post" modelAttribute="quiz">
    <table border="1" cellpadding="5">
        <tr>
            <th>Quiz name:</th>
            <td><form:input type="text" name="quizName" size="45" value="" path="name"/></td>
        </tr>
        <tr>
            <th>Quiz definition:</th>
            <td><form:textarea name="quizDefinition" cols="40" rows="15" path="definition"></form:textarea></td>
        </tr>
    </table>

    <input type="submit" value="Create the quiz"/>

</form:form>
<h1> "-" - oznacza polecenie <br>
    "++" - oznacza odpowiedz dobra<br>
    "+" - oznacza odpowiedz zla<br>
    <br>
</h1>
</body>
</html>
