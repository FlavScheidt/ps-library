package Controlador;

import java.util.List;

import Modelo.Usuario;

public class CtrlCadastrarUsuario {

	public void cadastrarUsuario(String tp_usuario, String nome, String cpf, Integer telefone, List<Usuario> listaUsuario)
	{
		//Como calcular o id?
		Integer id = null;
		
		//Cria usuário
		Usuario usuario = new Usuario(id, cpf, nome, telefone, tp_usuario);
		
		//Insere na lista
		listaUsuario.add(usuario);
	}
	
}
