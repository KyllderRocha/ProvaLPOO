package Prova;

public class ContaPoupanca extends Conta{
	private double juros;
	
	public ContaPoupanca() {
		
	}
	
	public ContaPoupanca(int numero, Banco banco, Cliente cliente, double saldo, double juros) {
		super(numero, banco, cliente, saldo);
		this.juros = juros;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}
	
}
