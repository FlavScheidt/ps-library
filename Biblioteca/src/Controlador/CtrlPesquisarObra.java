package Controlador;

import java.util.List;

import Modelo.Emprestimo;
import Modelo.Exemplar;
import Modelo.Livro;
import Modelo.Obra;
import Modelo.Periodico;

public class CtrlPesquisarObra {

	public void pesquisarobra(Integer tp_obra, String nome_obra,
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
				if (exemplar.getObra().equals(obra)) {
					numExemplares++;
				}
			}

			// Percorre lista de emprestimos procurando os que estao disponiveis
			if (numExemplares == 0) {
				System.out.println("Nenhum exemplar da obra foi encontrado");
			} else {

				Integer emprestados = 0;

				for (Emprestimo emprestimo : listaEmprestimo) {
					if (emprestimo.getExemplar().getObra().equals(obra)
							&& emprestimo.getDataDevolucao() == null) {
						emprestados++;
					}
				}
				Integer disponiveis = numExemplares - emprestados;

				System.out.println("Exemplares da obra : " + numExemplares);
				System.out.println("Exemplares disponíveis para empréstimo : "
						+ disponiveis);
			}

		} else {
			// Obra não encontrada
			System.out.println("Obra não encontrada !");
		}
	}

	public Obra buscaObra(Integer tp_obra, String nome_obra,
			List<Obra> listaObra) {
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
