<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    	<meta charset="UTF-8">
    <link rel="stylesheet" href="usuarios.css">
	<title>Gestión de Clientes | Tienda Géneris</title>
</head>

<body>
<%!
long cedula = 0;
String direccion = "", nombre = "", correo= "", telefono= ""; 
%>
<%
if (request.getParameter("cedula") != null) {
	cedula = Long.parseLong(request.getParameter("cedula"));
	direccion = request.getParameter("direccion");
	nombre = request.getParameter("nombre");
	correo = request.getParameter("correo");
	telefono = request.getParameter("telefono");
}
%>    
    <header>
        <div class="logo-titulo">
			<h1>Tienda Géneris | Gestión de Clientes</h1>
        </div>
        <nav>
            <a href="usuarios.jsp">Usuarios</a>&nbsp;|&nbsp;
			<b>Clientes</b>&nbsp;|&nbsp;
			<a href="proveedores.jsp">Proveedores</a>&nbsp;|&nbsp;
			<a href="productos.jsp">Productos</a>&nbsp;|&nbsp;
			<a href="ventas.jsp">Ventas</a>&nbsp;|&nbsp;
			<a href="reportes.jsp">Reportes</a>&nbsp;|&nbsp;
			<a href="Salir">Cerrar Sesión</a>
        </nav>
    </header>

    <fieldset class="cont-form">
	<legend>Gestión Clientes</legend>
        <form action="Clientes" method="POST">
        	<p>&nbsp;Cédula<input type="text" name="cedula" placeholder="Cédula"></p>
        	<p>&nbsp;Dirección<input type="text" name="direccion" placeholder="Dirección"></p>
			<p>&nbsp;Nombre<input type="text" name="nombre" placeholder="Nombre"></p>
			<p>&nbsp;Correo Electrónico<input type="text" name="correo" placeholder="Correo Electrónico"></p>
			<p>&nbsp;Teléfono<input type="text" name="telefono" placeholder="Teléfono"></p>
          
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
	out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend>");
	out.print("<p>&nbsp;<b>Cédula</b>: "+cedula+"</p>");
    out.print("<p>&nbsp;<b>Dirección</b>: "+direccion+"</p>");
	out.print("<p>&nbsp;<b>Nombre</b>: "+nombre+"</p>");
	out.print("<p>&nbsp;<b>Correo Electrónico</b>: "+correo+"</p>");
	out.print("<p>&nbsp;<b>Teléfono</b>: "+telefono+"</p>\n</fieldset>");
	}
%>
<%
if (request.getParameter("resultado") != null) {
	out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Operación exitosa.</p></fieldset>");
} 
if (request.getParameter("error") != null) {
	out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Operación no exitosa.</p></fieldset>");
} 
if (request.getParameter("ed") != null) {
	out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Cliente no hallado.</p></fieldset>");
} 
if (request.getParameter("ds") != null) {
	out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>No se ingresaron correctamente todos los campos.</p></fieldset>");
} 
%>
</body>
</html>