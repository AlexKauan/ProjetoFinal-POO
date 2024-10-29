package com.project.view;

import java.util.Scanner;

import com.project.model.entidades.Vendedor;
import com.project.controllers.VendedorController;


public class VendedorView {

    public static void chamarMenuVendedor() {
        int opcao = -1;
        Scanner sc = new Scanner(System.in);
        Vendedor vendedor = null;

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
                    String login = sc.nextLine();
                    vendedor.setLogin(login);
                    System.out.print("Informe o Senha ");
                    String senha = sc.nextLine();
                    vendedor.setSenha(senha);
                    System.out.print("Informe o nome do cliente ");
                    String nome = sc.nextLine();
                    vendedor.setNome(nome);
                    System.out.print("Informe o telefone ");
                    String telefone = sc.nextLine();
                    vendedor.setTelefone(telefone);
                    System.out.print("Informe o Email ");
                    String email = sc.nextLine();
                    vendedor.setEmail(email);
                    System.out.print("Informe o endereço ");
                    String endereco = sc.nextLine();
                    vendedor.setEndereco(endereco);
                    System.out.print("Informe o numero da Salario ");
                    double salario = sc.nextDouble();
                    vendedor.setSalario(salario);
                    System.out.print("Informe o numero da vendas ");
                    int numVendas = sc.nextInt();
                    vendedor.setNumeroDeVendas(numVendas);
                    System.out.print("Informe o Total Vendido ");
                    double totalVendido = sc.nextDouble();
                    vendedor.setTotalVendido(totalVendido);
                    VendedorController.cadastrarVendedor(vendedor);
                            
                    break;
                case 2:
                    VendedorController.editarVendedor(senha, nome, telefone, endereco);

                case 3:
                    /* Visualizar Vendedor */
                    int idVededorMostra = 0;
                    System.out.print("Informe o ID do Cliente: ");
                    idVededorMostra = sc.nextInt();

                    VendedorController.mostrarVendedor(idVededorMostra);
                    break;

                case 4:
                    /* Listar todos os Vendedor */
                    System.out.println("\nVendedores no sistema:\n");
                    VendedorController.listarVendedor();
                    break;

                case 5:
                    /* Excluir Vendedor */
                    int idVendedorExcluir = 0;
                    System.out.print("Informe o ID do Vendedor:\n");
                    idVendedorExcluir = sc.nextInt();
                    VendedorController.removerVendedor(idVendedorExcluir);
                    break;

                case 0:
                    System.out.println("Sair");
                    break;
            }
  }
}

}
