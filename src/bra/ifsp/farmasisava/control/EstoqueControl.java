package bra.ifsp.farmasisava.control;
import bra.ifsp.farmasisava.bd.JDBCEstoqueDao;
import bra.ifsp.farmasisava.bd.JDBCMedicamentoDao;
import bra.ifsp.farmasisava.model.Estoque;
import bra.ifsp.farmasisava.model.Medicamento;

public class EstoqueControl {
	public Estoque obterEstoque(String codigoBarras) {
		JDBCEstoqueDao bdEstoque = new JDBCEstoqueDao();
		return bdEstoque.obterEstoque(codigoBarras);
	}
	public String obterNomeMedicamento(String codigoBarras) {
		JDBCMedicamentoDao bdMedicamento = new JDBCMedicamentoDao();
		Medicamento medicamento = new Medicamento();
		medicamento = bdMedicamento.ObterMedicamento(codigoBarras);
		return medicamento.getNome();
	}
	
	public void AtualizarEstoque(Estoque estoque){
		JDBCEstoqueDao bdEstoque = new JDBCEstoqueDao();
		bdEstoque.AtualizarEstoque(estoque);
	}
}
