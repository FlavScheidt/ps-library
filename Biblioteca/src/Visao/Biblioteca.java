package Visao;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
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

		// Inicio
		int option = 0;

		while (option != 8) {
			// Faz a leitura da tecla, descartando o que não for números

			imprimeMenu();
			option = getIntFromKeyboard(keyboard);
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
				System.out.println("- Devolver Exemplar -");

				break;
			case 6:
				System.out.println("- Pesquisar Obra -");

				break;
			case 7:
				System.out.println("- Pagar Multa -");

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

	private static void emprestarExemplar(Scanner keyboard,
			CtrlEmprestarExemplar ctrlEmprestarExemplar,
			List<Exemplar> listaExemplar, List<Usuario> listaUsuario,
			List<Emprestimo> listaEmprestimo) {
		System.out.println("- Emprestar Exemplar -");
		System.out.println();

		Integer id_exemplar = null;
		String cpf = null;

		System.out.println("Insira o identificador do exemplar:");
		System.out.println();
		id_exemplar = getIntFromKeyboard(keyboard);

		System.out.println("Insira o CPF do usuário:");
		System.out.println();
		cpf = getStringFromKeyboard(keyboard);

		try {
			ctrlEmprestarExemplar.emprestarExemplar(id_exemplar, cpf,
					listaEmprestimo, listaUsuario, listaExemplar);
			System.out.println("Emprestimo realizado com sucesso.");
		} catch (Exception e) {

		}
	}

	private static void cadastrarUsuario(Scanner keyboard,
			CtrlCadastrarUsuario ctrlCadastrarUsuario,
			List<Usuario> listaUsuario) {
		System.out.println("- Cadastrar Usuário -");
		System.out.println();

		TipoUsuario tp_usuario = null;
		Integer telefone = null;
		String nome_usuario = null;
		String cpf = null;

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
		try {
			ctrlCadastrarUsuario.cadastrarUsuario(tp_usuario, nome_usuario,
					cpf, telefone, listaUsuario);
			System.out.println("Usuário cadastrada com sucesso.");
		} catch (Exception e) {

		}
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

		try {
			ctrlCadastrarExemplar.cadastrarExemplar(tp_obra, nome_obra,
					listaObra, listaExemplar);
			System.out.println("Exemplar cadastrada com sucesso com o id:"
					+ (listaExemplar.size() - 1) + ".");
		} catch (Exception e) {

			System.out.println("ERROR");
		}
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
		try {
			ctrlCadastrarObra.cadastrarObra(tp_obra, nome_obra, ano,
					nome_autor, editora, volume, mes, listaObra);
			System.out.println("Obra cadastrada com sucesso.");
		} catch (Exception e) {
			System.out.println("Problema ao cadastrar a obra.");
		}
	}

	private static void imprimeMenu() {
		System.out.println("----------------------------");
		System.out.println("-        Biblioteca        -");
		System.out.println("----------------------------");
		System.out.println();
		System.out.println("- Menu -");
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
}
