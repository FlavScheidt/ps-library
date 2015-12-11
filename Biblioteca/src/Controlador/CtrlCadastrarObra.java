package Controlador;

import java.util.List;

import Modelo.Livro;
import Modelo.Periodico;
import Modelo.Obra;

public class CtrlCadastrarObra {

	public void cadastrarObra(Integer tp_obra, String nome, Integer ano,
			String autor, String editora, Integer volume, Integer mes,
			List<Obra> listaObra) {

		Obra obra = buscaObra(tp_obra, nome, listaObra);
		
		if (obra != null) {
			System.out.println("Obra já existe.");
			return;
		}
		// Livro
		if (tp_obra == 1) {
			Livro livro = new Livro(nome, ano, autor, editora);

			// Insere na lista
			listaObra.add(livro);
			System.out.println();
			System.out.println("-- Livro cadastrado com sucesso --");
			System.out.print("Nome: " + nome);
			System.out.print("; Ano: " + ano);
			System.out.print("; Autor: " + autor);
			System.out.println("; Editora: " + editora);
			System.out.println("----------------------------------");
		}
		// Periodico
		else if (tp_obra == 2) {
			Periodico periodico = new Periodico(nome, ano, volume, mes);

			// Insere na lista
			listaObra.add(periodico);
			System.out.println();
			System.out.println("-- Periodico cadastrado com sucesso --");
			System.out.print("Nome: " + nome);
			System.out.print("; Ano: " + ano);
			System.out.print("; Volume: " + volume);
			System.out.println("; Mês: " + mes);
			System.out.println("----------------------------------");
		}
	}

	public Obra buscaObra(Integer tp_obra, String nome_obra,
			List<Obra> listaObra) {
		for (Obra obra : listaObra) {
			if (tp_obra == 1) {
				if (obra.getClass().equals(Livro.class)
						&& obra.getNome().equals(nome_obra)) { // && obra
																// instanceof
																// Livro
					return obra;
				}
			} else if (tp_obra == 2) {
				if (obra.getClass().equals(Periodico.class)
						&& obra.getNome().equals(nome_obra)) { // && obra
																// instanceof
																// Periodico
					return obra;
				}
			}
		}
		return null;
	}
}
