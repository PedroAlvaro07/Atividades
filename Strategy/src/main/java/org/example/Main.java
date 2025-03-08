package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha um método de pagamento:");
        System.out.println("1: Pix");
        System.out.println("2: Cartão de Crédito");
        System.out.println("3: Boleto");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();
        System.out.print("Digite o valor da transação: R$");
        double amount = scanner.nextDouble();

        PaymentStrategy strategy = null;

        switch (opcao) {
            case 1:
                strategy = new PixPayment();
                break;
            case 2:
                strategy = new CreditCardPayment();
                break;
            case 3:
                strategy = new BoletoPayment();
                break;
            default:
                System.out.println("Opção inválida!");
        }

        PaymentProcessor processar = new PaymentProcessor(strategy);
        processar.executar(amount);


    }
}