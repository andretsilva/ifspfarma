package bra.ifsp.farmasisava.bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import bra.ifsp.farmasisava.model.Medicamento;

public class JDBCMedicamentoDao implements MedicamentoDao {
	public void CadastrarMedicamento(Medicamento medicamento) {
	
			Connection conexao = 
					ConnectionFactory.createConnection();
			try {
				
				String sql = "INSERT INTO medicamentos (nome,fabricante,codigoBarras,preco)"
						+ " VALUES(?,?,?,?)" ;
				PreparedStatement comando = 
						conexao.prepareStatement(sql);
				
				comando.setString(1,medicamento.getNome());
				comando.setString(2,medicamento.getFabricante());
				comando.setString(3,medicamento.getCodigoBarras());
				comando.setDouble(4,medicamento.getPreco());
			
				
				comando.execute();
				conexao.close();
			}  catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	

		public Set<Medicamento> ObterMedicamentos() {
			
			try {
				
				Connection conexao = ConnectionFactory.createConnection();
				
				String sql = "SELECT * FROM medicamentos;";
				
				PreparedStatement comando = conexao.prepareStatement(sql);
				
				
				ResultSet resultado = comando.executeQuery();
				
				Set<Medicamento> listaMedicamentos = 
						new HashSet<Medicamento>();
				
			
				while (resultado.next()) {				
					Medicamento c = new Medicamento();
					c.setCodigoBarras(resultado.getString("codigoBarras"));
					c.setIdMedicamento(resultado.getInt("idMedicamento"));
					c.setNome(resultado.getString("nome"));
					c.setFabricante(resultado.getString("fabricante"));
					c.setPreco(resultado.getDouble("preco"));
					listaMedicamentos.add(c);
				}
				
				conexao.close();
				
				return listaMedicamentos;
				
			} catch ( Exception e) {
				e. printStackTrace ();
				return null;
			}
		}
		
		public Medicamento ObterMedicamento(String codigoBarras) throws Exception {
			
			try {
				
				Connection conexao = ConnectionFactory.createConnection();
				
				String sql = "SELECT * FROM medicamentos WHERE codigoBarras = ?;";
				
				PreparedStatement comando = conexao.prepareStatement(sql);
				comando.setString(1, codigoBarras);
				
				ResultSet resultado = comando.executeQuery();

				
				Medicamento c = new Medicamento();
				if (resultado.next()) {				
					c.setCodigoBarras(resultado.getString("codigoBarras"));
					c.setIdMedicamento(resultado.getInt("idMedicamento"));
					c.setNome(resultado.getString("nome"));
					c.setPreco(resultado.getDouble("preco"));
					conexao.close ();
					return c;
				} else {
					Exception error = new Exception("erro");
					
					throw error;
				}
				
				
				
			} catch ( Exception e) {
				return null;
			}
		}
		
		public void AtualizarMedicamento(Medicamento medicamento) {
			
			Connection conexao = 
					ConnectionFactory.createConnection();
			try {
				
				String sql = "UPDATE medicamentos SET nome=?,fabricante=?,preco=? WHERE codigoBarras =?";
				PreparedStatement comando = 
						conexao.prepareStatement(sql);
				
				comando.setString(1,medicamento.getNome());
				comando.setString(2,medicamento.getFabricante());
				comando.setDouble(3,medicamento.getPreco());
				comando.setString(4,medicamento.getCodigoBarras());
			
				
				comando.execute();
				conexao.close();
			}  catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
