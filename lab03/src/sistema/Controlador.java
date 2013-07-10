package sistema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controlador {

	Agenda agenda;
	List<Tarefa> tarefas;

	public Controlador() {
		agenda = new Agenda();
		tarefas = new ArrayList<Tarefa>();
	}

	public void criarTarefa(String nome, String descricao, int... data) {
		Date dataPrazo = criaData(data);
		agenda.criarTarefa(nome, descricao, dataPrazo);
	}

	@SuppressWarnings("deprecation")
	private Date criaData(int[] data) {
		Date retorno = null;
		if (data.length == 1) {
			retorno = new Date(data[0], 0, 1);
		} else if (data.length == 2) {
			retorno = new Date(data[0], data[1], 1);
		} else if (data.length == 3) {
			retorno = new Date(data[0], data[1], data[2]);
		} else if (data.length == 4) {
			retorno = new Date(data[0], data[1], data[2], data[3], 0);
		} else if (data.length == 5) {
			retorno = new Date(data[0], data[1], data[2], data[3], data[4]);
		}
		return retorno;
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
