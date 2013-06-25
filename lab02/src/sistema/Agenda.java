package sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Agenda {

	Set<Contato> contatos;

	public Agenda() {
		this.contatos = new TreeSet<Contato>();
	}

	public int getQtdContatos() {
		return contatos.size();
	}

	public void inserirContato(String nome, String idade, String descricao,
			List<Telefone> telefones, List<String> emails) {
		contatos.add(new Contato(nome, idade, descricao, telefones, emails));
	}

	public Set<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<Contato> buscar(String string, String modo) {
		if (modo.equals("nome")) {
			return buscaNome(string);
		} else if (modo.equals("numero")) {
			return buscaNumero(string);
		} else if (modo.equals("idadeMaior")) {
			return buscaIdadeMaior(string);
		} else if (modo.equals("idadeMenor")) {
			return buscaIdadeMenor(string);
		} else if (modo.equals("idadeIgual")) {
			return buscaIdadeIgual(string);
		}
		return new ArrayList<Contato>();
	}

	private List<Contato> buscaIdadeIgual(String string) {
		try {
			Integer idade = new Integer(string);
			if (idade < 0) {
				throw new Exception("Valor Inválido");
			}

			List<Contato> result = new ArrayList<Contato>();
			for (Contato contato : contatos) {
				Integer idadeContato = new Integer(contato.getIdade());
				if (idadeContato.intValue() == idade.intValue()) {
					result.add(contato);
				}
			}
			return result;

		} catch (Exception e) {
			return new ArrayList<Contato>();
		}
	}

	private List<Contato> buscaIdadeMenor(String string) {
		try {
			Integer idade = new Integer(string);
			if (idade < 0) {
				throw new Exception("Valor Inválido");
			}

			List<Contato> result = new ArrayList<Contato>();
			for (Contato contato : contatos) {
				Integer idadeContato = new Integer(contato.getIdade());
				if (idadeContato.intValue() <= idade.intValue()) {
					result.add(contato);
				}
			}
			return result;

		} catch (Exception e) {
			return new ArrayList<Contato>();
		}
	}

	private List<Contato> buscaIdadeMaior(String string) {
		try {
			Integer idade = new Integer(string);
			if (idade < 0) {
				throw new Exception("Valor Inválido");
			}

			List<Contato> result = new ArrayList<Contato>();
			for (Contato contato : contatos) {
				Integer idadeContato = new Integer(contato.getIdade());
				if (idadeContato.intValue() >= idade.intValue()) {
					result.add(contato);
				}
			}
			return result;

		} catch (Exception e) {
			return new ArrayList<Contato>();
		}
	}

	private List<Contato> buscaNumero(String string) {
		List<Contato> result = new ArrayList<Contato>();
		for (Contato contato : contatos) {
			for (Telefone telefone : contato.getTelefones()) {
				if (telefone.getNumero().startsWith(string)) {
					result.add(contato);
					break;
				}
			}
		}
		return result;
	}

	private List<Contato> buscaNome(String string) {
		List<Contato> result = new ArrayList<Contato>();
		for (Contato contato : contatos) {
			if (contato.getNome().toLowerCase()
					.startsWith(string.toLowerCase())) {
				result.add(contato);
			}
		}
		return result;
	}
}
