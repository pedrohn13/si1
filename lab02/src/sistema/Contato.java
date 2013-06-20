package sistema;

import java.util.List;

public class Contato {

	private String nome;
	private List<Telefone> telefones;

	public Contato(String nome, int telefone) {
		this.nome = nome;
		this.telefones.add(new Telefone(telefone));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
}