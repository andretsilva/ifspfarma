package bra.ifsp.farmasisava.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import bra.ifsp.farmasisava.control.ClientesControl;
import bra.ifsp.farmasisava.control.MedicamentoControl;
import bra.ifsp.farmasisava.control.ValorCartao;
import bra.ifsp.farmasisava.control.ValorDinheiro;
import bra.ifsp.farmasisava.control.ValorIdoso;
import bra.ifsp.farmasisava.control.ValorStrategy;
import bra.ifsp.farmasisava.control.VendaControl;
import bra.ifsp.farmasisava.model.Caixa;
import bra.ifsp.farmasisava.model.Cliente;
import bra.ifsp.farmasisava.model.ItemVenda;
import bra.ifsp.farmasisava.model.Medicamento;
import bra.ifsp.farmasisava.model.Venda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;


public class VendaItensUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtCodigoBarras;
	private JTextField txtQuantidade;
	private JFormattedTextField txtCpfDesconto;
	private JTextField txtTotalCompra;
	private ArrayList<ItemVenda> itens = new ArrayList<ItemVenda>();
	private JTextField txtDesconto;
	private Cliente cliente = new Cliente();
	private boolean pgDinheiro = false;

	/**
	 * Create the frame.
	 */
	public VendaItensUI(Caixa caixa) {
		setTitle("Lista de Compras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JRadioButton rdDinheiro = new JRadioButton("Dinheiro");
		rdDinheiro.setBounds(87, 248, 109, 23);
		contentPane.add(rdDinheiro);
		
		JRadioButton rdCartao = new JRadioButton("Cart\u00E3o\r\n");
		rdCartao.setBounds(10, 248, 73, 23);
		contentPane.add(rdCartao);
		ButtonGroup grupoRadio = new ButtonGroup();
		grupoRadio.add(rdDinheiro);
		grupoRadio.add(rdCartao);
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 275, 118);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de Barras");
		lblCdigoDeBarras.setBounds(10, 11, 161, 14);
		panel.add(lblCdigoDeBarras);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(10, 31, 240, 20);
		panel.add(txtCodigoBarras);
		txtCodigoBarras.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(10, 62, 115, 14);
		panel.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(10, 82, 86, 20);
		panel.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		DefaultTableModel modelo = new DefaultTableModel();
		String[] colunas = new String []{"MEDICAMENTO","QUANTIDADE", "PREÇO"};
		modelo.setColumnIdentifiers(colunas);
		JButton btnAdicionarALista = new JButton("Adicionar a lista");
		btnAdicionarALista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medicamento medicamento = new Medicamento();
				MedicamentoControl mc = new MedicamentoControl();
				String codigoBarras = txtCodigoBarras.getText().toString();
				try {
					medicamento = mc.obterMedicamento(codigoBarras);

					ItemVenda itemVenda = new ItemVenda();
					itemVenda.setMedicamento(medicamento);
					itemVenda.setQuantidade(Integer.parseInt(txtQuantidade.getText().toString()));
					
					itens.add(itemVenda);
					
						String[] linha = 
								new String[]{String.valueOf(itemVenda.getMedicamento().getNome()), String.valueOf(itemVenda.getQuantidade()), String.valueOf(itemVenda.getMedicamento().getPreco()*itemVenda.getQuantidade())};
						modelo.addRow(linha);
						
					
						atualizaValorCompra();
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Medicamento não encontrado", "Erro!",
                            JOptionPane.ERROR_MESSAGE);
				}
			
				
			}
		});
		btnAdicionarALista.setBounds(103, 81, 147, 23);
		panel.add(btnAdicionarALista);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(295, 11, 311, 173);
		contentPane.add(scrollPane);
		

		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(97);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 140, 278, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblClienteEspecial = new JLabel("Cliente Especial");
		lblClienteEspecial.setBounds(9, 4, 74, 14);
		panel_1.add(lblClienteEspecial);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 19, 46, 14);
		panel_1.add(lblCpf);
		
		txtCpfDesconto = new JFormattedTextField();
		txtCpfDesconto.setBounds(10, 36, 104, 20);
		panel_1.add(txtCpfDesconto);
		txtCpfDesconto.setColumns(10);
		
		try {
			MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
			maskCPF.install(txtCpfDesconto);
		}
		catch(Exception ex){
			ex.getMessage();
		}
		
		JButton btnNewButton = new JButton("Conceder Desconto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientesControl cc = new ClientesControl();
				
				cliente = cc.obterCliente(txtCpfDesconto.getText());
				atualizaValorCompra();
			}
		});
		btnNewButton.setBounds(124, 35, 136, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblTotalDaCompra = new JLabel("Total da Compra:");
		lblTotalDaCompra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalDaCompra.setBounds(390, 195, 90, 14);
		contentPane.add(lblTotalDaCompra);
		
		txtTotalCompra = new JTextField();
		txtTotalCompra.setEditable(false);
		txtTotalCompra.setBounds(490, 189, 116, 20);
		contentPane.add(txtTotalCompra);
		txtTotalCompra.setColumns(10);
		
		JButton btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendaControl vc = new VendaControl();
				String metodoPagamento;
				if(rdCartao.isSelected()) {
					metodoPagamento="Dinheiro";
				} else {
					metodoPagamento="Cartão";
				}
				Venda venda = new Venda();
				venda.setDataVenda();
				
				venda.setValorVenda(Double.parseDouble(txtDesconto.getText().toString()));
			
				vc.RealizarPagamento(venda,itens,metodoPagamento,cliente,caixa);
				setVisible(false);
			}
		});
		btnFinalizarVenda.setBounds(456, 248, 150, 23);
		contentPane.add(btnFinalizarVenda);
		
		JLabel lblDesconto = new JLabel("Valor com Desconto Especial:");
		lblDesconto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesconto.setBounds(305, 220, 175, 14);
		contentPane.add(lblDesconto);
		
		txtDesconto = new JTextField();
		txtDesconto.setEditable(false);
		txtDesconto.setColumns(10);
		txtDesconto.setBounds(490, 217, 116, 20);
		contentPane.add(txtDesconto);
		
		JLabel lblModoDePagamento = new JLabel("Modo de Pagamento");
		lblModoDePagamento.setBounds(10, 230, 116, 14);
		contentPane.add(lblModoDePagamento);
		
		
		setVisible(true);
		
		rdCartao.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if(rdCartao.isSelected()) {
					
				} else {rdCartao.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						if(rdCartao.isSelected()) {
							pgDinheiro = false;
							atualizaValorCompra();
						}
					}
				});
					if(cliente.getCpf()!=null){
						txtDesconto.setText(String.valueOf(Double.parseDouble(txtTotalCompra.getText())*0.95));
					}
						
				}
			}
		});
		
		rdDinheiro.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				pgDinheiro = false;
				if(rdDinheiro.isSelected()) {
					pgDinheiro = true;
					atualizaValorCompra();
				}
			}
		});
	}
	
	public void atualizaValorCompra() {
		
		double totalVendas = 0;
		double totalVendasDesconto = 0;
		double valorTemp;
		ValorStrategy valorItem;
		for (ItemVenda item : itens) {
			totalVendas = totalVendas + (item.getMedicamento().getPreco()*item.getQuantidade());
			txtTotalCompra.setText(String.valueOf(totalVendas));
		}
					
		for (ItemVenda item : itens) {
			valorTemp = item.getMedicamento().getPreco()*item.getQuantidade();
			if (cliente.getCpf()!= null) {
				valorItem = new ValorIdoso(valorTemp);				
			} else if (pgDinheiro) {
				valorItem = new ValorDinheiro(valorTemp);
			} else {
				valorItem = new ValorCartao(valorTemp);
			}
			totalVendasDesconto = totalVendasDesconto + valorItem.getValorDesconto();
			txtDesconto.setText(String.valueOf(totalVendasDesconto));
		}
	}
}
