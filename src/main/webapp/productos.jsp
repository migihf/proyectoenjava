<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    	<meta charset="UTF-8">
    <link rel="stylesheet" href="usuarios.css">
	<title>Gestión de Productos | Tienda Géneris</title>
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
			<h1>Tienda Géneris | Gestión de Productos</h1>
        </div>
        <nav>
            <a href="usuarios.jsp">Usuarios</a>&nbsp;|&nbsp;
			<a href="clientes.jsp">Clientes</a>&nbsp;|&nbsp;
			<a href="proveedores.jsp">Proveedores</a>&nbsp;|&nbsp;
			<b>Productos</b>&nbsp;|&nbsp;
			<a href="ventas.jsp">Ventas</a>&nbsp;|&nbsp;
			<a href="reportes.jsp">Reportes</a>&nbsp;|&nbsp;
			<a href="Salir">Cerrar Sesión</a>
        </nav>
    </header>

    <fieldset class="cont-form">
	<legend>Gestión Productos</legend>
		<form action="Productos" method="POST" enctype="multipart/form-data">
			<input type="file" name="archivo" value="" >
			<input type="submit" name="cargar" value="Subir archivo">
		</form>
		
		</fieldset>
<%
if (request.getParameter("resultado") != null) {
	out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Datos cargados correctamente.</p></fieldset>");
} 
if (request.getParameter("error") != null) {
	out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>No se subió el archivo correctamente.</p></fieldset>");
} 
if (request.getParameter("ds") != null) {
	out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Error. Los datos no fueron cargados.</p></fieldset>");
} 
if (request.getParameter("ed") != null) {
	out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>No se subió archivo.</p></fieldset>");
} 
%>
</body>
</html>