package com.project.model.entidades;

import com.project.util.Validacao;
import java.util.List;

public abstract class Pessoa {

    private int id;
    private String login;
    private String senha;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private static Pessoa pessoaLogada;

    public Pessoa(){}

    // Construtor da classe Pessoa
    public Pessoa(String login, String senha, String nome, String telefone, String email, String endereco) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    // Construtor da classe Pessoa
    public Pessoa(int id, String login, String senha, String nome, String telefone, String email, String endereco) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    // Métodos abstratos

    public void mostrarPessoa() {
        System.out.println(this.toString());
    }

    public void editarPessoa(String nome, String telefone, String endereco, String senha) {
        if (nome != null && !nome.isEmpty()) {
            this.setNome(nome);
        }
        if (senha != null && !senha.isEmpty()) {
            this.setSenha(senha);
        }
        if (telefone != null && !telefone.isEmpty()) {
            this.setTelefone(telefone);
        }
        if (endereco != null && !endereco.isEmpty()) {
            this.setEndereco(endereco);
        }

    }

    public void listarPessoas(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            pessoa.mostrarPessoa();
        }
    }

    public void removerPessoa(List<Pessoa> pessoas) {
        pessoas.remove(this); // Remove esta pessoa da lista de pessoas
    }

    public boolean logarPessoa(String login, String senha) {
        if (this.getLogin().equals(login) && this.getSenha().equals(senha)) {
            pessoaLogada = this;
            return true;
        }
        return false;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        /*if (Validacao.validarTelefone(telefone)) {
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("Telefone inválido.");
        }*/
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Validacao.validarEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("E-mail inválido.");
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pessoa{");
        sb.append("id=").append(id);
        sb.append(", login=").append(login);
        sb.append(", nome=").append(nome);
        sb.append(", telefone=").append(telefone);
        sb.append(", email=").append(email);
        sb.append(", endereco=").append(endereco);
        sb.append('}');
        return sb.toString();
}
}