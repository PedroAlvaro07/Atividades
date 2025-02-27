package org.example;

public class Onibus extends Veiculo{

    public int quantidadeDeEixos;
    public int ver;

    public Onibus(String marca, String modelo, int ano, int quantidadePassageiros, String combustivel, int quantidadeDeEixos)  {
        super(marca, modelo, ano, quantidadePassageiros, combustivel);


        if(quantidadeDeEixos < 6 || quantidadeDeEixos > 8){
            throw new IllegalArgumentException("CACETE");
        }

        this.quantidadeDeEixos = quantidadeDeEixos;
    }

    @Override
    public double calcularAutonomia(){
        return 200 * 5;
    }
}
