package sistema;

import java.util.Set;

public class Agenda {

	private Set<Contato> contatos;

	public int getQtdContatos() {
		return contatos.size();
	}

	public void inserirContato(String nome, int telefone) {
		contatos.add(new Contato(nome, telefone));
	}

	public void inserirContato(String nome, int telefone, int regiao) {
		contatos.add(new Contato(nome, telefone));
		
	}

	public void inserirContato(String nome, int telefone, int regiao,
			String operadora) {
		contatos.add(new Contato(nome, telefone));		
	}
}