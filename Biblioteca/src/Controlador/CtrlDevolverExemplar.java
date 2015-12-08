package Controlador;

import java.util.List;

import Modelo.Emprestimo;

public class CtrlDevolverExemplar {
	
	public void devolverExemplar(Integer id_exemplar, List<Emprestimo> listaEmprestimo)
	{
		//Busca emprestimo ativo a partir do id do exemplar emprestado
		Emprestimo emprestimo = buscaEmprestimo(id_exemplar, listaEmprestimo);
		
		//Registra a devolução
		emprestimo.registraDevolucao();
		
	}

	private Emprestimo buscaEmprestimo(Integer id_exemplar, List<Emprestimo> listaEmprestimo) {
		// TODO Auto-generated method stub
		return null;
	}

}
