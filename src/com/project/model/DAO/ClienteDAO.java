package com.project.model.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.project.model.Cliente;

public class ClienteDAO{

    public static Connection conn;

    public static Cliente pegar(int id) throws SQLException {
        Cliente cliente = null;
        String sql = "SELECT id_cliente, login, senha, nome, telefone, email, endereco, numeroDeCompras, totalComprado from cliente where id_cliente = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            cliente = new Cliente();
            cliente.setId(rs.getInt("id_cliente"));
            cliente.setLogin(rs.getString("login"));
            cliente.setSenha(rs.getString("senha"));
            cliente.setNome(rs.getString("nome")); 
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEmail(rs.getString("email"));
            cliente.setEndereco(rs.getString("endereco"));     
            cliente.setNumeroDeCompras(rs.getInt("numeroDeCompras"));
            cliente.setTotalComprado(rs.getDouble("totalComprado"));
            
            
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return cliente;
    }

    public static ArrayList<Cliente> pegarTodos() throws SQLException {
        ArrayList<Cliente> vendedores = new ArrayList<Cliente>();
        Cliente cliente = null;
        String sql = "SELECT id_cliente, login, senha, nome, telefone, email, endereco, numeroDeCompras, totalComprado from cliente";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            cliente = new Cliente();
            cliente.setId(rs.getInt("id_cliente"));
            cliente.setLogin(rs.getString("login"));
            cliente.setSenha(rs.getString("senha"));
            cliente.setNome(rs.getString("nome")); 
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEmail(rs.getString("email"));
            cliente.setEndereco(rs.getString("endereco"));  
            cliente.setNumeroDeCompras(rs.getInt("numeroDeCompras"));
            cliente.setTotalComprado(rs.getDouble("totalComprado"));

            vendedores.add(cliente);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return vendedores;
    }

    public static int inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (login, senha, nome, telefone, email, endereco, numeroDeCompras, totalComprado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getLogin());
        ps.setString(2, cliente.getSenha());
        ps.setString(3, cliente.getNome());
        ps.setString(4, cliente.getTelefone());
        ps.setString(6, cliente.getEmail());
        ps.setString(7, cliente.getEndereco());
        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente set login = ?, senha = ?, nome = ?, telefone = ?, email = ?, endereco = ? numeroDeCompras = ?, totalComprado = ? WHERE id_cliente = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getLogin());
        ps.setString(2, cliente.getSenha());
        ps.setString(3, cliente.getNome());
        ps.setString(4, cliente.getTelefone());
        ps.setString(6, cliente.getEmail());
        ps.setString(7, cliente.getEndereco());
        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void salvar(Cliente cliente) throws SQLException {
        if (cliente.getId() != 0)
            atualizar(cliente);
        else
            inserir(cliente);
    }

    public static int deletar(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, cliente.getId());

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

}
