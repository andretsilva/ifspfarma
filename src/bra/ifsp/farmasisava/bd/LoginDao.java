package bra.ifsp.farmasisava.bd;
import bra.ifsp.farmasisava.model.Usuario;

public interface LoginDao {
	public boolean doLogin(Usuario usuario);
}
