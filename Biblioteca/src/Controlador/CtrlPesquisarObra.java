package Controlador;

import java.util.List;

import Modelo.Emprestimo;
import Modelo.Exemplar;
import Modelo.Livro;
import Modelo.Obra;
import Modelo.Periodico;

public class CtrlPesquisarObra {
	
	public List<Integer> pesquisarobra(Integer tp_obra, String nome_obra, List<Obra> listaObra, List<Emprestimo> listaEmprestimo, List<Exemplar> listaExemplar)
	{
		List<Integer> retorno = null;
		//Busca obra
		Obra obra = buscaObra(tp_obra, nome_obra, listaObra);
		
		//Percorre lista de exemplares para saber quantos exemplares daquela obra existem
		Integer numExemplares = 0;
		for(Exemplar exemplar : listaExemplar)
		{
			if (exemplar.getObra().getId() == obra.getId())
			{
				numExemplares = numExemplares + 1;
			}
		}
		retorno.add(numExemplares);
		
		//Percorre lista de emprestimos procurando os que estao disponiveis
		Integer disponiveis = 0;
		
		for(Emprestimo emprestimo : listaEmprestimo)
		{
			if (emprestimo.getExemplar().getObra().getId() == obra.getId()
					&& emprestimo.getDataDevolucao() != null)
			{
				disponiveis = disponiveis + 1;
			}
		}
		retorno.add(disponiveis);
		
		return retorno;
		
	}
	
	public Obra buscaObra(int tp_obra, String nome_obra, List<Obra> listaObra) {
		for (Obra obra : listaObra) {
			if (tp_obra == 1) {
				if (obra.getClass().equals(Livro.class)
						&& obra.getNome() == nome_obra) { // && obra instanceof Livro
					return obra;
				}
			} else if (tp_obra == 2) {
				if (obra.getClass().equals(Periodico.class)
						&& obra.getNome() == nome_obra) { // && obra instanceof Periodico
					return obra;
				}
			}
		}
		return null;
	}

}
