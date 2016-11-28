package bra.ifsp.farmasisava.control;

public class ValorCartao implements ValorStrategy {
	private double valor;
	public ValorCartao(double valor) {
		this.valor = valor;
	}
	@Override
	public double getValorDesconto() {
		// TODO Auto-generated method stub
		return valor;
	}
	
}
