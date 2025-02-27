package org.example;

public class ContaCorrente extends ContaBancaria {
    private double chequeEspecial;

    public ContaCorrente(int numeroConta, String titular, double saldo, double chequeEspecial) {
        super(numeroConta, titular, saldo);
        this.chequeEspecial = this.chequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (saldo + chequeEspecial >= valor) {
            saldo -= valor;
            System.out.println("Saque Realizado");
            System.out.println("Saldo atual: " + saldo);
        }else{
            System.out.println("O Valor do saque excedeu o saldo atual e o limete de se Cheque Especial!");
        }
    }
}
