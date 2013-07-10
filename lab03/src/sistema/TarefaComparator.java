package sistema;

import java.util.Comparator;

public class TarefaComparator implements Comparator<Tarefa> {

	String modo;

	public TarefaComparator(String modo) {
		this.modo = modo;
	}

	@Override
	public int compare(Tarefa tarefa1, Tarefa tarefa2) {
		int retorno = 0;
		if (modo.equals("dataCriacao")) {
			retorno = tarefa1.getDataCriacao().compareTo(
					tarefa2.getDataCriacao());
		} else if (modo.equals("dataPrazo")) {
			retorno = tarefa1.getDataPrazo().compareTo(tarefa2.getDataPrazo());
		}
		if (retorno == 0) {
			retorno = tarefa1.getNome().compareTo(tarefa2.getNome());
		}
		return retorno;
	}

}
