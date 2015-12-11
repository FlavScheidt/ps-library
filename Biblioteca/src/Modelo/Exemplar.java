package Modelo;

public class Exemplar {

	private Integer  id;
	private Obra obra;

	//Getters & setters
	public Integer  getId() {
		return id;
	}

	public void setId(Integer  id) {
		this.id = id;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public Exemplar(Integer id, Obra obra) {
		super();
		this.id = id;
		this.obra = obra;
	}
}
