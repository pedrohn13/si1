package sistema;

import java.util.ArrayList;
import java.util.List;

public class Contato implements Comparable<Contato> {

	private String nome;
	private int idade;
	private String descricao;
	private List<Telefone> telefones;
	private List<String> emails;

	public Contato(String nome, int telefone) {
		this.nome = nome;
		this.telefones = new ArrayList<Telefone>();
		this.emails = new ArrayList<String>();
		this.telefones.add(new Telefone(telefone));

		//cenário
		this.telefones.add(new Telefone(1321313));
		this.telefones.add(new Telefone(45645645));
		this.telefones.add(new Telefone(78978978));
		this.telefones.add(new Telefone(345789879));
		this.emails.add("pedrohn13@gmail.com");
		this.emails.add("pedropicui@gmail.com");
		this.idade = 27;
		this.descricao = "Estudante de Ciência da Computação na Universidade Federal de Campina Grande";
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
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