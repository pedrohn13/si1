package sistema;

import java.util.ArrayList;
import java.util.List;

public class Controlador {

	Agenda agenda;
	List<Tarefa> tarefas;

	public Controlador() {
		agenda = new Agenda();
		tarefas = new ArrayList<Tarefa>();
	}

	public void criarTarefa(String nome, String descricao, int ano, int mes,
			int dia, int hora, int minuto) {
		agenda.criarTarefa(nome, descricao, ano, mes, dia, hora, minuto);
	}

	public void completarTarefa(Tarefa tarefa) {
		agenda.completarTarefa(tarefa);
	}

	public void editarTarefa(Tarefa tarefa, String nome, String descricao) {
		agenda.editarTarefa(tarefa, nome, descricao);
	}

	public void ordenarDataCriacao() {
		this.tarefas = agenda.ordenarDataCriacao();
	}

	public void ordenarDataPrazo() {
		this.tarefas = agenda.ordenarDataPrazo();
	}

	public void filtroNenhum() {
		this.tarefas = agenda.getTarefas();
	}

	public void filtroCompletas() {
		this.tarefas = agenda.getTarefasCompletas();
	}

	public void filtroIncompletas() {
		this.tarefas = agenda.getTarefasIncompletas();
	}

}
