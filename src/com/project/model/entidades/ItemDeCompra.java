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
        this.produto = produto;
        this.id_compra = id_compra;
    }

    public ItemDeCompra(int id_compra, double precoDoItemDeCompra, int quantidadeComprada, Produto produto) {
        this.precoDoItemDeCompra = precoDoItemDeCompra;
        this.quantidadeComprada = quantidadeComprada;
        this.produto = produto;
        this.id_compra = id_compra;
    }

      public static void criarItemDeCompra(int id_compra, double precoDoItemDeCompra, int quantidadeComprada, Produto produto) {
        ItemDeCompraControle.cadastrarItemDeCompra(id_compra, precoDoItemDeCompra,  quantidadeComprada, produto);
    }

    public void editarItem(double precoDoItemDeCompra, int quantidadeComprada) {
        if (precoDoItemDeCompra != 0.0)
            this.precoDoItemDeCompra = precoDoItemDeCompra;
        if (quantidadeComprada >= 0)
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
        sb.append("---------------------------\n");
        sb.append("ItemDeCompra: \n");
        sb.append("Id: ").append(id_item_compra);
        sb.append("\nquantidadeComprada = ").append(quantidadeComprada);
        sb.append("\nprecoDoItemDeCompra = ").append(precoDoItemDeCompra);
        sb.append("\n---------------------------\n");
        return sb.toString();
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }
  
}