package Modelo;


public abstract class Obra {

	private String nome;
	private Integer ano;
	 
	//Getters & setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Obra(String nome, Integer ano) {
		super();
		this.nome = nome;
		this.ano = ano;
	}
	
	
	
}
