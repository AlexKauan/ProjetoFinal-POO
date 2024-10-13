package com.project.model.entidades;

public class ItemDeCompra {
    private int id_item_compra;
    private int quantidadeComprada;
    private double precoDoItemDeCompra;

    public ItemDeCompra(){}

    public ItemDeCompra(int id_item_compra, int quantidadeComprada, double precoDoItemDeCompra) {
        this.id_item_compra = id_item_compra;
        this.quantidadeComprada = quantidadeComprada;
        this.precoDoItemDeCompra = precoDoItemDeCompra;
    }

    public ItemDeCompra(double precoDoItemDeCompra, int quantidadeComprada) {
        this.precoDoItemDeCompra = precoDoItemDeCompra;
        this.quantidadeComprada = quantidadeComprada;
    }

    public int getId_item_compra() {
        return id_item_compra;
    }

    public void setId_item_compra(int id_item_compra) {
        this.id_item_compra = id_item_compra;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(int quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public double getPrecoDoItemDeCompra() {
        return precoDoItemDeCompra;
    }

    public void setPrecoDoItemDeCompra(double precoDoItemDeCompra) {
        this.precoDoItemDeCompra = precoDoItemDeCompra;
    }

    public void adicionarItem(int quantidade, double preco){
        this.quantidadeComprada += quantidade;
        this.precoDoItemDeCompra = preco;
    }

    public void consultarItem(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ItemDeCompra{");
        sb.append("quantidadeComprada=").append(quantidadeComprada);
        sb.append(", precoDoItemDeCompra=").append(precoDoItemDeCompra);
        sb.append('}');
        return sb.toString();
    }   
}