package com.project.controllers;

import com.project.model.dao.VendedorDao;
import com.project.model.entidades.Vendedor;
import com.project.view.VendedorView;
import java.sql.SQLException;
import java.util.List;

public class VendedorController {
    private Vendedor vendedor;
    private VendedorView vendedorView;
    private List<Vendedor> vendedores;

    public VendedorController(Vendedor vendedor, VendedorView vendedorView) {
        this.vendedor = vendedor;
        this.vendedorView = vendedorView;
    }

    public void editarVendedor(String nome, String endereco, String telefone, String senha) {
        vendedor.editarPessoa(nome, telefone, endereco, senha);
    }

    public void listarVendedor(List<Vendedor> vendedores) {
        if (vendedores.isEmpty()){
            System.out.println("Não tem vendedores");
        } else {
            for(Vendedor vendedor : vendedores){
                vendedor.mostrarVendedor(vendedor);
            }
        }
    }

    public void removerVendedor(List<Vendedor> vendedores) {
        vendedores.remove(this);
    }

    public void salvar() {
        try {
            VendedorDao.salvar(this.vendedor);
            System.out.println("Vendedor salvo com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar vendedor!");
        }
    }

    public void deletar() {
        try {
            VendedorDao.deletar(this.vendedor);
            System.out.println("Vendedor deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar vendedor!");
        }
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public VendedorView getVendedorView() {
        return vendedorView;
    }

    public void setVendedorView(VendedorView vendedorView) {
        this.vendedorView = vendedorView;
    }

    public static void cadastrarVendedor(Vendedor vendedor) {
        try {
            VendedorDao.salvar(vendedor);
            System.out.println("Vendedor cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o vendedor: " + e.getMessage());
        }
    }
}
