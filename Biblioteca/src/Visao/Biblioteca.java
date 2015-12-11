package Visao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Controlador.CtrlCadastrarExemplar;
import Controlador.CtrlCadastrarObra;
import Controlador.CtrlCadastrarUsuario;
import Controlador.CtrlDevolverExemplar;
import Controlador.CtrlEmprestarExemplar;
import Controlador.CtrlPagarMulta;
import Controlador.CtrlPesquisarObra;
import Modelo.Emprestimo;
import Modelo.Exemplar;
import Modelo.Obra;
import Modelo.TipoUsuario;
import Modelo.Usuario;

public class Biblioteca {

	public static void main(String[] arguments) {
		Scanner keyboard = new Scanner(System.in);

		// Instancia os controladores
		CtrlCadastrarObra ctrlCadastrarObra = new CtrlCadastrarObra();
		CtrlCadastrarExemplar ctrlCadastrarExemplar = new CtrlCadastrarExemplar();
		CtrlCadastrarUsuario ctrlCadastrarUsuario = new CtrlCadastrarUsuario();
		CtrlEmprestarExemplar ctrlEmprestarExemplar = new CtrlEmprestarExemplar();
		CtrlDevolverExemplar ctrlDevolverExemplar = new CtrlDevolverExemplar();
		CtrlPesquisarObra ctrlPesquisarObra = new CtrlPesquisarObra();
		CtrlPagarMulta ctrlPagarMulta = new CtrlPagarMulta();

		// Cria as listas
		List<Obra> listaObra = new ArrayList<Obra>();
		List<Exemplar> listaExemplar = new ArrayList<Exemplar>();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		List<Emprestimo> listaEmprestimo = new ArrayList<Emprestimo>();

		populaListas(listaObra, listaExemplar, listaUsuario, listaEmprestimo,
				ctrlCadastrarObra, ctrlCadastrarExemplar, ctrlCadastrarUsuario,
				ctrlEmprestarExemplar, ctrlDevolverExemplar);

		// Inicio
		int option = 0;
		clearConsole();
		while (option != 8) {
			// Faz a leitura da tecla, descartando o que não for números

			imprimeMenu();
			option = getIntFromKeyboard(keyboard);
			clearConsole();
			switch (option) {
			case 1:
				cadastrarObra(keyboard, ctrlCadastrarObra, listaObra);
				break;
			case 2:
				cadastrarExemplar(keyboard, ctrlCadastrarExemplar, listaObra,
						listaExemplar);
				break;
			case 3:
				cadastrarUsuario(keyboard, ctrlCadastrarUsuario, listaUsuario);
				break;
			case 4:
				emprestarExemplar(keyboard, ctrlEmprestarExemplar,
						listaExemplar, listaUsuario, listaEmprestimo);
				break;
			case 5:
				devolverExemplar(keyboard, ctrlDevolverExemplar,
						listaEmprestimo);
				break;
			case 6:
				pesquisarObra(keyboard, ctrlPesquisarObra, listaObra,
						listaEmprestimo, listaExemplar);
				break;
			case 7:
				pagarMulta(keyboard, ctrlPagarMulta, listaUsuario,
						listaEmprestimo);
				break;
			case 8:
				System.out.println("- Sair -");
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		}
		keyboard.close();
	}

	private static void populaListas(List<Obra> listaObra,
			List<Exemplar> listaExemplar, List<Usuario> listaUsuario,
			List<Emprestimo> listaEmprestimo,
			CtrlCadastrarObra ctrlCadastrarObra,
			CtrlCadastrarExemplar ctrlCadastrarExemplar,
			CtrlCadastrarUsuario ctrlCadastrarUsuario,
			CtrlEmprestarExemplar ctrlEmprestarExemplar,
			CtrlDevolverExemplar ctrlDevolverExemplar) {

		// Obras
		ctrlCadastrarObra.cadastrarObra(1, "Harry Potter", 1997,
				"J. K. Rowling", "Rocco", null, null, listaObra);
		ctrlCadastrarObra.cadastrarObra(1, "Bible", 0000, "God", "Heaven",
				null, null, listaObra);
		ctrlCadastrarObra.cadastrarObra(1, "50 Shades of Grey", 2014,
				"E. L. James", "Arrow Books", null, null, listaObra);
		ctrlCadastrarObra.cadastrarObra(2, "RBCA12", 2012, null, null, 12, 5,
				listaObra);
		ctrlCadastrarObra.cadastrarObra(2, "RBCA7", 2007, null, null, 7, 9,
				listaObra);
		ctrlCadastrarObra.cadastrarObra(2, "RBCA1", 2001, null, null, 1, 2,
				listaObra);

		// Exemplares
		ctrlCadastrarExemplar.cadastrarExemplar(1, "Harry Potter", listaObra,
				listaExemplar);
		ctrlCadastrarExemplar.cadastrarExemplar(1, "Harry Potter", listaObra,
				listaExemplar);
		ctrlCadastrarExemplar.cadastrarExemplar(1, "Bible", listaObra,
				listaExemplar);
		ctrlCadastrarExemplar.cadastrarExemplar(1, "Bible", listaObra,
				listaExemplar);
		ctrlCadastrarExemplar.cadastrarExemplar(1, "50 Shades of Grey",
				listaObra, listaExemplar);
		ctrlCadastrarExemplar.cadastrarExemplar(1, "50 Shades of Grey",
				listaObra, listaExemplar);
		ctrlCadastrarExemplar.cadastrarExemplar(2, "RBCA12", listaObra,
				listaExemplar);
		ctrlCadastrarExemplar.cadastrarExemplar(2, "RBCA12", listaObra,
				listaExemplar);
		ctrlCadastrarExemplar.cadastrarExemplar(2, "RBCA7", listaObra,
				listaExemplar);
		ctrlCadastrarExemplar.cadastrarExemplar(2, "RBCA7", listaObra,
				listaExemplar);
		ctrlCadastrarExemplar.cadastrarExemplar(2, "RBCA1", listaObra,
				listaExemplar);
		ctrlCadastrarExemplar.cadastrarExemplar(2, "RBCA1", listaObra,
				listaExemplar);

		// Usuários
		ctrlCadastrarUsuario.cadastrarUsuario(TipoUsuario.PROFESSOR, "Silvia",
				"11111", 00000000, listaUsuario);
		ctrlCadastrarUsuario.cadastrarUsuario(TipoUsuario.ALUNO, "Elliott",
				"22222", 00000000, listaUsuario);
		ctrlCadastrarUsuario.cadastrarUsuario(TipoUsuario.USUARIO_GERAL,
				"Dilma", "33333", 00000000, listaUsuario);

		// Emprestimos
		ctrlEmprestarExemplar.emprestarExemplar(0, "33333", listaEmprestimo,
				listaUsuario, listaExemplar);
		ctrlEmprestarExemplar.emprestarExemplar(4, "22222", listaEmprestimo,
				listaUsuario, listaExemplar);
		ctrlEmprestarExemplar.emprestarExemplar(6, "11111", listaEmprestimo,
				listaUsuario, listaExemplar);
		ctrlEmprestarExemplar.emprestarExemplar(10, "11111", listaEmprestimo,
				listaUsuario, listaExemplar);

		// Altera as datas para simular um atraso
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataEmprestimo = null;
		Date dataPrevista = null;

		try {
			dataEmprestimo = sdf.parse("01/01/2011");
			dataPrevista = sdf.parse("08/01/2011");
		} catch (Exception e) {
			dataEmprestimo = new Date();
			dataPrevista = new Date();
		}

		listaEmprestimo.get(0).setDataEmprestimo(dataEmprestimo);
		listaEmprestimo.get(0).setDataPrevistaDevolucao(dataPrevista);

		// Devolve o exemplar atrasado
		ctrlDevolverExemplar.devolverExemplar(0, listaEmprestimo);

	}

	private static void cadastrarObra(Scanner keyboard,
			CtrlCadastrarObra ctrlCadastrarObra, List<Obra> listaObra) {
		String nome_obra = null;
		String nome_autor = null;
		String editora = null;
		Integer volume = null;
		Integer mes = null;
		Integer ano = null;
		Integer tp_obra = null;

		System.out.println("- Cadastrar Obra -");
		System.out.println();

		System.out.println("Escolha o tipo de obra:");
		System.out.println("1 - Livro");
		System.out.println("2 - Periódico");
		System.out.println();
		do {
			tp_obra = getIntFromKeyboard(keyboard);
		} while (tp_obra < 1 || tp_obra > 2);

		System.out.println("Insira o nome da obra:");
		System.out.println();
		nome_obra = getStringFromKeyboard(keyboard);

		System.out.println("Insira o ano da obra:");
		System.out.println();
		ano = getIntFromKeyboard(keyboard);

		switch (tp_obra) {
		case 1:
			System.out.println("Insira o nome do autor:");
			System.out.println();
			nome_autor = getStringFromKeyboard(keyboard);

			System.out.println("Insira o nome da editora:");
			System.out.println();
			editora = getStringFromKeyboard(keyboard);
			break;
		case 2:
			System.out.println("Insira o volume:");
			System.out.println();
			volume = getIntFromKeyboard(keyboard);

			System.out.println("Insira o mes:");
			System.out.println();
			mes = getIntFromKeyboard(keyboard);
			break;
		}

		ctrlCadastrarObra.cadastrarObra(tp_obra, nome_obra, ano, nome_autor,
				editora, volume, mes, listaObra);
	}

	private static void cadastrarExemplar(Scanner keyboard,
			CtrlCadastrarExemplar ctrlCadastrarExemplar, List<Obra> listaObra,
			List<Exemplar> listaExemplar) {
		Integer tp_obra = null;
		String nome_obra = null;

		System.out.println("- Cadastrar Exemplar -");
		System.out.println();

		System.out.println("Escolha o tipo de obra:");
		System.out.println("1 - Livro");
		System.out.println("2 - Periódico");
		System.out.println();
		do {
			tp_obra = getIntFromKeyboard(keyboard);
		} while (tp_obra < 1 || tp_obra > 2);

		System.out.println("Insira o nome da obra:");
		System.out.println();
		nome_obra = getStringFromKeyboard(keyboard);

		ctrlCadastrarExemplar.cadastrarExemplar(tp_obra, nome_obra, listaObra,
				listaExemplar);
	}

	private static void cadastrarUsuario(Scanner keyboard,
			CtrlCadastrarUsuario ctrlCadastrarUsuario,
			List<Usuario> listaUsuario) {
		TipoUsuario tp_usuario = null;
		Integer telefone = null;
		String nome_usuario = null;
		String cpf = null;

		System.out.println("- Cadastrar Usuário -");
		System.out.println();

		System.out.println("Escolha o tipo de usuário:");
		System.out.println("1 - Professor");
		System.out.println("2 - Aluno");
		System.out.println("3 - Usuário Geral");
		System.out.println();
		int vl_tpUsuario;
		do {
			vl_tpUsuario = getIntFromKeyboard(keyboard);
			tp_usuario = TipoUsuario.fromInteger(vl_tpUsuario);
		} while (vl_tpUsuario < 1 || vl_tpUsuario > 3);

		System.out.println("Insira o nome do usuário:");
		System.out.println();
		nome_usuario = getStringFromKeyboard(keyboard);

		System.out.println("Insira o CPF do usuário:");
		System.out.println();
		cpf = getStringFromKeyboard(keyboard);

		System.out.println("Insira o telefone do usuário:");
		System.out.println();
		telefone = getIntFromKeyboard(keyboard);

		ctrlCadastrarUsuario.cadastrarUsuario(tp_usuario, nome_usuario, cpf,
				telefone, listaUsuario);
	}

	private static void emprestarExemplar(Scanner keyboard,
			CtrlEmprestarExemplar ctrlEmprestarExemplar,
			List<Exemplar> listaExemplar, List<Usuario> listaUsuario,
			List<Emprestimo> listaEmprestimo) {
		Integer id_exemplar = null;
		String cpf = null;

		System.out.println("- Emprestar Exemplar -");
		System.out.println();

		System.out.println("Insira o identificador do exemplar:");
		System.out.println();
		id_exemplar = getIntFromKeyboard(keyboard);

		System.out.println("Insira o CPF do usuário:");
		System.out.println();
		cpf = getStringFromKeyboard(keyboard);

		ctrlEmprestarExemplar.emprestarExemplar(id_exemplar, cpf,
				listaEmprestimo, listaUsuario, listaExemplar);
	}

	private static void devolverExemplar(Scanner keyboard,
			CtrlDevolverExemplar ctrlDevolverExemplar,
			List<Emprestimo> listaEmprestimo) {
		Integer id_exemplar = null;

		System.out.println("- Devolver Exemplar -");
		System.out.println();

		System.out.println("Insira o identificador do exemplar:");
		System.out.println();
		id_exemplar = getIntFromKeyboard(keyboard);

		ctrlDevolverExemplar.devolverExemplar(id_exemplar, listaEmprestimo);
	}

	private static void pesquisarObra(Scanner keyboard,
			CtrlPesquisarObra ctrlPesquisarObra, List<Obra> listaObra,
			List<Emprestimo> listaEmprestimo, List<Exemplar> listaExemplar) {
		Integer tp_obra = null;
		String nome_obra = null;

		System.out.println("- Pesquisar Obra -");
		System.out.println();

		System.out.println("Escolha o tipo de obra:");
		System.out.println("1 - Livro");
		System.out.println("2 - Periódico");
		System.out.println();
		do {
			tp_obra = getIntFromKeyboard(keyboard);
		} while (tp_obra < 1 || tp_obra > 2);

		System.out.println("Insira o nome da obra:");
		System.out.println();
		nome_obra = getStringFromKeyboard(keyboard);

		try {
			ctrlPesquisarObra.pesquisarObra(tp_obra, nome_obra, listaObra,
					listaEmprestimo, listaExemplar);
		} catch (Exception e) {

		}
	}

	private static void pagarMulta(Scanner keyboard,
			CtrlPagarMulta ctrlPagarMulta, List<Usuario> listaUsuario,
			List<Emprestimo> listaEmprestimo) {
		System.out.println("- Pagar Multa -");
		System.out.println();

		String cpf = null;

		System.out.println("Insira o CPF do usuário:");
		System.out.println();
		cpf = getStringFromKeyboard(keyboard);

		ctrlPagarMulta.pagarMulta(cpf, listaUsuario, listaEmprestimo);
	}

	private static void imprimeMenu() {
		System.out.println();
		System.out.println("----------------------------");
		System.out.println("-        Biblioteca        -");
		System.out.println("----------------------------");
		System.out.println();
		System.out.println("- Opções -");
		System.out.println();
		System.out.println("1 - Cadastrar Obra");
		System.out.println("2 - Cadastrar Exemplar");
		System.out.println("3 - Cadastrar Usuário");
		System.out.println("4 - Emprestar Exemplar");
		System.out.println("5 - Devolver Exemplar");
		System.out.println("6 - Pesquisar Obra");
		System.out.println("7 - Pagar Multa");
		System.out.println("8 - Sair");
		System.out.println();
	}

	private static int getIntFromKeyboard(Scanner keyboard) {
		int retorno = 0;
		boolean inteiro = false;
		do {
			try {
				retorno = Integer.parseInt(getStringFromKeyboard(keyboard));
				inteiro = true;
			} catch (Exception e) {
				System.out.println("Opção Inválida!");
			}
		} while (!inteiro);

		return retorno;
	}

	private static String getStringFromKeyboard(Scanner keyboard) {
		String retorno = "";
		retorno = keyboard.nextLine();
		return retorno;
	}

	private static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			System.out.println("ERRO CLEAR");
		}
	}

}
