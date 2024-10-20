package com.project.controller;

import com.project.model.DAO.ProdutoDAO;
import com.project.model.entidades.Produto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoControle {
    private List<Produto> produtos;

    // Construtor
    public ProdutoControle() {
        this.produtos = new ArrayList<>();
    }

    public static void adicionarProduto(int codigoDoProduto, String descricao, double precoUnitario,
            int quantidadeDisponivel) {
        Produto produto = new Produto(codigoDoProduto, descricao, precoUnitario, quantidadeDisponivel);
        try {
            ProdutoDAO.salvar(produto);
            System.out.println("Produto cadastrado com sucesso");
        } catch (SQLException e) {
            System.out.println("Error ao salvar o Produto");
        }

    }

    public static void mostrarProduto(int idProduto) {
        Produto produto;
        try {
            produto = ProdutoDAO.pegar(idProduto);
            if (produto == null) {
                System.out.println("Produtoo não encontrado");
                return;
            } else {
                System.out.println("\nInformações do produto:\n");
                System.out.println(produto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar medicamento");
        }
    }

    public static void listarProdutos() {
        try {
            ArrayList<Produto> produtos = ProdutoDAO.pegarTodos();
            if (produtos.size() == 0) {
                System.out.println("Não há produtos para listar");
                return;
            }
            System.out.println("\nProdutos disponíveis:\n");
            for (Produto produto : produtos)
                System.out.println(produto + "\n");
        } catch (SQLException e) {
            System.out.println("Erro ao listar os produtos");
        }
    }

    public static void editarProduto(int idProduto, String novaDescricao, double novoPreco,
            int novaQuantidadeDisponivel) {
        try {
            Produto produto = ProdutoDAO.pegar(idProduto);
            if (produto == null) {
                System.out.println("Produto não encontrado");
                return;
            }
            produto.editarProduto(novaDescricao, novoPreco, novaQuantidadeDisponivel);
            ProdutoDAO.salvar(produto);
            System.out.println("Produto atualizado");
            System.out.println(produto.toString() + '\n');
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o produto");
        }
    }

    public static void removerProduto(int idProduto) {
        try {
            Produto produto = ProdutoDAO.pegar(idProduto);
            if (produto == null) {
                System.out.println("Produto não encontrado");
                return;
            }
            ProdutoDAO.deletar(produto);
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o produto");
        }
    }

    public void consultarQuantidadeDisponivel(int idProduto) {
        Produto produto = encontrarProdutoPorId(idProduto);
        if (produto != null) {
            System.out.println("Quantidade disponível: " + produto.getQuantidadeDisponivel());
        } else {
            System.out.println("Produto com ID " + idProduto + " não encontrado.");
        }
    }

    public void consultarPrecoUnitario(int idProduto) {
        Produto produto = encontrarProdutoPorId(idProduto);
        if (produto != null) {
            System.out.println("Preço unitário: R$ " + produto.getPrecoUnitario());
        } else {
            System.out.println("Produto com ID " + idProduto + " não encontrado.");
        }
    }

    private Produto encontrarProdutoPorId(int idProduto) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == idProduto) {
                return produto;
            }
        }
        return null;
    }
}
