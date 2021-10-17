package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Conexion;

public class ProductoDAO {
	ResultSet rs;
	Conexion con = new Conexion();
	Connection cnn = con.Conectar();
	PreparedStatement ps;
	Producto prodto;
	
   public boolean cargarproducto(String URL) {
		boolean resultado = false;
		try {
			ps = cnn.prepareStatement("LOAD DATA INFILE '"+URL+"' INTO TABLE productos FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\r\\n';");
		   	resultado = ps.executeUpdate()>0;
    	} catch(SQLException e) {
			e.printStackTrace();
			//e.printStackTrace();
		}
		return resultado;
	}
   
	 public Producto consultarproducto(Producto pro) {
		 Producto prodto = null;
			try {
				ps=cnn.prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
				ps.setLong(1, pro.getCodigoproducto());
				rs=ps.executeQuery();
				if(rs.next()){
					prodto = new Producto(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getDouble(4), rs.getDouble(5),rs.getDouble(6));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
					  
			return prodto;  
		  }
   
	
}