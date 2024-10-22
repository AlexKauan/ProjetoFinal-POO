package com.project.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.project.model.entidades.Cliente;
import com.project.model.entidades.Compra;

public class CompraDao {

    public static Connection conn;

    public static Compra pegar(int id) throws SQLException {
        Compra compra = null;
        String sql = "SELECT id_compra, id_cliente, data, statusCompra from compra where id_compra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        Cliente cliente = null;
        if (rs.next()) {
            compra = new Compra();
            cliente = ClienteDao.pegar(rs.getInt("id_cliente"));
            compra.setCliente(cliente);
            compra.setIdCompra(rs.getInt("id_compra"));
            compra.setDate(rs.getString("data"));
            compra.setStatusCompra(rs.getString("statusCompra"));

        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return compra;
    }

    public static ArrayList<Compra> pegarTodos() throws SQLException {
        ArrayList<Compra> compras = new ArrayList<Compra>();
        Compra compra = null;
        String sql = "SELECT id_compra, id_cliente, data, statusCompra from compra";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        Cliente cliente = null;
        while (rs.next()) {
            compra = new Compra();
            cliente = ClienteDao.pegar(rs.getInt("id_cliente"));
            compra.setCliente(cliente);
            compra.setIdCompra(rs.getInt("id_compra"));
            compra.setDate(rs.getString("data"));
            compra.setStatusCompra(rs.getString("statusCompra"));
            compras.add(compra);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return compras;
    }

    public static int inserir(Compra compra) throws SQLException {
        String sql = "INSERT INTO compra (id_cliente, data, statusCompra) VALUES (?, ?, ?)";
        Cliente cliente = compra.getCliente();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, cliente.getId());
        ps.setString(2, compra.getDate());
        ps.setString(3, compra.getStatusCompra());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void get_id_compra(Compra compra) throws SQLException {
        String sql = "SELECT id_compra from compra WHERE id_cliente = ? and data = ? and statusCompra = ?";
        Cliente cliente = compra.getCliente();

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, cliente.getId());
        ps.setString(2, compra.getDate());
        ps.setString(3, compra.getStatusCompra());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            compra.setIdCompra(rs.getInt("id_compra"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);

    }

    public static int atualizar(Compra compra) throws SQLException {
        String sql = "UPDATE compra set id_cliente = ?, data = ?, statusCompra = ? WHERE id_compra = ?";
        Cliente cliente = compra.getCliente();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, cliente.getId());
        ps.setString(2, compra.getDate());
        ps.setString(3, compra.getStatusCompra());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void salvar(Compra compra) throws SQLException {
        if (compra.getIdCompra() != 0)
            atualizar(compra);
        else {
            inserir(compra);
            get_id_compra(compra);
        }

    }

    public static int deletar(Compra compra) throws SQLException {
        String sql = "DELETE FROM compra WHERE id_compra = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, compra.getIdCompra());

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

}