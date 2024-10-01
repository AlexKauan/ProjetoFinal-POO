package com.project.controller;

import com.project.model.Cliente;
import com.project.model.DAO.BancoDeDados;

public class App {
    public static void main(String[] args) {
        // Cliente pessoa1 = new Cliente("null", "null", "null", "Alex", "null", "null", "null", 12, 1.0);
        // System.out.println(pessoa1);
        try {
            BancoDeDados.iniciarConexao();
        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o banco de dados");
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
