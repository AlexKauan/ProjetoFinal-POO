package com.project.controllers;

import com.project.model.dao.ClienteDao;
import com.project.model.entidades.Cliente;
import com.project.view.ClienteView;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteController {
    private Cliente cliente;
    private ClienteView clienteView;

    public ClienteController(Cliente cliente, ClienteView clienteView) {
        this.cliente = cliente;
        this.clienteView = clienteView;
    }

    public ClienteController(Cliente cliente) {
        this.cliente = cliente;
    }

    public int calcularNumeroDeCompras() {
        return cliente.getNumeroDeCompras();
    }

    public static void cadastraCliente(Cliente cliente) throws SQLException {
        try {
            ClienteDao.salvar(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void atualizarCliente(int idCliente, String login, String senha, String nome, String telefone,
            String email, String endereco, int numeroDeCompras, double totalComprado) {
        try {
            Cliente cliente = ClienteDao.pegar(idCliente);
            if (cliente == null) {
                System.out.println("Esse cliente não existe\n");
            } else {
                cliente.editarPessoa(login, senha, nome, telefone, email, endereco, numeroDeCompras, totalComprado);
                ClienteDao.salvar(cliente);
                System.out.println("\nCliente editado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar o Cliente: " + e.getMessage());
        }
    }

    public static void mostrarCliente(int idCliente) {
        try {
            Cliente cliente = ClienteDao.pegar(idCliente);
            if (cliente == null) {
                System.out.println("Esse cliente não existe\n");
            } else {
                System.out.println("\nInformações do cliente:\n");
                System.out.println(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar o Cliente: " + e.getMessage());
        }
    }

    public static Cliente buscarCliente(int idCliente) {
        try {
            return ClienteDao.pegar(idCliente);
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
            return null;
        }
    }

    public static void listarClientes() { 
        try {
            ArrayList<Cliente> clientes = ClienteDao.pegarTodos();
            if (clientes.isEmpty()) {
                System.out.println("Ainda não há clientes no sistema\n");
            } else {
                for (Cliente cliente : clientes) {
                    System.out.println(cliente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar os Clientes: " + e.getMessage());
        }
    }

    public static void removerCliente(int idCliente) {
        try {
            Cliente cliente = ClienteDao.pegar(idCliente);
            if (cliente == null) {
                System.out.println("Esse cliente não existe\n");
            } else {
                ClienteDao.deletar(cliente);
                System.out.println("\nCliente deletado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o Cliente: " + e.getMessage());
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
