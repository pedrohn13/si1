package view.grafica;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import sistema.Controlador;
import sistema.Tarefa;

@ManagedBean
@SessionScoped
public class ControladorBean {

	Controlador controlador = new Controlador();

	String nome = "";
	String descricao = "";
	Date dataPrazo = null;

	String filtro = "todas";
	String ordem = "criacao";

	Tarefa tarefaSelecionada;
	
	public String criarTarefa() {
		return "criarTarefa";
	}

	public String novaTarefa() {
		if (nome.equals("")) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nome Inválido", "O nome da tarefa não pode ser vazio");
			context.addMessage("nome", msg);
		} else {
			controlador.criarTarefa(nome, descricao, dataPrazo);
			restart();
		}
		return "";
	}

	public String voltar() {
		restart();
		return "index";
	}

	private void restart() {
		nome = "";
		descricao = "";
		dataPrazo = null;
	}

	private void ordenar() {
		if (ordem.equals("criacao")) {
			controlador.ordenarDataCriacao();
		} else if (ordem.equals("prazo")) {
			controlador.ordenarDataPrazo();
		}
	}

	public void completarTarefa() {
		tarefaSelecionada.setCompletada(true);
		controlador.completarTarefa(tarefaSelecionada);
	}

	public void removerTarefa() {
		controlador.removerTarefa(tarefaSelecionada);
	}

	public String editarTarefa() {
		this.nome = tarefaSelecionada.getNome();
		this.descricao = tarefaSelecionada.getDescricao();
		this.dataPrazo = tarefaSelecionada.getDataPrazo();
		return "editarTarefa";
	}

	public String salvarEdicao() {
		if (nome.equals("")) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nome Inválido", "O nome da tarefa não pode ser vazio");
			context.addMessage("nome", msg);
		} else {
			controlador.editarTarefa(tarefaSelecionada, nome, descricao,
					dataPrazo);
			restart();
		}
		return "index";
	}

	public List<Tarefa> getTarefas() {
		if (filtro.equals("completas")) {
			controlador.filtroCompletas();
		} else if (filtro.equals("incompletas")) {
			controlador.filtroIncompletas();
		} else {
			controlador.filtroNenhum();
		}
		ordenar();
		return controlador.getTarefas();
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.controlador.setTarefas(tarefas);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataPrazo() {
		return dataPrazo;
	}

	public void setDataPrazo(Date dataPrazo) {
		this.dataPrazo = dataPrazo;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getOrdem() {
		return ordem;
	}

	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}

	public Tarefa getTarefaSelecionada() {
		return tarefaSelecionada;
	}

	public void setTarefaSelecionada(Tarefa tarefaSelecionada) {
		this.tarefaSelecionada = tarefaSelecionada;
	}
}
