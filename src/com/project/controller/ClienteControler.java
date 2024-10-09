package com.project.controller;

import com.project.model.entidades.Cliente;
import com.project.view.ClienteView;

public class ClienteControler {
  private Cliente cliente;
    private ClienteView clienteView;

    // Construtor
    public ClienteControler(Cliente cliente, ClienteView clienteView) {
        this.cliente = cliente;
        this.clienteView = clienteView;
    }

    public void atualizarNome(String novoNome) {
        cliente.setNome(novoNome);
        System.out.println("Nome atualizado com sucesso!");
    }

    public void atualizarTelefone(String novoTelefone) {
        cliente.setTelefone(novoTelefone);
        System.out.println("Telefone atualizado com sucesso!");
    }

    public void atualizarEmail(String novoEmail) {
        cliente.setEmail(novoEmail);
        System.out.println("Email atualizado com sucesso!");
    }

    public void atualizarEndereco(String novoEndereco) {
        cliente.setEndereco(novoEndereco);
        System.out.println("Endereço atualizado com sucesso!");
    }

    public void atualizarNumeroDeCompras(int novoNumeroDeCompras) {
        cliente.setNumeroDeCompras(novoNumeroDeCompras);
        System.out.println("Número de compras atualizado com sucesso!");
    }

    public void atualizarTotalComprado(double novoTotalComprado) {
        cliente.setTotalComprado(novoTotalComprado);
        System.out.println("Total comprado atualizado com sucesso!");
    }

    public void exibirInformacoes() {
        clienteView.printInformacoes(cliente);
    }

    // Getters e Setters para Cliente e ClienteView, caso seja necessário

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteView getClienteView() {
        return clienteView;
    }

    public void setClienteView(ClienteView clienteView) {
        this.clienteView = clienteView;
    }
}
