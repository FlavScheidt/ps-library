package Controlador;

import java.util.List;

import Modelo.Exemplar;
import Modelo.Obra;
import Modelo.Livro;
import Modelo.Periodico;

public class CtrlCadastrarExemplar {

	public void cadastrarExemplar(Integer tp_obra, String nome_obra,
			List<Obra> listaObra, List<Exemplar> listaExemplar) {
		// Buscar a obra na listaObra
		Obra obra = buscaObra(tp_obra, nome_obra, listaObra);
		if (obra != null) {
			// Criar o exemplar
			Exemplar exemplar = new Exemplar();
			exemplar.setObra(obra);
			exemplar.setId(listaExemplar.size());
			// Adicionar o exemplar na lista
			listaExemplar.add(exemplar);
			System.out.println("Exemplar cadastrada com sucesso com o id:"
					+ (listaExemplar.size() - 1) + ".");
		} else {
			System.out.println("Obra não existe.");
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
