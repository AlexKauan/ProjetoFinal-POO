package com.project.view;

import com.project.model.dao.BancoDeDados;
import java.sql.SQLException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) throws SQLException {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        ClienteView.sc = sc;
        BancoDeDados.iniciarConexao();

        do {
            System.out.println("\n========== Menu Principal ============\n");
            System.out.println("   1 - Menu do Cliente                 ");
            System.out.println("   2 - Menu da Compra                  ");
            System.out.println("   0 - Sair                            ");
            System.out.println("=======================================");

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
                    System.out.println("Opção Inválida");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }

    private static int obterOpcaoDoUsuario(Scanner sc, String mensagem) {
        System.out.print(mensagem);
        String input = sc.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            return -1;
        }
    }
}
