package com.project.controller;

import com.project.model.DAO.CompraDAO;
import com.project.model.entidades.Compra;
import com.project.view.CompraView;
import java.sql.SQLException;
import java.util.List;

public class CompraControle {
    private Compra compra;
    private CompraView compraView;

    //Construtor
    public CompraControle(Compra compra, CompraView compraView) {
        this.compra = compra;
        this.compraView = compraView;
    }

    public void cadastrarCompra() {
        System.out.println("Compra cadastrada com ID: " + compra.getIdCompra());
    }

    public void mostrarCompra() {
        System.out.println("ID da Compra: " + compra.getIdCompra());
        System.out.println("Cliente: " + compra.getCliente().getNome());
        System.out.println("Data: " + compra.getDate());
        System.out.println("Status: " + compra.getStatusCompra());
        System.out.println("Itens da Compra:");
        for (var item : compra.getItens()) {
            System.out.println("Item: " + item.getItemDeCompra().toString());
        }
    }

    public void listarCompras(List<Compra> compras) {
        for (Compra compra : compras) {
            System.out.println("ID da Compra: " + compra.getIdCompra());
            System.out.println("Cliente: " + compra.getCliente().getNome());
            System.out.println("Data: " + compra.getDate());
            System.out.println("Status: " + compra.getStatusCompra());
        }
    }

    public void editarCompra(int novoIdCompra, String novaData, String novoStatusCompra) {
        compra.setIdCompra(novoIdCompra);
        compra.setDate(novaData);
        compra.setStatusCompra(novoStatusCompra);
        System.out.println("Compra editada com sucesso.");
    }

    public void removerCompra() {
        System.out.println("Compra removida com ID: " + compra.getIdCompra());
    }

    public void fecharCompra() {
        compra.setStatusCompra("Fechado");
        System.out.println("Compra fechada.");
    }

    public void cancelarCompra() {
        compra.setStatusCompra("Cancelado");
        System.out.println("Compra cancelada.");
    }

  public double calcularValorTotalDaCompra() {
        double total = 0;
        for (var item : compra.getItens()) {
            total += item.calcularValorTotalDoItem();
        }
        System.out.println("Valor total da compra: R$ " + total);
        return total;
    }
    

    public void salvar(){
        try {
            CompraDAO.salvar(this.compra);
            System.out.println("Cliente Salvo Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Cliente Não Salvo!!!");
        }
    }

    public void deletar(){
        try {
            CompraDAO.deletar(this.compra);
            System.out.println("Cliente Deletado Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Cliente Não Deletado!!!");
        }
    }
}
