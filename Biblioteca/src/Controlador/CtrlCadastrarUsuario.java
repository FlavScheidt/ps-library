package Controlador;

import java.util.List;

import Modelo.TipoUsuario;
import Modelo.Usuario;

public class CtrlCadastrarUsuario {

	public void cadastrarUsuario(TipoUsuario tp_usuario, String nome,
			String cpf, Integer telefone, List<Usuario> listaUsuario) {
		// Cria usuário
		Usuario usuario = new Usuario(listaUsuario.size(), cpf, nome, telefone,
				tp_usuario);
		
		// Insere na lista
		listaUsuario.add(usuario);
		System.out.println();
		System.out.println("-- Usuário cadastrada com sucesso --");
		System.out.print("Nome: " + nome);
		System.out.print("; CPF: " + cpf);
		System.out.println("; Telefone: " + telefone);
		System.out.println("------------------------------------");
	}

}
