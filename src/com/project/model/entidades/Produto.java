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
        this.setDescricao(descricao);
        this.setPrecoUnitario(precoUnitario);
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Produto(int codigoDoProduto, String descricao, double precoUnitario, int quantidadeDisponivel) {
        this.codigoDoProduto = codigoDoProduto;
        this.setDescricao(descricao);
        this.setPrecoUnitario(precoUnitario);
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
        if (descricao != null && !descricao.trim().isEmpty()) {
            this.descricao = descricao;
        } else {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        if (precoUnitario >= 0) {
            this.precoUnitario = precoUnitario;
        } else {
            throw new IllegalArgumentException("O preço unitário não pode ser negativo.");
        }
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
