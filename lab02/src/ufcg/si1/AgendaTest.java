package ufcg.si1;

import junit.framework.Assert;

import org.junit.Test;

public class AgendaTest {

	@Test
	public void testInserirContato() {
		Agenda agenda = new Agenda();

		// Inserções com dados obrigatorios//
		Assert.assertEquals(0, agenda.getQtdContatos());
		agenda.inserirContato("Pedro", 33712535);
		Assert.assertEquals(1, agenda.getQtdContatos());
		agenda.inserirContato("Maria", 96558796);
		Assert.assertEquals(2, agenda.getQtdContatos());
		agenda.inserirContato("Jose", 88880000);
		Assert.assertEquals(3, agenda.getQtdContatos());
		agenda.inserirContato("Pedro", 33712535);
		Assert.assertEquals(3, agenda.getQtdContatos());

		// Inserções com região //
		// Nesse caso como foi especificado a região, será criado um novo
		// contato diferente do outro Pedro já que existe a posibilidade de ter
		// 2 pessoas com o mesmo nome e mesmo telefone, porém de regiões
		// diferentes.
		agenda.inserirContato("Pedro", 33712535, 83);
		Assert.assertEquals(4, agenda.getQtdContatos());
		agenda.inserirContato("Francisco", 98756644, 83);
		Assert.assertEquals(5, agenda.getQtdContatos());
		

		// Inserções com Operadora //
		// Nesse caso, definir um novo contato igual a outro, adicionando
		// somenta a operadora, nao implica na criação de um novo.
		agenda.inserirContato("Pedro", 33712535, 83, "Fixo");
		Assert.assertEquals(5, agenda.getQtdContatos());
		agenda.inserirContato("Francisco", 99756644, 83, "Tim");
		Assert.assertEquals(6, agenda.getQtdContatos());
		
		agenda.inserirContato("Severino", 33211414,"Fixo");
		Assert.assertEquals(7, agenda.getQtdContatos());
		agenda.inserirContato("Severino", 33211414,"Tim");
		Assert.assertEquals(7, agenda.getQtdContatos());
	}
}