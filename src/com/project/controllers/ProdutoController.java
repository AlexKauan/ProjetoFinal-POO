package com.project.controllers;

import com.project.model.entidades.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> produtos;

    // Construtor
    public ProdutoController() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado: " + produto);
    }

    public void mostrarProduto(int idProduto) {
        Produto produto = encontrarProdutoPorId(idProduto);
        if (produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto com ID " + idProduto + " não encontrado.");
        }
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public void editarProduto(int idProduto, String novaDescricao, double novoPreco, int novaQuantidadeDisponivel) {
        Produto produto = encontrarProdutoPorId(idProduto);
        if (produto != null) {
            produto.setDescricao(novaDescricao);
            produto.setPrecoUnitario(novoPreco);
            produto.setQuantidadeDisponivel(novaQuantidadeDisponivel);
            System.out.println("Produto editado com sucesso.");
        } else {
            System.out.println("Produto com ID " + idProduto + " não encontrado.");
        }
    }

    public void removerProduto(int idProduto) {
        Produto produto = encontrarProdutoPorId(idProduto);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto com ID " + idProduto + " não encontrado.");
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
