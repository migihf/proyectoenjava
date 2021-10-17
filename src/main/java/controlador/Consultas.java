package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 * Servlet implementation class Consultas
 */
@WebServlet("/Consultas")
public class Consultas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consultas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Another sir has been kindly served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		if (request.getSession(false).getAttribute("login") != null) {
		PrintWriter out=response.getWriter();
		//JOptionPane.showMessageDialog(null, "en el servlet");
		ArrayList<Usuario> list=new ArrayList<Usuario>();
		UsuarioDAO usdao=new UsuarioDAO();
		list= usdao.Consultar();
		//JOptionPane.showMessageDialog(null, list.size());
		Gson gson=new Gson();
		out.print(gson.toJson(list));
		//HttpSession sesion=request.getSession();
		//sesion.setAttribute("ds", null);
		//request.getRequestDispatcher("reportes.jsp?").forward(request, response);
		}
	}

}
