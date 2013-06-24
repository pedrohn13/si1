package sistema;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Agenda {

	Set<Contato> contatos;

	public Agenda() {
		this.contatos = new TreeSet<Contato>();
	}

	public int getQtdContatos() {
		return contatos.size();
	}

	public void inserirContato(String nome, String idade, String descricao,
			List<Telefone> telefones, List<String> emails) {
		contatos.add(new Contato(nome, idade, descricao, telefones, emails));
	}

	public Set<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}
}
