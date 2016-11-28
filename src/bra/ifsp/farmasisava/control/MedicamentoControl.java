package bra.ifsp.farmasisava.control;

import java.util.Set;


import bra.ifsp.farmasisava.bd.JDBCMedicamentoDao;
import bra.ifsp.farmasisava.model.Medicamento;

public class MedicamentoControl {
	public void CadastrarMedicamento(Medicamento medicamento) {
		JDBCMedicamentoDao md = new JDBCMedicamentoDao();

		md.CadastrarMedicamento(medicamento);
		
	}
	
	public Set<Medicamento> ObterMedicamentos() {
		JDBCMedicamentoDao md = new JDBCMedicamentoDao();

		return md.ObterMedicamentos();
		
	}
	
	public Medicamento obterMedicamento(String codigoBarras) throws Exception{			
		
		JDBCMedicamentoDao cd = new JDBCMedicamentoDao();
		Medicamento medicamento;
		try {
			medicamento = cd.ObterMedicamento(codigoBarras);
			return medicamento;
		}
		catch (Exception ex) {
			Exception error = new Exception();
			throw error;
		}
		
	}

	
	public void AtualizarMedicamento(Medicamento medicamento) {
		JDBCMedicamentoDao md = new JDBCMedicamentoDao();

		md.AtualizarMedicamento(medicamento);
		
	}
}
