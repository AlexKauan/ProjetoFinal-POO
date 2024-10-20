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
        int opcao = -1; // Inicializa a variável opcao com -1 para entrar no loop
        Scanner sc = new Scanner(System.in);

        while (opcao != 0) { // Mantém o loop até que a opção 0 seja escolhida
            System.out.println("\n============ Menu de Compras ============\n");
            System.out.println("1 - Cadastrar Compra");
            System.out.println("2 - Mostrar Compra");
            System.out.println("3 - Listar Compras");
            System.out.println("4 - Remover Compras");
            System.out.println("0 - Voltar");
            System.out.println("=========================================\n");

            opcao = obterInteiroDoUsuario(sc, "Opção: ");

            switch (opcao) {
                case 1:
                    cadastrarCompra(sc);
                    break;
                case 2:
                    mostrarCompra(sc);
                    break;
                case 3:
                    listarCompras();
                    break;
                case 4:
                    removerCompra(sc);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break; // Sai do loop e volta ao menu principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void cadastrarCompra(Scanner sc) throws SQLException {
        Cliente cliente = (Cliente) Pessoa.getPessoaLogada();

        if (cliente == null) {
            System.out.println("Nenhum cliente logado. Faça login para continuar.");
            return;
        }

        System.out.print("Informe o Id do produto que deseja comprar: ");
        int idProduto = sc.nextInt();
        System.out.print("Informe a Quantidade do produto escolhido: ");
        int quantidadeComprada = sc.nextInt();
        Produto produto = ProdutoDao.pegar(idProduto);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        String date = LocalDate.now().toString();
        String statusCompra = "Em aberto";
        Compra compra = new Compra(cliente, date, statusCompra);

        CompraDao.salvar(compra);
        ItemDeCompra itemDeCompra = new ItemDeCompra(compra.getIdCompra(),
                produto.getPrecoUnitario() * quantidadeComprada, quantidadeComprada, produto);
        itemDeCompra.consultarItem();

        System.out.println("Compra cadastrada com sucesso!");
    }

    private static void mostrarCompra(Scanner sc) {
        int idCompra = obterInteiroDoUsuario(sc, "Informe o ID da Compra: ");
        CompraController.mostrarCompra(idCompra);
    }

    private static void listarCompras() {
        CompraController.listarCompras();
    }

    private static void removerCompra(Scanner sc) {
        int idCompra = obterInteiroDoUsuario(sc, "Informe o ID da Compra a ser removida: ");
        CompraController.removerCompra(idCompra);
    }

    private static int obterInteiroDoUsuario(Scanner sc, String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine(); // Limpar o buffer
        return valor;
    }
}
