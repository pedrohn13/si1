package ufcg.si1;

import java.util.HashSet;
import java.util.Set;

public class Agenda {
	
	Set<Contato> contatos;
	
	public Agenda() {
		this.contatos = new HashSet<Contato>();
	}

	public void inserirContato(String nome, int numero) {
		Contato c = new Contato(nome,numero);
		contatos.add(c);
	}

	public Object getQtdContatos() {
		return contatos.size();
	}

}
