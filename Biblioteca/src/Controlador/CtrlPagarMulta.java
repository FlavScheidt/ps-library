package Controlador;

import java.util.List;

import Modelo.Emprestimo;
import Modelo.Usuario;

public class CtrlPagarMulta {

	public void pagarMulta(String cpf, List<Usuario> listaUsuario, List<Emprestimo> listaEmprestimo) {

		Integer vl_multa = 0;
		// Busca o usuário
		Usuario usuario = buscaUsuario(cpf, listaUsuario);
		if (usuario == null) {
			System.out.println("Usuário não existe");
			return;
		}

		// Percorre Lista de emprestimos buscando se algum deles tem multa, se tem e nao foi paga, soma
		for (Emprestimo emprestimo : listaEmprestimo) {
			if (emprestimo.getUsuario().getId() == usuario.getId()) {
				if (emprestimo.getMulta() != null) {
					if (emprestimo.getMulta().getPago() == false) {
						vl_multa = vl_multa + emprestimo.getMulta().getValor();
					}
				}
			}
		}

		// Dar um jeito de pedir que a interface imprima o valor da multa
		System.out.println("Valor da multa paga:" + vl_multa);

		// Percorre lista encerrando multas
		// Percorre Lista buscando se algum deles tem multa, se tem e nao foi
		// paga, soma
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
