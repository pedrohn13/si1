package sistema;

import java.util.Date;

public class Tarefa implements Comparable<Tarefa> {

	String nome;
	String descricao;
	Date dataCriacao;
	Date dataPrazo;
	boolean completada;

	public Tarefa(String nome, String descricao, Date dataPrazo) {
		this.nome = nome;
		this.descricao = descricao;
		this.completada = false;
		this.dataPrazo = dataPrazo;
		this.dataCriacao = new Date();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataPrazo() {
		return dataPrazo;
	}

	public void setDataPrazo(Date dataPrazo) {
		this.dataPrazo = dataPrazo;
	}

	@Override
	public int compareTo(Tarefa outraTarefa) {
		return this.nome.compareTo(outraTarefa.getNome());
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
		Tarefa other = (Tarefa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (dataPrazo == null) {
			return "Tarefa: " + nome + " - Descricao: " + descricao
					+ "\nData de Criacao: " + dataCriacao + "\n";
		}
		return "Tarefa: " + nome + " - Descri��o: " + descricao
				+ "\nData de Cria��o: " + dataCriacao + "\nData Prazo: "
				+ dataPrazo + "\n";
	}
}