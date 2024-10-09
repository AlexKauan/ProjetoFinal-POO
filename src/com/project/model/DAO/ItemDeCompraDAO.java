
package com.project.model.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.project.model.Produto;

public class ItemDeCompraDAO{

    public static Connection conn;

    public static ItemDeCompra pegar(int id) throws SQLException {
        ItemDeCompra item = null;
        String sql = "SELECT idItemCompra, quantidadeComprada, precoDoItemDeCompra, from itemDeCompra where idItemCompra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            item = new ItemDeCompra();
            item.setInt(rs.getInt("idItemCompra"));
            item.setInt(rs.getString("quantidadeComprada"));       
            item.setString(rs.getString("precoDoItemDeCompra"));    
            
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return item;
    }

    public static ArrayList<ItemDeCompra> pegarTodos() throws SQLException {
        ArrayList<ItemDeCompra> itens = new ArrayList<ItemDeCompra>();
        ItemDeCompra item = null;
        String sql = "SELECT idItemCompra, quantidadeComprada, precoDoItemDeCompra, from item";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            item = new ItemDeCompra();
            item.setInt(rs.getInt("idItemCompra"));
            item.setInt(rs.getString("quantidadeComprada"));       
            item.setString(rs.getString("precoDoItemDeCompra"));    
            itens.add(item);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return item;
    }

    public static int inserir(ItemDeCompra item) throws SQLException {
        String sql = "INSERT INTO item (idItemCompra, quantidadeComprada, precoDoItemDeCompra) VALUES (?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, item.getidItemCompra());
        ps.setString(2, item.getQuantidadeComprada());
        ps.setDouble(3, item.getPrecoDoItemDeCompra());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int atualizar(ItemDeCompra item) throws SQLException {
        String sql = "UPDATE item set quantidadeComprada = ?, precoDoItemDeCompra = ? WHERE idItemCompra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, item.getidItemCompra());
        ps.setString(2, item.getQuantidadeComprada());
        ps.setDouble(3, item.getPrecoDoItemDeCompra());
        

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void salvar(ItemDeCompra item) throws SQLException {
        if (item.getId() != 0)
            atualizar(item);
        else
            inserir(item);
    }

    public static int deletar(ItemDeCompra item) throws SQLException {
        String sql = "DELETE FROM item WHERE idItemCompra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, item.getId());

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

}

