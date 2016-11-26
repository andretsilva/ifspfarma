package bra.ifsp.farmasisava.view;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bra.ifsp.farmasisava.control.ClientesControl;
import bra.ifsp.farmasisava.model.Cliente;


 
public class ListarClientesUI {
	
	public ListarClientesUI() {
		// Criando o JFrame
		JFrame frameRelatClientes = new JFrame("Relatório de Clientes");
		frameRelatClientes.setSize(600, 320);
		frameRelatClientes.setVisible(true);
		frameRelatClientes.setLocationRelativeTo(null);
				
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
				
		ClientesControl cc = new ClientesControl();
		ArrayList<Cliente> listaClientes = cc.obterClientes();
					
		String[] colunas = new String []{"CPF","NOME", "TELEFONE","DATA DE NASCIMENTO"};
				
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(colunas);
		
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		 
		
		for (Cliente cliente : listaClientes) {
			
				
			String[] linha = 
					new String[]{cliente.getCpf(), cliente.getNome(), cliente.getTelefone(),String.valueOf(dt.format(cliente.getDataNascimento()).toString())};
			modelo.addRow(linha);
						
		}
		
		
		
		
				
		JTable tabela = new JTable(modelo);
				
		JScrollPane barraRolagem = new JScrollPane(tabela);
				
		panel.add(barraRolagem);
				
		frameRelatClientes.setContentPane(panel);

	}
}

