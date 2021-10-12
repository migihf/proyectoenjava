<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="style.css" rel="stylesheet" type="text/css">
		
		<title>Tienda Géneris</title>
	</head>
	<body>
		<p><h1>Bienvenidos a Tienda Géneris</h1><p>
			<div class="logbox">
				<form action="Login" method="POST">
					<p class="logmsg">Ingrese sus datos</p>
					<p>Usuario: <input type="text" name="usu" class="logfield"></p>
					<p>Contraseña: <input type="password" name="pass" class="logfield"></p>
					<input type="submit" name="btnLogin" value="Ingresar" class="logbutton">
				</form>
				<%
				if (request.getParameter("error") != null) {
	out.print("<hr><b>Información incorrecta.</b>");
} 
%>
			</div>
		<footer>
			<p><a href="https://github.com" class="glink">¡Revise en Github!</a></p>
		</footer>
	</body>
</html>