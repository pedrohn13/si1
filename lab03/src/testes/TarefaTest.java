package testes;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import sistema.Tarefa;
import sistema.TarefaComparator;

public class TarefaTest {

	/**
	 * Não testarei gets e sets pois isso não é teste. O que se deve testar são
	 * métodos que tenham alguma lógica.
	 */

	@Test
	@SuppressWarnings("deprecation")
	public void testComparator() {
		Date dataPrazo1 = new Date(2013, 07, 11, 23, 59);
		Date dataPrazo2 = new Date(2013, 07, 11, 23, 59);
		Date dataPrazo3 = new Date(2013, 07, 22);

		Tarefa tarefa1 = new Tarefa("Tarefa1", "", dataPrazo1);
		Tarefa tarefa2 = new Tarefa("Tarefa2", "Lab de SI1", dataPrazo2);
		Tarefa tarefa3 = new Tarefa("Tarefa3", "Estudar para Prova de Sexta",
				dataPrazo3);
		Tarefa tarefa4 = new Tarefa("Tarefa1", "", dataPrazo1);

		Assert.assertEquals(1,
				new TarefaComparator("dataPrazo").compare(tarefa3, tarefa2));
		Assert.assertEquals(1,
				new TarefaComparator("dataPrazo").compare(tarefa3, tarefa1));
		Assert.assertEquals(-1,
				new TarefaComparator("dataPrazo").compare(tarefa1, tarefa2));
		Assert.assertEquals(0,
				new TarefaComparator("dataPrazo").compare(tarefa1, tarefa4));		
		Assert.assertEquals(1,
				new TarefaComparator("dataCriacao").compare(tarefa3, tarefa2));

	}
}
