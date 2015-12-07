package Modelo;

public class Livro extends Obra {

	private String autor;
	private String editora;

	//Getters & setters
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	//Construtores
	public Livro(String nome, int ano, String autor, String editora) {
		super();
		this.autor = autor;
		this.editora = editora;
	}
	

}
