package com.project.controller;

import com.project.model.DAO.ClienteDAO;
import com.project.model.entidades.Cliente;
import com.project.view.ClienteView;
import java.sql.SQLException;
import java.util.List;

public class ClienteControler {
    private Cliente cliente;
    private ClienteView clienteView;

    // Construtor
    public ClienteControler(Cliente cliente, ClienteView clienteView) {
        this.cliente = cliente;
        this.clienteView = clienteView;
    }

    
    public int calcularNumeroDeCompras() {
        return cliente.getNumeroDeCompras();
    }

    public void mostrarCliente() {
        System.out.println(cliente.toString());
    }

    public void editarCliente(String nome, String endereco, String telefone, String senha) {
        cliente.editarPessoa(nome, telefone, endereco, senha);
    }

    public void listarClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            cliente.mostrarPessoa();
        }
    }

    public void removerCliente(List<Cliente> clientes) {
        clientes.remove(this); 
    }

    public boolean logarCliente(String login, String senha) {
        return cliente.logarPessoa(login, senha); 
    }
    

    public void salvar(){
        try {
            ClienteDAO.salvar(this.cliente);
            System.out.println("Cliente Salvo Com sucesso!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cliente Não Salvo!!!");
        }
    }

    public void deletar(){
        try {
            ClienteDAO.deletar(this.cliente);
            System.out.println("Cliente Deletado Com sucesso!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cliente Não Deletado!!!");
        }
    }


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

