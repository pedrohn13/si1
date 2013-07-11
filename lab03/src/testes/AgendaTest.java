package testes;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import sistema.Controlador;
import sistema.Tarefa;

public class AgendaTest {

	Controlador controlador;
	Date data1;
	Date data2;
	Date data3;
	Date data4;
	Date data5;

	@Before
	@SuppressWarnings("deprecation")
	public void init() {
		controlador = new Controlador();
		data1 = null;
		data2 = new Date(113, 0, 0);
		data3 = new Date(114, 2, 0);
		data4 = new Date(114, 9, 3);
		data5 = new Date(113, 11, 31, 23, 59);
	}

	/**
	 * Não testarei gets e sets pois isso não é teste. O que se deve testar são
	 * métodos que tenham alguma lógica.
	 */

	@Test
	public void testCriarTarefa() {
		Assert.assertEquals(0, controlador.getTarefas().size());
		controlador.criarTarefa("Tarefa1", "", data1);
		controlador.filtroNenhum();
		Assert.assertEquals(1, controlador.getTarefas().size());

		// Tarefa com o mesmo nome
		controlador.criarTarefa("Tarefa1", "", data2);
		controlador.filtroNenhum();
		Assert.assertEquals(1, controlador.getTarefas().size());

		// Tarefa com prazo menor que a data atual
		controlador.criarTarefa("Tarefa2", "", data2);
		controlador.filtroNenhum();
		Assert.assertEquals(1, controlador.getTarefas().size());

		controlador.criarTarefa("Tarefa2", "", data3);
		controlador.filtroNenhum();
		Assert.assertEquals(2, controlador.getTarefas().size());

		controlador.criarTarefa("Tarefa3", "", data4);
		controlador.filtroNenhum();
		Assert.assertEquals(3, controlador.getTarefas().size());

		controlador.criarTarefa("Tarefa4", "", data2);
		controlador.filtroNenhum();
		Assert.assertEquals(4, controlador.getTarefas().size());

		controlador.criarTarefa("Tarefa5", "", data5);
		controlador.filtroNenhum();
		Assert.assertEquals(5, controlador.getTarefas().size());
	}

	@SuppressWarnings("deprecation")
	public void testCompletarTarefa() {
		controlador.criarTarefa("Tarefa1", "", data5);
		controlador.criarTarefa("Tarefa2", "", data2);
		controlador.criarTarefa("Tarefa3", "", data3);

		controlador.filtroIncompletas();
		Assert.assertEquals(3, controlador.getTarefas().size());

		controlador.filtroCompletas();
		Assert.assertEquals(0, controlador.getTarefas().size());

		Date data1 = new Date(2013, 07, 11, 23, 59);
		controlador.completarTarefa(new Tarefa("Tarefa1", "", data1));

		controlador.filtroIncompletas();
		Assert.assertEquals(2, controlador.getTarefas().size());

		controlador.filtroCompletas();
		Assert.assertEquals(1, controlador.getTarefas().size());

		Date data2 = new Date(2013, 0, 0, 0, 0);
		controlador.completarTarefa(new Tarefa("Tarefa2", "", data2));

		controlador.filtroIncompletas();
		Assert.assertEquals(1, controlador.getTarefas().size());

		controlador.filtroCompletas();
		Assert.assertEquals(2, controlador.getTarefas().size());

		Date data3 = new Date(2013, 11, 0, 0, 0);
		controlador.completarTarefa(new Tarefa("Tarefa3", "", data3));

		controlador.filtroIncompletas();
		Assert.assertEquals(0, controlador.getTarefas().size());

		controlador.filtroCompletas();
		Assert.assertEquals(3, controlador.getTarefas().size());
	}

}
