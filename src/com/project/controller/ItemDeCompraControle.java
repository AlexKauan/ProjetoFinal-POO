package com.project.controller;

import com.project.model.DAO.ItemDeCompraDAO;
import com.project.model.entidades.ItemDeCompra;
import com.project.view.ItemDeCompraView;
import java.sql.SQLException;

public class ItemDeCompraControle {
    private ItemDeCompra itemDeCompra;
    private ItemDeCompraView itemDeCompraView;

    // Construtor
    public ItemDeCompraControle(ItemDeCompra itemDeCompra, ItemDeCompraView itemDeCompraView) {
        this.itemDeCompra = itemDeCompra;
        this.itemDeCompraView = itemDeCompraView;
    }

    

    public void salvar(){
        try {
            ItemDeCompraDAO.salvar(this.itemDeCompra);
            System.out.println("Cliente Salvo Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Cliente Não Salvo!!!");
        }
    }

    public void deletar(){
        try {
            ItemDeCompraDAO.deletar(this.itemDeCompra);
            System.out.println("Cliente Deletado Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Cliente Não Deletado!!!");
        }
    }

     // Getters e Setters para ItemDecompra e ItemDecompraView, caso seja necessário
    public ItemDeCompra getItemDeCompra() {
        return itemDeCompra;
    }

    public void setItemDeCompra(ItemDeCompra itemDeCompra) {
        this.itemDeCompra = itemDeCompra;
    }

    public ItemDeCompraView getItemDeCompraView() {
        return itemDeCompraView;
    }

    public void setItemDeCompraView(ItemDeCompraView itemDeCompraView) {
        this.itemDeCompraView = itemDeCompraView;
    }

    
}
