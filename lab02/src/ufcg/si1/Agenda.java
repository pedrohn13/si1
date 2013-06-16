package ufcg.si1;

import java.util.HashSet;
import java.util.Set;

public class Agenda {

	Set<Contato> contatos;

	public Agenda() {
		this.contatos = new HashSet<Contato>();
	}

	public void inserirContato(String nome, int numero) {
		contatos.add(new Contato(nome, numero));
	}

	public void inserirContato(String nome, int numero, int regiao) {
		contatos.add(new Contato(nome, numero, regiao));
	}

	public void inserirContato(String nome, int numero, String operadora) {
		contatos.add(new Contato(nome, numero, operadora));
	}

	public void inserirContato(String nome, int numero, int regiao, String operadora) {
		contatos.add(new Contato(nome, numero, regiao, operadora));
	}

	public Object getQtdContatos() {
		return contatos.size();
	}
}