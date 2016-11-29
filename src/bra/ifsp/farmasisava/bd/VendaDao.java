package bra.ifsp.farmasisava.bd;

import java.util.ArrayList;

import bra.ifsp.farmasisava.model.Cliente;
import bra.ifsp.farmasisava.model.ItemVenda;
import bra.ifsp.farmasisava.model.Venda;

public interface VendaDao {
	public void RealizarPagamento(Venda venda, ArrayList<ItemVenda> itens, String metodoPagamento, Cliente cliente);
	

}
