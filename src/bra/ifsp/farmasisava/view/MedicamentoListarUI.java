package bra.ifsp.farmasisava.view;

import java.awt.GridLayout;

import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bra.ifsp.farmasisava.control.MedicamentoControl;
import bra.ifsp.farmasisava.model.Medicamento;


 
public class MedicamentoListarUI {
	
	public MedicamentoListarUI() {
		// Criando o JFrame
		JFrame frameRelatClientes = new JFrame("Relatório de Medicamentos");
		frameRelatClientes.setSize(600, 320);
		frameRelatClientes.setVisible(true);
		frameRelatClientes.setLocationRelativeTo(null);
				
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
				
		MedicamentoControl mc = new MedicamentoControl();
		Set<Medicamento> listaMedicamentos = mc.ObterMedicamentos();  
					
		String[] colunas = new String []{"CÓDIGO DE BARRAS","NOME", "FABRICANTE","PREÇO"};
				
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(colunas);
	
			
		for (Medicamento medicamento : listaMedicamentos) {
			
				
			String[] linha = 
					new String[]{medicamento.getCodigoBarras(), medicamento.getNome(), medicamento.getFabricante(),String.valueOf(medicamento.getPreco()).toString()};
			modelo.addRow(linha);
						
		}
		
		
				
		JTable tabela = new JTable(modelo);
				
		JScrollPane barraRolagem = new JScrollPane(tabela);
				
		panel.add(barraRolagem);
				
		frameRelatClientes.setContentPane(panel);

	}
}

