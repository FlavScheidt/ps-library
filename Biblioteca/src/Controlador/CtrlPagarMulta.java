package Controlador;

import java.util.List;

import Modelo.Usuario;
import Modelo.Emprestimo;
import Modelo.Multa;

public class CtrlPagarMulta {

	public void pagarMulta(String cpf, List<Usuario> listaUsuario,
			List<Emprestimo> listaEmprestimo) {

		// Busca o usuário
		Usuario usuario = buscaUsuario(cpf, listaUsuario);

		// Percorre Lista buscando se algum deles tem multa
		for (Emprestimo emprestimo : listaEmprestimo) {
			if (emprestimo.getUsuario() == usuario) {

				if (emprestimo.getMulta() != null) {
					
					if (!emprestimo.getMulta().getPago()) {
						emprestimo.getMulta().setPago(true);
					}
				}
			}
		}

	}

	public Usuario buscaUsuario(String cpf, List<Usuario> listaUsuario) {
		for (Usuario usuario : listaUsuario) {
			if (usuario.getCpf().equals(cpf)) {
				return usuario;
			}
		}
		return null;
	}
}
