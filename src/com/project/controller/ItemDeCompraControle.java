package com.project.controller;

import com.project.model.DAO.ItemDeCompraDAO;
import com.project.model.entidades.ItemDeCompra;
import com.project.model.entidades.Produto;
import com.project.view.ItemDeCompraView;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDeCompraControle {
    private ItemDeCompra itemDeCompra;
    private ItemDeCompraView itemDeCompraView;

    // Construtor
    public ItemDeCompraControle(ItemDeCompra itemDeCompra, ItemDeCompraView itemDeCompraView) {
        this.itemDeCompra = itemDeCompra;
        this.itemDeCompraView = itemDeCompraView;
    }

    public static void cadastrarItemDeCompra(int idcompra, double precoDoItemDeCompra, int quantidadeComprada, Produto produto) {
        ItemDeCompra itemDeCompra = new ItemDeCompra(idcompra, precoDoItemDeCompra, quantidadeComprada, produto);
        try {
            ItemDeCompraDAO.salvar(itemDeCompra);
            System.out.println("\nItem de Compra cadastrado com sucesso\n");
        } catch (SQLException e) {
            System.out.println("Erro ao criar o Compra");
        }
    }

    public static void listarItemDeCompra() {
        try {
            ArrayList<ItemDeCompra> itens = ItemDeCompraDAO.pegarTodos();
            if (itens.size() == 0) {
                System.out.println("Não há produtos para listar");
                return;
            }
            System.out.println("\nProdutos disponíveis:\n");
            for (ItemDeCompra itemDeCompra : itens)
                System.out.println(itemDeCompra + "\n");
        } catch (SQLException e) {
            System.out.println("Erro ao listar os itens de compra");
        }
    }

     public static void consultarItem(int idItem) {
        ItemDeCompra item;
        try {
            item = ItemDeCompraDAO.pegar(idItem);
            if (item == null) {
                System.out.println("Esse item não existe\n");
            } else {
                System.out.println("\nInformações do item:\n");
                System.out.println(item);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar o Item");
        }
    }

    public static void editarItem(int idItem, int quantidadeComprada, double precoDoItemDeCompra) {
        try {
            ItemDeCompra item = ItemDeCompraDAO.pegar(idItem);
            if (item == null) {
                System.out.println("Esse item não existe\n");
            } else {
                item.editarItem(precoDoItemDeCompra, quantidadeComprada);
                ItemDeCompraDAO.salvar(item);
                System.out.println("\nItem editado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar o Item");
        }
    }


    public static void excluirItem(int idItem) {
        try {
            ItemDeCompra item = ItemDeCompraDAO.pegar(idItem);
            if (item == null) {
                System.out.println("Esse Item não existe\n");
            } else {
                ItemDeCompraDAO.deletar(item);
                System.out.println("\nItem deletado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o Item");
        }
    }
   

    public void salvar(){
        try {
            ItemDeCompraDAO.salvar(this.itemDeCompra);
            System.out.println("Item Salvo Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Item Não Salvo!!!");
        }
    }

    public void deletar(){
        try {
            ItemDeCompraDAO.deletar(this.itemDeCompra);
            System.out.println("Item Deletado Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Item Não Deletado!!!");
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
