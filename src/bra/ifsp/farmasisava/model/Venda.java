package bra.ifsp.farmasisava.model;

import java.util.Calendar;


public class Venda {
	private int idVenda;
	private double valorVenda;
	private Calendar dataVenda;
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public Calendar getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda() {
		this.dataVenda = Calendar.getInstance() ; 
	}
	
}
