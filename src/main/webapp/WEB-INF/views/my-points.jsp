<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>My points</title>
</head>
<body>
	<table border="1" cellpadding="5">
		<tr>
			<th>User Name:</th>
			<td><input type="text" name="name" size="45" disabled
				value="<c:out value='${user.name}' />" /></td>
		</tr>
		<tr>
			<th>Points:</th>
			<td><input type="text" name="points" size="45" disabled
				value="<c:out value='${user.points}' />" /></td>
		</tr>
	</table>
</body>
</html>