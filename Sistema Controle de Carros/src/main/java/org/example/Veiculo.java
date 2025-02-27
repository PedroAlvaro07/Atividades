package org.example;

public abstract class Veiculo {

    public String marca;
    public String modelo;
    public int ano;
    public int quantidadePassageiros;
    public String combustivel;

    public Veiculo(String marca, String modelo, int ano, int quantidadePassageiros, String combustivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quantidadePassageiros = quantidadePassageiros;
        this.combustivel = combustivel;
    }


    public abstract double calcularAutonomia();

    public void exibirDetalhes() {
        System.out.println("MARCA:" + marca + " Modelo:" + modelo + " Ano:" + ano + " Qtd_Passageiros: " + quantidadePassageiros + "Combustivel" + combustivel);
    }
}
