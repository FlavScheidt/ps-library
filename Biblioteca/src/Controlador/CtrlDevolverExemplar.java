package Controlador;

import java.util.List;

import Modelo.Emprestimo;

public class CtrlDevolverExemplar {

	public void devolverExemplar(Integer id_exemplar,
			List<Emprestimo> listaEmprestimo) {
		// Busca emprestimo ativo a partir do id do exemplar emprestado
		Emprestimo emprestimo = procuraEmprestimoAtivo(id_exemplar,
				listaEmprestimo);
		if (emprestimo != null) {
			// Registra a devolução
			emprestimo.registraDevolucao();
			System.out.println("Devolução realizada com sucesso.");
		} else {
			System.out.println("Emprestimo não existe.");
		}

	}

	private Emprestimo procuraEmprestimoAtivo(Integer id_exemplar,
			List<Emprestimo> listaEmprestimo) {
		for (Emprestimo emprestimo : listaEmprestimo) {
			if (emprestimo.getDataDevolucao() == null
					&& emprestimo.getExemplar().getId() == id_exemplar) {
				return emprestimo;
			}
		}
		return null;
	}

}
