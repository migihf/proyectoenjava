package modelo;

public class Cliente {
	private long cedula_cliente;
	private String direccion_cliente;
	private String nombre_cliente;
	private String email_cliente;
	private String telefono_cliente;
	
	public Cliente(long a1, String a2, String a3, String a4, String a5) {
		cedula_cliente = a1;
		direccion_cliente = a2;
		nombre_cliente = a3;
		email_cliente = a4;
		telefono_cliente = a5;
	}
	public Cliente(long a1) {
		this.cedula_cliente = a1;
	}
	public long getCedula_cliente() {
		return cedula_cliente;
	}
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public String getEmail_cliente() {
		return email_cliente;
	}
	public String getTelefono_cliente() {
		return telefono_cliente;
	}

}
