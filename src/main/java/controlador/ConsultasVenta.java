package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.Venta;
import modelo.VentaDAO;

/**
 * Servlet implementation class ConsultasVenta
 */
@WebServlet("/ConsultasVenta")
public class ConsultasVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultasVenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//  doGet(request, response);

		if (request.getSession(false).getAttribute("login") != null) {
		//JOptionPane.showMessageDialog(null, "en el servlet");
		HttpSession sesion=request.getSession();
		sesion.setAttribute("ds", null);
		PrintWriter out=response.getWriter();
		long cedula = 0;
		try {
			cedula = Long.parseLong(request.getParameter("cedula"));
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "AINA");
			//sesion.setAttribute("ds", "1");
		}
		ArrayList<Venta> list = new ArrayList<Venta>();
		VentaDAO usdao = new VentaDAO();
		list = usdao.ConsultarCliente(cedula);
		//JOptionPane.showMessageDialog(null, list.size());
		Gson gson = new Gson();
		out.print(gson.toJson(list));
	}
	}

}
