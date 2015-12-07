package Modelo;

import java.util.Date;

public class Emprestimo {

	private Integer id;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	private Date dataPrevistaDevolucao;
	private Exemplar exemplar;
	private Multa multa;
	private Usuario usuario;

	//Getters & setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Date getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	//Construtores
	public Emprestimo(Integer id, Date dataEmprestimo, Date dataDevolucao,
			Date dataPrevistaDevolucao, Exemplar exemplar, Multa multa,
			Usuario usuario) {
		super();
		this.id = id;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
		this.exemplar = exemplar;
		this.multa = multa;
		this.usuario = usuario;
	}
	
	//Métodos
	public Emprestimo buscaEmprestimo(Integer id_exemplar)
	{
		return null;
		
	}
	
	public void registraDevolucao()
	{
		long agora = System.currentTimeMillis();

		this.dataDevolucao = new Date (agora);
	}

}
