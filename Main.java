import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco(); // Instanciando a classe Banco

        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Loop principal
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumindo a quebra de linha

            switch (opcao) {
                case 1:
                    banco.exibirInformacoes();
                    break;
                case 2:
                    System.out.print("Informe o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    banco.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Informe o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    banco.sacar(valorSaque);
                    break;
                case 4:
                    System.out.println("Encerrando a aplicação.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    // Método para exibir o menu
    private static void exibirMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Realizar depósito");
        System.out.println("3. Realizar saque");
        System.out.println("4. Encerrar");
        System.out.print("Escolha uma opção: ");
    }
}

class Banco {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    // Construtor
    public Banco() {
        // Aqui você pode inicializar os valores iniciais do banco
        this.saldo = 0;
    }

    // Método para exibir as informações do cliente e saldo
    public void exibirInformacoes() {
        System.out.println("\n=== Informações do Cliente ===");
        System.out.println("Nome: " + nome);
        System.out.println("Sobrenome: " + sobrenome);
        System.out.println("CPF: " + cpf);
        System.out.println("Saldo: R$" + saldo);
    }

    // Método para realizar um depósito
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    // Método para realizar um saque
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }
}
