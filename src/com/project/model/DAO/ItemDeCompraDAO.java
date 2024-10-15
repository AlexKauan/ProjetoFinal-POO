
package com.project.model.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import com.project.model.entidades.ItemDeCompra;

public class ItemDeCompraDAO{

    public static Connection conn;

    public static ItemDeCompra pegar(int id) throws SQLException {
        ItemDeCompra item = null;
        String sql = "SELECT id_Item_Compra, quantidadeComprada, precoDoItemDeCompra from itemDeCompra where id_Item_Compra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            item = new ItemDeCompra();
            item.setId_item_compra(rs.getInt("id_Item_Compra")); 
            item.setQuantidadeComprada(rs.getInt("quantidadeComprada"));       
            item.setPrecoDoItemDeCompra(rs.getDouble("precoDoItemDeCompra"));    
            
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return item;
    }

    public static ArrayList<ItemDeCompra> pegarTodos() throws SQLException {
        ArrayList<ItemDeCompra> itens = new ArrayList<ItemDeCompra>();
        ItemDeCompra item = null;
        String sql = "SELECT id_Item_Compra, quantidadeComprada, precoDoItemDeCompra from itemDeCompra";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            item = new ItemDeCompra();
            item.setId_item_compra(rs.getInt("id_Item_Compra"));
            item.setQuantidadeComprada(rs.getInt("quantidadeComprada"));       
            item.setPrecoDoItemDeCompra(rs.getDouble("precoDoItemDeCompra"));      
            itens.add(item);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return itens;
    }

    public static int inserir(ItemDeCompra item) throws SQLException {
        String sql = "INSERT INTO itemDeCompra (quantidadeComprada, precoDoItemDeCompra) VALUES (?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, item.getQuantidadeComprada());
        ps.setDouble(2, item.getPrecoDoItemDeCompra());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void get_id_cliente(ItemDeCompra item) throws SQLException{
        String sql = "SELECT id_Item_Compra from itemDeCompra WHERE quantidadeComprada = ? and precoDoItemDeCompra = ?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, item.getQuantidadeComprada());
        ps.setDouble(2, item.getPrecoDoItemDeCompra());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            item.setId_item_compra(rs.getInt("id_Item_Compra"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);

    }

    public static int atualizar(ItemDeCompra item) throws SQLException {
        String sql = "UPDATE itemDeCompra set quantidadeComprada = ?, precoDoItemDeCompra = ? WHERE id_Item_Compra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, item.getQuantidadeComprada());
        ps.setDouble(2, item.getPrecoDoItemDeCompra());
        

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void salvar(ItemDeCompra item) throws SQLException {
        if (item.getId_item_compra() != 0)
            atualizar(item);
        else
            inserir(item);
    }

    public static int deletar(ItemDeCompra item) throws SQLException {
        String sql = "DELETE FROM itemDeCompra WHERE id_Item_Compra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, item.getId_item_compra());

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

}

