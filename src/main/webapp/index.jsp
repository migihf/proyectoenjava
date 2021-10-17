<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="style.css" rel="stylesheet" type="text/css">
		
		<title>Tienda G�neris</title>
	</head>
	<body>
		<p><h1>Bienvenidos a Tienda G�neris</h1><p>
			<div class="logbox">
				<form action="Login" method="POST">
					<p class="logmsg">Ingrese sus datos</p>
					<p>Usuario: <input type="text" name="usu" class="logfield"></p>
					<p>Contrase�a: <input type="password" name="pass" class="logfield"></p>
					<input type="submit" name="btnLogin" value="Ingresar" class="logbutton">
				</form>
				<%
				if (request.getParameter("error") != null) {
	out.print("<hr><b>Informaci�n incorrecta.</b>");
} 
				if (request.getParameter("sesion") != null) {
					out.print("<hr><b>No est� ingresado en el sistema.</b>");
				} 
				if (request.getParameter("salir") != null) {
					out.print("<hr><b>Sesi�n cerrada exitosamente.</b>");
				}
%>
			</div>
		<footer>
			<p><a href="https://github.com/migihf/proyectoenjava" class="glink">�Revise en Github!</a></p>
		</footer>
	</body>
</html>