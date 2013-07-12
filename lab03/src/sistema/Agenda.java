package sistema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Agenda {

	Set<Tarefa> tarefas = new TreeSet<Tarefa>();

	public void criarTarefa(String nome, String descricao, Date dataPrazo) {
		if (dataPrazo == null) {
			tarefas.add(new Tarefa(nome, descricao, dataPrazo));
		} else if (new Date().before(dataPrazo)) {
			tarefas.add(new Tarefa(nome, descricao, dataPrazo));
		}
	}

	public void completarTarefa(Tarefa tarefa) {
		try {
			Tarefa estaTarefa = buscarTarefa(tarefa);
			estaTarefa.setCompletada(true);
		} catch (NullPointerException e) {
			System.out.println("TAREFA NÃO EXISTE");
		}
	}

	public void editarTarefa(Tarefa tarefa, String nome, String descricao,
			Date dataPrazo) {
		try {
			Tarefa estaTarefa = buscarTarefa(tarefa);
			estaTarefa.setNome(nome);
			estaTarefa.setDescricao(descricao);
			if (dataPrazo == null) {
				estaTarefa.setDataPrazo(dataPrazo);
			} else if (estaTarefa.getDataCriacao().before(dataPrazo)) {
				estaTarefa.setDataPrazo(dataPrazo);
			}
		} catch (NullPointerException e) {
			System.out.println("TAREFA NÃO EXISTE");
		}
	}

	public void removerTarefa(Tarefa tarefa) {
		try {
			Tarefa estaTarefa = buscarTarefa(tarefa);
			tarefas.remove(estaTarefa);
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

	public List<Tarefa> getTarefasIncompletas() {
		List<Tarefa> retorno = new ArrayList<Tarefa>();
		for (Tarefa tarefa : tarefas) {
			if (!tarefa.isCompletada()) {
				retorno.add(tarefa);
			}
		}
		return retorno;
	}

	public List<Tarefa> getTarefasCompletas() {
		List<Tarefa> retorno = new ArrayList<Tarefa>();
		for (Tarefa tarefa : tarefas) {
			if (tarefa.isCompletada()) {
				retorno.add(tarefa);
			}
		}
		return retorno;
	}

	public List<Tarefa> getTarefas() {
		return new ArrayList<Tarefa>(tarefas);
	}

	public void setTarefas(Set<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

}
