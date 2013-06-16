package ufcg.si1;

import com.google.common.base.Objects;

public class Telefone {

	int numero;
	int regiao;
	String operadora;

	public Telefone(int numero) {
		this.numero = numero;
	}

	public Telefone(int numero, int regiao) {
		this.numero = numero;
		this.regiao = regiao;
	}

	public Telefone(int numero, String operadora) {
		this.numero = numero;
		this.operadora = operadora;
	}

	public Telefone(int numero, int regiao, String operadora) {
		this.numero = numero;
		this.regiao = regiao;
		this.operadora = operadora;
	}

	// GETs e SETs
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getRegiao() {
		return regiao;
	}

	public void setRegiao(int regiao) {
		this.regiao = regiao;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	// toString, HashCode e Equals
	@Override
	public int hashCode() {
		return Objects.hashCode(this.numero, this.regiao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || !(obj instanceof Contato)) {
			return false;
		}
		Telefone telefone = (Telefone) obj;
		return Objects.equal(this.numero, telefone.getNumero())
				&& Objects.equal(this.regiao, telefone.getRegiao());
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(this.numero)
				.addValue(this.regiao).toString();
	}
}