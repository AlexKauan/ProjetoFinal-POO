package com.project.controller;

import com.project.model.DAO.BancoDeDados;
import com.project.model.DAO.ClienteDAO;
import com.project.model.DAO.CompraDAO;
import com.project.model.entidades.Cliente;
import com.project.model.entidades.Compra;
import com.project.view.CompraView;

import java.util.ArrayList;

public class AppCompra {
    public static void main(String[] args) {
        try {
            // Iniciando a conexão com o banco de dados
            BancoDeDados.iniciarConexao();
            System.out.println("Conexão com o banco de dados iniciada com sucesso.");

            
            Cliente cliente = ClienteDAO.pegar(1);      
            Compra compra = new Compra(cliente,"2025-09-12","Ativo");
            // Criando a visualização (ClienteView)
            CompraView compraView = new CompraView();
      
            // Criando o controlador (CompraControle)
             CompraControle compraControle = new CompraControle(compra, compraView);

            // compraControle.atualizarDate("2024-08-12");
            

             compraControle.salvar();

            // Exibindo as informações atualizadas do compra
          //  compraControle.deletar();


       // compraControle.exibirInformacoes();
         ArrayList<CompraControle>  compraControlers = new ArrayList<CompraControle>();
        CompraControle compraControler = null;
        
        // Aqui esta pegando todos os compras da lista que esta no banco de dados
        for (Compra compra1 : CompraDAO.pegarTodos()) {
            compraControler = new CompraControle(compra1, compraView);
            compraControlers.add(compraControler);
        }
        
        // Aqui esta exibindo todas as informações dos compras cadastrado no banco de dados
        System.out.println("\n====================================================================\n");
        for (CompraControle compraControler2 : compraControlers) {
            compraControler2.exibirInformacoes();
            System.out.println("\n====================================================================\n");
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
