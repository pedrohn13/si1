package sistema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Controlador {

	Agenda agenda;
	List<Tarefa> tarefas;

	public Controlador() {
		agenda = new Agenda();
		tarefas = new ArrayList<Tarefa>();
	}

	public void criarTarefa(String nome, String descricao, Date dataPrazo) {
		agenda.criarTarefa(nome, descricao, dataPrazo);
	}

	public void completarTarefa(Tarefa tarefa) {
		agenda.completarTarefa(tarefa);
	}

	public void editarTarefa(Tarefa tarefa, String nome, String descricao,  Date dataPrazo) {
		agenda.editarTarefa(tarefa, nome, descricao,  dataPrazo);
	}
	
	public void removerTarefa(Tarefa tarefa) {
		agenda.removerTarefa(tarefa);
	}

	public void ordenarDataCriacao() {
		Collections.sort(this.tarefas, new TarefaComparator("dataCriacao"));
	}

	public void ordenarDataPrazo() {
		Collections.sort(this.tarefas, new TarefaComparator("dataPrazo"));
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

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

}
