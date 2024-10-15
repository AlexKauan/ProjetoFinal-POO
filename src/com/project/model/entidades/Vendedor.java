package com.project.model.entidades;

import java.util.List;

public class Vendedor extends Pessoa {
    private double salario;
    private int numeroDeVendas;
    private double totalVendido;

    public Vendedor() {
        super();
    }

    public Vendedor(double salario, int numeroDeVendas, double totalVendido, int id, String login, String senha,
            String nome, String telefone, String email, String endereco) {
        super(id, login, senha, nome, telefone, email, endereco);
        this.salario = salario;
        this.numeroDeVendas = numeroDeVendas;
        this.totalVendido = totalVendido;
    }

    public Vendedor(double salario, int numeroDeVendas, double totalVendido, String login, String senha,
        String nome,String telefone, String email, String endereco) {
        super(login, senha, nome, telefone, email, endereco);
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
        System.out.println(this.toString());
    }

    public void editarVendedor(String nome, String endereco, String telefone, String senha) {
        super.editarPessoa(nome, telefone, endereco, senha);
    }

    public void listarVendedor(List<Vendedor> vendedores) {
        for (Vendedor vendedor : vendedores) {
            vendedor.mostrarPessoa();
        }
    }

    public void removerVendedor(List<Vendedor> vendedores) {
        vendedores.remove(this);
    }

    public boolean logarVendedor(String login, String senha) {
        return super.logarPessoa(login, senha);
    }

    public int calcularNumeroDeVendas() {
        return numeroDeVendas;
    }

    public double calcularTotalVendido() {
        return totalVendido;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id='" + getId() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", login='" + getLogin() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", salario=" + salario +
                ", numeroDeVendas=" + numeroDeVendas +
                ", totalVendido=" + totalVendido +
                '}';
    }

    

}