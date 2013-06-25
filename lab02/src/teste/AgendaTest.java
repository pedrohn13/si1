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
		Telefone telefone = new Telefone("99999999","83","Tim");
		List<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(telefone);		

		// Inserções com dados obrigatorios//
		Assert.assertEquals(0, agenda.getQtdContatos());
		agenda.inserirContato("Pedro","","",telefones,null);
		Assert.assertEquals(1, agenda.getQtdContatos());
		agenda.inserirContato("Maria","","",telefones,null);
		Assert.assertEquals(2, agenda.getQtdContatos());
		agenda.inserirContato("Jose","","",telefones,null);
		Assert.assertEquals(3, agenda.getQtdContatos());
		agenda.inserirContato("Pedro","","",telefones,null);
		Assert.assertEquals(3, agenda.getQtdContatos());
	}
	
	@Test
	public void testBuscarContato() {
		Agenda agenda = new Agenda();
		Telefone telefone = new Telefone("99999999","83","Tim");
		List<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(telefone);
		
		agenda.inserirContato("Pedro","27","",telefones,null);
		agenda.inserirContato("Henrique","27","",telefones,null);
		agenda.inserirContato("Neto","27","",telefones,null);
		agenda.inserirContato("Adriana","20","",telefones,null);
		agenda.inserirContato("Paulo","26","",telefones,null);
		agenda.inserirContato("Paula","20","",telefones,null);
		agenda.inserirContato("Jose","11","",telefones,null);
		agenda.inserirContato("Joao","67","",telefones,null);
		Assert.assertEquals(8, agenda.getQtdContatos());
		
		Assert.assertEquals(3, agenda.buscaNome("p").size());
		Assert.assertEquals(1, agenda.buscaNome("pe").size());
		Assert.assertEquals(1, agenda.buscaNome("pedro").size());
		Assert.assertEquals(2, agenda.buscaNome("pa").size());
		Assert.assertEquals(2, agenda.buscaNome("paul").size());
		Assert.assertEquals(1, agenda.buscaNome("paulo").size());
		Assert.assertEquals(1, agenda.buscaNome("paula").size());
		Assert.assertEquals(1, agenda.buscaNome("HE").size());
		Assert.assertEquals(8, agenda.buscaNome("").size());
		Assert.assertEquals(0, agenda.buscaNome("sadhkasjdhkajsd").size());
		Assert.assertEquals(1, agenda.buscaNome("a").size());
		Assert.assertEquals(2, agenda.buscaNome("JO").size());
		Assert.assertEquals(1, agenda.buscaNome("JOS").size());
		Assert.assertEquals(1, agenda.buscaNome("JOA").size());
		
	}
}