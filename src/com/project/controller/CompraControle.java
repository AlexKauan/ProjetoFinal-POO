package com.project.controller;

import java.sql.SQLException;
import com.project.model.DAO.CompraDAO;
import com.project.model.entidades.Compra;
import com.project.view.CompraView;

public class CompraControle {
    private Compra compra;
    private CompraView compraView;

    //Construtor
    public CompraControle(Compra compra, CompraView compraView) {
        this.compra = compra;
        this.compraView = compraView;
    }
    
    public void atualizarDate(String novoDate) {
        compra.setDate(novoDate);
        System.out.println("Data atualizado com sucesso!");
    }
    
    public void atualizarStatusCompra(String statusCompra) {
        compra.setDate(statusCompra);
        System.out.println("Status Compra atualizado com sucesso!");
    }

     public void exibirInformacoes() {
        compraView.printInformacoes(this.compra);
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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public CompraView getCompraView() {
        return compraView;
    }

    public void setCompraView(CompraView compraView) {
        this.compraView = compraView;
    }

    
}
