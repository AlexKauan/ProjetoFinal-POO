package com.project.model.entidades;

public class Cliente extends Pessoa {

    private int numeroDeCompras;
    private double totalComprado;

    public Cliente() {
       super();
    }

    public Cliente(int id, String login, String senha, String nome,
        String telefone, String email, String endereco, int numeroDeCompras, double totalComprado) {
        super(id, login, senha, nome, telefone, email, endereco);
        this.numeroDeCompras = numeroDeCompras;
        this.totalComprado = totalComprado;
    }

    public Cliente(String login, String senha, String nome,
        String telefone, String email, String endereco, int numeroDeCompras, double totalComprado) {
        super(login, senha, nome, telefone, email, endereco);
        this.numeroDeCompras = numeroDeCompras;
        this.totalComprado = totalComprado;
    }

    public int getNumeroDeCompras() {
        return numeroDeCompras;
    }

    public void setNumeroDeCompras(int numeroDeCompras) {
        this.numeroDeCompras = numeroDeCompras;
    }

    public double getTotalComprado() {
        return totalComprado;
    }

    public void setTotalComprado(double totalComprado) {
        this.totalComprado = totalComprado;
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
