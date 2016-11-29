package bra.ifsp.farmasisava.bd;

import bra.ifsp.farmasisava.model.Estoque;

public interface EstoqueDao {
	public Estoque obterEstoque(String codigoBarras);
	public void AtualizarEstoque(Estoque estoque);

}
