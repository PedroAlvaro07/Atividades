package org.example;

import org.example.entities.User;
import org.example.repository.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = null;
        Connection conn = null;

        String url = "jdbc:sqlite:database.sqlite";

        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                System.out.println("Conexão bem-sucedida!");
                userRepository = new UserRepository(conn);

                String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                        + "uuid TEXT PRIMARY KEY, "
                        + "name TEXT NOT NULL, "
                        + "email TEXT UNIQUE NOT NULL, "
                        + "password TEXT NOT NULL)";
                try (PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
                    stmt.execute();
                }
            } else {
                System.out.println("Falha na conexão.");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n---MENU---");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Listar Usuários");
            System.out.println("3 - Encontrar Usuário por UUID");
            System.out.println("4 - Deletar Usuário por UUID");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Digite um número entre 1 e 5.");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nome: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Senha: ");
                    String password = scanner.nextLine();

                    User user = new User(name, email, password);
                    userRepository.save(user);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Lista de Usuários:");
                    List<User> users = userRepository.findAll();
                    if (users.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        users.forEach(u -> System.out.println(u.getUuid() + " - " + u.getName() + " - " + u.getEmail()));
                    }
                    break;

                case 3:
                    System.out.println("Digite o UUID do usuário: ");
                    String id = scanner.nextLine();
                    userRepository.findById(UUID.fromString(id))
                            .ifPresentOrElse(
                                    u -> System.out.println(u.getUuid() + " - " + u.getName() + " - " + u.getEmail()),
                                    () -> System.out.println("Usuário não encontrado!")
                            );
                    break;

                case 4:
                    System.out.println("Digite o UUID do usuário a ser deletado: ");
                    String deleteId = scanner.nextLine();
                    userRepository.deleteById(UUID.fromString(deleteId));
                    System.out.println("Usuário deletado com sucesso!");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Digite um número entre 1 e 3.");
            }

        } while (option != 5);

        scanner.close();
        try {
            conn.close();
            System.out.println("Conexão encerrada.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
