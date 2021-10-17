package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.swing.JOptionPane;

import modelo.ClienteDAO;
import modelo.Cliente;
import modelo.DetalleVentaDAO;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.VentaDAO;
import modelo.Venta;
import modelo.Resultado;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 * Servlet implementation class Ventas
 */
@WebServlet("/Ventas")
public class Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double iva, iva1, iva2;   
	int  cant1, cant2, cant3;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ventas() {
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
		HttpSession sesion=request.getSession();
		if (request.getSession(false).getAttribute("login") != null) {
		sesion.setAttribute("ds", null);
		Resultado resultado;
		if(request.getParameter("confirmar") != null) {
				try {
					long cedula;
					Cliente listado;
					cedula = Long.parseLong(request.getParameter("cedula"));
					ClienteDAO clidao = new ClienteDAO();
					Cliente clidto = new Cliente(cedula);
					listado = clidao.Buscar_Cliente(clidto.getCedula_cliente());
					if (listado != null) {
						sesion.setAttribute("cliente", listado);
						sesion.setAttribute("ds", null);
						request.getRequestDispatcher("ventas.jsp").forward(request, response);
					} else {
						sesion.setAttribute("ds", "3");
						request.getRequestDispatcher("ventas.jsp").forward(request, response);
					}
				} catch (Exception e) {
					sesion.setAttribute("ds", "2");
					request.getRequestDispatcher("ventas.jsp").forward(request, response);
				}
			
		}
		
		if(request.getParameter("conpro") != null) {
			try {
				long codpro;
				Producto listapro;
				codpro = Long.parseLong(request.getParameter("codigo"));
				Producto podto = new Producto(codpro);
				ProductoDAO prodao = new ProductoDAO();
				listapro = prodao.consultarproducto(podto);
				if (listapro != null) {
					sesion.setAttribute("producto", listapro);
					request.getRequestDispatcher("ventas.jsp").forward(request, response);
				} else {
					sesion.setAttribute("ds", "6");
					request.getRequestDispatcher("ventas.jsp").forward(request, response);
				}
			} catch(Exception e) {
				sesion.setAttribute("ds", "4");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
		}
		
		if(request.getParameter("conpro1") != null) {
				try {
			long codpro;
			Producto listapro1;
			codpro = Long.parseLong(request.getParameter("codigo1"));
			Producto podto = new Producto(codpro);
			ProductoDAO prodao = new ProductoDAO();
			listapro1 = prodao.consultarproducto(podto);
			if (listapro1 != null) {
				sesion.setAttribute("producto1", listapro1);
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			} else {
				sesion.setAttribute("ds", "9");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
		} catch(Exception e) {
			sesion.setAttribute("ds", "7");
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
		}
		
		}
		
		if(request.getParameter("conpro2") != null) {
			
				try {
			long codpro;
			Producto listapro2;
			codpro = Long.parseLong(request.getParameter("codigo2"));
			Producto podto = new Producto(codpro);
			ProductoDAO prodao = new ProductoDAO();
			listapro2 = prodao.consultarproducto(podto);
			if (listapro2 != null) {
				sesion.setAttribute("producto2", listapro2);
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			} else {
				sesion.setAttribute("ds", "12");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
		} catch(Exception e) {
			sesion.setAttribute("ds", "10");
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
		}
		}

		if(request.getParameter("total")!=null) {
			long cedula = 0;
			long cedulaa = 0;
			try {
				cedula = Long.parseLong(request.getParameter("cu"));

				UsuarioDAO usuDAO = new UsuarioDAO();	
				Usuario usu = usuDAO.Buscar_Usuario(cedula);
				if (usu == null) {
				sesion.setAttribute("ds", "11");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
				}
			} catch (Exception e) {
				sesion.setAttribute("ds", "1");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			long codpro = 0;
			long codpro1 = 0;
			long codpro2 = 0;
			try {
				Cliente listado;
				cedulaa = Long.parseLong(request.getParameter("cedula"));
				ClienteDAO clidao = new ClienteDAO();
				Cliente clidto = new Cliente(cedulaa);
				listado = clidao.Buscar_Cliente(clidto.getCedula_cliente());
				sesion.setAttribute("cliente", listado);
				if (listado == null) {
					sesion.setAttribute("ds", "3");
					request.getRequestDispatcher("ventas.jsp").forward(request, response);
				}
			} catch (Exception e) {
				sesion.setAttribute("ds", "2");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			
			Producto listapro;
			int temp1 = 0;
			int temp2 = 0;
			int temp3 = 0;
			int temp = 0;
			double iva = 0;
			double iva1 = 0;
			double iva2 = 0;

			double tot = 0;
			double tot1 = 0;
			double tot2 = 0;
			
				try {
						codpro = Long.parseLong(request.getParameter("codigo"));
						Producto podto = new Producto(codpro);
						ProductoDAO prodao = new ProductoDAO();
						listapro = prodao.consultarproducto(podto);
						if (listapro != null) {
							sesion.setAttribute("producto", listapro);
							iva = listapro.getIvacompra();
							tot = listapro.getPrecioventa();
							temp += 1;
							temp1 = 1;
						} else {
							sesion.setAttribute("ds", "6");
							request.getRequestDispatcher("ventas.jsp").forward(request, response);
						}
					} catch(Exception e) {
						
					}
				
					try {
						codpro1 = Long.parseLong(request.getParameter("codigo1"));
						Producto podto = new Producto(codpro1);
						ProductoDAO prodao = new ProductoDAO();
						listapro = prodao.consultarproducto(podto);
						if (listapro != null) {
							sesion.setAttribute("producto1", listapro);
							iva1 = listapro.getIvacompra();
							tot1 = listapro.getPrecioventa();
							temp += 1;
							temp2 = 1;
						} else {
							sesion.setAttribute("ds", "9");
							request.getRequestDispatcher("ventas.jsp").forward(request, response);
						}
					} catch(Exception e) {
						
					}
			
					try {
						codpro2 = Long.parseLong(request.getParameter("codigo2"));
						Producto podto = new Producto(codpro2);
						ProductoDAO prodao = new ProductoDAO();
						listapro = prodao.consultarproducto(podto);
						if (listapro != null) {
							sesion.setAttribute("producto2", listapro);
							iva2 = listapro.getIvacompra();
							tot2 = listapro.getPrecioventa();
							temp += 1;
							temp3 = 1;
						} else {
							sesion.setAttribute("ds", "12");
							request.getRequestDispatcher("ventas.jsp").forward(request, response);
						}
					} catch(Exception e) {
						
					}
				
			if (temp < 1) {
				sesion.setAttribute("ds", "5");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			
			temp = 0;
			
			double res,res1,res2,totalsiniva,totaliva,totaldesiva;
			double total1,total2,total3;
			
			
			cant1 = 0;
			cant2 = 0;
			cant3 = 0;
			
			
			if (request.getParameter("can").length() == 0 && temp1 == 1) {
				sesion.setAttribute("ds", "13");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			
			if (request.getParameter("can").length() != 0 && temp1 == 1) {
				cant1 = Integer.parseInt(request.getParameter("can"));
				
			}
			
			if (request.getParameter("can1").length() == 0 && temp2 == 1) {
				sesion.setAttribute("ds", "14");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			
			
			if (request.getParameter("can1").length() != 0 && temp2 == 1) {
				cant2 = Integer.parseInt(request.getParameter("can1"));
			}
			
			if (request.getParameter("can2").length() == 0 && temp3 == 1) {
				sesion.setAttribute("ds", "15");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			
			if (request.getParameter("can2").length() != 0 && temp3 == 1) {
				cant3 = Integer.parseInt(request.getParameter("can2"));
			}
			
			res = cant1*tot;
			res1 = cant2*tot1;
			res2 = cant3*tot2;
			total1 = res*iva/100;
			total2 = res1*iva1/100;
			total3 = res2*iva2/100;
			totalsiniva = res+res1+res2;
			totaliva = total1+total2+total3;
			totaldesiva = totalsiniva+totaliva;
			double toto1 = res + total1;
			double toto2 = res1 + total2;
			double toto3 = res2 + total3;
			
			resultado = new Resultado(totalsiniva,totaliva,totaldesiva, cant1, cant2, cant3, cedula,cedulaa, toto1, toto2, toto3);
			//JOptionPane.showMessageDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n");
			//JOptionPane.showMessageDialog(null,"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n");
			//JOptionPane.showMessageDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA  "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n");
		    
			// int i=JOptionPane.showConfirmDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA  "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n" );
		     // JOptionPane.showMessageDialog(null, "impriendo la i"+i);
		    sesion.setAttribute("resultado", resultado);
		    sesion.setAttribute("ds", "16");
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
		     
		}
		
		if(request.getParameter("confirmarr") != null) {
			long cedula = 0;
			long cedulaa = 0;
			try {
				cedula = Long.parseLong(request.getParameter("cu"));

				UsuarioDAO usuDAO = new UsuarioDAO();	
				Usuario usu = usuDAO.Buscar_Usuario(cedula);
				if (usu == null) {
				sesion.setAttribute("ds", "11");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
				}
			} catch (Exception e) {
				sesion.setAttribute("ds", "1");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			long codpro = 0;
			long codpro1 = 0;
			long codpro2 = 0;
			try {
				Cliente listado;
				cedulaa = Long.parseLong(request.getParameter("cedula"));
				ClienteDAO clidao = new ClienteDAO();
				Cliente clidto = new Cliente(cedulaa);
				listado = clidao.Buscar_Cliente(clidto.getCedula_cliente());
				sesion.setAttribute("cliente", listado);
				if (listado == null) {
					sesion.setAttribute("ds", "3");
					request.getRequestDispatcher("ventas.jsp").forward(request, response);
				}
			} catch (Exception e) {
				sesion.setAttribute("ds", "2");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			
			Producto listapro;
			int temp1 = 0;
			int temp2 = 0;
			int temp3 = 0;
			int temp = 0;
			double iva = 0;
			double iva1 = 0;
			double iva2 = 0;
			
			double tot = 0;
			double tot1 = 0;
			double tot2 = 0;
			
			
				try {
						codpro = Long.parseLong(request.getParameter("codigo"));
						Producto podto = new Producto(codpro);
						ProductoDAO prodao = new ProductoDAO();
						listapro = prodao.consultarproducto(podto);
						if (listapro != null) {
							sesion.setAttribute("producto", listapro);
							iva = listapro.getIvacompra();
							tot = listapro.getPrecioventa();
							temp += 1;
							temp1 = 1;
						} else {
							sesion.setAttribute("ds", "6");
							request.getRequestDispatcher("ventas.jsp").forward(request, response);
						}
					} catch(Exception e) {
						
					}
				
					try {
						codpro1 = Long.parseLong(request.getParameter("codigo1"));
						Producto podto = new Producto(codpro1);
						ProductoDAO prodao = new ProductoDAO();
						listapro = prodao.consultarproducto(podto);
						if (listapro != null) {
							sesion.setAttribute("producto1", listapro);
							iva1 = listapro.getIvacompra();
							tot1  = listapro.getPrecioventa();
							temp += 1;
							temp2 = 1;
						} else {
							sesion.setAttribute("ds", "9");
							request.getRequestDispatcher("ventas.jsp").forward(request, response);
						}
					} catch(Exception e) {
						
					}
			
					try {
						codpro2 = Long.parseLong(request.getParameter("codigo2"));
						Producto podto = new Producto(codpro2);
						ProductoDAO prodao = new ProductoDAO();
						listapro = prodao.consultarproducto(podto);
						if (listapro != null) {
							sesion.setAttribute("producto2", listapro);
							iva2 = listapro.getIvacompra();
							tot2 = listapro.getPrecioventa();
							temp += 1;
							temp3 = 1;
						} else {
							sesion.setAttribute("ds", "12");
							request.getRequestDispatcher("ventas.jsp").forward(request, response);
						}
					} catch(Exception e) {
						
					}
				
			if (temp < 1) {
				sesion.setAttribute("ds", "5");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			
			temp = 0;
			
			double res,res1,res2,totalsiniva,totaliva,totaldesiva;
			double total1,total2,total3;
			
			
			cant1 = 0;
			cant2 = 0;
			cant3 = 0;
			
			
			if (request.getParameter("can").length() == 0 && temp1 == 1) {
				sesion.setAttribute("ds", "13");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}

			if (request.getParameter("can").length() != 0 && temp1 == 1) {
				cant1 = Integer.parseInt(request.getParameter("can"));
				tot = Double.parseDouble(request.getParameter("precio"));
			}

			if (request.getParameter("can1").length() == 0 && temp2 == 1) {
				sesion.setAttribute("ds", "14");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			
			if (request.getParameter("can1").length() != 0 && temp2 == 1) {
				cant2 = Integer.parseInt(request.getParameter("can1"));
			}
			
			if (request.getParameter("can2").length() == 0 && temp3 == 1) {
				sesion.setAttribute("ds", "15");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			
			if (request.getParameter("can2").length() != 0 && temp3 == 1) {
				cant3 = Integer.parseInt(request.getParameter("can2"));
				tot2 = Double.parseDouble(request.getParameter("precio2"));
			}
			
			res = cant1*tot;
			res1 = cant2*tot1;
			res2 = cant3*tot2;
			total1 = res*iva/100;
			total2 = res1*iva1/100;
			total3 = res2*iva2/100;
			totalsiniva = res+res1+res2;
			totaliva = total1+total2+total3;
			totaldesiva = totalsiniva+totaliva;
			double toto1 = res + total1;
			double toto2 = res1 + total2;
			double toto3 = res2 + total3;
			
			//JOptionPane.showMessageDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n");
			//JOptionPane.showMessageDialog(null,"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n");
			//JOptionPane.showMessageDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA  "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n");
			long cc,cu;
			double tv,vv;
			boolean ress;
			iva = totaliva;
			tv = totalsiniva;
			vv = totaldesiva;
			cc = cedulaa;
			cu = cedula;
			Venta ven = new Venta(cc, cu, iva, tv,vv);
			VentaDAO vendao = new VentaDAO();
			ress=vendao.insertarventa(ven);
			if(ress) {
				// JOptionPane.showMessageDialog(null, "Venta registrada");
				int can;
				long cv;
				double iv,dtv,dvv;
				boolean x;
				Venta venn;
				DetalleVenta dd;
				DetalleVentaDAO dedao;
				VentaDAO vend=new VentaDAO();
				venn=vend.consultarcodventa();
				
				can = cant1;
				if (can > 0) {
					cv = venn.getCodigo_venta();
					iv = ven.getIvaventa();
					dtv = ven.getTotal_venta();
					dvv = ven.getValor_venta();
					dd = new DetalleVenta(can, cv, codpro, toto1, res, total1);
					dedao = new DetalleVentaDAO();
					x = dedao.Inserta_Cliente(dd);
					//if(x) {
					//	JOptionPane.showMessageDialog(null, "anadido");
					//}
				}//else {
				// JOptionPane.showMessageDialog(null, "No inserto cantidad");
				// }
				can = cant2;
				if (can>0) {
					cv = venn.getCodigo_venta();
					iv = ven.getIvaventa();
					dtv = ven.getTotal_venta();
					dvv = ven.getValor_venta();
					dd = new DetalleVenta(can, cv, codpro1, toto2, res1, total2);
					dedao = new DetalleVentaDAO();
					x=dedao.Inserta_Cliente(dd);
					//	if(x) {
					//		JOptionPane.showMessageDialog(null, "detalle insertado");
					//	}
				}
				//else {
				// JOptionPane.showMessageDialog(null, "No inserto cantidad");
				//}
				can = cant3;
				if (can>0) {
					cv = venn.getCodigo_venta();
					iv = ven.getIvaventa();
					dtv = ven.getTotal_venta();
					dvv = ven.getValor_venta();
					dd = new DetalleVenta(can, cv, codpro2, toto3, res2, total3);
					dedao = new DetalleVentaDAO();
					x = dedao.Inserta_Cliente(dd);
					//if(x) {
					// 	JOptionPane.showMessageDialog(null, "detalle insertado");
					//  }
				}// else {
				// JOptionPane.showMessageDialog(null, "No inserto cantidad");
				//}
				sesion.setAttribute("producto", null);
				sesion.setAttribute("producto1", null);
				sesion.setAttribute("producto2", null);
				sesion.setAttribute("resultado", null);
				sesion.setAttribute("cliente", null);
				sesion.setAttribute("ds", "21");
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
				} else {
					//sesion.setAttribute("producto", null);
					//sesion.setAttribute("producto1", null);
					//sesion.setAttribute("producto2", null);
					//sesion.setAttribute("resultado", null);
					//sesion.setAttribute("cliente", null);
					sesion.setAttribute("ds", "20");
					request.getRequestDispatcher("ventas.jsp").forward(request, response);
				}
			}
		} else {
			response.sendRedirect("index.jsp?sesion=1");
			
		}
		}
}
