package Controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Modelo.Emprestimo;
import Modelo.Exemplar;
import Modelo.Livro;
import Modelo.Usuario;

public class CtrlEmprestarExemplar {

	public void emprestarExemplar(Integer idExemplar, String cpf,
			List<Emprestimo> listaEmprestimo, List<Usuario> listaUsuario,
			List<Exemplar> listaExemplar) {
		// Busca usuario
		Usuario usuario = retornaUsuario(cpf, listaUsuario);

		if (usuario != null) {

			// Verifica se o usuario pode emprestar
			Boolean bloqueio = false;
			Integer numEmprestimosAtivo = 0;
			for (Emprestimo emprestimo : listaEmprestimo) {
				if (emprestimo.getUsuario() == usuario) {
					// verifica numero de empristimos ativos do usuario
					if (emprestimo.getDataDevolucao() == null) {
						numEmprestimosAtivo++;

						switch (usuario.getTipo()) {
						case PROFESSOR:
							if (numEmprestimosAtivo == 3) {
								System.out
										.println("Usuário já possui 3 emprestimos.");
								return;
							}
							break;
						case ALUNO:
							if (numEmprestimosAtivo == 2) {
								System.out
										.println("Usuário já possui 2 emprestimos.");
								return;
							}
							break;
						case USUARIO_GERAL:
							if (numEmprestimosAtivo == 1) {
								System.out
										.println("Usuário já possui 1 emprestimos.");
								return;
							}
							break;
						}
					}
					// verifica se tem multa
					bloqueio = emprestimo.verificaBloqueio();
					if (bloqueio) {
						System.out.println("Usuário bloqueado.");
						return;
					}
				}

			}
			// Busca exemplar
			Exemplar exemplar = buscaExemplar(idExemplar, listaExemplar,
					listaEmprestimo);

			if (exemplar != null) {

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
				case USUARIO_GERAL:
					c.add(Calendar.DATE, 7);
					break;
				}
				dataPrevistaDevolucao = c.getTime();

				// Cria um novo emprestimo
				Emprestimo empr = new Emprestimo(listaEmprestimo.size(),
						new Date(), null, dataPrevistaDevolucao, exemplar,
						null, usuario);

				// Adiciona o emprestimo na lista de emprestimos
				listaEmprestimo.add(empr);
				System.out.println();
				System.out.println("-- Emprestimo realizado com sucesso --");
				System.out.print("Usuário: " + usuario.getNome());
				if (exemplar.getObra().getClass().equals(Livro.class)) {
					System.out
							.print("; Livro: " + exemplar.getObra().getNome());
				} else {
					System.out.print("; Periódico: "
							+ exemplar.getObra().getNome());
				}
				System.out.print("; Identificador: " + exemplar.getId());
				System.out.println("; Data Prevista Devolução: "
						+ dataPrevistaDevolucao);
				System.out.println("--------------------------------------");

			}
		} else {
			System.out.println("Usuário não existe.");
		}
	}

	private Usuario retornaUsuario(String cpf, List<Usuario> listaUsuario) {

		for (Usuario usuario : listaUsuario) {
			if (usuario.getCpf().equals(cpf)) {
				return usuario;
			}
		}
		return null;
	}

	private Exemplar buscaExemplar(Integer idExemplar,
			List<Exemplar> listaExemplar, List<Emprestimo> listaEmprestimo) {

		for (Exemplar exemplar : listaExemplar) {
			if (exemplar.getId().equals(idExemplar)) {
				for (Emprestimo emprestimo : listaEmprestimo) {
					if (emprestimo.getExemplar().getId()
							.equals(exemplar.getId())
							&& emprestimo.getDataDevolucao() == null) {
						System.out.println();
						System.out
								.println("-- Exemplar já possui um emprestimo ativo --");
						return null;
					}
				}

				return exemplar;
			}
		}
		System.out.println();
		System.out.println("-- Exemplar não existe --");
		return null;
	}
}
