package bra.ifsp.farmasisava.control;


import bra.ifsp.farmasisava.bd.JDBCCaixa;
import bra.ifsp.farmasisava.model.Caixa;
import bra.ifsp.farmasisava.view.DefaultUI;

public class CaixaControl {
	public boolean LoginAbertura(String password) {
		
		JDBCCaixa bdCaixa = new JDBCCaixa();
		return bdCaixa.LoginAbertura(password);		
	}
	
	public boolean LoginFechamento(String password) {
		
		JDBCCaixa bdCaixa = new JDBCCaixa();
		return bdCaixa.LoginFechamento(password);		
	}

	public void AbrirCaixa(Caixa caixa,DefaultUI ui){ 
		caixa.setCaixaAberto(true);
		ui.AtualizaMenu();
		JDBCCaixa bdCaixa = new JDBCCaixa();
		caixa.setIdCaixa(bdCaixa.AbreCaixa(caixa));
	};
	
	public void FecharCaixa(Caixa caixa,DefaultUI ui){ 
		caixa.setCaixaAberto(false);
		caixa.setMoedas5(0);
		caixa.setMoedas10(0);
		caixa.setMoedas25(0);
		caixa.setMoedas50(0);
		caixa.setMoedas100(0);
		caixa.setNotas2(0);
		caixa.setNotas5(0);
		caixa.setNotas10(0);
		caixa.setNotas20(0);
		caixa.setNotas50(0);
		caixa.setNotas100(0);
		JDBCCaixa bdCaixa = new JDBCCaixa();
		bdCaixa.FechaCaixa(caixa);
		ui.AtualizaMenu();
	};
	public int ObterNumeroDeVendas() {
		int total=0;
		JDBCCaixa bdCaixa = new JDBCCaixa();
		total = bdCaixa.ObterNumeroDeVendas(); 
		return total;
	}
}
