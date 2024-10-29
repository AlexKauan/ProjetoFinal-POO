package com.project.model.entidades;

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
            String nome, String telefone, String email, String endereco) {
        super(login, senha, nome, telefone, email, endereco);
        this.salario = salario;
        this.numeroDeVendas = numeroDeVendas;
        this.totalVendido = totalVendido;
    }

    public void mostrarVendedor(Vendedor vendedor) {
        System.out.println(this.toString());
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