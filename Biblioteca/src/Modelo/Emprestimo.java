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

	// Getters & setters
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

	// Construtores
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

	// Métodos
	public void registraDevolucao() {
		// Insere data atual na data de devolução
		this.dataDevolucao = new Date();

		// Verifica se precisa criar multa
		if (this.dataDevolucao.compareTo(this.dataPrevistaDevolucao) > 0) {
			// Calcula valor da multa
			int valor = 5 * (int) ((this.dataDevolucao.getTime() - this.dataPrevistaDevolucao
					.getTime()) / (1000 * 60 * 60 * 24));

			// Cria multa
			Multa multa = new Multa(false, valor);
			this.multa = multa;
		}

	}

	public Boolean verificaBloqueio() {
		// Verifica se possui multa
		if (this.multa != null) {
			return !this.multa.getPago();
		}
		// verifica se precisa devolver
		if (this.dataDevolucao.compareTo(this.dataPrevistaDevolucao) > 0) {
			return true;
		}
		return false;
	}
	
	private static int difDatas(Date dt1, Date dt2) {  
        long tempo1 = dt1.getTime();  
        long tempo2 = dt2.getTime();  
        long difTempo = tempo2 - tempo1;  
        return (int) ((difTempo + 60L * 60 * 1000) / (24L * 60 * 60 * 1000)) + 1;  
    }  

	public Integer calculaMulta() {
		return (difDatas(this.dataPrevistaDevolucao, this.dataDevolucao)*5);
	}

}
