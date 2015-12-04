package Controlador;

import java.util.List;

import Modelo.Livro;
import Modelo.Periodico;
import Modelo.Usuario;
import Modelo.Emprestimo;
import Modelo.Exemplar;

public class Biblioteca {

	private List<Livro> listaLivros;
	private List<Periodico> listaPeriodicos;
	private List<Usuario> listaUsuarios;
	private List<Emprestimo> listaEmprestimos;
	private List<Exemplar> listaExemplar;

	public List<Livro> getListaLivros() {
		return listaLivros;
	}

	public void setListaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}

	public List<Periodico> getListaPeriodicos() {
		return listaPeriodicos;
	}

	public void setListaPeriodicos(List<Periodico> listaPeriodicos) {
		this.listaPeriodicos = listaPeriodicos;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Emprestimo> getListaEmprestimos() {
		return listaEmprestimos;
	}

	public void setListaEmprestimos(List<Emprestimo> listaEmprestimos) {
		this.listaEmprestimos = listaEmprestimos;
	}

	public List<Exemplar> getListaExemplar() {
		return listaExemplar;
	}

	public void setListaExemplar(List<Exemplar> listaExemplar) {
		this.listaExemplar = listaExemplar;
	}

}
