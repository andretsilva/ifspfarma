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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AbrirCaixaSenhaUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4898544834445654880L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Create the frame.z
	 */
	public AbrirCaixaSenhaUI(Caixa caixa, DefaultUI ui) {
		
		setTitle("Abrir Caixa");
		setBounds(100, 100, 317, 123);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDigiteASenha = new JLabel("DIGITE A SENHA DE ABERTURA DO CAIXA");
		lblDigiteASenha.setBounds(10, 11, 273, 14);
		panel.add(lblDigiteASenha);
		
		JButton btnAbrir = new JButton("ABRIR");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CaixaControl cc = new CaixaControl();
				String password = new String (passwordField.getPassword());
				if (cc.LoginAbertura(password)) {
					new AbrirCaixaUI(caixa, ui);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Senha Incorreta", "Erro!",
                            JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		
		btnAbrir.setBounds(160, 35, 107, 23);
		panel.add(btnAbrir);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 36, 140, 20);
		panel.add(passwordField);
		
		setVisible(true);
	}
}
