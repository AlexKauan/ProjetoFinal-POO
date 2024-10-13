package com.project.view;

import com.project.model.entidades.Compra;

public class CompraView {

    // Método para exibir as informações da Compra
    public void printInformacoes(Compra compra) {
        if (compra == null) {
            System.out.println("Nenhuma informação da Compra disponível.");
            return;
        }

        System.out.println("Informações da Compra:");
        System.out.println("Nome: " + compra.getCliente().getNome());
        System.out.println("IdCompra: " + compra.getIdCompra());
        System.out.println("Data: " + compra.getDate());
        System.out.println("Status da Compra: " + compra.getStatusCompra());
    }
}

