package org.example;

public class ContaSalario extends ContaCorrente{
    private int saquesGratuitos = 1;

    public ContaSalario(int numeroConta, String titular, double saldo, double chequeEspecial) {
        super(numeroConta, titular, saldo, chequeEspecial);
    }

    @Override
    public void sacar(double valor) {
        if (saquesGratuitos > 0) {
            saquesGratuitos--;
            super.sacar(valor);
        } else {
            super.sacar(valor + 5);
        }
    }

}
