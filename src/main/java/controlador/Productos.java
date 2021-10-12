package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import modelo.ProductoDAO;

/**
 * Servlet implementation class Productos
 */
@WebServlet("/Productos")
@MultipartConfig
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if(request.getParameter("cargar")!=null) {
			Part archivo= request.getPart("archivo");
			String Url="C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\tiendageneris\\";			
			InputStream file = archivo.getInputStream();
			File copia = new File(Url+"archivo12.csv");
			FileOutputStream escribir = new FileOutputStream(copia);
			int num = file.read();
			while(num !=-1) {	
				escribir.write(num);
				num = file.read();
			}
			file.close();
			escribir.close();
			try {	
				boolean x;
				ProductoDAO proDAO = new ProductoDAO();
				x = proDAO.cargarproducto("archivo12.csv");
				if(x) {
					response.sendRedirect("productos.jsp?resultado=1");
				} else {
					response.sendRedirect("productos.jsp?ds=1");
				}
			} catch(Exception e) {
				response.sendRedirect("productos.jsp?error=1");
			}
		} else {
			response.sendRedirect("productos.jsp?ed=1");
		}
	}
}
