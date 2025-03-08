package org.example;

import java.util.Scanner;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do cartão: ");
        String cardNumber = scanner.nextLine();
        System.out.println("Pagamento de R$" + amount + " processado com sucesso no cartão " + cardNumber);
    }
}
