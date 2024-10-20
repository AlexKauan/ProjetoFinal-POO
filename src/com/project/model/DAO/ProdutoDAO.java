
package com.project.model.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.project.model.entidades.Produto;

public class ProdutoDAO{

    public static Connection conn;

    public static Produto pegar(int id) throws SQLException {
        Produto produto = null;
        String sql = "SELECT id_produto, codigoDoProduto, descricao, precoUnitario, quantidadeDisponivel from produto where id_produto = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            produto = new Produto();
            produto.setIdProduto(rs.getInt("id_produto")); 
            produto.setCodigoDoProduto(rs.getInt("codigoDoProduto")); 
            produto.setDescricao(rs.getString("descricao"));       
            produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
            produto.setQuantidadeDisponivel(rs.getInt("quantidadeDisponivel"));     
            
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return produto;
    }

    public static ArrayList<Produto> pegarTodos() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto produto = null;
        String sql = "SELECT id_produto, codigoDoProduto, descricao, precoUnitario, quantidadeDisponivel from produto";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            produto = new Produto();
            produto.setIdProduto(rs.getInt("id_produto")); 
            produto.setCodigoDoProduto(rs.getInt("codigoDoProduto")); 
            produto.setDescricao(rs.getString("descricao"));       
            produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
            produto.setQuantidadeDisponivel(rs.getInt("quantidadeDisponivel"));

            produtos.add(produto);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return produtos;
    }

    public static int inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (codigoDoProduto, descricao, precoUnitario, quantidadeDisponivel) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, produto.getCodigoDoProduto());
        ps.setString(2, produto.getDescricao());
        ps.setDouble(3, produto.getPrecoUnitario());
        ps.setInt(4, produto.getQuantidadeDisponivel());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void get_id_produto(Produto produto) throws SQLException{
        String sql = "SELECT id_produto from produto WHERE codigoDoProduto = ? and descricao = ? and precoUnitario = ? and quantidadeDisponivel = ?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, produto.getCodigoDoProduto());
        ps.setString(2, produto.getDescricao());
        ps.setDouble(3, produto.getPrecoUnitario());
        ps.setInt(4, produto.getQuantidadeDisponivel());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            produto.setIdProduto(rs.getInt("id_produto"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);

    }

    public static int atualizar(Produto produto) throws SQLException {
        String sql = "UPDATE produto set codigoDoProduto = ?, descricao = ?, precoUnitario = ? quantidadeDisponivel = ? WHERE id_Produto = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, produto.getCodigoDoProduto());
        ps.setString(2, produto.getDescricao());
        ps.setDouble(3, produto.getPrecoUnitario());
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
        ps.setInt(1, produto.getIdProduto());

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

}