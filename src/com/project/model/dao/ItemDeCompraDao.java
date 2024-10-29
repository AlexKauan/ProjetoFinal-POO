
package com.project.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import com.project.model.entidades.ItemDeCompra;
import com.project.model.entidades.Produto;

public class ItemDeCompraDao {

    public static Connection conn;

    public static ItemDeCompra pegar(int id) throws SQLException {
        ItemDeCompra item = null;
        String sql = "SELECT id_Item_Compra, id_compra, id_produto, quantidadeComprada, precoDoItemDeCompra from itemDeCompra where id_Item_Compra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        Produto produto = null;
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            item = new ItemDeCompra();
            produto = ProdutoDao.pegar(rs.getInt("id_produto"));
            item.setProduto(produto);
            item.setId_item_compra(rs.getInt("id_Item_Compra"));
            item.setQuantidadeComprada(rs.getInt("quantidadeComprada"));
            item.setPrecoDoItemDeCompra(rs.getDouble("precoDoItemDeCompra"));

        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return item;
    }

    public static ArrayList<ItemDeCompra> pegarTodos(int id_compra) throws SQLException {
        ArrayList<ItemDeCompra> itens = new ArrayList<ItemDeCompra>();
        ItemDeCompra item = null;
        String sql = "SELECT id_Item_Compra, id_produto, quantidadeComprada, precoDoItemDeCompra from itemDeCompra WHERE id_compra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id_compra);
        Produto produto = null;

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            item = new ItemDeCompra();
            produto = ProdutoDao.pegar(rs.getInt("id_produto"));
            item.setProduto(produto);
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
        String sql = "INSERT INTO itemDeCompra (id_produto, id_compra, quantidadeComprada, precoDoItemDeCompra) VALUES (?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, item.getProduto().getIdProduto());
        ps.setInt(2, item.getId_compra());
        ps.setInt(3, item.getQuantidadeComprada());
        ps.setDouble(4, item.getPrecoDoItemDeCompra());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void get_id_Itm_compra(ItemDeCompra item) throws SQLException {
        String sql = "SELECT id_Item_Compra from itemDeCompra WHERE id_compra = ? and id_produto = ? and quantidadeComprada = ? and precoDoItemDeCompra = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, item.getProduto().getIdProduto());
        ps.setInt(2, item.getId_compra());
        ps.setInt(3, item.getQuantidadeComprada());
        ps.setDouble(4, item.getPrecoDoItemDeCompra());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            item.setId_item_compra(rs.getInt("id_Item_Compra"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);

    }

    public static int atualizar(ItemDeCompra item) throws SQLException {
        String sql = "UPDATE itemDeCompra set id_compra = ?, id_produto = ?, quantidadeComprada = ?, precoDoItemDeCompra = ? WHERE id_Item_Compra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, item.getProduto().getIdProduto());
        ps.setInt(2, item.getId_compra());
        ps.setInt(3, item.getQuantidadeComprada());
        ps.setDouble(4, item.getPrecoDoItemDeCompra());

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
