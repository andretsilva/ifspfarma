package bra.ifsp.farmasisava.control;
import javax.swing.JOptionPane;

import bra.ifsp.farmasisava.bd.JDBCEstoqueDao;
import bra.ifsp.farmasisava.bd.JDBCMedicamentoDao;
import bra.ifsp.farmasisava.model.Estoque;
import bra.ifsp.farmasisava.model.Medicamento;

public class EstoqueControl {
	public Estoque obterEstoque(String codigoBarras) {
		JDBCEstoqueDao bdEstoque = new JDBCEstoqueDao();
		return bdEstoque.obterEstoque(codigoBarras);
	}
	public String obterNomeMedicamento(String codigoBarras) throws Exception {
		JDBCMedicamentoDao bdMedicamento = new JDBCMedicamentoDao();
		Medicamento medicamento = new Medicamento();
		try {
		medicamento = bdMedicamento.ObterMedicamento(codigoBarras);
		return medicamento.getNome();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw ex;
		}
		
	}
	
	public void AtualizarEstoque(Estoque estoque){
		JDBCEstoqueDao bdEstoque = new JDBCEstoqueDao();
		bdEstoque.AtualizarEstoque(estoque);
	}
}
