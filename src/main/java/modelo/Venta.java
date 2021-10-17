package modelo;

public class Venta {
	private int codigo_venta;
	private long cedula_cliente;
	private long cedula_usuario;
	private double ivaventa;
	private double total_venta;
	private double valor_venta;
	
	public Venta(int a1, long a2, long a3, double a4, double a5, double a6) {
		codigo_venta = a1;
		cedula_cliente = a2;
		cedula_usuario = a3;
		ivaventa = a4;
		total_venta = a5;
		valor_venta = a6;
	}

	public Venta(long a1, long a2, double a3, double a4, double a5) {
		cedula_cliente = a1;
		cedula_usuario = a2;
		ivaventa = a3;
		total_venta = a4;
		valor_venta = a5;
		
	}

	public int getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public long getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public long getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public double getIvaventa() {
		return ivaventa;
	}

	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
}
