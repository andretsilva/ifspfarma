package bra.ifsp.farmasisava.bd;

import bra.ifsp.farmasisava.model.Caixa;

public interface CaixaDao {
	public boolean LoginAbertura(String password);
	public boolean LoginFechamento(String password);
	public int AbreCaixa(Caixa caixa);
	public void FechaCaixa(Caixa caixa);
	public int ObterNumeroDeVendas();

}
