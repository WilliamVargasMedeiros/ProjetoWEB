<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>ProjetoWEB</title>
</head>
<body>

<form action="ServletLogin" method="post">
	<input type="text" name="login">
	<input type="password" name="senha">
	<input type="submit" value="Enviar">
</form>

<h4>${msg}</h4>

</body>
</html>