package com.project.view;

import com.project.model.entidades.Cliente;

public class ClienteView {

    // Método para exibir as informações do cliente
    public void printInformacoes(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Nenhuma informação de cliente disponível.");
            return;
        }

        System.out.println("Informações do Cliente:");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Número de Compras: " + cliente.getNumeroDeCompras());
        System.out.println("Total Comprado: R$ " + cliente.getTotalComprado());
    }
}
