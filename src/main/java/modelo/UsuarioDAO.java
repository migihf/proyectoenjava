package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Conexion;

public class UsuarioDAO {
		PreparedStatement ps = null;
		ResultSet res = null;
		Conexion con = new Conexion();
		Connection conectar = con.Conectar();
		
		public boolean Insertar_Usuario(Usuario u){
			boolean resultado = false;
			Usuario usu = null;
			try {
				usu = Buscar_Usuario(u.getCedula_Usuario());
				if (usu == null) {
					String sql = "Insert Into usuarios value(?,?,?,?,?)";
					ps = conectar.prepareStatement(sql);
					ps.setLong(1, u.getCedula_Usuario());
					ps.setString(2, u.getUsuario());
					ps.setString(3, u.getEmail_Usuario());
					ps.setString(4, u.getNombre_Usuario());
					ps.setString(5, u.getPassword());
					resultado = ps.executeUpdate()>0;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return resultado;
		}  
		
	    public Usuario Buscar_Usuario(long cedula){
	    	Usuario u = null;
	    	try {
				String sql = "select * from usuarios where cedula_usuario=?";
				ps = conectar.prepareStatement(sql);
				ps.setLong(1, cedula);
				res = ps.executeQuery();
	    
				while(res.next()){
					u = new Usuario(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
				}
	    	} catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return u;
	    }
		
	    public boolean Eliminar_Usuario(Usuario us) {
			int x;
			boolean dat = false;
			try {
				ps = conectar.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=?");
				ps.setLong(1,us.getCedula_Usuario() );
				x = ps.executeUpdate();			
				if(x>0) {
					dat = true;	
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return dat;
		}
	    
	    public boolean Actualizar_Usuario(Usuario usdto) {
			int x = 0;
			boolean dat = false;
			try {
				ps = conectar.prepareStatement("UPDATE usuarios SET usuario=?, email_usuario=?, nombre_usuario=?, password=? WHERE cedula_usuario=?");
				ps.setString(1, usdto.getUsuario());
				ps.setString(2,usdto.getEmail_Usuario());
				ps.setString(3, usdto.getNombre_Usuario());
				ps.setString(4, usdto.getPassword());
				ps.setLong(5, usdto.getCedula_Usuario());
				x = ps.executeUpdate();
				if(x>0) {
					dat = true;	
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return dat;
		}

}
