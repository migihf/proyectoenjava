package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ProveedorDAO;
import modelo.Proveedor;

@WebServlet("/Proveedores")
public class Proveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Proveedores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getSession(false).getAttribute("login") != null) {
		ProveedorDAO proDAO = new ProveedorDAO();
		if(request.getParameter("insertar") != null) {
			if (!request.getParameter("ciudad").equals("") && !request.getParameter("direccion").equals("") && !request.getParameter("nombre").equals("") && !request.getParameter("telefono").equals("")) {
				long nit;
				String ciudad, direccion, nombre, telefono;
				ciudad = request.getParameter("ciudad");
				direccion = request.getParameter("direccion");
				nombre = request.getParameter("nombre");
				telefono = request.getParameter("telefono");
				try {
					nit = Long.parseLong(request.getParameter("nit"));
					Proveedor pro = new Proveedor(nit, ciudad, direccion, nombre, telefono);
					if(proDAO.Insertar_Proveedor(pro)){
						response.sendRedirect("proveedores.jsp?resultado=1");
					} else {
						response.sendRedirect("proveedores.jsp?error=1");
					}
				} catch (Exception e) {
					response.sendRedirect("proveedores.jsp?ds=1");
				}
			} else  {
				response.sendRedirect("proveedores.jsp?ds=1");	 
			}
		}
	
		if(request.getParameter("consultar") != null) {
			try {
				long nit = Long.parseLong(request.getParameter("nit"));
				Proveedor pro = proDAO.Buscar_Proveedor(nit);
				if (pro != null) {
					String ciudad, direccion, nombre, telefono;
					nit = pro.getNit_proveedor();
					ciudad = pro.getCiudad_proveedor();
					direccion = pro.getDireccion_proveedor();
					nombre = pro.getNombre_proveedor();
					telefono = pro.getTelefono_proveedor();
					response.sendRedirect("proveedores.jsp?nitproveedor="+nit+"&&ciudad="+ciudad+"&&direccion="+direccion+"&&nombre="+nombre+"&&telefono="+telefono);
				} else {
					response.sendRedirect("proveedores.jsp?ed=1");
				}
			} catch (Exception e) {
				response.sendRedirect("proveedores.jsp?ds=1");	
			}
		}
		
		if(request.getParameter("actualizar") != null) {
			try {
				long nit = Long.parseLong(request.getParameter("nit"));
				Proveedor pro = proDAO.Buscar_Proveedor(nit);
				if (pro != null) {
					if (!request.getParameter("ciudad").equals("") && !request.getParameter("direccion").equals("") && !request.getParameter("nombre").equals("") && !request.getParameter("telefono").equals("")) {
						String ciudad, direccion, nombre, telefono;
						ciudad = request.getParameter("ciudad");
						direccion = request.getParameter("direccion");
						nombre = request.getParameter("nombre");
						telefono = request.getParameter("telefono");
						Proveedor prod = new Proveedor(nit, ciudad, direccion, nombre, telefono);
						if(proDAO.Actualizar_Proveedor(prod)){
							response.sendRedirect("proveedores.jsp?resultado=1");
						} else {
							response.sendRedirect("proveedores.jsp?error=1");
						}
					} else {
						response.sendRedirect("proveedores.jsp?ds=1");
					}
				} else {
					response.sendRedirect("proveedores.jsp?ed=1");
				}
			} catch (Exception e) {
				response.sendRedirect("proveedores.jsp?ds=1");	
			}
		}

		if(request.getParameter("eliminar") != null) {
			try {
				long nit = Long.parseLong(request.getParameter("nit"));
				Proveedor pro = proDAO.Buscar_Proveedor(nit);
				if (pro != null) {
					 if(proDAO.Eliminar_Proveedor(pro)){
						 response.sendRedirect("proveedores.jsp?resultado=1"); 
					 } else {
						 response.sendRedirect("proveedores.jsp?error=1");
					 }
				} else {
					response.sendRedirect("proveedores.jsp?ed=1");
				}
			} catch (Exception e) {
				response.sendRedirect("proveedores.jsp?ds=1");
			}
		}
	} else {
		response.sendRedirect("index.jsp?sesion=1");
	}
	}
}
