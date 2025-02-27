package org.example;

public class ContaInvestimento extends ContaBancaria {
    public ContaInvestimento(int numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        double taxa = valor * 0.02;
        if (saldo >= (valor + taxa)) {
            saldo -= (valor + taxa);
            System.out.println("Saque Realizado");
            System.out.println("Saldo atual: " + saldo);
        }else{
            System.out.println("O Valor do saque excedeu o seu saldo atual");
        }
    }
}
