package com.project.model.entidades;

import com.project.controller.CompraControle;
import com.project.controller.ItemDeCompraControle;

public class ItemDeCompra {
    private int id_item_compra;
    private int id_compra;
    private int quantidadeComprada;
    private double precoDoItemDeCompra;
    private Produto produto;

    public ItemDeCompra(){}

    public ItemDeCompra(int id_item_compra, int id_compra, int quantidadeComprada, double precoDoItemDeCompra, Produto produto) {
        this.id_item_compra = id_item_compra;
        this.quantidadeComprada = quantidadeComprada;
        this.precoDoItemDeCompra = precoDoItemDeCompra;
    }

    public ItemDeCompra(int id_compra, double precoDoItemDeCompra, int quantidadeComprada, Produto produto) {
        this.precoDoItemDeCompra = precoDoItemDeCompra;
        this.quantidadeComprada = quantidadeComprada;
    }

      public static void criarItemDeCompra(int id_compra, double precoDoItemDeCompra, int quantidadeComprada, Produto produto) {
        ItemDeCompraControle.cadastrarItemDeCompra( id_compra, precoDoItemDeCompra,  quantidadeComprada, produto);
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }
  
}