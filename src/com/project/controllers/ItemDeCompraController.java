package com.project.controllers;

import com.project.model.dao.ItemDeCompraDao;
import com.project.model.entidades.ItemDeCompra;
import com.project.model.entidades.Produto;
import com.project.view.ItemDeCompraView;
import java.sql.SQLException;

public class ItemDeCompraController {
    private ItemDeCompra itemDeCompra;
    private ItemDeCompraView itemDeCompraView;

    // Construtor
    public ItemDeCompraController(ItemDeCompra itemDeCompra, ItemDeCompraView itemDeCompraView) {
        this.itemDeCompra = itemDeCompra;
        this.itemDeCompraView = itemDeCompraView;
    }

    public static void cadastrarItemDeCompra(int idcompra, double precoDoItemDeCompra, int quantidadeComprada,
            Produto produto) {
        ItemDeCompra itemDeCompra = new ItemDeCompra(idcompra, precoDoItemDeCompra, quantidadeComprada, produto);
        try {
            ItemDeCompraDao.salvar(itemDeCompra);
            System.out.println("\nItem de Compra cadastrado com sucesso\n");
        } catch (SQLException e) {
            System.out.println("Erro ao criar o Compra");
        }
    }

    public void salvar() {
        try {
            ItemDeCompraDao.salvar(this.itemDeCompra);
            System.out.println("Cliente Salvo Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Cliente Não Salvo!!!");
        }
    }

    public void deletar() {
        try {
            ItemDeCompraDao.deletar(this.itemDeCompra);
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
