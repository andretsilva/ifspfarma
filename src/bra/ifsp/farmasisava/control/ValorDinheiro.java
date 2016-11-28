package bra.ifsp.farmasisava.control;

public class ValorDinheiro implements ValorStrategy{
	
	private double valor;
	public ValorDinheiro(double valor) {
		this.valor = valor*0.95;
	}
	@Override
	public double getValorDesconto() {
		// TODO Auto-generated method stub
		return valor;
	}
	
	
	
}
