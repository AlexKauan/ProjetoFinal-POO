package com.project.view;

import java.util.Scanner;

import com.project.controller.ProdutoControle;

public class ProdutoView {

    // static Scanner sc;

    public static void chamarMenuProduto() {
        int opcao = -1;

        Scanner sc = new Scanner(System.in);

        int idProduto = 0;
        int codigoDoProduto = 0;
        String descricao = "";
        double precoUnitario = 0.0;
        int quantidadeDisponivel = 0;

        while (opcao != 0) {

            System.out.println("\n    Escolha uma opção de Produto     ");
            System.out.println("=======================================");
            System.out.println("   1 - Cadastrar Produto                ");
            System.out.println("   2 - Editar Produto                   ");
            System.out.println("   3 - Mostra Produto                  ");
            System.out.println("   4 - Listar todos os Produtos        ");
            System.out.println("   5 - Excluir Produto                  ");
            System.out.println("   0 - Sair                             ");
            System.out.println("=======================================");

            System.out.print("Opcao ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o Codigo do Produto ");
                    codigoDoProduto = sc.nextInt();
                    sc.nextLine(); // Limpa o buffer do scanner
                    System.out.print("Informe a Descrição ");
                    descricao = sc.nextLine();
                    System.out.print("Informe o Preço ");
                    precoUnitario = sc.nextInt();
                    System.out.println("Informe a Quantidade Dispomivel ");
                    quantidadeDisponivel = sc.nextInt();
                    sc.nextLine(); // Limpa o buffer do scanner

                    ProdutoControle.adicionarProduto(codigoDoProduto, descricao, precoUnitario, quantidadeDisponivel);

                    break;

                case 3:
                    /* Visualizar Produto */
                    int idProdutoMostra = 0;
                    System.out.print("Informe o ID do Produto: ");
                    idProdutoMostra = sc.nextInt();

                    ProdutoControle.mostrarProduto(idProdutoMostra);
                    break;

                case 4:
                    /* Listar todos os Produtos */
                    System.out.println("\nProdutos no sistema:\n");
                    ProdutoControle.listarProdutos();
                    break;

                case 5:
                    /* Excluir Produto */
                    int idProdutoExcluir = 0;
                    System.out.print("Informe o ID do Produto:\n");
                    idProdutoExcluir = sc.nextInt();
                    ProdutoControle.removerProduto(idProdutoExcluir);
                    break;

                case 0:
                    System.out.println("Sair");
                    break;

                default:
                    break;
            }

        }
    }
}