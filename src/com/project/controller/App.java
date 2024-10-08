package com.project.controller;

import com.project.model.DAO.BancoDeDados;

public class App {
    public static void main(String[] args) {
        try {
            BancoDeDados.iniciarConexao();
        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o banco de dados");
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }
}