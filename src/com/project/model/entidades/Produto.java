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

    public boolean isDisponivel() {
        return this.quantidadeDisponivel > 0;
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