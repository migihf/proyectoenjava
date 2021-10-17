package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.UsuarioDAO;
import modelo.Usuario;
/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession(false).getAttribute("login") != null) {
		UsuarioDAO usuDAO = new UsuarioDAO();	
		if(request.getParameter("insertar") != null) {
			 long cedula;
			 String nombre,correo,usuario,pass;
			 if (!request.getParameter("usuario").equals("") && !request.getParameter("correo").equals("") && !request.getParameter("nombre").equals("") && !request.getParameter("pass").equals("")) {
				 usuario = request.getParameter("usuario");
				 correo = request.getParameter("correo");
				 nombre = request.getParameter("nombre");
				 pass = request.getParameter("pass");
				 try {
					 cedula = Long.parseLong(request.getParameter("cedula"));
					 Usuario usu = new Usuario(cedula,usuario,correo,nombre,pass);
					 if(usuDAO.Insertar_Usuario(usu)){
						 response.sendRedirect("usuarios.jsp?resultado=1");
					 } else {
						 response.sendRedirect("usuarios.jsp?error=1");
					 }
				 } catch (Exception e) {
					 response.sendRedirect("usuarios.jsp?ds=1");
				 }
			 } else  {
				 response.sendRedirect("usuarios.jsp?ds=1");
			 }	
		}
	
		if(request.getParameter("consultar")!=null) {
			try {
				long cedula = Long.parseLong(request.getParameter("cedula"));
				Usuario usu = usuDAO.Buscar_Usuario(cedula);
				if (usu != null) {
					String nombre,correo,usuario,pass;
					cedula = usu.getCedula_Usuario();
					nombre = usu.getNombre_Usuario();
					correo = usu.getEmail_Usuario();
					usuario = usu.getUsuario();
					pass = usu.getPassword();
					response.sendRedirect("usuarios.jsp?cedula="+cedula+"&&nombre="+nombre+"&&correo="+correo+"&&usuario="+usuario+"&&pass="+pass);
				} else {
					response.sendRedirect("usuarios.jsp?ed=1");
				}
			} catch (Exception e) {
				response.sendRedirect("usuarios.jsp?ds=1");	
			}
		}
		
		if(request.getParameter("actualizar") != null) {
			try {
				long cedula = Long.parseLong(request.getParameter("cedula"));
				Usuario usu = usuDAO.Buscar_Usuario(cedula);
				if (usu != null) {
					if (!request.getParameter("usuario").equals("") && !request.getParameter("correo").equals("") && !request.getParameter("nombre").equals("") && !request.getParameter("pass").equals("")) {
						String nombre,correo,usuario,pass;
						usuario = request.getParameter("usuario");
						correo = request.getParameter("correo");
						nombre = request.getParameter("nombre");
						pass = request.getParameter("pass");
						Usuario usut = new Usuario(cedula,usuario,correo,nombre,pass);
						if(usuDAO.Actualizar_Usuario(usut)){
							response.sendRedirect("usuarios.jsp?resultado=1");
						} else {
							response.sendRedirect("usuarios.jsp?error=1");
						}
					} else {
						response.sendRedirect("usuarios.jsp?ds=1");
					}
				} else {
					response.sendRedirect("usuarios.jsp?ed=1");
				}
			} catch (Exception e) {
				response.sendRedirect("usuarios.jsp?ds=1");	
			}
		}

		if(request.getParameter("eliminar") != null) {
			try {
				long cedula = Long.parseLong(request.getParameter("cedula"));
				Usuario usu = usuDAO.Buscar_Usuario(cedula);
				if (usu != null) {
					 if(usuDAO.Eliminar_Usuario(usu)){
						 response.sendRedirect("usuarios.jsp?resultado=1"); 
					 } else {
						 response.sendRedirect("usuarios.jsp?error=1");
					 }
				} else {
					response.sendRedirect("usuarios.jsp?ed=1");
				}
			} catch (Exception e) {
				response.sendRedirect("usuarios.jsp?ds=1");
			}
		}
		} else {
			response.sendRedirect("index.jsp?sesion=1");
		}
	}
}
