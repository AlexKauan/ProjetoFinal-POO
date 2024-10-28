package com.project.controllers;

import com.project.model.dao.CompraDao;
import com.project.model.entidades.Cliente;
import com.project.model.entidades.Compra;
import com.project.view.CompraView;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompraController {
    private Compra compra;
    private CompraView compraView;

    public CompraController(Compra compra, CompraView compraView) {
        this.compra = compra;
        this.compraView = compraView;
    }

    public static void cadastrarCompra(int idCliente, String date, String statusCompra) {
        Cliente cliente = ClienteController.buscarCliente(idCliente);
        Compra compra = new Compra(cliente, date, statusCompra);
        try {
            CompraDao.salvar(compra);
            System.out.println("\nCompra cadastrado com sucesso\n");
        } catch (SQLException e) {
            System.out.println("Erro ao criar o Compra");
        }
    }

    public static void mostrarCompra(int idCompra) {
        Compra compra;
        try {
            compra = CompraDao.pegar(idCompra);
            if (compra == null) {
                System.out.println("Esse compra não existe\n");
            } else {
                System.out.println("\nInformações do compra:\n");
                System.out.println(compra);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar o Compra");
        }
    }

    public static void listarCompras() {
        try {
            ArrayList<Compra> compras = CompraDao.pegarTodos();
            if (compras.size() == 0) {
                System.out.println("\nNão há pedidos para lsitar\n");
                return;
            }
            for (Compra compra : compras)
                System.out.println(compra);
        } catch (SQLException e) {
            System.out.println("Erro ao listar os pedidos");
        }
    }

    public void editarCompra(int novoIdCompra, String novaData, String novoStatusCompra) {
        compra.setIdCompra(novoIdCompra);
        compra.setDate(novaData);
        compra.setStatusCompra(novoStatusCompra);
        System.out.println("Compra editada com sucesso.");
    }

    public static void removerCompra(int idcompra) {
        try {
            Compra compra = CompraDao.pegar(idcompra);
            if (compra == null) {
                System.out.println("\nEsse pedido não está no sistema\n");
                return;
            }
            CompraDao.deletar(compra);
            System.out.println("\nPedido deletado com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o pedido");
        }
    }

    public void fecharCompra() {
        compra.setStatusCompra("Fechado");
        System.out.println("Compra fechada.");
    }

    public void cancelarCompra() {
        compra.setStatusCompra("Cancelado");
        System.out.println("Compra cancelada.");
    }

    // public double calcularValorTotalDaCompra() {
    // double total = 0;
    // for (var item : compra.getItens()) {
    // total += item.calcularValorTotalDoItem();
    // }
    // System.out.println("Valor total da compra: R$ " + total);
    // return total;
    // }

    public void salvar() {
        try {
            CompraDao.salvar(this.compra);
            System.out.println("COmpra Salvo Com sucesso!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Compra Não Salvo!!!");
        }
    }

    public void deletar() {
        try {
            CompraDao.deletar(this.compra);
            System.out.println("Cliente Deletado Com sucesso!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cliente Não Deletado!!!");
        }
    }
}
