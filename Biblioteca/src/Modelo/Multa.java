package Modelo;

public class Multa {

	private Integer id;
	private Boolean pago;
	private Float valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	//Construtores
	public Multa(Integer id, Boolean pago, Float valor) {
		super();
		this.id = id;
		this.pago = pago;
		this.valor = valor;
	}
	
}
