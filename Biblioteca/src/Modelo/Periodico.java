package Modelo;

public class Periodico extends Obra {

	private Integer volume;
	private Integer mes;

	// Getters & Setters
	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	// Construtores
	public Periodico(String nome, Integer ano, Integer volume, Integer mes) {
		super(nome, ano);
		this.volume = volume;
		this.mes = mes;
	}
}
