package Controlador;

import java.util.List;

import Modelo.Livro;
import Modelo.Periodico;
import Modelo.Obra;

public class CtrlCadastrarObra {

	public void cadastrarObra(Integer tp_obra, String nome, Integer ano,
			String autor, String editora, Integer volume, Integer mes,
			List<Obra> listaObra) {
		// Livro
		if (tp_obra == 1) {
			Livro livro = new Livro(nome, ano, autor, editora);

			// Insere na lista
			listaObra.add(livro);
		}
		// Periodico
		else if (tp_obra == 2) {
			Periodico periodico = new Periodico(nome, ano, volume, mes);

			// Insere na lista
			listaObra.add(periodico);
		}
		System.out.println("Obra cadastrada com sucesso.");
	}
}
