package sistema;

public class Telefone {

	private int numero;
	private int regiao;
	private String operadora;

	public Telefone(int telefone, int regiao, String operadora) {
		this.numero = telefone;
		this.regiao = regiao;
		this.operadora = operadora;
	}

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
}
