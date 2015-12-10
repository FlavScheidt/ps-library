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
import Modelo.Usuario;

public class Biblioteca {

	public static void main(String[] arguments) {

		// Instancia os controladores
		CtrlCadastrarObra ctrlCadastrarObra;
		CtrlCadastrarExemplar ctrlCadastrarExemplar;
		CtrlCadastrarUsuario ctrlCadastrarUsuario;
		CtrlEmprestarExemplar ctrlEmprestarExemplar;
		CtrlDevolverExemplar ctrlDevolverExemplar;
		CtrlPesquisarObra ctrlPesquisarObra;
		CtrlPagarMulta ctrlPagarMulta;

		// Cria as listas
		List<Obra> listaObra = new ArrayList<Obra>();
		List<Exemplar> listaExemplar = new ArrayList<Exemplar>();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		List<Emprestimo> listaEmprestimo = new ArrayList<Emprestimo>();

		// Inicio
		int option = 0;
		imprimeMenu();
		while (option != 8) {
			// Faz a leitura da tecla, descartando o que não for números

			option = getIntFromKeyboard();
			switch (option) {
			case 1:
				System.out.println("- Cadastrar Obra -");
				System.out.println();
				System.out.println("Escolha o tipo de obra:");
				System.out.println("1 - Livro");
				System.out.println("2 - Periódico");
				System.out.println();
				
				int tp_obra = getIntFromKeyboard();
				System.out.println(tp_obra);
				
				//ctrladastrarObra.cadastrarObra(tp_obra, nome, ano, autor,
				// editora, volume, mes, listaObra)
				break;
			case 2:
				System.out.println("- Cadastrar Exemplar -");

				break;
			case 3:
				System.out.println("- Cadastrar Usuário -");

				break;
			case 4:
				System.out.println("- Emprestar Exemplar -");

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

	private static int getIntFromKeyboard() {
		Scanner keyboard = new Scanner(System.in);
		int retorno;
		while (!keyboard.hasNextInt()) {
			keyboard.next();
			System.out.println("Opção Inválida!");
		}
		retorno = keyboard.nextInt();
		keyboard.close();
		return retorno;
	}
}
