package com.project.view;

import com.project.controllers.PessoaController;
import com.project.model.dao.BancoDeDados;
import com.project.model.entidades.Pessoa;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        BancoDeDados.iniciarConexao();
        ClienteView.sc = sc;

        int opcao = -1;
        while (opcao != 0) {
            // Exibe o menu inicial para escolher o tipo de usuário
            exibirMenuInicial();
            opcao = obterOpcaoDoUsuario(sc, "Opção: ");

            switch (opcao) {
                case 1:
                    // Login de Cliente
                    if (login(sc, "Cliente")) {
                        // Exibe o menu principal após login de cliente
                        exibirMenuPrincipal("Cliente", sc);
                    }
                    break;
                case 2:
                    // Login de Vendedor
                    if (login(sc, "Vendedor")) {
                        // Exibe o menu principal após login de vendedor
                        exibirMenuPrincipal("Vendedor", sc);
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        sc.close();
    }

    // Método para exibir o menu inicial de escolha do tipo de login
    private static void exibirMenuInicial() {
        System.out.println("\n========== Escolha o Tipo de Login ============\n");
        System.out.println("1 - Logar como Cliente");
        System.out.println("2 - Logar como Vendedor");
        System.out.println("0 - Sair");
        System.out.println("===============================================");
    }

    // Método para exibir o menu principal com base no tipo de usuário logado
    private static void exibirMenuPrincipal(String tipoUsuario, Scanner sc) {
        int opcao = 0;
        do {
            System.out.println("\n========== Menu Principal (" + tipoUsuario + ") ============\n");
            System.out.println("1 - Menu do Cliente");
            System.out.println("2 - Menu da Compra");
            System.out.println("0 - Sair");
            System.out.println("=========================================");

            opcao = obterOpcaoDoUsuario(sc, "Opção: ");

            switch (opcao) {
                case 1:
                    ClienteView.chamarMenuCliente();
                    break;
                case 2:
                    try {
                        CompraView.chamarMenuCompra();
                    } catch (SQLException e) {
                        System.out.println("Erro ao chamar menu de compra: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    // Função de login para cliente ou vendedor
    private static boolean login(Scanner sc, String tipoUsuario) {
        System.out.println("========== Login " + tipoUsuario + " ===========");
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        // Usar PessoaController para validar login
        Pessoa pessoaLogada = PessoaController.logarPessoa(login, senha);

        if (pessoaLogada != null) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + pessoaLogada.getNome());
            return true;
        } else {
            System.out.println("Login ou senha inválidos.");
            return false;
        }
    }

    // Método para capturar a opção do usuário
    private static int obterOpcaoDoUsuario(Scanner sc, String mensagem) {
        System.out.print(mensagem);
        String input = sc.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            return -1; // Retorna -1 para capturar a opção inválida e exibir o menu novamente
        }
    }
}
