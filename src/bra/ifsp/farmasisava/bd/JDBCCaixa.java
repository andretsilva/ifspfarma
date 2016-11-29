package bra.ifsp.farmasisava.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Calendar;
import java.util.Date;

import bra.ifsp.farmasisava.model.Caixa;


public class JDBCCaixa implements CaixaDao{
	public boolean LoginAbertura(String password) {
		
		try {
			Connection conexao = 
					ConnectionFactory.createConnection();
			String sql = "SELECT * FROM opcoesAdm where option_name = 'senhaAbertura' AND option_value = MD5(?)" ;
			PreparedStatement comando = 
					conexao.prepareStatement(sql);
			
			comando.setString(1,password);
			
			ResultSet resultado = comando.executeQuery();
			
			if(resultado.next()) {
				conexao.close();
				return true;
			}
			conexao.close();
			return false;
			
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean LoginFechamento(String password) {
		
		try {
			Connection conexao = 
					ConnectionFactory.createConnection();
			String sql = "SELECT * FROM opcoesAdm where option_name = 'senhaFechamento' AND option_value = MD5(?)" ;
			PreparedStatement comando = 
					conexao.prepareStatement(sql);
			
			comando.setString(1,password);
			
			ResultSet resultado = comando.executeQuery();
			
			if(resultado.next()) {
				conexao.close();
				return true;
			}
			conexao.close();
			return false;
			
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public int AbreCaixa(Caixa caixa) {
		int idVenda=0;
		try {
			
			Connection conexao = 
					ConnectionFactory.createConnection();
			String sql = "INSERT INTO caixa (dataHoraAbertura,nota2,nota5,nota10,nota20,nota50,nota100,moeda5,moeda10,moeda25,moeda50,moeda100)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)" ;
			PreparedStatement comando = 
					conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			Calendar cal = Calendar.getInstance();
		
			Date myDate = cal.getTime();
			java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
			comando.setDate(1, sqlDate, cal);
			comando.setInt(2, caixa.getNotas2());
			comando.setInt(3, caixa.getNotas5());
			comando.setInt(4, caixa.getNotas10());
			comando.setInt(5, caixa.getNotas20());
			comando.setInt(6, caixa.getNotas50());
			comando.setInt(7, caixa.getNotas100());
			comando.setInt(8, caixa.getMoedas5());
			comando.setInt(9, caixa.getMoedas10());
			comando.setInt(10, caixa.getMoedas25());
			comando.setInt(11, caixa.getMoedas50());
			comando.setInt(12, caixa.getMoedas100());
			
			comando.executeUpdate();
			ResultSet rs = comando.getGeneratedKeys();

			if (rs.next()) {
			    idVenda = rs.getInt(1);
				}
			
			conexao.close();
			return idVenda;
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return idVenda;
	}
	
	
	public void FechaCaixa(Caixa caixa) {
		try {
			
			Connection conexao = 
					ConnectionFactory.createConnection();
			String sql = "UPDATE caixa set dataHoraFechamento=?, valorFinal=? WHERE idCaixa = ?" ;
			PreparedStatement comando = 
					conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			Calendar cal = Calendar.getInstance();
		
			Date myDate = cal.getTime();
			java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
			comando.setDate(1, sqlDate, cal);
			comando.setDouble(2, caixa.getTotalCaixa());
			comando.setInt(3, caixa.getIdCaixa());
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int ObterNumeroDeVendas() {
		int total =0;
		try {
				
			Connection conexao = 
					ConnectionFactory.createConnection();
			String sql = "SELECT COUNT(*) FROM vendasefetuadas where dataHoraVenda = ?" ;
			PreparedStatement comando = 
					conexao.prepareStatement(sql);
			Calendar cal = Calendar.getInstance();
			Date myDate = cal.getTime();
			java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
			comando.setDate(1, sqlDate);
			
			ResultSet resultado = comando.executeQuery();
			
			if(resultado.next()) {
				total = resultado.getInt(1);
			}
			conexao.close();
			return total;
			
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		
		return total;
	}
}
