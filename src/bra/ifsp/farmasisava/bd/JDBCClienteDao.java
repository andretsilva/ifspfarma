package bra.ifsp.farmasisava.bd;
import bra.ifsp.farmasisava.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;


public class JDBCClienteDao implements ClienteDao{
	
		public void CadastrarCliente(Cliente cliente) {
			Connection conexao = 
					ConnectionFactory.createConnection();
			try {
				
				String sql = "INSERT INTO CLIENTESESPECIAIS (nome,telefone,cpf,endereco,cidade,uf,bairro,CEP,dataNascimento)"
						+ " VALUES(?,?,?,?,?,?,?,?,?)" ;
				PreparedStatement comando = 
						conexao.prepareStatement(sql);
				
				comando.setString(1,cliente.getNome());
				comando.setString(2,cliente.getTelefone());
				comando.setString(3,cliente.getCpf());
				comando.setString(4,cliente.getEndereco());
				comando.setString(5,cliente.getCidade());
				comando.setString(6,cliente.getUf());
				comando.setString(7,cliente.getBairro());
				comando.setString(8,cliente.getCEP());
				
				
				Date myDate = cliente.getDataNascimento();
				java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
				comando.setDate(9,sqlDate);
				
				comando.execute();
				conexao.close();
			}  catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public ArrayList<Cliente> obterClientes() {
			
			try {
				
				Connection conexao = ConnectionFactory.createConnection();
				
				String sql = "SELECT * FROM clientesespeciais;";
				
				PreparedStatement comando = conexao.prepareStatement(sql);
				
				
				ResultSet resultado = comando.executeQuery();
				
				ArrayList<Cliente> listaClientes = 
						new ArrayList<Cliente>();
				
				
				while (resultado.next()) {				
					Cliente c = new Cliente();
					c.setIdCliente(resultado.getInt("idCliente"));
					c.setNome(resultado.getString("nome"));
					c.setEndereco(resultado.getString("endereco"));
					c.setBairro(resultado.getString("bairro"));
					c.setCidade(resultado.getString("cidade"));
					c.setUf(resultado.getString("uf"));
					c.setTelefone(resultado.getString("telefone"));
					c.setDataNascimento(resultado.getDate("dataNascimento"));
					c.setCEP(resultado.getString("CEP"));
					c.setCpf(resultado.getString("CPF"));
					
					listaClientes.add(c);
				}
				
				
				conexao . close ();
				
				return listaClientes;
				
			} catch ( Exception e) {
				e. printStackTrace ();
				return null;
			}
		}
		
		public void AlterarCliente(Cliente cliente) {
			Connection conexao = 
					ConnectionFactory.createConnection();
			try {
				
				String sql = "UPDATE CLIENTESESPECIAIS set nome=?,telefone=?,endereco=?,cidade=?,uf=?,bairro=?,CEP=?,dataNascimento=? WHERE cpf = ?";
						
				PreparedStatement comando = 
						conexao.prepareStatement(sql);
				
				comando.setString(1,cliente.getNome());
				comando.setString(2,cliente.getTelefone());
				comando.setString(3,cliente.getEndereco());
				comando.setString(4,cliente.getCidade());
				comando.setString(5,cliente.getUf());
				comando.setString(6,cliente.getBairro());
				comando.setString(7,cliente.getCEP());
				
				
				
				Date myDate = cliente.getDataNascimento();
				java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
				comando.setDate(8,sqlDate);
				comando.setString(9,cliente.getCpf());
				comando.execute();
				conexao.close();
			}  catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public Cliente obterCliente(String cpf) {
			
			try {
				
				Connection conexao = ConnectionFactory.createConnection();
				
				String sql = "SELECT * FROM clientesespeciais WHERE cpf = ?;";
				
				PreparedStatement comando = conexao.prepareStatement(sql);
				
				comando.setString(1, cpf);
				
				ResultSet resultado = comando.executeQuery();
				Cliente c = new Cliente();
								
				if (resultado.next()) {				
					
					c.setIdCliente(resultado.getInt("idCliente"));
					c.setNome(resultado.getString("nome"));
					c.setEndereco(resultado.getString("endereco"));
					c.setBairro(resultado.getString("bairro"));
					c.setCidade(resultado.getString("cidade"));
					c.setUf(resultado.getString("uf"));
					c.setTelefone(resultado.getString("telefone"));
					c.setDataNascimento(resultado.getDate("dataNascimento"));
					c.setCEP(resultado.getString("CEP"));
					c.setCpf(resultado.getString("CPF"));
										
				}
				
				
				conexao . close ();
				
				return c;
				
			} catch ( Exception e) {
				e. printStackTrace ();
				return null;
			}
		}


}




