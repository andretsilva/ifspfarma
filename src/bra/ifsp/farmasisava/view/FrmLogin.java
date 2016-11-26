package bra.ifsp.farmasisava.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import bra.ifsp.farmasisava.control.LoginControl;
import bra.ifsp.farmasisava.model.Usuario;

class FrmLogin {
	public static void main(String[] args) {
		// Criação e estilização do JFrame
		JFrame frmLogin = new JFrame("Login - FarmasisAVA");
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setSize(400,230);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.setResizable(false);
		
		//Criação e estilização do Panel Principal
		JPanel panel = new JPanel();
		ImageIcon img = new ImageIcon(frmLogin.getClass().getResource("/logo-farmacia.png"));
		JLabel imageLabel = new JLabel(img);
		
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel loginLabel = new JLabel("Login:");
		JLabel pwdLabel = new JLabel("Senha:");
		JTextField txtLogin = new JTextField(7);
		JPasswordField pwdLogin = new JPasswordField(7);
		JButton btnLogin = new JButton(" Entrar ");
		
		
		
		//Criação do Panel do Login
		JPanel panelLogin = new JPanel();
		panelLogin.add(loginLabel);
		panelLogin.add(txtLogin);
		panelLogin.add(pwdLabel);
		panelLogin.add(pwdLogin);
		panelLogin.add(btnLogin);
		panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));
		panelLogin.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0,0,0,0), new EtchedBorder()));
		panel.add(imageLabel);
		panel.add(panelLogin);
		frmLogin.setContentPane(panel);
		
		
		btnLogin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				String senha = new String (pwdLogin.getPassword());
				usuario.setPwd(senha);
				usuario.setLogin(txtLogin.getText());
				LoginControl lc = new LoginControl();				
				if (!lc.doLogin(usuario,frmLogin)) {
					 JOptionPane.showMessageDialog(null, "Login ou Senha Inválidos", "Erro!",
                             JOptionPane.ERROR_MESSAGE);
				}

			}
			
		});
		//Mostra o JForm, na ultima linha pra não bugar...
		frmLogin.setVisible(true);
	
		
	}

}
