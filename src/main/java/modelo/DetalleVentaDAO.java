package modelo;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.swing.JOptionPane;

public class DetalleVentaDAO {

		PreparedStatement ps = null;
		ResultSet res = null;
		Conexion con = new Conexion();
		Connection cnn = con.Conectar();
		
		public boolean Inserta_Cliente(DetalleVenta det) {

			boolean resultado=false;
			//ClienteDTO usu=null;
			try{
			//usu=  buscarcliente(u);
			//if(usu!=null) {
				
				ps = cnn.prepareStatement("Insert Into detalle_ventas(cantidad_producto,codigo_producto,codigo_venta,valor_venta,valoriva, valor_total) value(?,?,?,?,?,?);");
				ps.setInt(1, det.getCantidad_producto());
				ps.setLong(2, det.getCodigo_producto());
				ps.setLong(3, det.getCodigo_venta());
				ps.setDouble(4, det.getValor_total());
				ps.setDouble(5, det.getValoriva());
				ps.setDouble(6, det.getValor_total());
				resultado=ps.executeUpdate()>0;
			//}
			}catch(SQLException ex){
				//JOptionPane.showMessageDialog(null, "Error al Insertar" +ex);
			}
			return resultado;
			}  	
}

