<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Quiz creator</title>
</head>
<body>
	<form action="NewQuiz" method="post">
		<table border="1" cellpadding="5">
			<tr>
				<th>Quiz name:</th>
				<td><input type="text" name="quizName" size="45" value="" /></td>
			</tr>
			<tr>
				<th>Quiz definition:</th>
				<td><textarea name="quizDefinition" cols="40" rows="15"></textarea></td>
			</tr>
		</table>

		<input type="submit" value="Create the quiz" />
		
	</form>
	<h1> "-" - oznacza polecenie <br>
"++" - oznacza odpowiedz dobra<br>
"+" - oznacza odpowiedz zla<br>
<br>
	</h1>
</body>
</html>