package org.example;

public class PaymentFactory {
    public static PaymentStrategy createPayment(String type) {
        switch (type.toLowerCase()) {
            case "pix":
                return new PixPayment();
            case "cartao":
                return new CreditCardPayment();
            case "boleto":
                return new BoletoPayment();
            default:
                throw new IllegalArgumentException("Método de pagamento inválido!");
        }
    }
}
