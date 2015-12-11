package Controlador;

import java.util.List;

import Modelo.Emprestimo;
import Modelo.Exemplar;
import Modelo.Livro;
import Modelo.Obra;
import Modelo.Periodico;

public class CtrlPesquisarObra {

	public void pesquisarObra(Integer tp_obra, String nome_obra,
			List<Obra> listaObra, List<Emprestimo> listaEmprestimo,
			List<Exemplar> listaExemplar) {
		// Busca obra
		Obra obra = buscaObra(tp_obra, nome_obra, listaObra);

		// Verifica se encontrou a obra
		if (obra != null) {

			System.out.println();
			System.out.println("-- Obra Encontrada --");
			System.out.print("Nome: " + obra.getNome());
			System.out.print("; Ano: " + obra.getAno());
			if (obra.getClass().equals(Livro.class)) {
				System.out.print("; Autor: " + ((Livro) obra).getAutor());
				System.out.print("; Editora: " + ((Livro) obra).getEditora());
			}else {
				System.out.print("; Volume: " + ((Periodico) obra).getVolume());
				System.out.print("; Mês: " + ((Periodico) obra).getMes());
			}

			// Percorre lista de exemplares para saber quantos exemplares
			// daquela obra existem
			Integer numExemplares = 0;
			for (Exemplar exemplar : listaExemplar) {
				if (exemplar.getObra().equals(obra)) {
					numExemplares++;
				}
			}
			System.out.print("; Nº de Exemplares: " + numExemplares);

			// Percorre lista de emprestimos procurando os que estao disponiveis
			if (numExemplares > 0) {
				Integer emprestados = 0;

				for (Emprestimo emprestimo : listaEmprestimo) {
					if (emprestimo.getExemplar().getObra().equals(obra)
							&& emprestimo.getDataDevolucao() == null) {
						emprestados++;
					}
				}
				Integer disponiveis = numExemplares - emprestados;

				System.out.print("; Nº de Exemplares Disponiveis: "
						+ disponiveis);
			}
			System.out.println();
			System.out.println("---------------------");

		} else {
			System.out.println("Obra não encontrada !");
		}
	}

	private Obra buscaObra(Integer tp_obra, String nome_obra,
			List<Obra> listaObra) {
		for (Obra obra : listaObra) {
			if (tp_obra == 1) {
				if (obra.getClass().equals(Livro.class)
						&& obra.getNome().equals(nome_obra)) {
					return obra;
				}
			} else if (tp_obra == 2) {
				if (obra.getClass().equals(Periodico.class)
						&& obra.getNome().equals(nome_obra)) {
					return obra;
				}
			}
		}
		return null;
	}

}
