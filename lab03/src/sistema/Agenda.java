package sistema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Agenda {

	Set<Tarefa> tarefas = new HashSet<Tarefa>();

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

	public List<Tarefa> ordenarDataCriacao() {
		List<Tarefa> retorno = new ArrayList<Tarefa>(tarefas);
		Collections.sort(retorno, new TarefaComparator("dataCriacao"));

		return retorno;
	}

	public List<Tarefa> ordenarDataPrazo() {
		List<Tarefa> retorno = new ArrayList<Tarefa>(tarefas);
		Collections.sort(retorno, new TarefaComparator("dataPrazo"));

		return retorno;
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
