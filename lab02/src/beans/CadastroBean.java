package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.Contato;
import sistema.Telefone;

@ManagedBean
@SessionScoped
public class CadastroBean {

	Contato contato;
	private String nome;
	private int idade;
	private String descricao;
	private List<String> emails = new ArrayList<String>();
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	private int numero;
	private int regiao;
	private String operadora;
	private String email;
	
	private Telefone telefoneSelecionado;
	private String emailSelecionado;

	public String finalizaCadastro() {
		contato = new Contato(nome.trim(), idade, descricao.trim(), telefones,
				emails);
		AgendaBean.getAgenda().getContatos().add(contato);
		reset();
		return "index";
	}

	public void addTelefone() {
		telefones.add(new Telefone(numero,regiao,operadora));
		numero = 0;
		regiao = 0;
		operadora = "";
	}
	
	public void addEMail() {
		emails.add(email);
		this.email = "";
	}

	public void removeTelefone() {

	}

	public void reset() {
		nome = "";
		idade = 0;
		descricao = "";
		emails = new ArrayList<String>();
		telefones = new ArrayList<Telefone>();
		numero = 0;
		regiao = 0;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
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
