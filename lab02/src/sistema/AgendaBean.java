package sistema;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class AgendaBean {
	
	Agenda agenda = new Agenda();
	List<Contato> contatos;
	Contato contatoSelecionado;	

	public String criarContato() {
		return "cadastro";
	}
	
	public String finalizaCadastro() {
		return "index";
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
}
