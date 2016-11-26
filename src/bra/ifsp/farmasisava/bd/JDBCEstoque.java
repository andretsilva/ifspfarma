package bra.ifsp.farmasisava.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bra.ifsp.farmasisava.control.MedicamentoControl;
import bra.ifsp.farmasisava.model.Estoque;
import bra.ifsp.farmasisava.model.Medicamento;

public class JDBCEstoque {
	public Estoque obterEstoque(String codigoBarras) {
		Medicamento medicamento = new Medicamento();
		MedicamentoControl mc = new MedicamentoControl();
		medicamento = mc.obterMedicamento(codigoBarras);
		Estoque estoque = new Estoque();
		Connection conexao = 
				ConnectionFactory.createConnection();
		try {
			
			String sql = "SELECT * from estoque where idMedicamento = ?" ;
			PreparedStatement comando = 
					conexao.prepareStatement(sql);
			comando.setInt(1,medicamento.getIdMedicamento());		
			ResultSet resultado = comando.executeQuery();
			int i = 0;
			if(resultado.next()) {
				estoque.setIdEstoque(resultado.getInt("idEstoque"));
				estoque.setQuantidade(resultado.getInt("quantidade"));
				i++;
			} else {
				if(i==0){
				String sqlInsert = "INSERT INTO ESTOQUE(idMedicamento,quantidade) values(?,?)";
				PreparedStatement comandoInsert = 
						conexao.prepareStatement(sqlInsert);
				comandoInsert.setInt(1,medicamento.getIdMedicamento());
				comandoInsert.setInt(2, 0);
				comandoInsert.execute();
				conexao.close();
				System.out.println(medicamento.getIdMedicamento());
				i++;
				}
				//obterEstoque(codigoBarras);
				
			}
			conexao.close();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return estoque;
	}
	
}
