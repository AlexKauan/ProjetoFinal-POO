package com.project.model;

import java.util.List;

public class Cliente extends Pessoa {

    private int numeroDeCompras;
    private double totalComprado;

    public Cliente(int id, String login, String senha, String nome,
            String telefone, String email, String endereco, int numeroDeCompras, double totalComprado) {
        super(id, login, senha, nome, telefone, email, endereco);
        this.numeroDeCompras = numeroDeCompras;
        this.totalComprado = totalComprado;
    }

    public int calcularNumeroDeCompras() {
        return this.numeroDeCompras;
    }

    public void mostrarCliente() {
        System.out.println("Dados do cliente: " + this.toString());
    }

    public void editarCliente(String nome, String endereco, String telefone, String senha) {
        super.editarPessoa(nome, telefone, endereco, senha);
    }

    public void listarClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            cliente.mostrarPessoa();
        }
    }

    public void removerCliente(List<Cliente> clientes) {
        clientes.remove(this); // Remove esta pessoa da lista de pessoas
    }

    public boolean logarCliente(String login, String senha) {
        return this.getLogin().equals(login) && this.getSenha().equals(senha);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + getId() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", login='" + getLogin() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", numeroDeCompras=" + numeroDeCompras +
                ", totalComprado=" + totalComprado +
                '}';
    }
}
