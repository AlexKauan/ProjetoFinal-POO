package com.project.view;

import java.util.Scanner;

import com.project.model.entidades.ItemDeCompra;
import com.project.model.entidades.Produto;

public class ItemDeCompraView {

    public static void chamarMenuCompra() {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);

        int menu = -1;
        int id_compra = 0;
        int quantidadeComprada = 0;
        double precoDoItemDeCompra = 0.0;
        Produto produto;

        while (menu != 0) {

            System.out.println("\n Escolha uma opção de Item de Compra ");
            System.out.println("=======================================");
            System.out.println("     1 - Cadastrar Ite de Compra       ");
            System.out.println("=======================================");

            System.out.print("Opcao ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    
                    
                    break;
            
                default:
                    break;
            }
        }

    }

}
