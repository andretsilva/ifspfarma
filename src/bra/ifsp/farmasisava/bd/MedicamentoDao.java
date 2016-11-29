package bra.ifsp.farmasisava.bd;

import java.util.Set;

import bra.ifsp.farmasisava.model.Medicamento;

public interface MedicamentoDao {
	public void CadastrarMedicamento(Medicamento medicamento);
	public Set<Medicamento> ObterMedicamentos();
	public Medicamento ObterMedicamento(String codigoBarras) throws Exception;
	public void AtualizarMedicamento(Medicamento medicamento);

}
