package com.project.view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.project.controller.CompraControle;
import com.project.model.DAO.ClienteDAO;
import com.project.model.DAO.ProdutoDAO;
import com.project.model.entidades.Cliente;
import com.project.model.entidades.Compra;
import com.project.model.entidades.ItemDeCompra;
import com.project.model.entidades.Pessoa;
import com.project.model.entidades.Produto;

public class CompraView {

    public static void chamarMenuCompra() throws SQLException {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);

        int menu = -1;
        String date = LocalDate.now().toString();
        String statusCompra = "Em aberto";
        int idCliente = 0;
        int idCompra = 0;
        int idProduto = 0;
        int quantidadeComprada = 0;
        while (menu != 0) {

            System.out.println("\n    Escolha uma opção de Compra      ");
            System.out.println("=======================================");
            System.out.println("   1 - Cadastrar Compra                ");
            System.out.println("   2 - Mostra Compra                   ");
            System.out.println("   3 - Listar Compras                  ");
            System.out.println("   4 - Remover Compras                 ");
            System.out.println("=======================================");

            System.out.print("Opcao ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // ProdutoView.chamarMenuProduto();
                     Produto produto1 = new Produto(1, "Agua", 2.50, 10);
                     ProdutoDAO.salvar(produto1);
                     Cliente cliente = (Cliente) Pessoa.getPessoaLogada();
                    // sc.nextLine();
                    // System.out.print("Informe a Data ");
                    // date = sc.nextLine();
                    // System.out.print("Informe o Status da Compra ");
                    // statusCompra = sc.nextLine();
                    // sc.nextLine();

                    // Listar Produto
                    for (Produto produto2 : ProdutoDAO.pegarTodos()) {
                    System.out.println(produto2);
                    }

                    System.out.print("Informe o Id do produto que deseja compra: ");
                    idProduto = sc.nextInt();
                    System.out.print("Informe a Quantidade do produto escolhido: ");
                    quantidadeComprada = sc.nextInt();
                    Produto produto = ProdutoDAO.pegar(idProduto);

                    // Compra.criarCompra(cliente.getId(), date, statusCompra);
                    Cliente cliente2 = ClienteDAO.pegar(1);
                    Compra compra = new Compra(cliente2, date, statusCompra);
                    // CompraDAO.salvar(compra);
                    // CompraDAO.salvar(compra);
                    ItemDeCompra itemDeCompra = new ItemDeCompra(compra.getIdCompra(),
                    produto.getPrecoUnitario() * quantidadeComprada, quantidadeComprada,
                    produto);
                    // ItemDeCompraDAO.salvar(itemDeCompra);
                    // itemDeCompra.
                    compra.adicionarItem(itemDeCompra);
                    
                    System.out.println(itemDeCompra);
                    System.out.println(compra);

                    
                    // TODO Auto-generated catch block

                    // Salva compra para pega seu id e adicionar em item de compra

                    break;
                case 2:
                    System.out.println("Buscar Compra:");
                    System.out.print("Informe o ID do Cliente");
                    idCompra = sc.nextInt();

                    CompraControle.mostrarCompra(idCompra);
                    break;
                case 3:
                    System.out.println("Listar Compras:");
                    CompraControle.listarCompras();
                    break;

                case 4:
                    System.out.print("Remover Compra ");
                    idCompra = sc.nextInt();
                    CompraControle.removerCompra(idCompra);
                    break;
                default:
                    break;
            }
        }

    }

}
