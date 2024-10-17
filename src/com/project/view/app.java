package com.project.view;

import java.util.ArrayList;

import com.project.controller.ClienteControler;
import com.project.model.DAO.BancoDeDados;
import com.project.model.DAO.ClienteDAO;
import com.project.model.entidades.Cliente;

public class app {
 public static void main(String[] args) {
        try {
            // Iniciando a conexão com o banco de dados
            BancoDeDados.iniciarConexao();
            System.out.println("Conexão com o banco de dados iniciada com sucesso.");

            // Criando o modelo (Cliente)
            Cliente cliente = new Cliente("user1", "senha123", "João Silva", "123456789", "joao@gmail.com", "Rua B", 5, 1500.00);
           // Cliente cliente = ClienteDAO.pegar(1);
            
            // Criando a visualização (ClienteView)
            ClienteView clienteView = new ClienteView();

            // Criando o controlador (ClienteController)
             ClienteControler clienteController = new ClienteControler(cliente, clienteView);

            // Atualizando algumas informações do cliente
            //clienteController.atualizarNome("Alex Kauan");
            //clienteController.atualizarTelefone("(84) 99841-3374");
            //clienteController.atualizarEmail("alex@exemplo.com");
            //clienteController.atualizarEndereco("Rua C");
            //clienteController.atualizarLogin("gabriel");
            //clienteController.atualizarSenha("senha123");
              clienteController.atualizarTotalComprado(2000.00);
              clienteController.salvar();
            

            // Exibindo as informações atualizadas do cliente
            // clienteController.exibirInformacoes();
           // clienteController.deletar();

        ArrayList<ClienteControler>  clienteControlers = new ArrayList<ClienteControler>();
        ClienteControler clienteControler = null;
        
        // Aqui esta pegando todos os clientes da lista que esta no banco de dados
        for (Cliente cliente2 : ClienteDAO.pegarTodos()) {
            clienteControler = new ClienteControler(cliente2, clienteView);
            clienteControlers.add(clienteControler);
        }
        
        // Aqui esta exibindo todas as informações dos clientes cadastrado no banco de dados
        System.out.println("\n======================================\n");
        for (ClienteControler clienteControler2 : clienteControlers) {
            clienteControler2.exibirInformacoes();
            System.out.println("\n======================================\n");
        }

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
