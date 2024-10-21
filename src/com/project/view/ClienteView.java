package com.project.view;

import com.project.controllers.ClienteController;
import com.project.model.entidades.Cliente;
import java.util.Scanner;

public class ClienteView {

    static Scanner sc;

    public static void chamarMenuCliente() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n============ Menu do Cliente ============\n");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Editar Cliente");
            System.out.println("3 - Mostrar Cliente");
            System.out.println("4 - Listar todos os Clientes");
            System.out.println("5 - Excluir Cliente");
            System.out.println("0 - Voltar");
            System.out.println("=========================================\n");

            opcao = obterInteiroDoUsuario("Opção: ");

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    editarCliente();
                    break;
                case 3:
                    mostrarCliente();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    excluirCliente();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarCliente() {
        System.out.println("\n========== Cadastro de Cliente ==========");
        String login = obterStringDoUsuario("Login: ");
        String senha = obterStringDoUsuario("Senha: ");
        String nome = obterStringDoUsuario("Nome: ");
        String telefone = obterStringDoUsuario("Telefone: ");
        String email = obterStringDoUsuario("Email: ");
        String endereco = obterStringDoUsuario("Endereço: ");

        // Cria um objeto Cliente com os dados fornecidos
        Cliente cliente = new Cliente(login, senha, nome, telefone, email, endereco, 0, 0.0);

        // Chama o método do controlador passando o objeto Cliente
        try {
            ClienteController.cadastraCliente(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o cliente: " + e.getMessage());
        }
    }

    private static void editarCliente() {
        System.out.println("\n========== Edição de Cliente ==========");
        int idCliente = obterInteiroDoUsuario("Informe o ID do Cliente a ser editado: ");
        Cliente cliente = ClienteController.buscarCliente(idCliente);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        String nome = obterStringDoUsuario("Novo Nome (pressione Enter para manter o atual): ", cliente.getNome());
        String telefone = obterStringDoUsuario("Novo Telefone (pressione Enter para manter o atual): ",
                cliente.getTelefone());
        String email = obterStringDoUsuario("Novo Email (pressione Enter para manter o atual): ", cliente.getEmail());
        String endereco = obterStringDoUsuario("Novo Endereço (pressione Enter para manter o atual): ",
                cliente.getEndereco());

        ClienteController.atualizarCliente(idCliente, cliente.getLogin(), cliente.getSenha(), nome, telefone, email,
                endereco, cliente.getNumeroDeCompras(), cliente.getTotalComprado());
        System.out.println("Cliente atualizado com sucesso!");
    }

    private static void mostrarCliente() {
        int idCliente = obterInteiroDoUsuario("Informe o ID do Cliente: ");
        ClienteController.mostrarCliente(idCliente);
    }

    private static void listarClientes() {
        System.out.println("\n========== Lista de Clientes ==========");
        ClienteController.listarClientes();
    }

    private static void excluirCliente() {
        int idCliente = obterInteiroDoUsuario("Informe o ID do Cliente a ser excluído: ");
        ClienteController.removerCliente(idCliente);
    }

    private static String obterStringDoUsuario(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    private static String obterStringDoUsuario(String mensagem, String valorAtual) {
        System.out.print(mensagem);
        String valor = sc.nextLine();
        return valor.isEmpty() ? valorAtual : valor;
    }

    private static int obterInteiroDoUsuario(String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine(); // Limpar buffer após uso de nextInt()
        return valor;
    }

    private static double obterDoubleDoUsuario(String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida. Digite um valor numérico.");
            sc.next();
        }
        double valor = sc.nextDouble();
        sc.nextLine(); // Limpar buffer após uso de nextDouble()
        return valor;
    }
}
