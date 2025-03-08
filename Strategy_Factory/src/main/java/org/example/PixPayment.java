package org.example;

import java.util.Random;

public class PixPayment implements PaymentStrategy{


    @Override
    public void processPayment(double amount) {
        String pixCodigo = "PIX-" + new Random().nextInt(100000);
        System.out.println("Pagamento via Pix processado.");
        System.out.println("Código Pix: " + pixCodigo);
    }
}
