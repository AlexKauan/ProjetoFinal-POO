package com.project.controller;

import com.project.model.DAO.BancoDeDados;
import com.project.model.DAO.VendedorDAO;
import com.project.model.entidades.Vendedor;
import com.project.view.VendedorView;

import java.util.ArrayList;

public class AppVendedor {
    public static void main(String[] args) {
        try {
            // Iniciando a conexão com o banco de dados
            BancoDeDados.iniciarConexao();
            System.out.println("Conexão com o banco de dados iniciada com sucesso.");

            // Criando o modelo (Cliente)
        
           // Vendedor vendedor = new Vendedor(1500.00, 5, 200.00, "user1", "senha123", "Gabriel", "123456789", "gabriel@gmail.com", "Rua B");
            Vendedor vendedor = VendedorDAO.pegar(1);
            
            // Criando a visualização (ClienteView)
            VendedorView vendedorVieww = new VendedorView();

            // Criando o controlador (ClienteController)
             VendedorControle vendedorControlle = new VendedorControle(vendedor, vendedorVieww);

            // Atualizando algumas informações do cliente

             // vendedorControlle.atualizarNome("Alex Kauan");
             // vendedorControlle.atualizarTelefone("(84) 99841-2183");
             // vendedorControlle.atualizarEmail("alex.silva@exemplo.com");
            // clienteController.atualizarEndereco("Rua C");
            // clienteController.atualizarLogin("Pedro");
            // clienteController.atualizarSenha("senha123");

             // vendedorControlle.salvar();
            

            // Exibindo as informações atualizadas do cliente
            // vendedorControlle.exibirInformacoes();
           // clienteController.deletar();
              vendedorControlle.deletar();

        /*ArrayList<VendedorControle>  vendedorControlers = new ArrayList<VendedorControle>();
        VendedorControle vendedorControle = null;
        
        // Aqui esta pegando todos os clientes da lista que esta no banco de dados
        for (Vendedor vendedor2 : VendedorDAO.pegarTodos()) {
            vendedorControle = new VendedorControle(vendedor2, vendedorVieww);
            vendedorControlers.add(vendedorControle);
        }
        
        // Aqui esta exibindo todas as informações dos clientes cadastrado no banco de dados
        System.out.println("\n==========================================\n");
        for (VendedorControle vendedorControler2 : vendedorControlers) {
            vendedorControler2.exibirInformacoes();
            System.out.println("\n==========================================\n");
        }*/

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

