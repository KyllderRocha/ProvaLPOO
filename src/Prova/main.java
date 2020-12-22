package Prova;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Conta> contas = new ArrayList();
		int op = -1;
		while (op!=0) {
			System.out.println("1. Cadastrar Conta ou Poupança (Pergunte aos clientes o que ele quer cadastrar)");
			System.out.println("2. Realizar depósito (Buscar pelo CPF do cliente)");
			System.out.println("3. Render Juros (Buscar pelo CPF do cliente)");
			System.out.println("4. Consultar número e nome da agência (Mostrar nome e o CPF do cliente)");
			System.out.println("5. Alterar o número e nome da agência (Buscar pelo nome do cliente)");
			System.out.println("0. Sair");
			op=sc.nextInt();
			switch (op) {
			case 1:
				CadastrarConta(sc, contas);
				break;
			case 2:
				Depositar(sc, contas);
				break;
			case 3:
				RenderJuros(sc, contas);
				break;
			case 4:
				Consultar(sc, contas);
				break;
			case 5:
				Alterar(sc, contas);
				break;
				
			default:
				op=0;
				System.out.println("Tchau");
				break;
			}
		}
		
	}
	
	public static void CadastrarConta(Scanner sc, ArrayList<Conta> contas) {
		System.out.println("Digite a agência do Banco: ");
		int agencia = sc.nextInt();
		System.out.println("Digite o nome do Banco: ");
		sc.nextLine();
		String nomeBanco = sc.nextLine();
		System.out.println("Digite o nome do Cliente: ");
		String nomeCliente = sc.nextLine();
		System.out.println("Digite o CPF do Cliente: ");
		String cpfCliente = sc.nextLine();
		Banco banco = new Banco(agencia, nomeBanco);
		Cliente cliente = new Cliente(nomeCliente, cpfCliente);
		System.out.println("Digite o número da conta a ser cadastrada: ");
		int numeroConta = sc.nextInt();
		System.out.println("Digite o saldo da conta a ser cadastrada: ");
		double saldoConta = sc.nextDouble();
		System.out.println("1. Cadastrar Conta");
		System.out.println("2. Cadastrar Poupança");
		int op = sc.nextInt();
		if(op==1) {
			contas.add(new Conta(numeroConta, banco, cliente, saldoConta));
		}else if(op==2) {
			System.out.println("Digite o juros da conta poupança: ");
			double juros = sc.nextDouble();
			contas.add(new ContaPoupanca(numeroConta, banco, cliente, saldoConta, juros));
		}else {
			System.out.println("Opção inválida!");
		}
	}
	
	public static void Depositar(Scanner sc, ArrayList<Conta> contas) {
		double valor=0;
		String cpf ="";
		System.out.println("Digite o cpf: ");
		cpf = sc.next();
		System.out.println("Digite o valor a depositar: ");
		valor = sc.nextDouble();
		for (Conta conta : contas) {
			if(conta.getCliente().getCpf().equals(cpf)) {
				conta.setSaldo(conta.getSaldo()+valor);
				System.out.println("Valor depositado com sucesso!");
				System.out.println("Saldo atual: "+conta.getSaldo());
				return;
			}
		}
		System.out.println("Erro no deposito!");
		
	}
	
	public static void RenderJuros(Scanner sc, ArrayList<Conta> contas) {
		String cpf ="";
		System.out.println("Digite o cpf: ");
		cpf = sc.next();
		for (Conta conta : contas) {
			if(conta.getCliente().getCpf().equals(cpf)) {
				ContaPoupanca cp = new ContaPoupanca();
				if (conta instanceof ContaPoupanca) {
					cp = (ContaPoupanca) conta;
				}
				System.out.println("Juros é: "+cp.getJuros());
				conta.setSaldo(conta.getSaldo()*(1+cp.getJuros()));
				System.out.println("Juros aplicado com sucesso!");
				System.out.println("Saldo atual: "+conta.getSaldo());
				return;
			}
		}
		System.out.println("Erro no juros!");
		
	}
	
	public static void Consultar(Scanner sc, ArrayList<Conta> contas) {
		System.out.println("Digite o numero: ");
		int num = sc.nextInt();
		System.out.println("Digite a agencia: ");
		String agen = sc.next();
		for (Conta conta : contas) {
			if(conta.getBanco().getNumero()==num && conta.getBanco().getNome().equals(agen)) {
				System.out.println("Nome cliente: "+conta.getCliente().getNome());
				System.out.println("Nome cpf: "+conta.getCliente().getCpf());
				return;
			}
		}
		System.out.println("Conta não achada!");
	}
	
	public static void Alterar(Scanner sc, ArrayList<Conta> contas) {
		System.out.println("Digite o nome do Cliente: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.println("Digite o novo numero da agencia: ");
		int num = sc.nextInt();
		System.out.println("Digite o novo nome do Banco: ");
		sc.nextLine();
		String agen = sc.nextLine();
		for (Conta conta : contas) {
			if(conta.getCliente().getNome().equals(nome)) {
				conta.getBanco().setNome(agen);
				conta.getBanco().setNumero(num);
				return;
			}
		}
		System.out.println("Conta não achada!");
	}


}
