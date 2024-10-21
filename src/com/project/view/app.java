package com.project.view;

import com.project.controllers.ClienteController;
import com.project.controllers.PessoaController;
import com.project.controllers.VendedorController;
import com.project.model.dao.BancoDeDados;
import com.project.model.entidades.Cliente;
import com.project.model.entidades.Pessoa;
import com.project.model.entidades.Vendedor;
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
                        exibirMenuPrincipal("Cliente", sc);
                    }
                    break;
                case 2:
                    // Login de Vendedor
                    if (login(sc, "Vendedor")) {
                        exibirMenuPrincipal("Vendedor", sc);
                    }
                    break;
                case 3:
                    // Cadastro de Cliente
                    cadastrarCliente(sc);
                    break;
                case 4:
                    // Cadastro de Vendedor
                    cadastrarVendedor(sc);
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
        System.out.println("\n========== Escolha o Tipo de Login ou Cadastro ============\n");
        System.out.println("1 - Logar como Cliente");
        System.out.println("2 - Logar como Vendedor");
        System.out.println("3 - Cadastrar Cliente");
        System.out.println("4 - Cadastrar Vendedor");
        System.out.println("0 - Sair");
        System.out.println("==========================================================");
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

        // Usa PessoaController para validar login
        Pessoa pessoaLogada = PessoaController.logarPessoa(login, senha);

        if (pessoaLogada != null) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + pessoaLogada.getNome());
            return true;
        } else {
            System.out.println("Login ou senha inválidos.");
            return false;
        }
    }

    // Método para cadastrar um novo cliente
    private static void cadastrarCliente(Scanner sc) {
        System.out.println("\n========== Cadastro de Cliente ===========");
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        int numeroDeCompras = 0; // Inicialize com valores padrão
        double totalComprado = 0.0;

        Cliente cliente = new Cliente(login, senha, nome, telefone, email, endereco, numeroDeCompras, totalComprado);

        try {
            ClienteController.cadastraCliente(cliente);
            System.out.println("\nCliente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o cliente: " + e.getMessage());
        }
    }

    // Método para cadastrar um novo vendedor
    private static void cadastrarVendedor(Scanner sc) {
        System.out.println("\n========== Cadastro de Vendedor ===========");
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Salário: ");
        double salario = sc.nextDouble();
        System.out.print("Número de Vendas: ");
        int numeroDeVendas = sc.nextInt();
        sc.nextLine(); // Limpar o buffer

        Vendedor vendedor = new Vendedor(salario, numeroDeVendas, 0, login, senha, nome, telefone, email, endereco);

        VendedorController.cadastrarVendedor(vendedor);

        System.out.println("Vendedor cadastrado com sucesso!");
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
