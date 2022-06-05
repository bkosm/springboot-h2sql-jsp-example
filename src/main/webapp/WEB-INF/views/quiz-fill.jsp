<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Fill the quiz</title>
</head>
<body>
<form:form action="Quiz" method="post" modelAttribute="quiz">
    <table border="1" cellpadding="5">
        <tr>
            <th>Quiz:</th>
            <td><c:out value="${quiz.name}"/></td>
        </tr>
        <c:forEach items="${quiz.questions}" var="question" varStatus="status">
            <tr>
                <th>Question ${status.index + 1}:</th>
                <td><c:out value="${question.description}"/>
                <ul>
                    <c:forEach items="${question.answers}" var="answer" varStatus="answerStatus">
                        <li>
                            <input type="checkbox">${answer.text}
                        </li>
                    </c:forEach>
                </ul>
                </td>
            </tr>
        </c:forEach>

    </table>

    <input type="submit" value="Finish"/>

</form:form>
</body>
</html>
