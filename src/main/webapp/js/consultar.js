$(document).ready(function(){

$('.btnconsultaru').on('click',function(){
	//alert("consulta")
	consultarusuario();	
});	

$('.btnconsultarc').on('click',function(){
	//alert("consulta")
	consultarcliente();	
});	

$('.btnconsultarv').on('click',function(){
	//alert("consulta")
	
	var cedulita = document.getElementById("cedula").value;
	consultarventa(cedulita);	
});	

	function consultarusuario(){
		//alert("en el metodo")
	$.ajax({		
		url: "Consultas",
		type:"POST",
		dataType:'json',
		success: function( datos ) {
		console.log(datos);
		let tab=document.getElementById('tabla');
		//console.log(tab);
		tab.innerHTML='';
		tab.innerHTML+=`<tr><th>Documento</th>
			<th>Nombre Usuario</th>
			<th>Correo</th>
			<th>Usuario</th>
			<th>Clave</th></tr>`;
			
			for(let i of datos){
			tab.innerHTML+=`<tr>
								<td>${i.Cedula_Usuario}</td>
								<td>${i.Nombre_Usuario}</td>	
								<td>${i.Email_Usuario}</td>
								<td>${i.Usuario}</td>
								<td>${i.Password}</td>
							 </tr> `;
			}
		}
	});
	}
	
	function consultarcliente(){
		//alert("en el metodo")
	$.ajax({		
		url: "ConsultaClientes",
		type:"POST",
		dataType:'json',
		success: function( datos ) {
		console.log(datos);
		let tab=document.getElementById('tabla');
		//console.log(tab);
		tab.innerHTML='';
		tab.innerHTML+=`<tr><th>Cedula</th>
			<th>Direccion</th>
			<th>Nombre</th>
			<th>Email</th>
			<th>Cliente</th></tr>`;
	
			for(let i of datos){
			tab.innerHTML+=`<tr>
								<td>${i.cedula_cliente}</td>
								<td>${i.direccion_cliente}</td>	
								<td>${i.nombre_cliente}</td>
								<td>${i.email_cliente}</td>
								<td>${i.telefono_cliente}</td>
							 </tr> `;
			}
		}
	});
	}
	
	function consultarventa(cedulita){
		//alert("en el metodo")
	$.ajax({		
		url: "ConsultasVenta",
		type:"POST",
		data:{ cedula: cedulita},
		dataType:'json',
		success: function( datos ) {
		//console.log(datos);
		let tab=document.getElementById('tabla');
		console.log(tab);
		tab.innerHTML='';
		tab.innerHTML+=`<tr><th>Codigo Venta</th>
			<th>Cedula Cliente</th>
			<th>Cedula Usuario</th>
			<th>IVA</th>
			<th>Venta</th>
			<th>Total</th></tr>`;
			
			for(let i of datos){
			tab.innerHTML+=`<tr>
								<td>${i.codigo_venta}</td>
								<td>${i.cedula_cliente}</td>
								<td>${i.cedula_usuario}</td>
								<td>${i.ivaventa}</td>
								<td>${i.total_venta}</td>
								<td>${i.valor_venta}</td>
							 </tr> `;
			}
		}
	});
	}
});
