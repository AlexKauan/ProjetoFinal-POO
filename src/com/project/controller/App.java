package com.project.controller;

import com.project.model.DAO.BancoDeDados;
import com.project.model.entidades.Cliente;
import com.project.view.ClienteView;

public class App {
    public static void main(String[] args) {
        try {
            // Iniciando a conexão com o banco de dados
            BancoDeDados.iniciarConexao();
            System.out.println("Conexão com o banco de dados iniciada com sucesso.");

            // Criando o modelo (Cliente)
            Cliente cliente = new Cliente(1, "user1", "senha123", "João Silva", "123456789", "joao@gmail.com", "Rua A", 5, 1500.00);

            // Criando a visualização (ClienteView)
            ClienteView clienteView = new ClienteView();

            // Criando o controlador (ClienteController)
            ClienteControler clienteController = new ClienteControler(cliente, clienteView);

            // Atualizando algumas informações do cliente
            clienteController.atualizarNome("João da Silva");
            clienteController.atualizarTelefone("987654321");
            clienteController.atualizarEmail("joao.silva@exemplo.com");

            // Exibindo as informações atualizadas do cliente
            clienteController.exibirInformacoes();

        } catch (Exception e) {
            System.out.println("Erro ao iniciar conexão com o banco de dados.");
            e.printStackTrace(); // Corrigido para exibir a pilha de erros
            System.out.println(e.getMessage());
        } finally {
            try {
                // Fechando a conexão com o banco de dados
                BancoDeDados.fecharConexao();
                System.out.println("Conexão com o banco de dados fechada.");
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão com o banco de dados.");
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}
