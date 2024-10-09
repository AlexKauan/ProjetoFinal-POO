package com.project.model.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.project.model.Compra;

public class CompraDAO{

    public static Connection conn;

    public static Compra pegar(int id) throws SQLException {
        Compra compra = null;
        String sql = "SELECT id_compra, id_cliente, id_vendedor, data, status, from cliente where id_compra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            compra = new Compra();
            compra.setId(rs.getInt("id_compra"));
            compra.setInt(rs.getString("id_cliente"));       
            compra.set(rs.getString("date"));
            compra.setString(rs.getString("status"));     
            
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return compra;
    }

    public static ArrayList<Compra> pegarTodos() throws SQLException {
        ArrayList<Compra> compras = new ArrayList<Compra>();
        Compra compra = null;
        String sql = "SELECT id_compra, id_cliente, id_vendedor, data, status, from compra";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            compra = new Compra();
            compra.setId(rs.getInt("id_compra"));
            compra.setInt(rs.getString("id_cliente"));
            compra.setInt(rs.getString("id_vendedor"));
            compra.set(rs.getString("date"));
            compra.setString(rs.getString("status"));     
            compras.add(compra);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return compra;
    }

    public static int inserir(Compra compra) throws SQLException {
        String sql = "INSERT INTO cliente (id_cliente, id_vendedor, data, status) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, compra.getId_cliente());
        ps.setInt(2, compra.getId_vendedor());
        ps.setString(3, compra.getDate());
        ps.setString(4, compra.getStatus());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int atualizar(Compra compra) throws SQLException {
        String sql = "UPDATE compra set data = ?, status = ? WHERE id_cliente = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, compra.getId_cliente());
        ps.setInt(2, compra.getId_vendedor());
        ps.setString(3, compra.getDate());
        ps.setString(4, compra.getStatus());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void salvar(Compra compra) throws SQLException {
        if (compra.getId_compra() != 0)
            atualizar(compra);
        else
            inserir(compra);
    }

    public static int deletar(Compra compra) throws SQLException {
        String sql = "DELETE FROM compra WHERE id_compra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, compra.getId_compra);

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

}