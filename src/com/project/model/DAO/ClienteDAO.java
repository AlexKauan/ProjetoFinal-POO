package com.project.model.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.project.model.entidades.Cliente;

public class ClienteDAO{

    public static Connection conn;

    public static Cliente pegar(int id) throws SQLException {
        Cliente cliente = null;
        String sql = "SELECT id_cliente, login, senha, nome, telefone, email, endereco, numero_de_compras, totalComprado from cliente where id_cliente = ?";
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
            cliente.setNumeroDeCompras(rs.getInt("numero_de_compras"));
            cliente.setTotalComprado(rs.getDouble("totalComprado"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return cliente;
    }

    public static ArrayList<Cliente> pegarTodos() throws SQLException {
        ArrayList<Cliente> vendedores = new ArrayList<Cliente>();
        Cliente cliente = null;
        String sql = "SELECT id_cliente, login, senha, nome, telefone, email, endereco, numero_de_compras, totalComprado from cliente";
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
            cliente.setNumeroDeCompras(rs.getInt("numero_de_compras"));
            cliente.setTotalComprado(rs.getDouble("totalComprado"));

            vendedores.add(cliente);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return vendedores;
    }

    public static int inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (login, senha, nome, telefone, email, endereco, numero_de_compras, totalComprado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getLogin());
        ps.setString(2, cliente.getSenha());
        ps.setString(3, cliente.getNome());
        ps.setString(4, cliente.getTelefone());
        ps.setString(5, cliente.getEmail());
        ps.setString(6, cliente.getEndereco());
        ps.setInt(7, cliente.getNumeroDeCompras());
        ps.setDouble(8, cliente.getTotalComprado());
        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void get_id_cliente(Cliente cliente) throws SQLException{
        String sql = "SELECT id_cliente from Cliente WHERE login = ? and senha = ? and nome = ? and telefone = ? and email = ? and endereco = ? and numero_de_compras = ? and totalComprado = ?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getLogin());
        ps.setString(2, cliente.getSenha());
        ps.setString(3, cliente.getNome());
        ps.setString(4, cliente.getTelefone());
        ps.setString(5, cliente.getEmail());
        ps.setString(6, cliente.getEndereco());
        ps.setInt(7, cliente.getNumeroDeCompras());
        ps.setDouble(8, cliente.getTotalComprado());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            cliente.setId(rs.getInt("id_cliente"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);

    }


    public static int atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente set login = ?, senha = ?, nome = ?, telefone = ?, email = ?, endereco = ?, numero_de_compras = ?, totalComprado = ? WHERE id_cliente = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getLogin());
        ps.setString(2, cliente.getSenha());
        ps.setString(3, cliente.getNome());
        ps.setString(4, cliente.getTelefone());
        ps.setString(5, cliente.getEmail());
        ps.setString(6, cliente.getEndereco());
        ps.setInt(7, cliente.getNumeroDeCompras());
        ps.setDouble(8, cliente.getTotalComprado());
        ps.setInt(9, cliente.getId());
        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void salvar(Cliente cliente) throws SQLException {
        if (cliente.getId() != 0)
            atualizar(cliente);
        else{
            inserir(cliente);
            get_id_cliente(cliente);
        }
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
