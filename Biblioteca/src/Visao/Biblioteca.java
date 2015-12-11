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

	static Scanner keyboard = new Scanner(System.in);

	// Instancia os controladores
	static CtrlCadastrarObra ctrlCadastrarObra = new CtrlCadastrarObra();
	static CtrlCadastrarExemplar ctrlCadastrarExemplar = new CtrlCadastrarExemplar();
	static CtrlCadastrarUsuario ctrlCadastrarUsuario = new CtrlCadastrarUsuario();
	static CtrlEmprestarExemplar ctrlEmprestarExemplar = new CtrlEmprestarExemplar();
	static CtrlDevolverExemplar ctrlDevolverExemplar = new CtrlDevolverExemplar();
	static CtrlPesquisarObra ctrlPesquisarObra = new CtrlPesquisarObra();
	static CtrlPagarMulta ctrlPagarMulta = new CtrlPagarMulta();

	// Cria as listas
	static List<Obra> listaObra = new ArrayList<Obra>();
	static List<Exemplar> listaExemplar = new ArrayList<Exemplar>();
	static List<Usuario> listaUsuario = new ArrayList<Usuario>();
	static List<Emprestimo> listaEmprestimo = new ArrayList<Emprestimo>();
	
	public static void main(String[] arguments) {

		// Inicio
		int option = 0;
		while (option != 8) {
			// Faz a leitura da tecla, descartando o que não for números

			imprimeMenu();
			option = getIntFromKeyboard();
			switch (option) {
			case 1:
				cadastrarObra();
				break;
			case 2:
				cadastrarExemplar();
				break;
			case 3:
				cadastrarUsuario();
				break;
			case 4:
				emprestarExemplar();
				break;
			case 5:
				devolverExemplar();
				break;
			case 6:
				pesquisarObra();
				break;
			case 7:
				pagarMulta();
				break;
			case 8:
				System.out.println("- Sair -");
				break;
			case 99:
				populaListas();
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		}
		keyboard.close();
	}

	private static void populaListas() {

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

	private static void cadastrarObra() {
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
			tp_obra = getIntFromKeyboard();
		} while (tp_obra < 1 || tp_obra > 2);

		System.out.println("Insira o nome da obra:");
		System.out.println();
		nome_obra = getStringFromKeyboard();

		System.out.println("Insira o ano da obra:");
		System.out.println();
		ano = getIntFromKeyboard();

		switch (tp_obra) {
		case 1:
			System.out.println("Insira o nome do autor:");
			System.out.println();
			nome_autor = getStringFromKeyboard();

			System.out.println("Insira o nome da editora:");
			System.out.println();
			editora = getStringFromKeyboard();
			break;
		case 2:
			System.out.println("Insira o volume:");
			System.out.println();
			volume = getIntFromKeyboard();

			System.out.println("Insira o mes:");
			System.out.println();
			mes = getIntFromKeyboard();
			break;
		}

		ctrlCadastrarObra.cadastrarObra(tp_obra, nome_obra, ano, nome_autor,
				editora, volume, mes, listaObra);
	}

	private static void cadastrarExemplar() {
		Integer tp_obra = null;
		String nome_obra = null;

		System.out.println("- Cadastrar Exemplar -");
		System.out.println();

		System.out.println("Escolha o tipo de obra:");
		System.out.println("1 - Livro");
		System.out.println("2 - Periódico");
		System.out.println();
		do {
			tp_obra = getIntFromKeyboard();
		} while (tp_obra < 1 || tp_obra > 2);

		System.out.println("Insira o nome da obra:");
		System.out.println();
		nome_obra = getStringFromKeyboard();

		ctrlCadastrarExemplar.cadastrarExemplar(tp_obra, nome_obra, listaObra,
				listaExemplar);
	}

	private static void cadastrarUsuario() {
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
			vl_tpUsuario = getIntFromKeyboard();
			tp_usuario = TipoUsuario.fromInteger(vl_tpUsuario);
		} while (vl_tpUsuario < 1 || vl_tpUsuario > 3);

		System.out.println("Insira o nome do usuário:");
		System.out.println();
		nome_usuario = getStringFromKeyboard();

		System.out.println("Insira o CPF do usuário:");
		System.out.println();
		cpf = getStringFromKeyboard();

		System.out.println("Insira o telefone do usuário:");
		System.out.println();
		telefone = getIntFromKeyboard();

		ctrlCadastrarUsuario.cadastrarUsuario(tp_usuario, nome_usuario, cpf,
				telefone, listaUsuario);
	}

	private static void emprestarExemplar() {
		Integer id_exemplar = null;
		String cpf = null;

		System.out.println("- Emprestar Exemplar -");
		System.out.println();

		System.out.println("Insira o identificador do exemplar:");
		System.out.println();
		id_exemplar = getIntFromKeyboard();

		System.out.println("Insira o CPF do usuário:");
		System.out.println();
		cpf = getStringFromKeyboard();

		ctrlEmprestarExemplar.emprestarExemplar(id_exemplar, cpf,
				listaEmprestimo, listaUsuario, listaExemplar);
	}

	private static void devolverExemplar() {
		Integer id_exemplar = null;

		System.out.println("- Devolver Exemplar -");
		System.out.println();

		System.out.println("Insira o identificador do exemplar:");
		System.out.println();
		id_exemplar = getIntFromKeyboard();

		ctrlDevolverExemplar.devolverExemplar(id_exemplar, listaEmprestimo);
	}

	private static void pesquisarObra() {
		Integer tp_obra = null;
		String nome_obra = null;

		System.out.println("- Pesquisar Obra -");
		System.out.println();

		System.out.println("Escolha o tipo de obra:");
		System.out.println("1 - Livro");
		System.out.println("2 - Periódico");
		System.out.println();
		do {
			tp_obra = getIntFromKeyboard();
		} while (tp_obra < 1 || tp_obra > 2);

		System.out.println("Insira o nome da obra:");
		System.out.println();
		nome_obra = getStringFromKeyboard();

		try {
			ctrlPesquisarObra.pesquisarObra(tp_obra, nome_obra, listaObra,
					listaEmprestimo, listaExemplar);
		} catch (Exception e) {

		}
	}

	private static void pagarMulta() {
		System.out.println("- Pagar Multa -");
		System.out.println();

		String cpf = null;

		System.out.println("Insira o CPF do usuário:");
		System.out.println();
		cpf = getStringFromKeyboard();

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

	private static int getIntFromKeyboard() {
		int retorno = 0;
		boolean inteiro = false;
		do {
			try {
				retorno = Integer.parseInt(getStringFromKeyboard());
				inteiro = true;
			} catch (Exception e) {
				System.out.println("Opção Inválida!");
			}
		} while (!inteiro);

		return retorno;
	}

	private static String getStringFromKeyboard() {
		String retorno = "";
		retorno = keyboard.nextLine();
		return retorno;
	}

}
