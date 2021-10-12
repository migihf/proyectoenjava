package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Conexion;

public class ProveedorDAO {

	PreparedStatement ps = null;
	ResultSet res = null;
	Conexion con = new Conexion();
	Connection conectar = con.Conectar();
	
	public boolean Insertar_Proveedor(Proveedor u){
		boolean resultado = false;
		Proveedor pro = null;
		try {
			pro = Buscar_Proveedor(u.getNit_proveedor());
			if (pro == null) {
				String sql = "Insert Into proveedores value(?,?,?,?,?)";
				ps = conectar.prepareStatement(sql);
				ps.setLong(1, u.getNit_proveedor());
				ps.setString(2, u.getCiudad_proveedor());
				ps.setString(3, u.getDireccion_proveedor());
				ps.setString(4, u.getNombre_proveedor());
				ps.setString(5, u.getTelefono_proveedor());
				resultado = ps.executeUpdate()>0;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}  
	
    public Proveedor Buscar_Proveedor(long nit){
    	Proveedor u = null;
    	try {
			String sql = "select * from proveedores where nitproveedor=?";
			ps = conectar.prepareStatement(sql);
			ps.setLong(1, nit);
			res = ps.executeQuery();
    
			while(res.next()){
				u = new Proveedor(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return u;
    }
	
    public boolean Eliminar_Proveedor(Proveedor us) {
		int x;
		boolean dat = false;
		try {
			ps = conectar.prepareStatement("DELETE FROM proveedores WHERE nitproveedor=?");
			ps.setLong(1,us.getNit_proveedor() );
			x = ps.executeUpdate();
			
			if(x>0) {
				dat = true;	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dat;
	}
    
    public boolean Actualizar_Proveedor(Proveedor usdto) {
		int x = 0;
		boolean dat = false;
		try {
			ps = conectar.prepareStatement("UPDATE proveedores SET ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? WHERE nitproveedor=?");
			ps.setString(1, usdto.getCiudad_proveedor());
			ps.setString(2,usdto.getDireccion_proveedor());
			ps.setString(3, usdto.getNombre_proveedor());
			ps.setString(4, usdto.getTelefono_proveedor());
			ps.setLong(5, usdto.getNit_proveedor());
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
