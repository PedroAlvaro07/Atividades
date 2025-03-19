package org.example;
import org.example.Produto;
import java.util.HashMap;
import java.util.Map;

public class cadastrarProduto {
    private Map<Integer, Produto> produtos = new HashMap<>();

    public boolean adicionarProduto(int codigo, String nome, double preco) {
        if (produtos.containsKey(codigo)) {
            return false;
        }
        produtos.put(codigo, new Produto(codigo, nome, preco));
        return true;
    }

    public Produto buscarProduto(int codigo) {
        return produtos.get(codigo);
    }
}