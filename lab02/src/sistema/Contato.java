package sistema;

import java.util.ArrayList;
import java.util.List;

public class Contato implements Comparable<Contato> {

	private String nome;
	private String idade;
	private String descricao;
	private List<Telefone> telefones;
	private List<String> emails;

	public Contato(String nome, String idade, String descricao,
			List<Telefone> telefones, List<String> emails) {
		this.nome = nome;
		this.idade = idade;
		this.descricao = descricao;
		this.telefones = telefones;
		this.emails = emails;
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

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descriscao) {
		this.descricao = descriscao;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public Contato clone() {
		List<Telefone> novoTele = new ArrayList<Telefone>(telefones);
		List<String> novoEmails = new ArrayList<String>(emails);
		return new Contato(nome, idade, descricao, novoTele, novoEmails);
	}

	@Override
	public int compareTo(Contato outroContato) {
		return this.nome.compareTo(outroContato.getNome());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}