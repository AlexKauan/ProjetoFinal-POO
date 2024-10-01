package com.project.model;

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

    public int calcularNumeroDeCompras() {
        return this.numeroDeCompras;
    }

    public void cadastrarCliente() {
        System.out.println("Cliente cadastrado: " + this.getNome());
    }

    public void mostrarCliente() {
        System.out.println("Dados do cliente: " + this.toString());
    }

    public void editarCliente() {
        System.out.println("Cliente editado.");
    }

    public void listarCliente() {
        System.out.println("Lista de clientes.");
    }

    public void removerCliente() {
        System.out.println("Cliente removido.");
    }

    public boolean logarCliente(String login, String senha) {
        return this.getLogin().equals(login) && this.getSenha().equals(senha);
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
