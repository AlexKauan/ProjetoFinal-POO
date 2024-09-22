package com.project.model;

public class Vendedor {
    private double salario;
    private int numeroDeVendas;
    private double totalVendido;

    public Vendedor(double salario, int numeroDeVendas, double totalVendido) {
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

    public void cadastrarVendidos(){

    }

    public void mostrarVendedor(){

    }

    public void listarVendedores(){

    }

    public void editarVendedor(){
        
    }
}
