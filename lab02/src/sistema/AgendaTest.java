package sistema;

import org.junit.Assert;
import org.junit.Test;

public class AgendaTest {

	@Test
	public void testInserirContato() {
		Agenda agenda = new Agenda();

		// Inser��es com dados obrigatorios//
		Assert.assertEquals(0, agenda.getQtdContatos());
		//agenda.inserirContato("Pedro", 33712535);
		Assert.assertEquals(1, agenda.getQtdContatos());
		//agenda.inserirContato("Maria", 96558796);
		Assert.assertEquals(2, agenda.getQtdContatos());
		//agenda.inserirContato("Jose", 88880000);
		Assert.assertEquals(3, agenda.getQtdContatos());
		//agenda.inserirContato("Pedro", 33712535);
		Assert.assertEquals(3, agenda.getQtdContatos());
	}
}