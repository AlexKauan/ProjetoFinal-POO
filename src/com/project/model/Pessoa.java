package com.project.model;

public abstract class Pessoa {

    public abstract void cadastrarPessoa();

    public abstract void mostrarPessoa();

    public abstract void editarPessoa();

    public abstract void listarPessoas();

    public abstract void removerPessoa();

    public abstract boolean logarPessoa(String login, long senha);
}
