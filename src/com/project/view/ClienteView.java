package com.project.view;

import java.util.Scanner;

import com.project.controller.ClienteControler;
import com.project.model.entidades.Cliente;

public class ClienteView {

    static Scanner sc;

    public static void chamarMenuCliente() {
        int opcao = -1;
       

        int menu = -1;
        String nome = "";
        String telefone = "";
        String email = "";
        String endereco = "";
        String login = "";
        String senha = "";
        int numeroDeCompras = 0;
        double totalComprado = 0.0;
        while (opcao != 0) {

            System.out.println("\n    Escolha uma opção de Cliente     ");
            System.out.println("=======================================");
            System.out.println("   1 - Cadastrar Cliente                ");
            System.out.println("   2 - Editar Cliente                   ");
            System.out.println("   3 - Mostra Cliente                   ");
            System.out.println("   4 - Listar todos os Clientes         ");
            System.out.println("   5 - Excluir Cliente                  ");
            System.out.println("   0 - Sair                             ");
            System.out.println("=======================================");

            System.out.print("Opcao ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o login ");
                    login = sc.nextLine();
                    sc.nextLine(); // Limpa o buffer do scanner
                    System.out.print("Informe o Senha ");
                    senha = sc.nextLine();
                    System.out.print("Informe o nome do cliente ");
                    nome = sc.nextLine();
                    System.out.print("Informe o telefone ");
                    telefone = sc.nextLine();
                    System.out.print("Informe o Email ");
                    email = sc.nextLine();
                    System.out.print("Informe o endereço ");
                    endereco = sc.nextLine();
                    System.out.print("Informe o numero da compra ");
                    numeroDeCompras = sc.nextInt();
                    System.out.print("Informe o Total Comprado ");
                    totalComprado = sc.nextDouble();
                    sc.nextLine(); // Limpa o buffer do scanner
                    ClienteControler.cadastraCliente(login, senha, nome, telefone, email, endereco, numeroDeCompras,
                            totalComprado);
                    break;
                case 2:
                    /* Editar Cliente */
                    int idClienteEditar = 0;
                    System.out.print("Informe o ID do cliente: ");
                    idClienteEditar = sc.nextInt();
                    Cliente cliente = ClienteControler.buscarCliente(idClienteEditar);
                    if (cliente == null) {
                        System.out.println("Não é possível editar um cliente que não existe\n");
                        break;
                    }

                    login = null;
                    senha = null;
                    nome = null;
                    telefone = null;
                    email = null;
                    endereco = null;

                    System.out.println("            Menu Cliente"               );
                    System.out.println("=======================================");
                    System.out.println("   1 - Editar Todos"                    );
                    System.out.println("   2 - Editar Nome"                     );
                    System.out.println("   3 - Editar Senha"                    );
                    System.out.println("   4 - Editar Login"                    );
                    System.out.println("   5 - Editar Telefone"                 );
                    System.out.println("   6 - Editar Email"                    );
                    System.out.println("   7 - Editar Endereço"                 );
                    System.out.println("   0 - Sair"                            );
                    System.out.println("=======================================");
                    int opcao1 = sc.nextInt();
                    sc.nextLine();

                    boolean editarTodosOsCampos = false;

                    switch (opcao1) {
                        case 1:
                            editarTodosOsCampos = true;

                        case 2:
                            System.out.print("Digite o novo nome do Cliente ");
                            nome = sc.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }

                        case 3:
                            System.out.print("Digite o novo nome da Senha ");
                            senha = sc.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }

                        case 4:
                            System.out.print("Digite o novo Login ");
                            login = sc.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }

                        case 5:
                            System.out.print("Digite o Novo Telefone ");
                            telefone = sc.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }

                        case 6:
                            System.out.print("Digite o novo Email ");
                            email = sc.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }

                        case 7:
                            System.out.print("Digite o Novo Endereço ");
                            endereco = sc.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }

                        case 0:
                            System.out.println("Sair");
                            break;

                        default:
                            System.out.println("Opção Invalida");
                            break;
                    }
                    ClienteControler.atualizarCliente(idClienteEditar, login, senha, nome, telefone, email, endereco,
                            numeroDeCompras,
                            totalComprado);
                    break;

                case 3:
                    /* Visualizar Cliente */
                    int idClienteMostra = 0;
                    System.out.print("Informe o ID do Cliente: ");
                    idClienteMostra = sc.nextInt();

                    ClienteControler.mostrarCliente(idClienteMostra);
                    break;

                case 4:
                    /* Listar todos os Clientes */
                    System.out.println("\nCLientes no sistema:\n");
                    ClienteControler.listarClientes();
                    break;

                case 5:
                    /* Excluir Cliente */
                    int idClienteExcluir = 0;
                    System.out.print("Informe o ID do Cliente:\n");
                    idClienteExcluir = sc.nextInt();
                    ClienteControler.removerCliente(idClienteExcluir);
                    break;

                case 0:
                    System.out.println("Sair");
                    break;
            }
        }
    }

}
