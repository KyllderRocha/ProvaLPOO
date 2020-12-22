package Prova;

public class Conta {
	private int numero;
	private Banco banco;
	private Cliente cliente;
	private double saldo;
	
	public Conta() {
		
	}
	
	public Conta(int numero, Banco banco, Cliente cliente, double saldo) {
		this.numero = numero;
		this.banco = banco;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}
