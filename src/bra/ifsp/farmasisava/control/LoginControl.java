package bra.ifsp.farmasisava.control;
import bra.ifsp.farmasisava.model.Usuario;
import bra.ifsp.farmasisava.view.DefaultUI;
import javax.swing.JFrame;

import bra.ifsp.farmasisava.bd.JDBCUsuarioDao;
public class LoginControl {
	public boolean doLogin(Usuario usuario, JFrame frmLogin) {
		JDBCUsuarioDao ud = new JDBCUsuarioDao();
		boolean result = ud.doLogin(usuario);
		if (result) {
			new DefaultUI(usuario);
			frmLogin.setVisible(false);
		}
		return result;
	}
}
