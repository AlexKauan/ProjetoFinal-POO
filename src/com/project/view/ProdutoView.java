package com.project.view;

import com.project.model.entidades.Produto;

public class ProdutoView {

    // Método para exibir as informações do cliente
    public void printInformacoes(Produto produto) {
        if (produto == null) {
            System.out.println("Nenhuma informação de cliente disponível.");
            return;
        }

        System.out.println("Informações do Cliente:");
        System.out.println("Codigo do Produto: " + produto.getCodigoDoProduto());
        System.out.println("Descricao: " + produto.getDescricao());
        System.out.println("Preco Unitario: " + produto.getPrecoUnitario());
        System.out.println("Quantidade Disponivel: " + produto.getQuantidadeDisponivel());
    }
}

