package com.project.model;

public abstract class Pessoa {

    private long id;
    private String login;
    private long senha;
    private String nome;
    private int telefone;
    private String email;
    private String endereco;

    // Construtor com parâmetros
    public Pessoa(long id, String login, long senha, String nome, int telefone, String email, String endereco) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    // Construtor padrão vazio
    public Pessoa() {
    }

    // Getters e setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Métodos abstratos
    public abstract void cadastrarPessoa();

    public abstract void mostrarPessoa();

    public abstract void editarPessoa();

    public abstract void listarPessoas();

    public abstract void removerPessoa();

    public abstract boolean logarPessoa(String login, long senha);
}