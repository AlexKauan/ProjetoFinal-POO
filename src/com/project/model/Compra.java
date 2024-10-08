package com.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
    private int idCompra;
    private Date date;
    private Status statusCompra;
    private List<ItemDeCompra> itens;

    public Compra(int idCompra, Date data, Status statusCompra) {
        this.idCompra = idCompra;
        this.date = data;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatusCompra() {
        return statusCompra;
    }

    public void setStatusCompra(Status statusCompra) {
        this.statusCompra = statusCompra;
    }

    public List<ItemDeCompra> getItens() {
        return itens;
    }

    public void setItens(List<ItemDeCompra> itens) {
        this.itens = itens;
    }
}

