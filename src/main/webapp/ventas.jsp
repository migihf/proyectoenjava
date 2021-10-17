<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="usuarios.css">
		<title>Gestión de Ventas | Tienda Géneris</title>
	</head>
	
	<body>
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
				<a href="reportes.jsp">Reportes</a>&nbsp;|&nbsp;
				<a href="Salir">Cerrar Sesión</a>
			</nav>
	    </header>
	    
	    <fieldset class="cont-form">
			<legend>Gestión Ventas</legend>
	 		<form action="Ventas" method="POST">
			<table>
		    	<tbody>
		    		<tr>
		    			<th>Cédula Cliente</th>
		     			<th>Consultar</th>
		      			<th>Nombre Cliente</th>
		       			<th>Cédula Usuario</th>
						<th>Enviar</th>
		    		</tr>
		    		<tr>
					    <td> <input type="text" name="cedula" value="${cliente.getCedula_cliente()}" placeholder="Cédula"></td>
					    <td><input type="submit" name="confirmar"  value="Buscar Cédula"></td>
					    <td><input type="text" name="nombre" value="${cliente.getNombre_cliente()}" placeholder="Nombre"></td>
					    <td><input type="text" name="cu" value="${resultado.getCedula_usuario()}" placeholder="Cédula Usuario"></td>
					    <td><input type="submit" name="total" value="Enviar venta"></td>
		    		</tr>
		        	<tr>
			            <th>Codigo del producto</th>
			            <th>Consultar producto</th>
			            <th>Nombre del producto</th>
			            <th>Cantidad de producto</th>
			            <th>Precio  del producto</th>
			        </tr>
		        	<tr>
			            <td><input type="text" name="codigo" value="${producto.getCodigoproducto()}"  ></td>
			            <td> <input type="submit" name="conpro" value="Buscar Producto" ></td>
			            <td> <input type="text" class="nombre" name="n2" value="${producto.getNombreproducto()}"  ></td>
			            <td> <input type="text" class="cantidad" id="cantidad" name="can"   value="${resultado.getCant()}" ></td>
			            <td> <input type="text" class="pre" id="pre" name="precio" value="${producto.getPrecioventa()}"  ></td>
		                
		        	</tr>
		        	<tr>
			            <td><input type="text" name="codigo1" value="${producto1.getCodigoproducto()}"  ></td>
			            <td> <input type="submit" name="conpro1" value="Buscar Producto" ></td>
			            <td> <input type="text" class="nombre" name="n2" value="${producto1.getNombreproducto()}"  ></td>
			            <td> <input type="text" class="cantidad1"  id="cantidad1" name="can1" value="${resultado.getCant1()}" ></td>
			            <td> <input type="text" class="pre"  id="pre1" name="precio1" value="${producto1.getPrecioventa()}"  ></td>
					</tr>
		        	<tr>
						<td><input type="text" name="codigo2" value="${producto2.getCodigoproducto()}"  ></td>
				        <td> <input type="submit" name="conpro2" value="Buscar Producto" ></td>
				        <td> <input type="text" class="nombre" name="n2" value="${producto2.getNombreproducto()}"  ></td>
				        <td> <input type="text" class="cantidad2" id="cantidad2" name="can2"value="${resultado.getCant2()}" ></td>
				        <td> <input type="text" class="pre"  id="pre2" name="precio2" value="${producto2.getPrecioventa()}"  ></td>
		        	</tr>
				</tbody>
	    	</table>	
		</fieldset>
	<%
	if (request.getSession().getAttribute("ds") != null) {
		if (request.getSession().getAttribute("ds").equals("1")) {
			out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Error. No escribió el número de cédula del usuario correctamente.</p></fieldset>");
		}
	if (request.getSession().getAttribute("ds").equals("2")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Error. No escribió el número de cédula del cliente correctamente.</p></fieldset>");
	}
	if (request.getSession().getAttribute("ds").equals("3")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Cédula de cliente no hallada en la base de datos.</p></fieldset>");
	}
	if (request.getSession().getAttribute("ds").equals("4")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Error. No ingresó correctamente el código del primer producto.</p></fieldset>");
	}
	if (request.getSession().getAttribute("ds").equals("5")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Error. No ingresó ningún código.</p></fieldset>");
	}
	
	if (request.getSession().getAttribute("ds").equals("6")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Código del primer producto no hallado en la base de datos.</p></fieldset>");
	}
	
	if (request.getSession().getAttribute("ds").equals("7")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Error. No ingresó correctamente el código del segundo producto.</p></fieldset>");
	}
	
	if (request.getSession().getAttribute("ds").equals("8")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Error. No ingresó la cantidad.</p></fieldset>");
	}
	
	if (request.getSession().getAttribute("ds").equals("9")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Código del segundo producto no hallado en la base de datos.</p></fieldset>");
	}
	
	if (request.getSession().getAttribute("ds").equals("10")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Error. No ingresó correctamente el código del tercer producto.</p></fieldset>");
	}
	if (request.getSession().getAttribute("ds").equals("11")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>No se halló la cédula de usuario en la base de datos.</p></fieldset>");
	}
	
	if (request.getSession().getAttribute("ds").equals("12")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Código del tercer producto no hallado en la base de datos.</p></fieldset>");
	}
	
	if (request.getSession().getAttribute("ds").equals("13")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Error. Cantidad del primer producto no ingresada.</p></fieldset>");
	}
	if (request.getSession().getAttribute("ds").equals("14")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Error. Cantidad del segundo producto no ingresada.</p></fieldset>");
	}
	if (request.getSession().getAttribute("ds").equals("15")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Error. Cantidad del tercer producto no ingresada.</p></fieldset>");
	}
	
	if (request.getSession().getAttribute("ds").equals("17")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>No se consultó el precio del primer producto.</p></fieldset>");
	}
	if (request.getSession().getAttribute("ds").equals("18")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>No se consultó el precio del segundo producto.</p></fieldset>");
	}
	if (request.getSession().getAttribute("ds").equals("19")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>No se consultó el precio del tercer producto.</p></fieldset>");
	}
	
	if (request.getSession().getAttribute("ds").equals("20")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>Error al ingresar la venta.</p></fieldset>");
	}
	if (request.getSession().getAttribute("ds").equals("21")) {
		out.print("<fieldset class=\"cont-form result\">\n<legend>Resultado</legend><p>La venta se ingresó exitosamente.</p></fieldset>");
	}
	
	if (request.getSession().getAttribute("ds").equals("16")) {
		
	%>
		<fieldset class="cont-form result">
			<legend>Confirmar</legend>
			<p>Valor total primer producto: <b>${resultado.getTotal()}</b></p>
			<p>Valor total segundo producto: <b>${resultado.getTotal1()}</b></p>
			<p>Valor total tercer producto: <b>${resultado.getTotal2()}</b></p>
			<p>Total Venta: <b>${resultado.getTotalsiniva()}</b></p>
			<p>Total IVA: <b>${resultado.getTotaliva()}</b></p>
			<p>Total con IVA: <b>${resultado.getTotaldesiva()}</b>
			<p><center><input type="submit" name="confirmarr" value="Confirmar" style="background-color: #4CB942;"></center></p>	
		</fieldset>
	<%
	}
	}
	%> 
		</form>
	</body>
</html>