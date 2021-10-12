package modelo;

public class Proveedor {
	private long nit_proveedor;
	private String ciudad_proveedor;
	private String direccion_proveedor;
	private String nombre_proveedor;
	private String telefono_proveedor;
	
	public Proveedor(long a1, String a2, String a3, String a4, String a5) {
		// TODO Auto-generated constructor stub
		nit_proveedor = a1;
		ciudad_proveedor = a2;
		direccion_proveedor = a3;
		nombre_proveedor = a4;
		telefono_proveedor = a5;
	}
	
	public long getNit_proveedor() {
		return nit_proveedor;
	}

	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}

	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

}
