package bra.ifsp.farmasisava.control;

public class ValorIdoso implements ValorStrategy {
	private double valor;
	public ValorIdoso(double valor) {
		this.valor = valor*0.80;
	}
	@Override
	public double getValorDesconto() {
		// TODO Auto-generated method stub
		return valor;
	}
	

}
