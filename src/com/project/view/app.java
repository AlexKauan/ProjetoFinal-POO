package com.project.view;

import com.project.controllers.ClienteController;
import com.project.model.dao.BancoDeDados;
import com.project.model.entidades.Cliente;
import java.sql.SQLException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        BancoDeDados.iniciarConexao();
        ClienteView.sc = sc;

        // Tentar logar
        if (login(sc)) {
            int opcao = 0;
            do {
                exibirMenuPrincipal();
                opcao = obterOpcaoDoUsuario(sc, "Opção: ");

                switch (opcao) {
                    case 1:
                        ClienteView.chamarMenuCliente();
                        break;

                    case 2:
                        CompraView.chamarMenuCompra();
                        break;

                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } while (opcao != 0);
        } else {
            System.out.println("Falha no login. Encerrando o sistema.");
        }

        sc.close();
    }

    // Método para exibir o menu principal
    private static void exibirMenuPrincipal() {
        System.out.println("\n========== Menu Principal ============\n");
        System.out.println("1 - Menu do Cliente");
        System.out.println("2 - Menu da Compra");
        System.out.println("0 - Sair");
        System.out.println("=======================================\n");
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

    // Função de login
    private static boolean login(Scanner sc) {
        System.out.println("========== Login ===========");
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        // Usar ClienteController para validar login
        try {
            Cliente cliente = ClienteController.logarCliente(login, senha);
            if (cliente != null) {
                System.out.println("Login bem-sucedido! Bem-vindo, " + cliente.getNome());
                return true;
            } else {
                System.out.println("Login ou senha inválidos.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar logar: " + e.getMessage());
            return false;
        }
    }
}
