package ufcg.si1;

import com.google.common.base.Objects;

public class Telefone {

	int numero;
	int regiao;
	Operadora operadora;

	public Telefone(int numero) {
		this.numero = numero;
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

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	// toString, HashCode e Equals

	@Override
	public int hashCode() {
		return Objects.hashCode(this.numero, this.regiao, this.operadora);
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
				&& Objects.equal(this.regiao, telefone.getRegiao())
				&& Objects.equal(this.operadora, telefone.getOperadora());
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(this.numero)
				.addValue(this.regiao).addValue(this.operadora).toString();
	}
}