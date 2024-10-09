
package com.project.model.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.project.model.Produto;

public class ProdutoDAO{

    public static Connection conn;

    public static Produto pegar(int id) throws SQLException {
        Produto produto = null;
        String sql = "SELECT idProduto, descricao, precoUnitario, quantidadeDisponivel from produto where idProduto = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            produto = new Produto();
            produto.setId(rs.getInt("idProduto"));
            produto.setInt(rs.getString("descricao"));       
            produto.setString(rs.getString("precoUnitario"));
            produto.setInt(rs.getString("quantidadeDisponivel"));     
            
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return produto;
    }

    public static ArrayList<Produto> pegarTodos() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto produto = null;
        String sql = "SELECT id_compra, id_cliente, id_vendedor, data, status, from produto";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            produto = new Produto();
            produto.setId(rs.getInt("idProduto"));
            produto.setInt(rs.getString("descricao"));       
            produto.setString(rs.getString("precoUnitario"));
            produto.setInt(rs.getString("quantidadeDisponivel"));      
            produtos.add(produto);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return produto;
    }

    public static int inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (idProduto, descricao, precoUnitario, quantidadeDisponivel) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, produto.getidProduto());
        ps.setString(2, produto.getDescricao());
        ps.setDouble(3, produto.getPrecoUnitario);
        ps.setInt(4, produto.getQuantidadeDisponivel());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int atualizar(Produto produto) throws SQLException {
        String sql = "UPDATE produto set descricao = ?, precoUnitario = ? quantidadeDisponivel = ? WHERE idProduto = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, produto.getidProduto());
        ps.setString(2, produto.getDescricao());
        ps.setDouble(3, produto.getPrecoUnitario);
        ps.setInt(4, produto.getQuantidadeDisponivel());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void salvar(Produto produto) throws SQLException {
        if (produto.getIdProduto() != 0)
            atualizar(produto);
        else
            inserir(produto);
    }

    public static int deletar(Produto produto) throws SQLException {
        String sql = "DELETE FROM produto WHERE idProduto = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, produto.getIdProduto);

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

}