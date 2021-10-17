package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ClienteDAO;
import modelo.Cliente;
/**
 * Servlet implementation class
 */
@WebServlet("/Clientes")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Clientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getSession(false).getAttribute("login") != null) {
		ClienteDAO cliDAO= new ClienteDAO();

		if(request.getParameter("insertar") != null) {
			if (!request.getParameter("direccion").equals("") && !request.getParameter("nombre").equals("") && !request.getParameter("correo").equals("") && !request.getParameter("telefono").equals("")) {
				long cedula;
				String direccion, nombre, email, telefono;
				direccion = request.getParameter("direccion");
				nombre = request.getParameter("nombre");
				email = request.getParameter("correo");
				telefono = request.getParameter("telefono");
				try {
					cedula = Long.parseLong(request.getParameter("cedula"));
					Cliente cli= new Cliente(cedula, direccion, nombre, email, telefono);
					if(cliDAO.Insertar_Cliente(cli)){
						response.sendRedirect("clientes.jsp?resultado=1");
					} else {
						response.sendRedirect("clientes.jsp?error=1");
					}
				} catch (Exception e) {
					response.sendRedirect("clientes.jsp?ds=1");
				}
			} else  {
				response.sendRedirect("clientes.jsp?ds=1");	 
			}
		}		
	
		if(request.getParameter("consultar") != null) {
			try {
				long cedula=Long.parseLong(request.getParameter("cedula"));
				Cliente cli = cliDAO.Buscar_Cliente(cedula);
				if (cli != null) {
					String direccion, nombre, email, telefono;
					cedula = cli.getCedula_cliente();
					direccion = cli.getDireccion_cliente();
					nombre = cli.getNombre_cliente();
					email = cli.getEmail_cliente();
					telefono = cli.getTelefono_cliente();
					response.sendRedirect("clientes.jsp?cedula="+cedula+"&&direccion="+direccion+"&&nombre="+nombre+"&&correo="+email+"&&telefono="+telefono);
				} else {
					response.sendRedirect("clientes.jsp?ed=1");
				}
			} catch (Exception e) {
				response.sendRedirect("clientes.jsp?ds=1");	
			}
		}
		
		if(request.getParameter("actualizar") != null) {	
			try {
				long cedula = Long.parseLong(request.getParameter("cedula"));
				Cliente cli = cliDAO.Buscar_Cliente(cedula);
				if (cli != null) {
					if (!request.getParameter("direccion").equals("") && !request.getParameter("nombre").equals("") && !request.getParameter("correo").equals("") && !request.getParameter("telefono").equals("")) {
						String direccion, nombre, email, telefono;
						direccion = request.getParameter("direccion");
						nombre = request.getParameter("nombre");
						email = request.getParameter("correo");
						telefono = request.getParameter("telefono");
						Cliente clid = new Cliente(cedula, direccion, nombre, email, telefono);
				 if(cliDAO.Actualizar_Cliente(clid)){
					 response.sendRedirect("clientes.jsp?resultado=1");
				 } else {
					 response.sendRedirect("clientes.jsp?error=1");
				 }

				} else {
					response.sendRedirect("clientes.jsp?ds=1");
				}
			} else {
				response.sendRedirect("clientes.jsp?ed=1");
			}
			} catch (Exception e) {
				response.sendRedirect("clientes.jsp?ds=1");	
			}
		}

		if(request.getParameter("eliminar") != null) {
			try {
				long cedula = Long.parseLong(request.getParameter("cedula"));
				Cliente cli = cliDAO.Buscar_Cliente(cedula);
				if (cli != null) {
					if(cliDAO.Eliminar_Cliente(cli)){
						response.sendRedirect("clientes.jsp?resultado=1"); 
					} else {
						response.sendRedirect("clientes.jsp?error=1");
					}
				} else {
					response.sendRedirect("clientes.jsp?ed=1");
				}
			} catch (Exception e) {
				response.sendRedirect("clientes.jsp?ds=1");
			}
		}

		} else {
			response.sendRedirect("index.jsp?sesion=1");
		}
	}
}
