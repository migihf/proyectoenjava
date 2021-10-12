package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	    public String db = "tiendageneris";
	    public String url = "jdbc:mysql://localhost/"+db;
	    public String user = "root";
	    public String pass = "root";
	    public String error;
	    Connection con = null;

	public Connection Conectar()	{
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	con = DriverManager.getConnection(this.url, this.user, this.pass);
	    } catch (Exception e) {
	    	error = "Error: "+e;
	    }
	    return con;
	}
}