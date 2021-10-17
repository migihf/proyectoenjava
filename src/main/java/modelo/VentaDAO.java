package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import javax.swing.JOptionPane;

import controlador.Conexion;

public class VentaDAO {
	PreparedStatement ps = null;
	ResultSet rs = null;
	Conexion con = new Conexion();
	Connection cnn = con.Conectar();
	Venta ven;
	
	public boolean insertarventa(Venta ven){
		boolean resultado = false;
		
		try {
		    	ps = cnn.prepareStatement("INSERT INTO ventas(cedula_cliente, cedula_usuario, ivaventa, total_venta, valor_venta) VALUE(?,?,?,?,?)");
				ps.setLong(1, ven.getCedula_cliente());
				ps.setLong(2, ven.getCedula_usuario());
				ps.setDouble(3, ven.getIvaventa());
				ps.setDouble(4, ven.getTotal_venta());
				ps.setDouble(5, ven.getValor_venta());
				resultado = ps.executeUpdate()>0;
			} catch(SQLException ex){
				//JOptionPane.showMessageDialog(null, "Error al Insertar " +ex);
			}
		return resultado;
		}  	
	
	public Venta consultarcodventa() {
	try {
		ps = cnn.prepareStatement("SELECT MAX(codigo_venta), cedula_cliente, cedula_usuario, ivaventa, total_venta, valor_venta AS id FROM ventas");
		rs = ps.executeQuery();
		if(rs.next()) {
			//JOptionPane.showMessageDialog(null, "epic time");
			ven = new Venta(rs.getInt(1), rs.getLong(2), rs.getLong(3), rs.getDouble(4), rs.getDouble(5),rs.getDouble(6));
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ven;

	}
	
	   public ArrayList<Venta> ConsultarCliente(Long cedula){
	    	ArrayList<Venta> lista=new  ArrayList<Venta>();
	    	try {
	    		String sql = "select * from ventas where cedula_cliente=?";
	    		ps = cnn.prepareStatement(sql);
	    		ps.setLong(1, cedula);
	    		rs = ps.executeQuery();
	    		while(rs.next()) {
	    			Venta usu = new Venta(rs.getInt(1),rs.getLong(2),rs.getLong(3),rs.getDouble(4),rs.getDouble(5), rs.getDouble(6));
	    			lista.add(usu);
	    		}
	    	} catch (SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    	return lista;
	    }

}
