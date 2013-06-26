package teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sistema.Agenda;
import sistema.Telefone;

public class AgendaTest {

	@Test
	public void testInserirContato() {
		Agenda agenda = new Agenda();
		Telefone telefone = new Telefone("99999999", "83", "Tim");
		List<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(telefone);

		// Inserções com dados obrigatorios//
		Assert.assertEquals(0, agenda.getQtdContatos());
		agenda.inserirContato("Pedro", "", "", telefones, null);
		Assert.assertEquals(1, agenda.getQtdContatos());
		agenda.inserirContato("Maria", "", "", telefones, null);
		Assert.assertEquals(2, agenda.getQtdContatos());
		agenda.inserirContato("Jose", "", "", telefones, null);
		Assert.assertEquals(3, agenda.getQtdContatos());
		agenda.inserirContato("Pedro", "", "", telefones, null);
		Assert.assertEquals(3, agenda.getQtdContatos());
	}

	@Test
	public void testBuscarContato() {
		Agenda agenda = new Agenda();
		Telefone telefone = new Telefone("99999999", "83", "Tim");
		List<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(telefone);

		agenda.inserirContato("Paulo", "30", "", telefones, null);
		agenda.inserirContato("Pedro", "27", "", telefones, null);
		agenda.inserirContato("Henrique", "25", "", telefones, null);
		agenda.inserirContato("Neto", "22", "", telefones, null);
		agenda.inserirContato("Adriana", "20", "", telefones, null);
		agenda.inserirContato("Paula", "18", "", telefones, null);
		agenda.inserirContato("Jose", "11", "", telefones, null);
		agenda.inserirContato("Joao", "", "", telefones, null);
		Assert.assertEquals(8, agenda.getQtdContatos());

		Assert.assertEquals(3, agenda.buscar("p", "nome").size());
		Assert.assertEquals(1, agenda.buscar("pe", "nome").size());
		Assert.assertEquals(1, agenda.buscar("pedro", "nome").size());
		Assert.assertEquals(2, agenda.buscar("pa", "nome").size());
		Assert.assertEquals(2, agenda.buscar("paul", "nome").size());
		Assert.assertEquals(1, agenda.buscar("paulo", "nome").size());
		Assert.assertEquals(1, agenda.buscar("paula", "nome").size());
		Assert.assertEquals(1, agenda.buscar("HE", "nome").size());
		Assert.assertEquals(8, agenda.buscar("", "nome").size());
		Assert.assertEquals(0, agenda.buscar("sadhkasjdhkajsd", "nome").size());
		Assert.assertEquals(1, agenda.buscar("a", "nome").size());
		Assert.assertEquals(2, agenda.buscar("JO", "nome").size());
		Assert.assertEquals(1, agenda.buscar("JOS", "nome").size());
		Assert.assertEquals(1, agenda.buscar("JOA", "nome").size());
		
		Assert.assertEquals(8, agenda.buscar("99999999", "numero").size());
		Assert.assertEquals(8, agenda.buscar("", "numero").size());
		Assert.assertEquals(0, agenda.buscar("81", "numero").size());
		
		Assert.assertEquals(5, agenda.buscar("20", "idadeMaior").size());
		Assert.assertEquals(7, agenda.buscar("0", "idadeMaior").size());
		Assert.assertEquals(2, agenda.buscar("27", "idadeMaior").size());
		Assert.assertEquals(0, agenda.buscar("200", "idadeMaior").size());
		
		Assert.assertEquals(3, agenda.buscar("20", "idadeMenor").size());
		Assert.assertEquals(0, agenda.buscar("0", "idadeMenor").size());
		Assert.assertEquals(6, agenda.buscar("27", "idadeMenor").size());
		Assert.assertEquals(7, agenda.buscar("200", "idadeMenor").size());
		
		Assert.assertEquals(1, agenda.buscar("20", "idadeIgual").size());
		Assert.assertEquals(0, agenda.buscar("0", "idadeIgual").size());
		Assert.assertEquals(1, agenda.buscar("27", "idadeIgual").size());
		Assert.assertEquals(0, agenda.buscar("200", "idadeIgual").size());

	}
}