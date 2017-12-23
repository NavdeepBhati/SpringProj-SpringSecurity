<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelloWorld page</title>
</head>
<body>
<%
      request.setAttribute("Request-Attribute", "Value of Attribute ");
      response.sendRedirect("http://localhost:8088/SpringWebNoXMl/login");
    %>
    Greeting : ${greeting}
</body>
</html>