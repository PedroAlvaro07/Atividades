package org.example;

public class Carro extends Veiculo{

    public String tipoCarro;

    public Carro(String marca, String modelo, int ano, int quantidadePassageiros, String combustivel, String tipoCarro) {
        super(marca, modelo, ano, quantidadePassageiros, combustivel);
        this.tipoCarro = tipoCarro;
    }

    @Override
    public double calcularAutonomia(){
        return 50 * 12;
    }
}
