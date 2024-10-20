package com.project.view;

import com.project.controllers.CompraController;
import com.project.model.dao.CompraDao;
import com.project.model.dao.ProdutoDao;
import com.project.model.entidades.Cliente;
import com.project.model.entidades.Compra;
import com.project.model.entidades.ItemDeCompra;
import com.project.model.entidades.Pessoa;
import com.project.model.entidades.Produto;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

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
                    Cliente cliente = (Cliente) Pessoa.getPessoaLogada();
                    // sc.nextLine();
                    // System.out.print("Informe a Data ");
                    // date = sc.nextLine();
                    // System.out.print("Informe o Status da Compra ");
                    // statusCompra = sc.nextLine();
                    // sc.nextLine();

                    // Listar Produto
                    System.out.print("Informe o Id do produto que deseja compra: ");
                    idProduto = sc.nextInt();
                    System.out.print("Informe a Quantidade do produto escolhido: ");
                    quantidadeComprada = sc.nextInt();
                    Produto produto = ProdutoDao.pegar(idProduto);

                    // Compra.criarCompra(cliente.getId(), date, statusCompra);

                    Compra compra = new Compra(cliente, date, statusCompra);

                    try {
                        CompraDao.salvar(compra);
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    // Salva compra para pega seu id e adicionar em item de compra
                    ItemDeCompra itemDeCompra = new ItemDeCompra(compra.getIdCompra(),
                            produto.getPrecoUnitario() * quantidadeComprada, quantidadeComprada, produto);
                    itemDeCompra.consultarItem();

                    break;
                case 2:
                    System.out.println("Buscar Compra:");
                    System.out.print("Informe o ID do Cliente");
                    idCompra = sc.nextInt();

                    CompraController.mostrarCompra(idCompra);
                    break;
                case 3:
                    System.out.println("Listar Compras:");
                    CompraController.listarCompras();
                    break;

                case 4:
                    System.out.print("Remover Compra ");
                    idCompra = sc.nextInt();
                    CompraController.removerCompra(idCompra);
                    break;
                default:
                    break;
            }
        }

    }

    // // Método para exibir as informações da Compra
    // public void printInformacoes(Compra compra) {
    // if (compra == null) {
    // System.out.println("Nenhuma informação da Compra disponível.");
    // return;
    // }

    // System.out.println("Informações da Compra:");
    // System.out.println("Nome: " + compra.getCliente().getNome());
    // System.out.println("IdCompra: " + compra.getIdCompra());
    // System.out.println("Data: " + compra.getDate());
    // System.out.println("Status da Compra: " + compra.getStatusCompra());
    // }
}
