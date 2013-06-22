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
	private List<Contato> contatos;
	private Contato contatoSelecionado;

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
}
