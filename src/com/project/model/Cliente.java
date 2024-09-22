package com.project.model;

public class Cliente extends Pessoa {

    private int numeroDeCompras;
    private double totalComprado;

    // Construtor padrão vazio
    public Cliente() {
    }

    // Construtor com parâmetros
    public Cliente(long id, String login, long senha, String nome, int telefone, String email, String endereco) {
        super(id, login, senha, nome, telefone, email, endereco);
        this.numeroDeCompras = 0;
        this.totalComprado = 0.0;
    }

    // Métodos específicos do cliente
    public int calcularNumeroDeCompras() {
        return this.numeroDeCompras;
    }

    // Métodos abstratos sobrescritos de Pessoa
    @Override
    public void cadastrarPessoa() {
    }

    @Override
    public void mostrarPessoa() {
    }

    @Override
    public void editarPessoa() {
    }

    @Override
    public void listarPessoas() {
    }

    @Override
    public void removerPessoa() {
    }

    @Override
    public boolean logarPessoa(String login, long senha) {
        return false;
    }
}
