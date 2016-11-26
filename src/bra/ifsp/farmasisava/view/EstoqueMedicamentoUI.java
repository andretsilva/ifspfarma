package bra.ifsp.farmasisava.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bra.ifsp.farmasisava.control.EstoqueControl;
import bra.ifsp.farmasisava.model.Estoque;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstoqueMedicamentoUI extends JFrame {
	static int estoqueID;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3504377083623712543L;
	private JPanel contentPane;
	private JTextField txtCodigoBarras;
	private JTextField txtNomeMedicamento;
	private JTextField txtQuantidade;


	/**
	 * Create the frame.
	 */
	public EstoqueMedicamentoUI() {
		
		setTitle("Alterar Estoque");
		setBounds(100, 100, 450, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 163);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDigiteOCdigo = new JLabel("Digite o c\u00F3digo de barras do medicamento");
		lblDigiteOCdigo.setBounds(10, 11, 287, 14);
		panel.add(lblDigiteOCdigo);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(10, 32, 200, 20);
		panel.add(txtCodigoBarras);
		txtCodigoBarras.setColumns(10);
		
		JButton btnAtualizarEstoque = new JButton("Pesquisar");
		
		btnAtualizarEstoque.setBounds(223, 31, 181, 23);
		panel.add(btnAtualizarEstoque);
		
		JLabel lblNomeDoMedicamento = new JLabel("Nome do Medicamento");
		lblNomeDoMedicamento.setBounds(10, 63, 130, 14);
		panel.add(lblNomeDoMedicamento);
		
		txtNomeMedicamento = new JTextField();
		txtNomeMedicamento.setEditable(false);
		txtNomeMedicamento.setBounds(10, 77, 394, 20);
		panel.add(txtNomeMedicamento);
		txtNomeMedicamento.setColumns(10);
		
		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade em estoque");
		lblQuantidadeEmEstoque.setBounds(10, 108, 183, 14);
		panel.add(lblQuantidadeEmEstoque);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(11, 125, 157, 20);
		panel.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JButton btnNewButton = new JButton("Alterar Estoque");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstoqueControl ec = new EstoqueControl();
				Estoque estoque = new Estoque();
				estoque.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				estoque.setIdEstoque(estoqueID);
				
				ec.AtualizarEstoque(estoque);
				JOptionPane.showMessageDialog(null, "Estoque alterado com sucesso", "Estoque alterado!",
                        JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnNewButton.setBounds(223, 124, 181, 23);
		panel.add(btnNewButton);
		btnAtualizarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nomeMedicamento;
				
				EstoqueControl ec = new EstoqueControl();
				
				nomeMedicamento = ec.obterNomeMedicamento(txtCodigoBarras.getText().toString());
				if(nomeMedicamento != null) {
					Estoque estoque = new Estoque();
					estoque = ec.obterEstoque(txtCodigoBarras.getText());
					txtQuantidade.setText(String.valueOf(estoque.getQuantidade()).toString());
					txtNomeMedicamento.setText(nomeMedicamento);
					estoqueID = estoque.getIdEstoque();
					btnNewButton.setEnabled(true);
				}
				
			}
		});
		
		setVisible(true);
	}
}
