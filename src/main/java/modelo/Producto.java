package modelo;

public class Producto {
		// TODO Auto-generated constructor stub
		private long codigo_producto;
		private String nombre_producto;
		private long nitproveedor;
		private double precio_compra;
		private double ivacompra;
		private double precio_venta;
		public Producto(long a1, String a2, long a3, double a4, double a5, double a6) {

			this.codigo_producto = a1;
			this.nombre_producto = a2;
			this.nitproveedor = a3;
			this.precio_compra = a4;
			this.ivacompra = a5;
			this.precio_venta = a6;
		}
		
		public Producto(long codigoproducto) {
			super();
			this.codigo_producto = codigoproducto;
		}
		public long getCodigoproducto() {
			return codigo_producto;
		}
		public void setCodigoproducto(long codigoproducto) {
			this.codigo_producto = codigoproducto;
		}
		public double getIvacompra() {
			return ivacompra;
		}
		public void setIvacompra(double ivacompra) {
			this.ivacompra = ivacompra;
		}
		public long getNitproveedor() {
			return nitproveedor;
		}
		public void setNitproveedor(long nitproveedor) {
			this.nitproveedor = nitproveedor;
		}
		public String getNombreproducto() {
			return nombre_producto;
		}
		public void setNombreproducto(String nombreproducto) {
			this.nombre_producto = nombreproducto;
		}
		public double getPreciocompra() {
			return precio_compra;
		}
		public void setPreciocompra(double preciocompra) {
			this.precio_compra = preciocompra;
		}
		public double getPrecioventa() {
			return precio_venta;
		}
		public void setPrecioventa(double precioventa) {
			this.precio_venta = precioventa;
		}
}

