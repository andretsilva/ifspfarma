package bra.ifsp.farmasisava.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bra.ifsp.farmasisava.control.CaixaControl;
import bra.ifsp.farmasisava.model.Caixa;

import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FecharCaixaUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3155627728826629157L;
	private JPanel contentPane;
	private JTextField txtVlEsperado;
	private JTextField txtQtdVendas;


	/**
	 * Create the frame.
	 */
	public FecharCaixaUI(Caixa caixa, DefaultUI ui ) {
		setResizable(false);
		setTitle("Fechar Caixa");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblT = new JLabel("Valor Esperado em Caixa:");
		lblT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblT.setBounds(21, 11, 181, 14);
		panel.add(lblT);
		
		txtVlEsperado = new JTextField();
		txtVlEsperado.setEditable(false);
		txtVlEsperado.setBounds(212, 8, 118, 20);
		panel.add(txtVlEsperado);
		txtVlEsperado.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 414, 2);
		panel.add(separator);
		
		JLabel lblVendasDoDia = new JLabel("Quantidade de Vendas no dia");
		lblVendasDoDia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVendasDoDia.setBounds(10, 49, 192, 14);
		panel.add(lblVendasDoDia);
		
		txtQtdVendas = new JTextField();
		txtQtdVendas.setEditable(false);
		txtQtdVendas.setBounds(212, 46, 54, 20);
		panel.add(txtQtdVendas);
		txtQtdVendas.setColumns(10);
		
		JButton btnFecharCaixa = new JButton("Fechar Caixa");
		btnFecharCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaixaControl cc = new CaixaControl();
				cc.FecharCaixa(caixa, ui);
				
				setVisible(false);
			}
		});
		
		txtVlEsperado.setText(String.valueOf(caixa.getTotalCaixa()));
		btnFecharCaixa.setBounds(10, 105, 111, 23);
		panel.add(btnFecharCaixa);
		CaixaControl cc = new CaixaControl();
		txtQtdVendas.setText(String.valueOf(cc.ObterNumeroDeVendas()));
		setVisible(true);
	}

}
