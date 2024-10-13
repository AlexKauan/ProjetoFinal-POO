package com.project.controller;

import com.project.model.DAO.ClienteDAO;
import com.project.model.DAO.ProdutoDAO;
import com.project.model.entidades.Produto;
import com.project.view.ProdutoView;
import java.sql.SQLException;



public class ProdutoControle {
    private Produto produto;
    private ProdutoView produtoView;

    // Contrutor
    public ProdutoControle(Produto produto, ProdutoView produtoView) {
        this.produto = produto;
        this.produtoView = produtoView;
    }

    public void atualizarCodigoDoProduto(int novoCodigoDoProduto) {
        produto.setCodigoDoProduto(novoCodigoDoProduto);
        System.out.println("Codigo DoProduto atualizado com sucesso!");
    }

    public void atualizarDescricao(String descricao) {
        produto.setDescricao(descricao);
        System.out.println("Descricao atualizado com sucesso!");
    }

    public void atualizarPrecoUnitario(double precoUnitario) {
        produto.setPrecoUnitario(precoUnitario);
        System.out.println("Preco Unitario atualizado com sucesso!");
    }
    
    public void atualizarQuantidadeDisponivel(int quantidadeDisponivel) {
        produto.setQuantidadeDisponivel(quantidadeDisponivel);
        System.out.println("Quantidade Disponivel atualizado com sucesso!");
    }

    public void exibirInformacoes() {
        produtoView.printInformacoes(this.produto);
    }

     public void salvar(){
        try {
            ProdutoDAO.salvar(this.produto);
            System.out.println("Produto Salvo Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Produto Não Salvo!!!");
        }
    }

     public void deletar(){
        try {
            ProdutoDAO.deletar(this.produto);
            System.out.println("Produto Deletado Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Produto Não Deletado!!!");
        }
    }

    // Getters e Setters para Produto e ProdutoView, caso seja necessário
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ProdutoView getProdutoView() {
        return produtoView;
    }

    public void setProdutoView(ProdutoView produtoView) {
        this.produtoView = produtoView;
    }

    
}
