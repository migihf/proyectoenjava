package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Conexion;

public class LoginDAO {
	PreparedStatement ps=null;
	ResultSet res=null;
	Conexion con= new Conexion();
	Connection conectar=con.Conectar();
	
	public Usuario login(Usuario us){  
		    Usuario u=null;
		    
		    try {
			    String sql="select * from usuarios where usuario=? and password_usuario=?";
			    ps =conectar.prepareStatement(sql);
			    ps.setString(1, us.getUsuario());
				ps.setString(2, us.getPassword());
				res=ps.executeQuery();
			    
			    if(res.next()){
			       u= new Usuario(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			     }
		    } catch(SQLException e) {
		    	e.printStackTrace();
		    }
		    return u;
	}
	 
	public Usuario Buscar_Usuario(String usu, String pass){
		Usuario u=null;
		try {
			String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
			ps = conectar.prepareStatement(sql);
			ps.setString(1, usu);
			ps.setString(2, pass);
			res = ps.executeQuery();
	    
			while(res.next()){
				u = new Usuario(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
	    } catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    return u;
	}
		
}
