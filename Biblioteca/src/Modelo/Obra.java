package Modelo;

import java.util.List;

public abstract class Obra {

	private Integer id;
	private String nome;
	private Integer ano;
	private List<Exemplar> listaExemplar;
	 
	//Getters & setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	
	public List<Exemplar> getExemplar() {
		return listaExemplar;
	}

	public void setExemplar(List<Exemplar> listaExemplar) {
		this.listaExemplar = listaExemplar;
	}
	
	//Construtores
	public Obra() {
		super();
	}
	
	//Métodos 
	public void criarExemplar(List<Exemplar> listaExemplar)
	{
		//Cria exemplar
		Exemplar exemplar = new Exemplar();
		//Adiciona na lista de exemplares DESTA obra
		this.listaExemplar.add(exemplar);
		//Adicona na lista do main
		listaExemplar.add(exemplar);
	}
	
	public Integer numExemplares()
	{
		return this.listaExemplar.size();
	}

}
