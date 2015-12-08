package Controlador;

import java.util.List;

import Modelo.Emprestimo;
import Modelo.Obra;

public class CtrlPesquisarObra {
	
	public void pesquisarobra(Integer tp_obra, String nome_obra, List<Obra> listaObra, List<Emprestimo> listaEmprestimo)
	{
		//Busca obra
		Obra obra = buscaObra(tp_obra, nome_obra, listaObra);
		
		Integer numExemplares = obra.numExemplares();
		
		//Percorre lista de emprestimos procurando os que estao disponiveis
		Integer disponiveis = 0;
		
		for(Emprestimo emprestimo : listaEmprestimo)
		{
			if (emprestimo.getExemplar().getObra().getId() == obra.getId()
					&& emprestimo.getDataDevolucao() != NULL)
			{
				disponiveis = disponiveis + 1;
			}
		}
		
	}
	
	public Obra buscaObra(int tp_obra, String nome_obra, List<Obra> listaObra) {
		return listaObra.get(0);
	}

}
