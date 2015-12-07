package Controlador;

import java.util.List;

import Modelo.Livro;
import Modelo.Periodico;
import Modelo.Obra;

public class CtrlCadastrarObra {
	
	public void cadastrarObra(int tp_obra, String nome, int ano, String autor, String editora, String volume, 
								int mes, List<Obra> listaObra)
	{
		//Livro
		if (tp_obra == 1)
		{
			Livro livro = new Livro(nome, ano, autor, editora);
			
			//Insere na lista
			listaObra.add(livro);
		}
		//Periodico
		else if (tp_obra == 2)
		{
			Periodico periodico = new Periodico(nome, ano, volume, mes);
			
			//Insere na lista
			listaObra.add(periodico);
		}
		
	}
}
