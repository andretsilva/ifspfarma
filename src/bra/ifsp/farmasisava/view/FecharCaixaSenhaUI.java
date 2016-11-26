package bra.ifsp.farmasisava.view;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bra.ifsp.farmasisava.control.CaixaControl;
import bra.ifsp.farmasisava.model.Caixa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FecharCaixaSenhaUI extends JFrame {
	JPanel contentPane;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7716658270025258635L;
	private JPasswordField passwordField;


	/**
	 * Create the frame.
	 */
	public FecharCaixaSenhaUI(Caixa caixa, DefaultUI ui ) {
		setTitle("Fechar Caixa");
		setBounds(100, 100, 411, 111);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDigiteASenha = new JLabel("Digite a senha de fechamento do caixa");
		lblDigiteASenha.setBounds(10, 11, 186, 14);
		panel.add(lblDigiteASenha);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaixaControl cc = new CaixaControl();
				String password = new String (passwordField.getPassword());
				if (cc.LoginAbertura(password)) {
					new FecharCaixaUI(caixa, ui);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Senha Incorreta", "Erro!",
                            JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnContinuar.setBounds(261, 31, 114, 23);
		panel.add(btnContinuar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 35, 243, 20);
		panel.add(passwordField);
		setVisible(true);
	}

}
