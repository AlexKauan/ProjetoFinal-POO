package com.project.view;

import com.project.model.entidades.ItemDeCompra;

public class ItemDeCompraView {

    // Método para exibir as informações do cliente
    public void printInformacoes(ItemDeCompra itemDeCompra) {
        if (itemDeCompra == null) {
            System.out.println("Nenhuma informação itemDeCompra de disponível.");
            return;
        }

        System.out.println("Informações do Item de Compra:");
        System.out.println("Nome: " + itemDeCompra.getPrecoDoItemDeCompra());
        System.out.println("Telefone: " + itemDeCompra.getQuantidadeComprada());
    }
}


