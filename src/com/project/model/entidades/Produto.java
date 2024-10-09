package com.project.model.entidades;

public class Produto {

    private long codigoDoProduto;
    private String descricao;
    private double precoUnitario;
    private int quantidadeDisponivel;

    public Produto(long codigoDoProduto, String descricao, double precoUnitario, int quantidadeDisponivel) {
        this.codigoDoProduto = codigoDoProduto;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public long getCodigoDoProduto() {
        return codigoDoProduto;
    }

    public void setCodigoDoProduto(long codigoDoProduto) {
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

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeDisponivel += quantidade;
        }
    }

    public boolean removerEstoque(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidadeDisponivel) {
            this.quantidadeDisponivel -= quantidade;
            return true;
        }
        return false;
    }

    public double calcularValorTotalEstoque() {
        return this.precoUnitario * this.quantidadeDisponivel;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigoProduto=" + codigoDoProduto +
                ", descricao='" + descricao + '\'' +
                ", precoUnitario=" + precoUnitario +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }
}