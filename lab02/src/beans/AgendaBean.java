package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.Agenda;
import sistema.Contato;

@SessionScoped
@ManagedBean
public class AgendaBean {

	public static Agenda agenda = new Agenda();
	public static Contato contatoSelecionado;
	private List<Contato> contatos;
	private String busca;

	public String criarContato() {
		return "cadastro";
	}

	public List<Contato> getContatos() {
		contatos = new ArrayList<Contato>(agenda.getContatos());
		return contatos;
	}

	public Contato getContatoSelecionado() {
		return contatoSelecionado;
	}

	public void setContatoSelecionado(Contato contatoSelecionado) {
		this.contatoSelecionado = contatoSelecionado;
	}

	public static Agenda getAgenda() {
		return agenda;
	}

	public String voltar() {
		return "index";
	}

	public String editar() {
		EditarBean.reset();
		return "editar";
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	} 
	
	
}
