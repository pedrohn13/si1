package testes;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import sistema.Controlador;
import sistema.Tarefa;

public class AgendaTest {

	Controlador controlador;

	@Before
	public void init() {
		controlador = new Controlador();
	}

	/**
	 * Não testarei gets e sets pois isso não é teste. O que se deve testar são
	 * métodos que tenham alguma lógica.
	 */

	@Test
	public void testCriarTarefa() {
		Assert.assertEquals(0, controlador.getTarefas().size());
		controlador.criarTarefa("Tarefa1", "");
		controlador.filtroNenhum();
		Assert.assertEquals(1, controlador.getTarefas().size());

		// Tarefa com o mesmo nome
		controlador.criarTarefa("Tarefa1", "");
		controlador.filtroNenhum();
		Assert.assertEquals(1, controlador.getTarefas().size());

		// Tarefa com prazo menor que a data atual
		controlador.criarTarefa("Tarefa2", "", 113);
		controlador.filtroNenhum();
		Assert.assertEquals(1, controlador.getTarefas().size());

		controlador.criarTarefa("Tarefa2", "", 114, 2);
		controlador.filtroNenhum();
		Assert.assertEquals(2, controlador.getTarefas().size());

		controlador.criarTarefa("Tarefa3", "", 114, 9, 3);
		controlador.filtroNenhum();
		Assert.assertEquals(3, controlador.getTarefas().size());

		controlador.criarTarefa("Tarefa4", "", 115, 7, 11, 12);
		controlador.filtroNenhum();
		Assert.assertEquals(4, controlador.getTarefas().size());

		controlador.criarTarefa("Tarefa5", "", 113, 11, 31, 23, 59);
		controlador.filtroNenhum();
		Assert.assertEquals(5, controlador.getTarefas().size());
	}

	@SuppressWarnings("deprecation")
	public void testCompletarTarefa() {
		controlador.criarTarefa("Tarefa1", "", 113, 07, 11, 23, 59);
		controlador.criarTarefa("Tarefa2", "", 113);
		controlador.criarTarefa("Tarefa3", "", 113, 11);

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
