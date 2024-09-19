package com.project.model;


public abstract class Pessoa {

    private long id;
    private String login;
    private long senha;
    private String nome;
    private int telefone;
    private String email;
    private String endereco; 

    public abstract void cadastrarPessoa();

    public abstract void mostrarPessoa();

    public abstract void editarPessoa();

    public abstract void listarPessoas();

    public abstract void removerPessoa();

    public abstract boolean logarPessoa(String login, long senha);
}
