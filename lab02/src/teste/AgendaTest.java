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
		
	}
}