package modelo;

public class Resultado {
	private double tot,tot1,tot2,res,res1,res2,totalsiniva,totaliva,totaldesiva;
	private double total,total1,total2;
	private int cant, cant1, cant2;
	private long cedula_usuario, cedula_cliente;
	private long codpro, codpro1, codpro2;
	
	public Resultado(double a7, double a8, double a9,int a13, int a14, int a15, long a16, long a17, double a18, double a19, double a20) {
		// TODO Auto-generated constructor stub
		totalsiniva = a7;
		totaliva = a8;
		totaldesiva = a9;
		cant = a13;
		cant1 = a14;
		cant2 = a15;
		cedula_usuario = a16;
		cedula_cliente = a17;
		total = a18;
		total1 = a19;
		total2 = a20;
	}
	
	public Resultado(long a16) {
		// TODO Auto-generated constructor stub
		cedula_usuario = a16;
	}
	

	public long getCodpro() {
		return codpro;
	}

	public long getCodpro1() {
		return codpro1;
	}

	public long getCodpro2() {
		return codpro2;
	}

	public long getCedula_usuario() {
		return cedula_usuario;
	}

	public long getCedula_cliente() {
		return cedula_cliente;
	}

	public double getTot() {
		return tot;
	}

	public void setTot(double tot) {
		this.tot = tot;
	}

	public double getTot1() {
		return tot1;
	}

	public void setTot1(double tot1) {
		this.tot1 = tot1;
	}

	public double getTot2() {
		return tot2;
	}

	public void setTot2(double tot2) {
		this.tot2 = tot2;
	}

	public double getRes() {
		return res;
	}

	public void setRes(double res) {
		this.res = res;
	}

	public double getRes1() {
		return res1;
	}

	public void setRes1(double res1) {
		this.res1 = res1;
	}

	public double getRes2() {
		return res2;
	}

	public void setRes2(double res2) {
		this.res2 = res2;
	}

	public double getTotalsiniva() {
		return totalsiniva;
	}

	public void setTotalsiniva(double totalsiniva) {
		this.totalsiniva = totalsiniva;
	}

	public double getTotaliva() {
		return totaliva;
	}

	public void setTotaliva(double totaliva) {
		this.totaliva = totaliva;
	}

	public double getTotaldesiva() {
		return totaldesiva;
	}

	public void setTotaldesiva(double totaldesiva) {
		this.totaldesiva = totaldesiva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal1() {
		return total1;
	}

	public void setTotal1(double total1) {
		this.total1 = total1;
	}

	public double getTotal2() {
		return total2;
	}

	public void setTotal2(double total2) {
		this.total2 = total2;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public int getCant1() {
		return cant1;
	}

	public void setCant1(int cant1) {
		this.cant1 = cant1;
	}

	public int getCant2() {
		return cant2;
	}

	public void setCant2(int cant2) {
		this.cant2 = cant2;
	}

}
