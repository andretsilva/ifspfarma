package bra.ifsp.farmasisava.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;


import bra.ifsp.farmasisava.model.Cliente;
import bra.ifsp.farmasisava.model.ItemVenda;
import bra.ifsp.farmasisava.model.Venda;

public class JDBCVenda implements VendaDao {
	public void RealizarPagamento(Venda venda, ArrayList<ItemVenda> itens, String metodoPagamento, Cliente cliente) {
		
		try {
			Connection conexao = 
					ConnectionFactory.createConnection();
			String sql = "INSERT INTO vendasefetuadas (valorVenda, cpfCliente, dataHoraVenda)"
					+ " VALUES(?,?,?)" ;
			PreparedStatement comando = 
					conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			comando.setDouble(1,venda.getValorVenda());
			comando.setString(2,cliente.getCpf());
			
			
			Date myDate = venda.getDataVenda().getTime();
			java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
			comando.setDate(3, sqlDate);
			comando.executeUpdate();
			ResultSet rs = comando.getGeneratedKeys();

			if (rs.next()) {
			    int idVenda = rs.getInt(1);
			
				String sql2;
				String sql3;/*string para dar baixa na quantidade do estoque*/
				PreparedStatement comando2;
				PreparedStatement comando3;
				for (ItemVenda item : itens) {
				 sql2 = "Insert INTO itensvendidos (idVenda,idMedicamento,quantidade) Values(?,?,?)";
				 comando2 = conexao.prepareStatement(sql2);
					comando2.setInt(1,idVenda);
					comando2.setInt(2,item.getMedicamento().getIdMedicamento());
					comando2.setInt(3,item.getQuantidade());
				comando2.execute();
				sql3 = "UPDATE estoque SET quantidade = estoque.quantidade - ? WHERE estoque.idMedicamento = ?";
				comando3 = conexao.prepareStatement(sql3);
				comando3.setInt(1, item.getQuantidade());
				comando3.setInt(2, item.getMedicamento().getIdMedicamento());
				comando3.execute();
				}
			}
			
			conexao.close();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
