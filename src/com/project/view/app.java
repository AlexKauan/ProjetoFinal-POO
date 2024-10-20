package com.project.view;

import java.sql.SQLException;
import java.util.Scanner;
import com.project.model.DAO.BancoDeDados;

public class app {
    public static void main(String[] args) throws SQLException {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        ClienteView.sc = sc;
        BancoDeDados.iniciarConexao();
        do {
            System.out.println("\n Bem Vindo ao Sestema \n");

            System.out.println("=======================================");
            System.out.println("   1 - Menu do Cliente                 ");
            System.out.println("   2 - Menu da Vendedor                ");
            System.out.println("   3 - Menu da Compra                  ");
            System.out.println("   4 - Menu do Item de Compra          ");
            System.out.println("   5 - Menu do Produto                 ");
            System.out.println("   0 - Sair                            ");
            System.out.println("=======================================");

            System.out.print("Opção ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    ClienteView.chamarMenuCliente();
                    break;

                case 2:
                    VendedorView.chamarMenuVendedor();
                    break;

                case 3:
                    CompraView.chamarMenuCompra();
                    break;
                case 4:
                    ItemDeCompraView.chamarMenuItemDeCompra();
                    break;
                    
                case 5:
                    ProdutoView.chamarMenuProduto();
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }

        } while (opcao != 0);

    }

}