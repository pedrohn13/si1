package sistema;

import java.util.Set;
import java.util.TreeSet;

public class Agenda {

	Set<Contato> contatos;
	
	public Agenda() {
		this.contatos = new TreeSet<Contato>();
		contatos.add(new Contato("Pedro", 33712535));
	}

	public int getQtdContatos() {
		return contatos.size();
	}

	public void inserirContato(String nome, int telefone) {
		contatos.add(new Contato(nome, telefone));
	}

	public Set<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}
}
