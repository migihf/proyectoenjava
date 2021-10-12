<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    	<meta charset="UTF-8">
    <link rel="stylesheet" href="usuarios.css">
	<title>Gestión de Ventas | Tienda Géneris</title>
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
			<h1>Tienda Géneris | Gestión de Ventas</h1>
        </div>
        <nav>
            <a href="usuarios.jsp">Usuarios</a>&nbsp;|&nbsp;
			<a href="clientes.jsp">Clientes</a>&nbsp;|&nbsp;
			<a href="proveedores.jsp">Proveedores</a>&nbsp;|&nbsp;
			<a href="productos.jsp">Productos</a>&nbsp;|&nbsp;
			<b>Ventas</b>&nbsp;|&nbsp;
			<a href="reportes.jsp">Reportes</a>
        </nav>
    </header>

    <fieldset class="cont-form">
	<legend>Gestión Productos</legend>
		<form action="Productos" method="POST">
		Cedula Cliente Consultar
		
		</form>
		
		</fieldset>
<%
if (request.getParameter("resultado") != null) {
	out.print("<fieldset class=\"cont-form\">\n<legend>Resultado</legend><p>Datos cargados correctamente.</p></fieldset>");
} 
if (request.getParameter("error") != null) {
	out.print("<fieldset class=\"cont-form\">\n<legend>Resultado</legend><p>No se subió el archivo correctamente.</p></fieldset>");
} 
if (request.getParameter("ds") != null) {
	out.print("<fieldset class=\"cont-form\">\n<legend>Resultado</legend><p>Error. Los datos no fueron cargados.</p></fieldset>");
} 
if (request.getParameter("ed") != null) {
	out.print("<fieldset class=\"cont-form\">\n<legend>Resultado</legend><p>No se subió archivo.</p></fieldset>");
} 
%>
</body>
</html>