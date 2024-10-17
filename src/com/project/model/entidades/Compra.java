package com.project.model.entidades;

import java.util.ArrayList;
import java.util.List;

public class Compra{
    private int idCompra;
    private Cliente cliente;
    private ItemDeCompra itemDeCompra;
    private String date;
    private String statusCompra;
    private List<ItemDeCompra> itens;

    public Compra(){}


    public Compra(int idCompra, Cliente cliente, String date, String statusCompra) {
        this.idCompra = idCompra;
        this.cliente = cliente;
        this.date = date;
        this.statusCompra = statusCompra;
        this.itens = new ArrayList<>();
    }

    public Compra(Cliente cliente, String date, String statusCompra) {
        this.cliente = cliente;
        this.date = date;
        this.statusCompra = statusCompra;
        this.itens = new ArrayList<>();
    }


    // Getters e Setters
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatusCompra() {
        return statusCompra;
    }

    public void setStatusCompra(String statusCompra) {
        this.statusCompra = statusCompra;
    }

    public List<ItemDeCompra> getItens() {
        return itens;
    }

    public void setItens(List<ItemDeCompra> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemDeCompra getItemDeCompra() {
        return itemDeCompra;
    }

    public void setItemDeCompra(ItemDeCompra itemDeCompra) {
        this.itemDeCompra = itemDeCompra;
    }


}

