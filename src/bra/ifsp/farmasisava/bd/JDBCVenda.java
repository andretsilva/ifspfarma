package bra.ifsp.farmasisava.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;


import bra.ifsp.farmasisava.model.Cliente;
import bra.ifsp.farmasisava.model.ItemVenda;
import bra.ifsp.farmasisava.model.Venda;

public class JDBCVenda {
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
				PreparedStatement comando2;
				for (ItemVenda item : itens) {
				 sql2 = "Insert INTO itensvendidos (idVenda,idMedicamento,quantidade) Values(?,?,?)";
				 comando2 = conexao.prepareStatement(sql2);
					comando2.setInt(1,idVenda);
					comando2.setInt(2,item.getMedicamento().getIdMedicamento());
					comando2.setInt(3,item.getQuantidade());
				comando2.execute();
				}
			}
			
			conexao.close();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
