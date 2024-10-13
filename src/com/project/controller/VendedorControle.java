package com.project.controller;

import com.project.model.DAO.VendedorDAO;
import com.project.model.entidades.Vendedor;
import com.project.view.VendedorView;
import java.sql.SQLException;

public class VendedorControle {
    private Vendedor vendedor;
    private  VendedorView vendedorView;

     // Construtor
    public VendedorControle(Vendedor vendedor, VendedorView vendedorView) {
        this.vendedor = vendedor;
        this.vendedorView = vendedorView;
    }

    public void atualizariId(int novoId) {
        vendedor.setId(novoId);
        System.out.println("Id atualizado com sucesso!");
    }

    public void atualizarNome(String novoNome) {
        vendedor.setNome(novoNome);
        System.out.println("Nome atualizado com sucesso!");
    }

    public void atualizarLogin(String novoLogin) {
        vendedor.setLogin(novoLogin);
        System.out.println("Login atualizado com sucesso!");
    }

    public void atualizarSenha(String novoSenha) {
        vendedor.setSenha(novoSenha);
        System.out.println("Senha atualizado com sucesso!");
    }

    public void atualizarTelefone(String novoTelefone) {
        vendedor.setTelefone(novoTelefone);
        System.out.println("Telefone atualizado com sucesso!");
    }

    public void atualizarEmail(String novoEmail) {
        vendedor.setEmail(novoEmail);
        System.out.println("Email atualizado com sucesso!");
    }

    public void atualizarEndereco(String novoEndereco) {
        vendedor.setEndereco(novoEndereco);
        System.out.println("Endereço atualizado com sucesso!");
    }

    public void atualizarSalario(Double novosalario) {
        vendedor.setSalario(novosalario);
        System.out.println("Salario atualizado com sucesso!");
    }

    public void atualizarNumeroDeVendas(int novoNumeroDeVendas) {
        vendedor.setNumeroDeVendas(novoNumeroDeVendas);
        System.out.println("Salario atualizado com sucesso!");
    }

    public void atualizarTotalVendido(Double novoTotalVendido) {
        vendedor.setTotalVendido(novoTotalVendido);
        System.out.println("Salario atualizado com sucesso!");
    }

    public void exibirInformacoes() {
        vendedorView.printInformacoes(this.vendedor);
    }

    public void salvar(){
        try {
            VendedorDAO.salvar(this.vendedor);
            System.out.println("Cliente Salvo Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Cliente Não Salvo!!!");
        }
    }

    public void deletar(){
        try {
            VendedorDAO.deletar(this.vendedor);
            System.out.println("Cliente Deletado Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Cliente Não Deletado Com sucesso!!!");
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

    
}
