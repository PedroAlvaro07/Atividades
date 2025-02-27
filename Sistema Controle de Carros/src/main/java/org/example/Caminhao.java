package org.example;

public class Caminhao extends Veiculo{

    public int capacidadeCarga;

    public Caminhao(String marca, String modelo, int ano, int quantidadePassageiros, String combustivel, int capacidadeCarga) {
        super(marca, modelo, ano, quantidadePassageiros, combustivel);
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public double calcularAutonomia(){
        int consumoBase = 6;
        double reducao = Math.min(capacidadeCarga * 0.01, 0.25);
        double consumoFinal = consumoBase * (1 - reducao);
        return 300 * consumoFinal;
    }
}
