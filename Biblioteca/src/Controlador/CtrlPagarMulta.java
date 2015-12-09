package Controlador;

import java.util.List;

import Modelo.Usuario;
import Modelo.Emprestimo;

public class CtrlPagarMulta {

	public void pagarMulta(String cpf, List<Usuario> listaUsuario,
			List<Emprestimo> listaEmprestimo) {

		Integer vl_multa;
		// Busca o usuário
		Usuario usuario = buscaUsuario(cpf, listaUsuario);

		// Percorre Lista buscando se algum deles tem multa, se tem e nao foi paga, soma
		for (Emprestimo emprestimo : listaEmprestimo) {
			if (emprestimo.getUsuario().getId() == usuario.getId()) {

				if (emprestimo.getMulta() != null) {
					
					if (!emprestimo.getMulta().getPago()) {
						vl_multa = emprestimo.calculaMulta();
					}
				}
			}
		}
		
		//Dar um jeito de pedir que a interface imprima o valor da multa
		
		//Percorre lista encerrando multas
		// Percorre Lista buscando se algum deles tem multa, se tem e nao foi paga, soma
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
