<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="usuarios.css">
	<title>Gestión de Reportes | Tienda Géneris</title>
	
	<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="js/consultar.js"></script>
</head>

<body>
    <header>
        <div class="logo-titulo">
			<h1>Tienda Géneris | Gestión de Reportes</h1>
        </div>
        <nav>
            <a href="usuarios.jsp">Usuarios</a>&nbsp;|&nbsp;
			<a href="clientes.jsp">Clientes</a>&nbsp;|&nbsp;
			<a href="proveedores.jsp">Proveedores</a>&nbsp;|&nbsp;
			<a href="productos.jsp">Productos</a>&nbsp;|&nbsp;
			<a href="ventas.jsp">Ventas</a>&nbsp;|&nbsp;
			<a href="reportes.jsp"><b>Reportes</b></a>&nbsp;|&nbsp;
			<a href="Salir">Cerrar Sesión</a>
        </nav>
    </header>
		<%
if (request.getParameter("usuarios") != null) {
	
%>
<fieldset class="cont-form">
	<legend>Reporte Usuarios</legend>
	
	<p><input type="button" value="Consultar" class="btnconsultaru result" ></p>
	</fieldset>
		<fieldset class="cont-form result">
		<legend>Resultado</legend>
<center>
	<table id="tabla">
	
	</table>
	</center>
</fieldset>

<%

} else if (request.getParameter("clientes") != null) {
%>
<fieldset class="cont-form">
	<legend>Reporte Clientes</legend>
	
	<p><input type="button" value="Consultar" class="btnconsultarc result" ></p>
	</fieldset>
		<fieldset class="cont-form result">
		<legend>Resultado</legend>
<center>
	<table id="tabla">
	
	</table>
	</center>
</fieldset>
<%

		} else if (request.getParameter("vista") != null) {
		%>
		<fieldset class="cont-form">
	<legend>Reporte Ventas por Cliente</legend>
	<p>&nbsp;Cédula del Cliente</b>:<input type="text" name="cedula_" Id="cedula" placeholder="Cédula"></p>
	<p><input type="button" value="Consultar" class="btnconsultarv result" ></p>
	</fieldset>
		<fieldset class="cont-form result">
		<legend>Resultado</legend>
<center>
	<table id="tabla">
	
	</table>
	</center>
	</fieldset>

		
		<%
		} else {
			%>
			    <fieldset class="cont-form">
	<legend>Gestion Reportes</legend>
        <form action="reportes.jsp" method="GET">
            <p><input class="submitto" type="submit" name="usuarios" value="Listado de Usuarios"></p>
            <p><input class="submitto" type="submit" name="clientes" value="Listado de Clientes"></p>
            <p><input class="submitto" type="submit" name="vista" value="Ventas por Cliente"></p>
		</form>
		
		</fieldset>
			<%
		}
%>
</body>
</html>