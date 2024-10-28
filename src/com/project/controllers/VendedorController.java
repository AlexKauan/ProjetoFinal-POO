package com.project.controllers;

import com.project.model.dao.VendedorDao;
import com.project.model.entidades.Vendedor;
import com.project.view.VendedorView;
import java.sql.SQLException;

public class VendedorController {
    private Vendedor vendedor;
    private VendedorView vendedorView;

    public VendedorController(Vendedor vendedor, VendedorView vendedorView) {
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

    public void atualizarSenha(String novaSenha) {
        vendedor.setSenha(novaSenha);
        System.out.println("Senha atualizada com sucesso!");
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

    public void atualizarSalario(Double novoSalario) {
        vendedor.setSalario(novoSalario);
        System.out.println("Salário atualizado com sucesso!");
    }

    public void atualizarNumeroDeVendas(int novoNumeroDeVendas) {
        vendedor.setNumeroDeVendas(novoNumeroDeVendas);
        System.out.println("Número de vendas atualizado com sucesso!");
    }

    public void atualizarTotalVendido(Double novoTotalVendido) {
        vendedor.setTotalVendido(novoTotalVendido);
        System.out.println("Total vendido atualizado com sucesso!");
    }

    public void exibirInformacoes() {
        vendedorView.printInformacoes(this.vendedor);
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
