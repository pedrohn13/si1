package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.Contato;
import sistema.JaExisteException;
import sistema.Telefone;

@ManagedBean
@SessionScoped
public class CadastroBean {

	private Contato contato;
	private String nome;
	private String idade;
	private String descricao;
	private List<Telefone> telefones = new ArrayList<Telefone>();
	private List<String> emails = new ArrayList<String>();

	private String numero;
	private String regiao;
	private String operadora;
	private String email;

	private Telefone telefoneSelecionado;
	private String emailSelecionado;

	public String finalizaCadastro() {
		try {
			Integer temp = new Integer(idade);
			if (temp.intValue() <= 0) {
				throw new Exception("Valor inválido");
			}
		} catch (Exception e) {
		}
		contato = new Contato(nome.trim(), idade, descricao.trim(), telefones,
				emails);
		AgendaBean.getAgenda().getContatos().add(contato);
		reset();
		return "index";
	}

	public void addTelefone() {
		Telefone novo = new Telefone(numero, regiao, operadora);;
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

	public void removeTelefone() {
		telefones.remove(telefoneSelecionado);
	}

	public void removeEMail() {
		emails.remove(emailSelecionado);
	}

	public void reset() {
		nome = "";
		idade = "";
		descricao = "";
		emails = new ArrayList<String>();
		telefones = new ArrayList<Telefone>();
		numero = "";
		regiao = "";
		operadora = "";
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

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}