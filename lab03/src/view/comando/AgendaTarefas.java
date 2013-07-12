package view.comando;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import sistema.Controlador;
import sistema.Tarefa;

public class AgendaTarefas {

	public static void main(String[] args) {

		Controlador controlador = new Controlador();

		System.out.println("Agenda Gerenciadora de Tarefas");
		System.out.println("Bem-Vindo(a)");
		run(controlador);
		System.out.println("Obrigado por usar nossa Agenda");
	}

	private static void run(Controlador control) {
		boolean rodando = true;
		String tipos = "todas";
		String ordem = "criacao";
		while (rodando) {
			exibeTarefas(control, tipos, ordem);
			exibeMensagens(control, tipos, ordem);

			Scanner scn = new Scanner(System.in);
			String opcao = scn.next();

			if (opcao.equals("1")) {
				cadastrarTarefa(scn, control);
			} else if (opcao.equals("2")) {
				if (tipos.equals("todas")) {
					tipos = "incompletas";
				} else {
					tipos = "todas";
				}
			} else if (opcao.equals("3")) {
				if (tipos.equals("completas")) {
					tipos = "incompletas";
				} else {
					tipos = "completas";
				}
			} else if (opcao.equals("4")) {
				if (ordem.equals("criacao")) {
					ordem = "prazo";
				} else {
					ordem = "criacao";
				}
			} else if (opcao.equals("5") && !control.getTarefas().isEmpty()) {
				Tarefa tarefa = achaTarefa(control, scn);
				control.completarTarefa(tarefa);
			} else if (opcao.equals("6") && !control.getTarefas().isEmpty()) {
				Tarefa tarefa = achaTarefa(control, scn);
				alteraTarefa(control, scn, tarefa);

			} else if (opcao.equals("0")) {
				rodando = false;
			}
		}
	}

	private static void alteraTarefa(Controlador control, Scanner scn,
			Tarefa tarefa) {
		System.out.println("O que deseja fazer?");
		System.out.println("1 - Alterar Nome");
		System.out.println("2 - Alterar Descricao");
		System.out.println("3 - Alterar Data Prazo");
		System.out.println("4 - Remover");
		System.out.println("Qualquer caractere - Cancelar Alteracao");

		String opcAlterar = scn.next();

		if (opcAlterar.equals("1")) {
			System.out.println("Novo nome: ");
			String novoNome = scn.nextLine();
			novoNome = scn.nextLine();
			while (novoNome.equals("")) {
				System.out.println("O nome nao pode ser vazio");
				System.out.println("Novo Nome: ");
				novoNome = scn.nextLine();
			}
			control.editarTarefa(tarefa, novoNome, tarefa.getDescricao(),
					tarefa.getDataPrazo());
		} else if (opcAlterar.equals("2")) {
			System.out.println("Nova Descricao: ");
			String novaDesc = scn.nextLine();
			novaDesc = scn.nextLine();
			control.editarTarefa(tarefa, tarefa.getNome(), novaDesc,
					tarefa.getDataPrazo());
		} else if (opcAlterar.equals("3")) {
			Date novaData = null;
			String data = scn.nextLine();
			while (true) {
				System.out.println("Nova Data Prazo (dd/mm/yyyy HH:mm):");
				data = scn.nextLine();
				try {
					if (!data.equals("")) {
						novaData = new SimpleDateFormat("dd/MM/yyyy HH:mm")
								.parse(data);
						if (novaData.before(tarefa.getDataCriacao())) {
							throw new Exception();
						}
					}
					break;
				} catch (Exception e) {
					System.out
							.println("Formato Invalido ou Data Inferior da Data de Criacao");
				}
			}
			control.editarTarefa(tarefa, tarefa.getNome(),
					tarefa.getDescricao(), novaData);
		} else if (opcAlterar.equals("4")) {
			control.removerTarefa(tarefa);
		}
	}

	private static void exibeMensagens(Controlador control, String tipos,
			String ordem) {
		System.out.println("Digite uma opcao: ");
		System.out.println("1 - Cadastrar Nova Tarefa");

		if (tipos.equals("todas")) {
			System.out.println("2 - Exibir tarefas incompletas");
			System.out.println("3 - Exibir tarefas completas");
		} else if (tipos.equals("incompletas")) {
			System.out.println("2 - Exibir todas tarefas");
			System.out.println("3 - Exibir tarefas completas");
		} else if (tipos.equals("completas")) {
			System.out.println("2 - Exibir todas tarefas");
			System.out.println("3 - Exibir tarefas incompletas");
		}

		if (ordem.equals("criacao")) {
			System.out.println("4 - Ordenar por Data Prazo");
		} else if (ordem.equals("prazo")) {
			System.out.println("4 - Ordenar por Data de Criação");
		}

		if (!control.getTarefas().isEmpty()) {
			if (!tipos.equals("completas")) {
				System.out.println("5 - Completar Tarefa");
			}

			System.out.println("6 - Alterar Tarefa");
		}

		System.out.println("0 - Sair da Agenda");
	}

	private static Tarefa achaTarefa(Controlador control, Scanner scn) {
		System.out.println("Digite o Numero da Lista referente a Tarefa");
		int numTarefa = scn.nextInt();
		while (numTarefa <= 0 || numTarefa > control.getTarefas().size()) {
			System.out.println("Esse Numero nao se refere a nenhuma Tarefa");
			numTarefa = scn.nextInt();
		}
		return control.getTarefas().get(numTarefa - 1);
	}

	private static void exibeTarefas(Controlador control, String tipos,
			String ordem) {
		System.out.println("[[Lista de Tarefas]]");
		atualizaLista(control, tipos, ordem);
		if (control.getTarefas().isEmpty()) {
			System.out.println("Nenhuma tarefa \n");
		} else {
			int ind = 1;
			for (Tarefa tarefa : control.getTarefas()) {
				System.out.println(ind + "- " + tarefa.toString());
				ind++;
			}
		}
	}

	private static void atualizaLista(Controlador control, String tipos,
			String ordem) {
		if (tipos.equals("completas")) {
			control.filtroCompletas();
		} else if (tipos.equals("incompletas")) {
			control.filtroIncompletas();
		} else {
			control.filtroNenhum();
		}
		ordenar(control, ordem);
	}

	private static void ordenar(Controlador control, String ordem) {
		control.ordenarDataCriacao();
	}

	private static void cadastrarTarefa(Scanner scn, Controlador control) {
		String nome;
		String descricao;
		String data;
		Date dataPrazo = null;

		System.out.println("Preencha os Campos (Apenas o nome eh obrigatorio)");
		System.out.println("Nome: ");
		nome = scn.nextLine();
		nome = scn.nextLine();
		while (nome.equals("")) {
			System.out.println("O nome nao pode ser vazio");
			System.out.println("Nome: ");
			nome = scn.nextLine();
		}
		System.out.println("Descricao: ");
		descricao = scn.nextLine();

		while (true) {
			System.out.println("Data Prazo (dd/mm/yyyy HH:mm):");
			data = scn.nextLine();
			try {
				if (!data.equals("")) {
					dataPrazo = new SimpleDateFormat("dd/MM/yyyy HH:mm")
							.parse(data);
					if (dataPrazo.before(new Date())) {
						throw new Exception();
					}
				}
				break;
			} catch (Exception e) {
				System.out.println("Formato Invalido ou Data Inferior a Atual");
			}
		}

		control.criarTarefa(nome, descricao, dataPrazo);
	}
}
