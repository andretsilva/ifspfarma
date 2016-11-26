package bra.ifsp.farmasisava.model;

public class Caixa {
	private int idCaixa;
	private int notas2;
	private int notas5;
	private int notas10;
	private int notas20;
	private int notas50;
	private int notas100;
	private int moedas5;
	private int moedas10;
	private int moedas25;
	private int moedas50;
	private int moedas100;
	private double totalCaixa;
	private boolean caixaAberto = false;

	public int getNotas2() {
		return notas2;
	}

	public void setNotas2(int notas2) {
		this.notas2 = notas2;
	}

	public int getNotas5() {
		return notas5;
	}

	public void setNotas5(int notas5) {
		this.notas5 = notas5;
	}

	public int getNotas10() {
		return notas10;
	}

	public void setNotas10(int notas10) {
		this.notas10 = notas10;
	}

	public int getNotas20() {
		return notas20;
	}

	public void setNotas20(int notas20) {
		this.notas20 = notas20;
	}

	public int getNotas50() {
		return notas50;
	}

	public void setNotas50(int notas50) {
		this.notas50 = notas50;
	}

	public int getNotas100() {
		return notas100;
	}

	public void setNotas100(int notas100) {
		this.notas100 = notas100;
	}

	public int getMoedas5() {
		return moedas5;
	}

	public void setMoedas5(int moedas5) {
		this.moedas5 = moedas5;
	}

	public int getMoedas10() {
		return moedas10;
	}

	public void setMoedas10(int moedas10) {
		this.moedas10 = moedas10;
	}

	public int getMoedas25() {
		return moedas25;
	}

	public void setMoedas25(int moedas25) {
		this.moedas25 = moedas25;
	}

	public int getMoedas50() {
		return moedas50;
	}

	public void setMoedas50(int moedas50) {
		this.moedas50 = moedas50;
	}

	public int getMoedas100() {
		return moedas100;
	}

	public void setMoedas100(int moedas100) {
		this.moedas100 = moedas100;
	}
	
	public double getTotalCaixa() {
		return totalCaixa;
	}
	
	public void setTotalCaixa() {
		this.totalCaixa = notas2*2 + notas5*5 + notas10 * 10 + notas20 * 20 + notas50*50 + notas100*100 + moedas5 * 0.05 + moedas10*0.10 + 
				moedas25*0.25 + moedas50*0.5 +moedas100;
	}
	
	public void somaTotalCaixa(double dinheiro) {
		this.totalCaixa = this.totalCaixa + dinheiro;
	}

	public boolean isCaixaAberto() {
		return caixaAberto;
	}

	public void setCaixaAberto(boolean caixaAberto) {
		this.caixaAberto = caixaAberto;
	}

	public int getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}
	
	
}
