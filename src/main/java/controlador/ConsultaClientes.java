package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.Cliente;
import modelo.ClienteDAO;

/**
 * Servlet implementation class ConsultaClientes
 */
@WebServlet("/ConsultaClientes")
public class ConsultaClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("A sir has been kindly served at: ").append(request.getContextPath());
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
		ArrayList<Cliente> list=new ArrayList<Cliente>();
		ClienteDAO usdao=new ClienteDAO();
		list= usdao.Consultar();
		//JOptionPane.showMessageDialog(null, list.size());
		Gson gson=new Gson();
		out.print(gson.toJson(list));
		}
	}

}
