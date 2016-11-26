package bra.ifsp.farmasisava.view;


import java.awt.Color;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bra.ifsp.farmasisava.control.MedicamentoControl;
import bra.ifsp.farmasisava.model.Medicamento;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class MedicamentoAlterar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4381745894017481664L;
	private JPanel contentPane;
	private JTextField txtMedicamento;
	private JTextField txtFabricante;
	private JTextField txtPreco;
	private JTextField txtCodigoBarras;
	private JTextField txtCbBuscar;


	public MedicamentoAlterar() {
		setTitle("Alterar Medicamento");
	
		setBounds(100, 100, 351, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 58, 321, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomeMedicamento = new JLabel("Medicamento");
		lblNomeMedicamento.setBounds(10, 11, 134, 14);
		panel.add(lblNomeMedicamento);
		
		txtMedicamento = new JTextField();
		txtMedicamento.setBounds(10, 29, 184, 20);
		panel.add(txtMedicamento);
		txtMedicamento.setColumns(10);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setBounds(10, 59, 134, 14);
		panel.add(lblFabricante);
		
		txtFabricante = new JTextField();
		txtFabricante.setBounds(10, 73, 184, 20);
		panel.add(txtFabricante);
		txtFabricante.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(10, 104, 46, 14);
		panel.add(lblPreo);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(10, 120, 184, 20);
		panel.add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de Barras");
		lblCdigoDeBarras.setBounds(10, 151, 184, 14);
		panel.add(lblCdigoDeBarras);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(10, 166, 297, 20);
		panel.add(txtCodigoBarras);
		txtCodigoBarras.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicamentoControl mc = new MedicamentoControl();
				Medicamento medicamento = new Medicamento();
				medicamento.setNome(txtMedicamento.getText());
				medicamento.setCodigoBarras(txtCodigoBarras.getText());
				medicamento.setFabricante(txtFabricante.getText());
				medicamento.setPreco(Double.parseDouble(txtPreco.getText()));
				
				mc.AtualizarMedicamento(medicamento);
				
				JOptionPane.showMessageDialog(null, "Medicamento Alterado com Sucesso", "Medicamento alterado!",
                        JOptionPane.INFORMATION_MESSAGE);
				
				setVisible(false);
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(10, 197, 134, 23);
		panel.add(btnSalvar);
		
		JLabel lblDigiteOCdigo = new JLabel("Digite o c\u00F3digo de barras do medicamento para alterar");
		lblDigiteOCdigo.setBounds(10, 11, 321, 14);
		contentPane.add(lblDigiteOCdigo);
		
		txtCbBuscar = new JTextField();
		txtCbBuscar.setBounds(10, 30, 192, 20);
		contentPane.add(txtCbBuscar);
		txtCbBuscar.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicamentoControl mc = new MedicamentoControl(); 
				Medicamento medicamentoObtido = mc.obterMedicamento(txtCbBuscar.getText().toString());
				if(medicamentoObtido.getCodigoBarras() != null) {
					txtMedicamento.setText(medicamentoObtido.getNome());
					txtCodigoBarras.setText(medicamentoObtido.getCodigoBarras());
					txtCodigoBarras.setEditable(false);
					txtPreco.setText(String.valueOf(medicamentoObtido.getPreco()).toString());
					txtFabricante.setText(medicamentoObtido.getFabricante());
					btnSalvar.setEnabled(true);
					
				} else {
					 JOptionPane.showMessageDialog(null, "Medicamento não encontrado", "Erro!",
                             JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		btnFiltrar.setBounds(219, 28, 89, 23);
		contentPane.add(btnFiltrar);
		setVisible(true);
	}

}
