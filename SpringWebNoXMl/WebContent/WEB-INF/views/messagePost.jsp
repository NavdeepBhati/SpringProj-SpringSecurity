<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Message Post</title>
</head>
<body>
	<form:form method="POST" modelAttribute="message">
		<table>
			<tr>
				<td>Title</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Body</td>
				<td><form:textarea path="body" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Post" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>