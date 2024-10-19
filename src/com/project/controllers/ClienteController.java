package com.project.controllers;

import com.project.model.DAO.ClienteDAO;
import com.project.model.entidades.Cliente;
import com.project.view.ClienteView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private Cliente cliente;
    private ClienteView clienteView;

    // Construtor
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

    public static void cadastraCliente(String login, String senha, String nome, String telefone, String email,
            String endereco, int numeroDeCompras, double totalComprado) {
        Cliente cliente = Cliente.criarCliente(login, senha, nome, telefone, email, endereco, numeroDeCompras,
                totalComprado);
        try {
            ClienteDAO.salvar(cliente);
            System.out.println("\nCLiente cadastrado com sucesso\n");
        } catch (SQLException e) {
            System.out.println("Erro ao criar o Cliente");
        }
    }

    public static void atualizarCliente(int idCliente, String login, String senha, String nome, String telefone,
            String email,
            String endereco, int numeroDeCompras, double totalComprado) {
        try {
            Cliente cliente = ClienteDAO.pegar(idCliente);
            if (cliente == null) {
                System.out.println("Esse cliente não existe\n");
            } else {
                cliente.editarPessoa(login, senha, nome, telefone, email, endereco, numeroDeCompras,
                        totalComprado);
                ClienteDAO.salvar(cliente);
                System.out.println("\nCliente editado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar o Cliente");
        }
    }

    public static void mostrarCliente(int idCliente) {
        Cliente cliente;
        try {
            cliente = ClienteDAO.pegar(idCliente);
            if (cliente == null) {
                System.out.println("Esse cliente não existe\n");
            } else {
                System.out.println("\nInformações do cliente:\n");
                System.out.println(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar o Cliente");
        }
    }

    public static void editarCliente(int idCliente, String nome, String endereco, String telefone, String senha) {
        try {
            Cliente cliente = ClienteDAO.pegar(idCliente);
            if (cliente == null) {
                System.out.println("Esse cliente não existe\n");
            } else {
                cliente.editarPessoa(nome, endereco, telefone, senha);
                ClienteDAO.salvar(cliente);
                System.out.println("\nCliente editado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar o Cliente");
        }
    }

    public static void listarClientes() {
        try {
            ArrayList<Cliente> clientes = ClienteDAO.pegarTodos();
            if (clientes.size() == 0) {
                System.out.println("Ainda não há clientes no sistema\n");
            } else {
                for (Cliente cliente : clientes)
                    System.out.println(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao Listar os Clientes");
        }

    }

    public void removerCliente(List<Cliente> clientes) {
        clientes.remove(this);
    }

    public static void logarCliente(String login, String senha) {

        Cliente cliente;
        boolean esta_logado;
        try {
            cliente = ClienteDAO.pegar_por_login(login);
            if (cliente != null) {
                esta_logado = cliente.logarPessoa(login, senha);
                if (esta_logado) {
                    System.out.println("Cliente logado com sucesso!!!");
                } else {
                    System.out.println("Senha incorreta!");

                }
            } else {
                System.out.println("Login incorreto");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void salvar() {
        try {
            ClienteDAO.salvar(this.cliente);
            System.out.println("Cliente Salvo Com sucesso!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cliente Não Salvo!!!");
        }
    }

    public static void removerCliente(int idCliente) {
        try {
            Cliente cliente = ClienteDAO.pegar(idCliente);
            if (cliente == null) {
                System.out.println("Esse cliente não existe\n");
            } else {
                ClienteDAO.deletar(cliente);
                System.out.println("\nCliente deletado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o Cliente");
        }
    }

    public static Cliente buscarCliente(int idCliente) {
        Cliente cliente;
        try {
            cliente = ClienteDAO.pegar(idCliente);
            if (cliente == null) {
                System.out.println("Esse cliente não existe\n");
                return cliente;
            } else {
                return cliente;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar um cliente");
            return null;
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
