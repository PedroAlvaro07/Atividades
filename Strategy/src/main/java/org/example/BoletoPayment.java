package org.example;

import java.util.Random;

public class BoletoPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        String codigo = "BOLETO-" + new Random().nextInt(100000);
        System.out.println("Pagamento via Boleto gerado.");
        System.out.println("Código do Boleto: " +  codigo);

    }
}
