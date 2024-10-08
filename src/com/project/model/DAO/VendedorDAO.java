package com.project.model.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.project.model.Vendedor;


public class VendedorDAO {

    public static Connection conn;

    public static Vendedor pegar(int id) throws SQLException {
        Vendedor vendedor = null;
        String sql = "SELECT id_vendedor, login, senha, nome, telefone, email, endereco from vendedor where id_vendedor = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            vendedor = new Vendedor();
            vendedor.setId(rs.getInt("id_vendedor"));
            vendedor.setLogin(rs.getString("login"));
            vendedor.setSenha(rs.getString("senha"));
            vendedor.setNome(rs.getString("nome")); 
            vendedor.setTelefone(rs.getString("telefone"));
            vendedor.setEmail(rs.getString("email"));
            vendedor.setEndereco(rs.getString("endereco"));       
            
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return vendedor;
    }

    public static ArrayList<Vendedor> pegarTodos() throws SQLException {
        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
        Vendedor vendedor = null;
        String sql = "SELECT id_vendedor, login, senha, nome, telefone, email, endereco from vendedor";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            vendedor = new Vendedor();
            vendedor.setId(rs.getInt("id_vendedor"));
            vendedor.setLogin(rs.getString("login"));
            vendedor.setSenha(rs.getString("senha"));
            vendedor.setNome(rs.getString("nome")); 
            vendedor.setTelefone(rs.getString("telefone"));
            vendedor.setEmail(rs.getString("email"));
            vendedor.setEndereco(rs.getString("endereco"));  

            vendedores.add(vendedor);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return vendedores;
    }

    public static int inserir(Vendedor vendedor) throws SQLException {
        String sql = "INSERT INTO vendedor (login, senha, nome, telefone, email, endereco) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vendedor.getLogin());
        ps.setString(2, vendedor.getSenha());
        ps.setString(3, vendedor.getNome());
        ps.setString(4, vendedor.getTelefone());
        ps.setString(6, vendedor.getEmail());
        ps.setString(7, vendedor.getEndereco());
        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int atualizar(Vendedor vendedor) throws SQLException {
        String sql = "UPDATE vendedor set login = ?, senha = ?, nome = ?, telefone = ?, email = ?, endereco = ? WHERE id_vendedor = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vendedor.getLogin());
        ps.setString(2, vendedor.getSenha());
        ps.setString(3, vendedor.getNome());
        ps.setString(4, vendedor.getTelefone());
        ps.setString(6, vendedor.getEmail());
        ps.setString(7, vendedor.getEndereco());
        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void salvar(Vendedor vendedor) throws SQLException {
        if (vendedor.getId() != 0)
            atualizar(vendedor);
        else
            inserir(vendedor);
    }

    public static int deletar(Vendedor vendedor) throws SQLException {
        String sql = "DELETE FROM vendedor WHERE id_vendedor = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, vendedor.getId());

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

}
