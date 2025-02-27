package org.example;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(int numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        if(saldo >= valor){
            saldo -= valor;
            System.out.println("Saque Realizado");
            System.out.println("Saldo atual: " + saldo);
        }else{
            System.out.println("O Valor do saque excedeu o seu saldo atual");
        }
    }
}
