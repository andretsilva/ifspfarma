package bra.ifsp.farmasisava.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bra.ifsp.farmasisava.control.MedicamentoControl;
import bra.ifsp.farmasisava.model.Medicamento;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MedicamentoCadastrarUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7294078876216251544L;
	private JPanel contentPane;
	private JTextField txtMedicamento;
	private JTextField txtFabricante;
	private JTextField txtPreco;
	private JTextField txtCodigoBarras;

	/**
	 * Create the frame.
	 */
	public MedicamentoCadastrarUI() {
		setTitle("Cadastar Medicamento");
		
		setBounds(100, 100, 351, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 11, 321, 240);
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
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicamentoControl cc = new MedicamentoControl();
				Medicamento medicamento = new Medicamento();
				medicamento.setNome(txtMedicamento.getText());
				medicamento.setCodigoBarras(txtCodigoBarras.getText());
				medicamento.setFabricante(txtFabricante.getText());
				medicamento.setPreco(Double.parseDouble(txtPreco.getText().replaceAll(",", ".")));
				cc.CadastrarMedicamento(medicamento);
				
				JOptionPane.showMessageDialog(null, "Medicamento cadastrado com Sucesso");
				setVisible(false);
			}
		});
		btnCadastrar.setBounds(10, 197, 134, 23);
		panel.add(btnCadastrar);
		setVisible(true);
	}
}
