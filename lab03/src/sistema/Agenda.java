package sistema;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Agenda {

	Set<Tarefa> tarefas = new TreeSet<Tarefa>();

	@SuppressWarnings("deprecation")
	public void criarTarefa(String nome, String descricao, int ano, int mes,
			int dia, int hora, int minuto) {
		Date dataPrazo = new Date(ano, mes, dia, hora, minuto);
		tarefas.add(new Tarefa(nome, descricao, dataPrazo));

	}

	public void completarTarefa(Tarefa tarefa) {
		try {
			Tarefa estaTarefa = buscarTarefa(tarefa);
			estaTarefa.setCompletada(true);
		} catch (NullPointerException e) {
			System.out.println("TAREFA NÃO EXISTE");
		}
	}

	public void editarTarefa(Tarefa tarefa, String nome, String descricao) {
		try {
			Tarefa estaTarefa = buscarTarefa(tarefa);
			estaTarefa.setNome(nome);
			estaTarefa.setDescricao(descricao);
		} catch (NullPointerException e) {
			System.out.println("TAREFA NÃO EXISTE");
		}
	}

	private Tarefa buscarTarefa(Tarefa tarefa) {
		for (Tarefa estaTarefa : tarefas) {
			if (estaTarefa.equals(tarefa)) {
				return estaTarefa;
			}
		}
		return null;
	}

	public Set<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(Set<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

}
