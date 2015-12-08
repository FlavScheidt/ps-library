package Controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Modelo.Emprestimo;
import Modelo.Exemplar;
import Modelo.Usuario;

public class CtrlEmprestarExemplar {

	public void emprestarExemplar(int idExemplar, String cpf, List<Emprestimo> listaEmprestimo, List<Usuario> listaUsuario,
			List<Exemplar> listaExemplar) {
		// Busca usuario
		Usuario usuario = retornaUsuario(cpf, listaUsuario);

		// Verifica se o usuario pode emprestar
		Boolean bloqueio = false;
		int numEmprestimosAtivo = 0;
		for (Emprestimo emprestimo : listaEmprestimo) {
			if (emprestimo.getUsuario() == usuario) {
				// verifica numero de empristimos ativos do usuario
				if (emprestimo.getDataDevolucao() == null) {
					numEmprestimosAtivo++;

					switch (usuario.getTipo()) {
					case PROFESSOR:
						if (numEmprestimosAtivo == 3) {
							return;
							// TODO return mensagem de error
						}
						break;
					case ALUNO:
						if (numEmprestimosAtivo == 2) {
							return;
							// TODO return mensagem de error
						}
						break;
					case GERAL:
						if (numEmprestimosAtivo == 1) {
							return;
							// TODO return mensagem de error
						}
						break;
					}
				}
				// verifica se tem multa
				bloqueio = emprestimo.verificaBloqueio();
				if (bloqueio) {
					return;
					// TODO return mensagem de error
				}
			}
		}

		// Busca exemplar
		Exemplar exemplar = buscaExemplar(idExemplar, listaExemplar);

		// Calcula data de devolução
		Date dataPrevistaDevolucao = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dataPrevistaDevolucao);

		switch (usuario.getTipo()) {
		case PROFESSOR:
			c.add(Calendar.DATE, 30);
			break;
		case ALUNO:
			c.add(Calendar.DATE, 15);
			break;
		case GERAL:
			c.add(Calendar.DATE, 7);
			break;
		}
		dataPrevistaDevolucao = c.getTime();

		// Cria um novo emprestimo
		Emprestimo empr = new Emprestimo(listaEmprestimo.size(), new Date(),
				null, dataPrevistaDevolucao, exemplar, null, usuario);

		// Adiciona o emprestimo na lista de emprestimos
		listaEmprestimo.add(empr);

	}

	private Usuario retornaUsuario(String cpf, List<Usuario> listaUsuario) {

		for (Usuario usuario : listaUsuario) {
			if (usuario.getCpf().equals(cpf)) {
				return usuario;
			}
		}
		return null;
	}

	private Exemplar buscaExemplar(int idExemplar, List<Exemplar> listaExemplar) {

		for (Exemplar exemplar : listaExemplar) {
			if (exemplar.getId().equals(idExemplar)) {
				return exemplar;
			}
		}
		return null;
	}
}
