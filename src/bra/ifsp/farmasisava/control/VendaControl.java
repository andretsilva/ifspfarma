package bra.ifsp.farmasisava.control;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import bra.ifsp.farmasisava.bd.JDBCVenda;
import bra.ifsp.farmasisava.model.Caixa;
import bra.ifsp.farmasisava.model.Cliente;
import bra.ifsp.farmasisava.model.ItemVenda;
import bra.ifsp.farmasisava.model.Venda;
import bra.ifsp.farmasisava.view.PagamentoCartaoUI;

public class VendaControl {
	public void RealizarPagamento(Venda venda, ArrayList<ItemVenda> itens, String metodoPagamento, Cliente cliente, Caixa caixa) {
		JDBCVenda bdVenda = new JDBCVenda();
		bdVenda.RealizarPagamento(venda, itens, metodoPagamento, cliente);
		if (metodoPagamento == "Dinheiro") {
			if (cliente.getCpf() != null) {
				caixa.somaTotalCaixa(venda.getValorVenda()*0.80);
			}  else {
				caixa.somaTotalCaixa(venda.getValorVenda()*0.95);
			}
			JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso", "Pagamento efetuado",
                    JOptionPane.INFORMATION_MESSAGE);
		} else {
			new PagamentoCartaoUI();
		}
	}
}
