package ufcg.si1;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Objects;

public class Contato {

	private String nome;
	private Set<Telefone> numeros;

	public Contato(String nome, int numero) {
		this.numeros = new HashSet<Telefone>();
		this.nome = nome;
		numeros.add(new Telefone(numero));
	}

	public Contato(String nome, int numero, int regiao) {
		this.numeros = new HashSet<Telefone>();
		this.nome = nome;
		numeros.add(new Telefone(numero, regiao));
	}

	public Contato(String nome, int numero, String operadora) {
		this.numeros = new HashSet<Telefone>();
		this.nome = nome;
		numeros.add(new Telefone(numero, operadora));
	}

	public Contato(String nome, int numero, int regiao, String operadora) {
		this.numeros = new HashSet<Telefone>();
		this.nome = nome;
		numeros.add(new Telefone(numero, regiao, operadora));
	}

	// GETs E SETs
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Telefone> getNumeros() {
		return numeros;
	}

	public void setNumeros(Set<Telefone> numeros) {
		this.numeros = numeros;
	}

	// toString, HashCode e Equals
	@Override
	public int hashCode() {
		return Objects.hashCode(this.nome, this.numeros.toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || !(obj instanceof Contato)) {
			return false;
		}
		Contato contato = (Contato) obj;
		return Objects.equal(this.nome, contato.getNome())
				&& Objects.equal(this.numeros.toString(), contato.getNumeros()
						.toString());
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(this.nome)
				.addValue(this.numeros).toString();
	}
}