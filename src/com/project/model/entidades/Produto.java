package com.project.model.entidades;

public class Produto {
    
    private int idProduto;
    private int codigoDoProduto;
    private String descricao;
    private double precoUnitario;
    private int quantidadeDisponivel;

    public Produto(){}

    public Produto(int idProduto, int codigoDoProduto, String descricao, double precoUnitario, int quantidadeDisponivel) {
        this.idProduto = idProduto;
        this.codigoDoProduto = codigoDoProduto;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Produto(int codigoDoProduto, String descricao, double precoUnitario, int quantidadeDisponivel) {
        this.codigoDoProduto = codigoDoProduto;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getCodigoDoProduto() {
        return codigoDoProduto;
    }

    public void setCodigoDoProduto(int codigoDoProduto) {
        this.codigoDoProduto = codigoDoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + getIdProduto() + '\'' +
                ",Codigo do Produto='" + getCodigoDoProduto() + '\'' +
                ",Descricao='" + getDescricao() + '\'' +
                ", Preco Unitario='" + getPrecoUnitario() + '\'' +
                ", Quantidade Disponivel='" + getQuantidadeDisponivel() + '\'' +
                '}';
    }

    

}
