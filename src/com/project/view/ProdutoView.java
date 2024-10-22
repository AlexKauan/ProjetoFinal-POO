package com.project.view;

import com.project.model.entidades.Produto;

public class ProdutoView {

    // Método para exibir as informações do Produto
    public void printInformacoes(Produto produto) {
        if (produto == null) {
            System.out.println("Nenhuma informação de produto disponível.");
            return;
        }

        System.out.println("\n=========== Informações do Produto ===========");
        System.out.println("Código do Produto: " + produto.getCodigoDoProduto());
        System.out.println("Descrição: " + produto.getDescricao());
        System.out.println("Preço Unitário: R$ " + produto.getPrecoUnitario());
        System.out.println("Quantidade Disponível: " + produto.getQuantidadeDisponivel());
        System.out.println("==============================================");
    }
}
