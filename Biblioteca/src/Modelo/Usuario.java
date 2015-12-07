package Modelo;

public class Usuario {

	private Integer id;
	private String cpf;
	private String nome;
	private Integer telefone;
	private String tipo;

	//Getters & Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	//Construtores
	public Usuario(Integer id, String cpf, String nome, Integer telefone,
			String tipo) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.tipo = tipo;
	}
}
