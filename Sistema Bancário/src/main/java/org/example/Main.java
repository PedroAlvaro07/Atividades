package org.example;

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaCorrente(123, "João", 1000, 500);
        ContaBancaria conta2 = new ContaPoupanca(456, "Maria", 2000);
        ContaBancaria conta3 = new ContaInvestimento(789, "Carlos", 5000);
        ContaBancaria conta4 = new ContaSalario(147, "Ana", 3000, 500);
        ContaBancaria conta5 = new ContaInvestimentoAltoRisco(258, "Pedro", 15000);

        conta1.sacar(1200);
        conta2.sacar(2500);
        conta3.sacar(1000);
        conta4.sacar(500);
        conta5.sacar(11000);

        conta1.exibirInformacoes();
        conta2.exibirInformacoes();
        conta3.exibirInformacoes();
        conta4.exibirInformacoes();
        conta5.exibirInformacoes();
    }
}