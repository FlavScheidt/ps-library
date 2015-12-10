package Modelo;

public class Multa {

	private Boolean pago;
	private Integer valor;

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	//Construtores
	public Multa(Boolean pago, Integer valor) {
		super();
		this.pago = pago;
		this.valor = valor;
	}
	
}
