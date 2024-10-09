package com.project.service;

import com.project.model.entidades.Produto;

import java.util.ArrayList;
import java.util.List;


public class ProdutosService {
    private List<Produto> listaDeProdutos;

    public ProdutosService() {
        this.listaDeProdutos = new ArrayList<>();
    } 

    public void adicionarProduto(Produto produto) {
        if (produto != null) {
            listaDeProdutos.add(produto);
            System.out.println("Produto adicionado com sucesso: " + produto);
        } else {
            System.out.println("Produto inválido. Não foi possível adicionar.");
        }
    }

    // Método para listar todos os produtos
    public void listarProdutos() {
        if (listaDeProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Lista de Produtos:");
            for (Produto produto : listaDeProdutos) {
                System.out.println(produto);
            }
        }
    }

    // Método para buscar um produto pelo código
    public Produto buscarProdutoPorCodigo(long codigoDoProduto) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getCodigoDoProduto() == codigoDoProduto) {
                return produto;
            }
        }
        System.out.println("Produto com código " + codigoDoProduto + " não encontrado.");
        return null;
    }

    // Método para remover um produto pelo código
    public boolean removerProduto(long codigoDoProduto) {
        Produto produto = buscarProdutoPorCodigo(codigoDoProduto);
        if (produto != null) {
            listaDeProdutos.remove(produto);
            System.out.println("Produto removido com sucesso: " + produto);
            return true;
        } else {
            System.out.println("Não foi possível remover o produto. Produto não encontrado.");
            return false;
        }
    }

    // Método para atualizar um produto existente
    public boolean atualizarProduto(long codigoDoProduto, String novaDescricao, double novoPreco, int novaQuantidade) {
        Produto produto = buscarProdutoPorCodigo(codigoDoProduto);
        if (produto != null) {
            produto.setDescricao(novaDescricao);
            produto.setPrecoUnitario(novoPreco);
            produto.setQuantidadeDisponivel(novaQuantidade);
            System.out.println("Produto atualizado com sucesso: " + produto);
            return true;
        } else {
            System.out.println("Produto com código " + codigoDoProduto + " não encontrado.");
            return false;
        }
    }

    // Getters e Setters para a lista de produtos, se necessário
    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }
}
