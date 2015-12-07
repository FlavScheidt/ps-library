package Modelo;

public class Periodico extends Obra {

	private String volume;
	private Integer mes;

	//Getters & Setters
	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}
	
	//Construtores
	public Periodico(String nome, int ano, String volume, Integer mes) {
		super();
		this.volume = volume;
		this.mes = mes;
	}

}
