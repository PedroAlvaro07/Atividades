package org.example;

public class carroEletrico extends Carro{

    public int bateriaKwh;

    public carroEletrico(String marca, String modelo, int ano, int quantidadePassageiros, String combustivel, String tipoCarro, int bateria) {
        super(marca, modelo, ano, quantidadePassageiros, combustivel, tipoCarro);
        this.bateriaKwh = bateria;
    }

    @Override
    public double calcularAutonomia(){
        return bateriaKwh * 5;
    }
}
