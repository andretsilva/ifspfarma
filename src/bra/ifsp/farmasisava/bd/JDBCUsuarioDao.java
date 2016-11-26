package bra.ifsp.farmasisava.bd;
import bra.ifsp.farmasisava.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBCUsuarioDao implements LoginDao {
	public boolean doLogin(Usuario usuario) {
	
		try {
			Connection conexao = 
					ConnectionFactory.createConnection();
			String sql = "SELECT * FROM FUNCIONARIO WHERE login=? AND pwd = MD5(?);" ;
			PreparedStatement comando = 
					conexao.prepareStatement(sql);
			comando.setString(1, usuario.getLogin());
			comando.setString(2, usuario.getPwd());
			
			ResultSet resultado = comando.executeQuery();
			boolean result = resultado.next();
			
			conexao.close();
			
			return result;
		}  catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
		return false;
	}
	
}
