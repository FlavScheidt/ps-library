package Controlador;

import java.util.Iterator;
import java.util.List;

import Modelo.Usuario;
import Modelo.Emprestimo;
import Modelo.Multa;

public class CtrlPagarMulta {
	
	public void pagarMulta (String cpf, List<Usuario> listaUsuario, List<Emprestimo> listaEmprestimo)
	{
		Boolean pago = true;
		
		//Busca o usuário
		Usuario usuario = buscaUsuario(cpf, listaUsuario);
		
		//Busca Empréstimos ativos do usuário
		List<Emprestimo> listaEmprestimosAtivos = buscaEmprestimosAtivos(usuario, listaEmprestimo);
		
		//Percorre Lista buscando se algum deles tem multa
		for(Emprestimo ativo : listaEmprestimosAtivos)
		{
			//Esse null tá errado. Não sei como colocar
			if (ativo.getMulta() != NULL)
			{
				Multa multa = new Multa(ativo.getMulta().getId(), pago, ativo.getMulta().getValor());
				ativo.setMulta(multa);
			}
		}
		
	}
	
	public Usuario buscaUsuario(String CPF, List<Usuario> listaUsuario)
	{
		return null;
	}
	
	public List<Emprestimo> buscaEmprestimosAtivos(Usuario usuario, List<Emprestimo> listaEmprestimo)
	{
		return null;
	}
}
