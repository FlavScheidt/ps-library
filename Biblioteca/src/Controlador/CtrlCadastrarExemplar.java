package Controlador;

import java.util.List;

import Modelo.Exemplar;
import Modelo.Obra;

public class CtrlCadastrarExemplar {
	
	public void cadastrarExemplar(int tp_obra, String nome_obra, List<Obra> listaObra, List<Exemplar> listaExemplar) {
		//Buscar a obra na lista usando um método genérico da classe lista
		Obra obra = buscaObra(tp_obra, nome_obra, listaObra);
		//Chama a obra para criar o exemplar
		obra.criarExemplar(listaExemplar);
	}

	public Obra buscaObra(int tp_obra, String nome_obra, List<Obra> listaObra) {
		return listaObra.get(0);
	}
}
