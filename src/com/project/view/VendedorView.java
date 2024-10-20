package com.project.view;

import java.util.Scanner;

import com.project.controller.VendedorControle;
import com.project.model.entidades.Vendedor;

public class VendedorView {

    public static void chamarMenuVendedor() {
        int opcao = -1;
        Scanner sc = new Scanner(System.in);

        String nome = "";
        String telefone = "";
        String email = "";
        String endereco = "";
        String login = "";
        String senha = "";
        double salario = 0.0;
        int numeroDeVendas = 0;
        double totalVendido = 0.0;

        while (opcao != 0) {

            System.out.println("\n    Escolha uma opção de Vendedor     ");
            System.out.println("=======================================");
            System.out.println("   1 - Cadastrar Vendedor                ");
            System.out.println("   2 - Editar Vendedor                   ");
            System.out.println("   3 - Mostra Vendedor                   ");
            System.out.println("   4 - Listar todos os Vendedor         ");
            System.out.println("   5 - Excluir Vendedor                  ");
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
                    System.out.print("Informe o numero da Salario ");
                    salario = sc.nextInt();
                    System.out.print("Informe o numero da vendas ");
                    numeroDeVendas = sc.nextInt();
                    System.out.print("Informe o Total Comprado ");
                    totalVendido = sc.nextDouble();
                    sc.nextLine(); // Limpa o buffer do scanner
                    VendedorControle.cadastraVendedor(salario, numeroDeVendas, totalVendido, login, senha, nome,
                            telefone, email, endereco);
                    break;
                case 2:
                    /* Editar Vendedor */
                    int idVendedorEditar = 0;
                    System.out.print("Informe o ID do cliente: ");
                    idVendedorEditar = sc.nextInt();
                    Vendedor vendedor = VendedorControle.buscarVendedor(idVendedorEditar);
                    if (vendedor == null) {
                        System.out.println("Não é possível editar um vendedor que não existe\n");
                        break;
                    }

                    login = null;
                    senha = null;
                    nome = null;
                    telefone = null;
                    email = null;
                    endereco = null;
                    salario = 0.0;
                    numeroDeVendas = 0;
                    totalVendido = 0.0;

                    System.out.println("            Menu Vendedor");
                    System.out.println("=======================================");
                    System.out.println("   1 - Editar Todos");
                    System.out.println("   2 - Editar Nome");
                    System.out.println("   3 - Editar Senha");
                    System.out.println("   4 - Editar Login");
                    System.out.println("   5 - Editar Telefone");
                    System.out.println("   6 - Editar Email");
                    System.out.println("   7 - Editar Endereço");
                    System.out.println("   8 - Editar Salario");
                    System.out.println("   9 - Editar Numero de Vendas");
                    System.out.println("   10 - Editar Total Vendido");
                    System.out.println("   0 - Sair");
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

                        case 8:
                            System.out.print("Digite o Novo Salario ");
                            salario = sc.nextDouble();
                            if (!editarTodosOsCampos) {
                                break;
                            }

                        case 9:
                            System.out.print("Digite o Novo Numero de Vendas ");
                            numeroDeVendas = sc.nextInt();
                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 10:
                            System.out.print("Digite o Novo Total Vendido ");
                            totalVendido = sc.nextDouble();
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
                    VendedorControle.atualizarVendedor(idVendedorEditar, salario, numeroDeVendas, totalVendido, login,
                            senha, nome, telefone, email, endereco);

                case 3:
                    /* Visualizar Vendedor */
                    int idVededorMostra = 0;
                    System.out.print("Informe o ID do Cliente: ");
                    idVededorMostra = sc.nextInt();

                    VendedorControle.mostrarVendedor(idVededorMostra);
                    break;

                case 4:
                    /* Listar todos os Vendedor */
                    System.out.println("\nVendedores no sistema:\n");
                    VendedorControle.listarVendedores();
                    break;

                case 5:
                    /* Excluir Vendedor */
                    int idVendedorExcluir = 0;
                    System.out.print("Informe o ID do Vendedor:\n");
                    idVendedorExcluir = sc.nextInt();
                    VendedorControle.removerVendedor(idVendedorExcluir);
                    break;

                case 0:
                    System.out.println("Sair");
                    break;
            }
        }
    }

}
