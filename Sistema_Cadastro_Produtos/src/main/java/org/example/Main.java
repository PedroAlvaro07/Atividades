package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cadastrarProduto cadastro = new cadastrarProduto();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Opção de cadastro selecionado.");
                    cadastrarProduto(cadastro, scanner);
                    break;
                case 2:
                    System.out.println("Opção de Busca selecionada");
                    buscarProduto(cadastro, scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void cadastrarProduto(cadastrarProduto cadastro, Scanner scanner) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();

        if (cadastro.adicionarProduto(codigo, nome, preco)) {
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Código já cadastrado! Tente novamente.");
        }
    }

    private static void buscarProduto(cadastrarProduto cadastro, Scanner scanner) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        Produto produto = cadastro.buscarProduto(codigo);
        if (produto != null) {
            System.out.println("Produto encontrado: " + produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
