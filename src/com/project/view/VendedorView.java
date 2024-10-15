package com.project.view;


import com.project.model.entidades.Vendedor;

public class VendedorView {

    // Método para exibir as informações do cliente
    public void printInformacoes(Vendedor vendedor) {
        if (vendedor == null) {
            System.out.println("Nenhuma informação de cliente disponível.");
            return;
        }

        System.out.println("Informações do Vendedor:");
        System.out.println("Nome: " + vendedor.getNome());
        System.out.println("Telefone: " + vendedor.getTelefone());
        System.out.println("Email: " + vendedor.getEmail());
        System.out.println("Endereço: " + vendedor.getEndereco());
        System.out.println("Salario: " + vendedor.getSalario());
        System.out.println("Número de Vendas: " + vendedor.getNumeroDeVendas());
        System.out.println("Total Vendido: R$ " + vendedor.getTotalVendido());
    }
}
