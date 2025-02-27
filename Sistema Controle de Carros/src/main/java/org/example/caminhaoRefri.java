package org.example;

public class caminhaoRefri extends Caminhao{

    public int temperatura;

    public caminhaoRefri(String marca, String modelo, int ano, int quantidadePassageiros, String combustivel, int capacidadeCarga, int temperatura) {
        super(marca, modelo, ano, quantidadePassageiros, combustivel, capacidadeCarga);
        this.temperatura = temperatura;
    }

    @Override
    public double calcularAutonomia(){
        return super.calcularAutonomia() * 0.9;
    }
}
