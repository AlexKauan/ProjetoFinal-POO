package com.project.view;

import com.project.model.entidades.Vendedor;

public class VendedorView {

    public void printInformacoes(Vendedor vendedor) {
        if (vendedor == null) {
            System.out.println("Nenhuma informação de vendedor disponível.");
            return;
        }

        System.out.println("\n=========== Informações do Vendedor ===========");
        System.out.println("Nome: " + vendedor.getNome());
        System.out.println("Telefone: " + vendedor.getTelefone());
        System.out.println("Email: " + vendedor.getEmail());
        System.out.println("Endereço: " + vendedor.getEndereco());
        System.out.println("Salário: R$ " + vendedor.getSalario());
        System.out.println("Número de Vendas: " + vendedor.getNumeroDeVendas());
        System.out.println("Total Vendido: R$ " + vendedor.getTotalVendido());
        System.out.println("===============================================");
    }
}
