package com.project.view;

import java.util.Scanner;

import com.project.controller.ItemDeCompraControle;
import com.project.controller.ProdutoControle;
import com.project.model.entidades.Produto;

public class ItemDeCompraView {

    public static void chamarMenuItemDeCompra() {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);

        int menu = -1;
        int id_compra = 0;
        int quantidadeComprada = 0;
        double precoDoItemDeCompra = 0.0;
        Produto produto;

        while (menu != 0) {

            System.out.println("\n    Escolha uma opção de Itens       ");
            System.out.println("=======================================");
            System.out.println("   1 - Mostra Item de Compra           ");
            System.out.println("   2 - Listar Item de Compra           ");
            System.out.println("   0 - Sair                            ");
            System.out.println("=======================================");

            System.out.print("Opcao ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    int idItemDeCompraMostra = 0;
                    System.out.print("Informe o ID do Produto: ");
                    idItemDeCompraMostra = sc.nextInt();
                    ItemDeCompraControle.consultarItem(idItemDeCompraMostra);  

                    break;

                    case 2:
                    /* Listar todos os Produtos */
                    System.out.println("\nProdutos no sistema:\n");
                    ItemDeCompraControle.listarItemDeCompra();
                    break;
            
                default:
                    break;
            }
        }

    }

}
