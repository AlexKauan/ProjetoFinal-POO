package com.project.controllers;

import com.project.model.entidades.Cliente;
import com.project.model.entidades.Vendedor;
import com.project.model.entidades.Pessoa;
import com.project.model.dao.ClienteDao;
import com.project.model.dao.VendedorDao;
import java.sql.SQLException;

public class PessoaController {

    // Método para logar tanto clientes quanto vendedores
    public static Pessoa logarPessoa(String login, String senha) {
        try {
            // Tenta logar como cliente
            Cliente cliente = ClienteDao.pegar_por_login(login);
            if (cliente != null && cliente.getSenha().equals(senha)) {
                return cliente;
            }

            // Se não for cliente, tenta logar como vendedor
            Vendedor vendedor = VendedorDao.pegar_por_login(login);
            if (vendedor != null && vendedor.getSenha().equals(senha)) {
                return vendedor;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao tentar logar a pessoa: " + e.getMessage());
        }

        return null; // Se as credenciais estiverem incorretas
    }

    // Método para validar senhas fortes (opcional)
    public static boolean validarSenhaForte(String senha) {
        return senha.length() >= 8 && senha.matches(".*[A-Za-z].*") && senha.matches(".*[0-9].*");
    }
}
