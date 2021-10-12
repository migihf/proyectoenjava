<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    	<meta charset="UTF-8">
    <link rel="stylesheet" href="usuarios.css">
	<title>Gestión de Proveedores | Tienda Géneris</title>
</head>

<body>
<%!
long nitproveedor = 0;
String ciudad = "", direccion = "", nombre = "", telefono= ""; 
%>
<%
if (request.getParameter("nitproveedor") != null) {
	nitproveedor = Long.parseLong(request.getParameter("nitproveedor"));
	ciudad = request.getParameter("ciudad");
	direccion = request.getParameter("direccion");
	nombre = request.getParameter("nombre");
	telefono = request.getParameter("telefono");	
}
%>    
    <header>
        <div class="logo-titulo">
			<h1>Tienda Géneris | Gestión de Proveedores</h1>
        </div>
        <nav>
            <a href="usuarios.jsp">Usuarios</a>&nbsp;|&nbsp;
			<a href="clientes.jsp">Clientes</a>&nbsp;|&nbsp;
			<b>Proveedores</b>&nbsp;|&nbsp;
			<a href="productos.jsp">Productos</a>&nbsp;|&nbsp;
			<a href="ventas.jsp">Ventas</a>&nbsp;|&nbsp;
			<a href="reportes.jsp">Reportes</a>
        </nav>
    </header>

    <fieldset class="cont-form">
	<legend>Gestión Proveedores</legend>
        <form action="Proveedores" method="POST">
        	<p>&nbsp;NIT<input type="text" name="nit" placeholder="NIT"></p>
        	<p>&nbsp;Ciudad<input type="text" name="ciudad" placeholder="Ciudad"></p>
			<p>&nbsp;Dirección<input type="text" name="direccion" placeholder="Dirección"></p>
			<p>&nbsp;Nombre<input type="text" name="nombre" placeholder="Nombre"></p>
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
if (request.getParameter("nitproveedor") != null) {
	out.print("<fieldset class=\"cont-form\">\n<legend>Resultado</legend>");
	out.print("<p>&nbsp;<b>NIT</b>: "+nitproveedor+"</p>");
    out.print("<p>&nbsp;<b>Ciudad</b>: "+ciudad+"</p>");
	out.print("<p>&nbsp;<b>Dirección</b>: "+direccion+"</p>");
	out.print("<p>&nbsp;<b>Nombre</b>: "+nombre+"</p>");
	out.print("<p>&nbsp;<b>Teléfono</b>: "+telefono+"</p>\n</fieldset>");
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
	out.print("<fieldset class=\"cont-form\">\n<legend>Resultado</legend><p>Proveedor no hallado.</p></fieldset>");
} 
if (request.getParameter("ds") != null) {
	out.print("<fieldset class=\"cont-form\">\n<legend>Resultado</legend><p>No se ingresaron correctamente todos los campos.</p></fieldset>");
} 
%>
</body>
</html>