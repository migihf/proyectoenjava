package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Conexion;

public class ClienteDAO {
		PreparedStatement ps = null;
		ResultSet res = null;
		Conexion con = new Conexion();
		Connection conectar = con.Conectar();
		
		public boolean Insertar_Cliente(Cliente u){
			boolean resultado = false;
			Cliente cli = null;
			try {
				cli = Buscar_Cliente(u.getCedula_cliente());
				if (cli == null) {
					String sql = "Insert Into clientes value(?,?,?,?,?)";
					ps = conectar.prepareStatement(sql);
					ps.setLong(1, u.getCedula_cliente());
					ps.setString(2, u.getDireccion_cliente());
					ps.setString(3, u.getNombre_cliente());
					ps.setString(4, u.getEmail_cliente());
					ps.setString(5, u.getTelefono_cliente());
					resultado = ps.executeUpdate()>0;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return resultado;
		}  
		
	    public Cliente Buscar_Cliente(long cedula){
	    	Cliente u = null;
	    	try {
				String sql = "select * from clientes where cedula_cliente=?";
				ps = conectar.prepareStatement(sql);
				ps.setLong(1, cedula);
				res = ps.executeQuery();
				while(res.next()){
					u = new Cliente(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
				}
	    	} catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return u;
	    }
		
	    public boolean Eliminar_Cliente(Cliente us) {
			int x;
			boolean dat = false;
			try {
				ps = conectar.prepareStatement("DELETE FROM clientes WHERE cedula_cliente=?");
				ps.setLong(1,us.getCedula_cliente() );
				x = ps.executeUpdate();
				if(x>0) {
					dat = true;	
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return dat;
		}
	    
	    public boolean Actualizar_Cliente(Cliente usdto) {
			int x = 0;
			boolean dat = false;
			try {
				ps = conectar.prepareStatement("UPDATE clientes SET direccion_cliente=?, nombre_cliente=?, email_cliente=?, telefono_cliente=? WHERE cedula_cliente=?");
				ps.setString(1, usdto.getDireccion_cliente());
				ps.setString(2,usdto.getNombre_cliente());
				ps.setString(3, usdto.getEmail_cliente());
				ps.setString(4, usdto.getTelefono_cliente());
				ps.setLong(5, usdto.getCedula_cliente());
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
	    
	    public ArrayList<Cliente> Consultar(){
	    	
	    	ArrayList<Cliente> lista=new  ArrayList<Cliente>();
	    	try {
	    		ps = conectar.prepareStatement("SELECT * FROM clientes");
	    		res = ps.executeQuery();
	    		while(res.next()) {
	    			Cliente usu = new Cliente(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
	    			lista.add(usu);
	    		}
	    	} catch (SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    	return lista;
	    }
	    
}
