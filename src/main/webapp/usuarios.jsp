<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    	<meta charset="UTF-8">
    <link rel="stylesheet" href="usuarios.css">
	<title>Gestión de Usuarios | Tienda Géneris</title>
</head>

<body>
<%!
long cedula = 0;
String nombre = "", correo = "", usuario = "", pass = ""; 
%>
<%
if (request.getParameter("cedula") != null) {
	cedula = Long.parseLong(request.getParameter("cedula"));
	nombre = request.getParameter("nombre");
	correo = request.getParameter("correo");
	usuario = request.getParameter("usuario");
	pass = request.getParameter("pass");	
}
%>    
    <header>
        <div class="logo-titulo">
			<h1>Tienda Géneris | Gestión de Usuarios</h1>
        </div>
        <nav>
            <b>Usuarios</b>&nbsp;|&nbsp;
			<a href="clientes.jsp">Clientes</a>&nbsp;|&nbsp;
			<a href="proveedores.jsp">Proveedores</a>&nbsp;|&nbsp;
			<a href="productos.jsp">Productos</a>&nbsp;|&nbsp;
			<a href="ventas.jsp">Ventas</a>&nbsp;|&nbsp;
			<a href="reportes.jsp">Reportes</a>
        </nav>
    </header>

    <fieldset class="cont-form">
	<legend>Gestion Usuarios</legend>
        <form action="Usuarios" method="POST">
        	<p>&nbsp;Usuario<input type="text" name="usuario" placeholder="Usuario"></p>
        	<p>&nbsp;Contraseña<input type="text" name="pass" placeholder="Contraseña"></p>
			<p>&nbsp;Cédula<input type="text" name="cedula" placeholder="Cédula"></p>
			<p>&nbsp;Nombre completo<input type="text" name="nombre" placeholder="Nombre Completo"></p>
			<p>&nbsp;Correo Electrónico<input type="text" name="correo" placeholder="Correo Electrónico"></p>
          
			<div class="sentbtn">
            <input type="submit" name="consultar" value="Consultar">
            <input type="submit" name="insertar" value="Insertar">
            <input type="submit" name="actualizar" value="Actualizar">
            <input type="submit" name="eliminar" value="Eliminar">
            </div>
		</form>
		
		</fieldset>
		<%
if (request.getParameter("cedula") != null) {
	out.print("<fieldset class=\"cont-form\">\n<legend>Resultado</legend>");
	out.print("<p>&nbsp;<b>Usuario</b>: "+usuario+"</p>");
    out.print("<p>&nbsp;<b>Contraseña</b>: "+pass+"</p>");
	out.print("<p>&nbsp;<b>Cédula</b>: "+cedula+"</p>");
	out.print("<p>&nbsp;<b>Nombre completo</b>: "+nombre+"</p>");
	out.print("<p>&nbsp;<b>Correo Electrónico</b>: "+correo+"</p>\n</fieldset>");
	}
%>
<%
if (request.getParameter("resultado") != null) {
	out.print("<fieldset class=\"cont-form\">\n<legend>Resultado</legend><p>Operación exitosa.</p></fieldset>");
} 
if (request.getParameter("error") != null) {
	out.print("<fieldset class=\"cont-form\">\n<legend>Resultado</legend><p>Operación no exitosa.</p></fieldset>");
} 
if (request.getParameter("ed") != null) {
	out.print("<fieldset class=\"cont-form\">\n<legend>Resultado</legend><p>Usuario no hallado.</p></fieldset>");
} 
if (request.getParameter("ds") != null) {
	out.print("<fieldset class=\"cont-form\">\n<legend>Resultado</legend><p>El usuario no ingresó correctamente todos los campos.</p></fieldset>");
} 
%>
</body>
</html>