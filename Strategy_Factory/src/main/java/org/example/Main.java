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
        scanner.nextLine();

        System.out.print("Digite o valor da transação: ");
        double amount = scanner.nextDouble();

        PaymentStrategy paymentStrategy = null;

        switch (opcao) {
            case 1:
                paymentStrategy = PaymentFactory.createPayment("pix");
                break;
            case 2:
                paymentStrategy = PaymentFactory.createPayment("cartao");
                break;
            case 3:
                paymentStrategy = PaymentFactory.createPayment("boleto");
                break;
            default:
                System.out.println("Opção inválida!");
                System.exit(0);
        }

        PaymentProcessor processor = new PaymentProcessor(paymentStrategy);
        processor.process(amount);
    }
}