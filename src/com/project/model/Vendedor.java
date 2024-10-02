package com.project.model;

public class Vendedor extends Pessoa {
    private double salario;
    private int numeroDeVendas;
    private double totalVendido;

    public Vendedor(double salario, int numeroDeVendas, double totalVendido, int id, String login, String senha,
            String nome,
            String telefone, String email, String endereco) {
        super(id, login, senha, nome, telefone, email, endereco);
        this.salario = salario;
        this.numeroDeVendas = numeroDeVendas;
        this.totalVendido = totalVendido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getNumeroDeVendas() {
        return numeroDeVendas;
    }

    public void setNumeroDeVendas(int numeroDeVendas) {
        this.numeroDeVendas = numeroDeVendas;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(double totalVendido) {
        this.totalVendido = totalVendido;
    }

    public void mostrarVendedor() {
        System.out.println("Dados do cliente: " + this.toString());
    }

    public void editarVendedor(String nome, String endereco, String telefone, String senha) {
        super.editarPessoa(nome, telefone, endereco, senha);

    }

    public void listarVendedor() {
        System.out.println("Lista de clientes.");
    }

    public void removerVendedor() {
        System.out.println("Cliente removido.");
    }

    public boolean logarVendedor(String login, String senha) {
        return this.getLogin().equals(login) && this.getSenha().equals(senha);
    }

    public int calcularNumeroDeVendas() {
        return numeroDeVendas;
    }

    public double calcularTotalVendido() {
        return totalVendido;
    }

}