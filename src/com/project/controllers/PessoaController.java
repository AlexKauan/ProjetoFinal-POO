package com.project.controllers;

import com.project.model.dao.ClienteDao;
import com.project.model.entidades.Cliente;
import com.project.model.entidades.Pessoa;
import java.sql.SQLException;

public class PessoaController {

    public static Pessoa logarPessoa(String login, String senha) {
        try {
            Cliente cliente = ClienteDao.pegar_por_login(login);
            if (cliente != null && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao tentar logar a pessoa: " + e.getMessage());
        }
        return null;
    }

    public static boolean validarSenhaForte(String senha) {
        return senha.length() >= 8 && senha.matches(".*[A-Za-z].*") && senha.matches(".*[0-9].*");
    }
}
