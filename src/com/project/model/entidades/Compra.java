package com.project.model.entidades;

import com.project.controllers.CompraController;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private int idCompra;
    private Cliente cliente;
    private String date;
    private String statusCompra;
    private List<ItemDeCompra> itens;

    public Compra() {
    }

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

    public static void criarCompra(int idCliente, String date, String statusCompra) {
        CompraController.cadastrarCompra(idCliente, date, statusCompra);
    }

    public void editarComora(Cliente cliente, String date, String statusCompra) {
        if (cliente != null) {
            setCliente(cliente);
        }
        if (date != null) {
            setDate(date);
        }
        if (statusCompra != null) {
            setStatusCompra(statusCompra);
        }
    }

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

    @Override
    public String toString() {
        System.out.println("-------------------------------");
        return "Compra idCompra = " + idCompra
                + "\n" + "cliente = " + cliente.getNome()
                + "\n" + "Date = " + date
                + "\n" + "Status da Compra = " + statusCompra
                + "\n" + "------------------------------";

    }

}
