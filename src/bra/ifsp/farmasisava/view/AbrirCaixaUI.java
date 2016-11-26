package bra.ifsp.farmasisava.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bra.ifsp.farmasisava.control.CaixaControl;
import bra.ifsp.farmasisava.model.Caixa;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AbrirCaixaUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7240837076182937271L;
	private JPanel contentPane;
	private JTextField txtNota2;
	private JTextField txtNota5;
	private JTextField txtNota20;
	private JTextField txtNota10;
	private JTextField txtNota50;
	private JTextField txtNota100;
	private JTextField txtMoeda5;
	private JTextField txtMoeda10;
	private JTextField txtMoeda25;
	private JTextField txtMoeda50;
	private JTextField txtMoeda100;

	/**
	 * Create the frame.
	 */
	public AbrirCaixaUI(Caixa caixa, DefaultUI ui) {
		setTitle("Abrir Caixa");
		setBounds(100, 100, 419, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 11, 388, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBounds(10, 11, 181, 189);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setBounds(10, 11, 133, 14);
		panel_1.add(lblNotas);
		
		JLabel lblR = new JLabel("R$2,00");
		lblR.setBounds(15, 39, 61, 14);
		panel_1.add(lblR);
		
		JLabel lblR_1 = new JLabel("R$5,00");
		lblR_1.setBounds(14, 62, 73, 14);
		panel_1.add(lblR_1);
		
		JLabel lblR_2 = new JLabel("R$10,00");
		lblR_2.setBounds(14, 88, 73, 14);
		panel_1.add(lblR_2);
		
		JLabel lblR_3 = new JLabel("R$20,00");
		lblR_3.setBounds(14, 112, 73, 14);
		panel_1.add(lblR_3);
		
		JLabel lblR_4 = new JLabel("R$50,00");
		lblR_4.setBounds(14, 139, 62, 14);
		panel_1.add(lblR_4);
		
		JLabel lblR_5 = new JLabel("R$100,00");
		lblR_5.setBounds(14, 164, 62, 14);
		panel_1.add(lblR_5);
		
		txtNota2 = new JTextField();
		txtNota2.setBounds(75, 36, 86, 20);
		panel_1.add(txtNota2);
		txtNota2.setColumns(10);
		
		txtNota5 = new JTextField();
		txtNota5.setColumns(10);
		txtNota5.setBounds(75, 60, 86, 20);
		panel_1.add(txtNota5);
		
		txtNota20 = new JTextField();
		txtNota20.setColumns(10);
		txtNota20.setBounds(75, 109, 86, 20);
		panel_1.add(txtNota20);
		
		txtNota10 = new JTextField();
		txtNota10.setColumns(10);
		txtNota10.setBounds(75, 85, 86, 20);
		panel_1.add(txtNota10);
		
		txtNota50 = new JTextField();
		txtNota50.setColumns(10);
		txtNota50.setBounds(75, 134, 86, 20);
		panel_1.add(txtNota50);
		
		txtNota100 = new JTextField();
		txtNota100.setColumns(10);
		txtNota100.setBounds(75, 160, 86, 20);
		panel_1.add(txtNota100);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.setBounds(196, 11, 181, 189);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMoedas = new JLabel("Moedas");
		lblMoedas.setBounds(10, 11, 127, 14);
		panel_2.add(lblMoedas);
		
		txtMoeda5 = new JTextField();
		txtMoeda5.setColumns(10);
		txtMoeda5.setBounds(71, 36, 86, 20);
		panel_2.add(txtMoeda5);
		
		txtMoeda10 = new JTextField();
		txtMoeda10.setColumns(10);
		txtMoeda10.setBounds(71, 60, 86, 20);
		panel_2.add(txtMoeda10);
		
		txtMoeda25 = new JTextField();
		txtMoeda25.setColumns(10);
		txtMoeda25.setBounds(71, 85, 86, 20);
		panel_2.add(txtMoeda25);
		
		txtMoeda50 = new JTextField();
		txtMoeda50.setColumns(10);
		txtMoeda50.setBounds(71, 109, 86, 20);
		panel_2.add(txtMoeda50);
		
		txtMoeda100 = new JTextField();
		txtMoeda100.setColumns(10);
		txtMoeda100.setBounds(71, 134, 86, 20);
		panel_2.add(txtMoeda100);
		
		JLabel lblR_10 = new JLabel("R$1,00");
		lblR_10.setBounds(10, 139, 62, 14);
		panel_2.add(lblR_10);
		
		JLabel lblR_9 = new JLabel("R$0,50");
		lblR_9.setBounds(10, 112, 73, 14);
		panel_2.add(lblR_9);
		
		JLabel lblR_8 = new JLabel("R$0,25");
		lblR_8.setBounds(10, 88, 73, 14);
		panel_2.add(lblR_8);
		
		JLabel lblR_7 = new JLabel("R$0,10");
		lblR_7.setBounds(10, 62, 73, 14);
		panel_2.add(lblR_7);
		
		JLabel lblR_6 = new JLabel("R$0,05");
		lblR_6.setBounds(11, 39, 61, 14);
		panel_2.add(lblR_6);
		
		JButton btnAbrirCaixa = new JButton("Confirmar Abertura");
		btnAbrirCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMoeda5.getText().isEmpty() || txtMoeda10.getText().isEmpty() || txtMoeda25.getText().isEmpty()
						|| txtMoeda50.getText().isEmpty() || txtMoeda100.getText().isEmpty() || txtNota2.getText().isEmpty()
						|| txtNota5.getText().isEmpty() || txtNota5.getText().isEmpty() || txtNota10.getText().isEmpty()
						|| txtNota20.getText().isEmpty() || txtNota50.getText().isEmpty() || txtNota50.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "Campos Em Branco!", "Erro!",
                             JOptionPane.ERROR_MESSAGE);
					
				} else {
					caixa.setMoedas5(Integer.parseInt(txtMoeda5.getText()));
					caixa.setMoedas10(Integer.parseInt(txtMoeda10.getText()));
					caixa.setMoedas25(Integer.parseInt(txtMoeda25.getText()));
					caixa.setMoedas50(Integer.parseInt(txtMoeda50.getText()));
					caixa.setMoedas100(Integer.parseInt(txtMoeda100.getText()));
					caixa.setNotas2(Integer.parseInt(txtNota2.getText())); 
					caixa.setNotas5(Integer.parseInt(txtNota5.getText()));
					caixa.setNotas10(Integer.parseInt(txtNota10.getText()));
					caixa.setNotas20(Integer.parseInt(txtNota20.getText()));
					caixa.setNotas50(Integer.parseInt(txtNota50.getText()));
					caixa.setNotas100(Integer.parseInt(txtNota100.getText()));
					caixa.setTotalCaixa();
					CaixaControl cc = new CaixaControl();
					cc.AbrirCaixa(caixa, ui);
					setVisible(false);
				}
			}
		});
		btnAbrirCaixa.setBounds(182, 212, 195, 23);
		panel.add(btnAbrirCaixa);
		
		setVisible(true);
	}

}
