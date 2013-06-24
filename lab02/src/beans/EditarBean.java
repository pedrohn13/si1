package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.JaExisteException;
import sistema.Telefone;

@ManagedBean
@SessionScoped
public class EditarBean {

	private static String nome = AgendaBean.contatoSelecionado.getNome();
	private static String idade = AgendaBean.contatoSelecionado.getIdade();
	private static String descricao = AgendaBean.contatoSelecionado
			.getDescricao();
	private static List<Telefone> telefones = AgendaBean.contatoSelecionado
			.getTelefones();
	private static List<String> emails = AgendaBean.contatoSelecionado
			.getEmails();

	private static String numero;
	private static String regiao;
	private static String operadora;
	private static String email;

	private static Telefone telefoneSelecionado;
	private static String emailSelecionado;

	public String finalizaEdicao() {
		AgendaBean.contatoSelecionado.setNome(nome);
		AgendaBean.contatoSelecionado.setIdade(idade);
		AgendaBean.contatoSelecionado.setDescricao(descricao);
		AgendaBean.contatoSelecionado.setTelefones(telefones);
		AgendaBean.contatoSelecionado.setEmails(emails);
		return "index";
	}

	public String cancelar() {
		return "index";
	}

	public void addTelefone() {
		Telefone novo = new Telefone(numero, regiao, operadora);
		try {
			if (numero == "") {
				throw new Exception("Falta o número");
			}
			for (Telefone telefone : telefones) {
				if (novo.equals(telefone)) {
					throw new JaExisteException("Este telefone já existe");
				}
			}
			telefones.add(novo);
		} catch (Exception e) {
		}
		numero = "";
		regiao = "";
		operadora = "";
	}

	public void removeTelefone() {
		telefones.remove(telefoneSelecionado);
	}

	public void addEMail() {
		try {
			if (email == "") {
				throw new Exception("Falta o E-Mail");
			}
			for (String email2 : emails) {
				if (email.equals(email2)) {
					throw new JaExisteException("Este E-Mail já existe");
				}
			}
			emails.add(email);
		} catch (Exception e) {
		}
		this.email = "";
	}

	public void removeEMail() {
		emails.remove(emailSelecionado);
	}

	public static void reset() {
		nome = AgendaBean.contatoSelecionado.getNome();
		idade = AgendaBean.contatoSelecionado.getIdade();
		descricao = AgendaBean.contatoSelecionado.getDescricao();
		telefones = AgendaBean.contatoSelecionado.getTelefones();
		emails = AgendaBean.contatoSelecionado.getEmails();
		numero = "";
		regiao = "";
		operadora = "";
		email = "";
		telefoneSelecionado = null;
		emailSelecionado = "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefone getTelefoneSelecionado() {
		return telefoneSelecionado;
	}

	public void setTelefoneSelecionado(Telefone telefoneSelecionado) {
		this.telefoneSelecionado = telefoneSelecionado;
	}

	public String getEmailSelecionado() {
		return emailSelecionado;
	}

	public void setEmailSelecionado(String emailSelecionado) {
		this.emailSelecionado = emailSelecionado;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

}