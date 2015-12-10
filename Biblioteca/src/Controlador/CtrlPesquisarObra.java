package Controlador;

import java.util.List;

import Modelo.Emprestimo;
import Modelo.Exemplar;
import Modelo.Livro;
import Modelo.Obra;
import Modelo.Periodico;

public class CtrlPesquisarObra {

	public void pesquisarobra(int tp_obra, String nome_obra,
			List<Obra> listaObra, List<Emprestimo> listaEmprestimo,
			List<Exemplar> listaExemplar) {
		// Busca obra
		Obra obra = buscaObra(tp_obra, nome_obra, listaObra);

		// Verifica se encontrou a obra
		if (obra != null) {

			// Percorre lista de exemplares para saber quantos exemplares
			// daquela obra existem
			Integer numExemplares = 0;
			for (Exemplar exemplar : listaExemplar) {
				if (exemplar.getObra().getId() == obra.getId()) {
					numExemplares = numExemplares + 1;
				}
			}
			System.out.println(numExemplares);

			// Percorre lista de emprestimos procurando os que estao disponiveis
			Integer disponiveis;
			Integer emprestados = 0;

			for (Emprestimo emprestimo : listaEmprestimo) {
				if (emprestimo.getExemplar().getObra().getId() == obra.getId()
						&& emprestimo.getDataDevolucao() == null) {
					emprestados = emprestados + 1;
				}
			}
			disponiveis = numExemplares - emprestados;
		} else {
			// Obra não encontrada
			System.out.println("Obra não encontrada !");
		}
	}

	public Obra buscaObra(int tp_obra, String nome_obra, List<Obra> listaObra) {
		for (Obra obra : listaObra) {
			if (tp_obra == 1) {
				if (obra.getClass().equals(Livro.class)
						&& obra.getNome() == nome_obra) { // && obra instanceof
															// Livro
					return obra;
				}
			} else if (tp_obra == 2) {
				if (obra.getClass().equals(Periodico.class)
						&& obra.getNome() == nome_obra) { // && obra instanceof
															// Periodico
					return obra;
				}
			}
		}
		return null;
	}

}
