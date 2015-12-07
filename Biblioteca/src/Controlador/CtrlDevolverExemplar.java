package Controlador;

import Modelo.Emprestimo;

public class CtrlDevolverExemplar {
	
	public void devolverExemplar(Integer id_exemplar)
	{
		//Busca emprestimo ativo a partir do id do exemplar emprestado
		Emprestimo emprestimo = buscaEmprestimo(id_exemplar);
		
		//Registra a devolução
		emprestimo.registraDevolucao();
		
	}

}
