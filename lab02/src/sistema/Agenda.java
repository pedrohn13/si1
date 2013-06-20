package sistema;

import java.util.Set;
import java.util.TreeSet;

public class Agenda {

	Set<Contato> contatos;
	
	public Agenda() {
		this.contatos = new TreeSet<Contato>();
		contatos.add(new Contato("Pedro Henriques Neto", 33712535));
		contatos.add(new Contato("Pedro Henriques", 36894477));
		contatos.add(new Contato("Pedro Neto", 11111111));
		contatos.add(new Contato("Henriques Neto", 3342535));
		contatos.add(new Contato("Henriques", 3294477));
		contatos.add(new Contato("Neto", 1111155111));
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
