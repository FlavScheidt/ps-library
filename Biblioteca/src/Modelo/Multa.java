package Modelo;

public class Multa {

	private Boolean pago;
	private int valor;

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	//Construtores
	public Multa(Boolean pago, int valor) {
		super();
		this.pago = pago;
		this.valor = valor;
	}
	
}
