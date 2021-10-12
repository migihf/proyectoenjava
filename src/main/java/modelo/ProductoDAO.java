package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import controlador.Conexion;

public class ProductoDAO {
	
	Conexion con = new Conexion();
	Connection cnn = con.Conectar();
	PreparedStatement ps;
	
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
	
}