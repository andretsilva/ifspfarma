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
	
	public Medicamento obterMedicamento(String codigoBarras){
		
		JDBCMedicamentoDao cd = new JDBCMedicamentoDao();
		return cd.ObterMedicamento(codigoBarras);
	}

	
	public void AtualizarMedicamento(Medicamento medicamento) {
		JDBCMedicamentoDao md = new JDBCMedicamentoDao();

		md.AtualizarMedicamento(medicamento);
		
	}
}
