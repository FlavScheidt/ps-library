package Controlador;

import java.util.Iterator;
import java.util.List;

import Modelo.Usuario;
import Modelo.Emprestimo;
import Modelo.Multa;

public class CtrlPagarMulta {

	public void pagarMulta(String cpf, List<Usuario> listaUsuario,
			List<Emprestimo> listaEmprestimo) {
		
		Boolean pago = true;

		// Busca o usuário
		Usuario usuario = buscaUsuario(cpf, listaUsuario);

		// Percorre Lista buscando se algum deles tem multa
		for (Emprestimo emprestimo : listaEmprestimo) {
			if (emprestimo.getUsuario() == usuario) {

				// Esse null tá errado. Não sei como colocar
				if (emprestimo.getMulta() != null) {
					
					if (!emprestimo.getMulta().getPago()) {
						
					}
					//Multa multa = new Multa(pago, emprestimo.getMulta().getValor());
					//emprestimo.setMulta(multa);
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
