package com.project.model.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.project.model.entidades.Vendedor;


public class VendedorDAO {

    public static Connection conn;

    public static Vendedor pegar(int id) throws SQLException {
        Vendedor vendedor = null;
        String sql = "SELECT id_vendedor, login, senha, nome, telefone, email, endereco, salario, numeroDeVendas, totalVendido from vendedor where id_vendedor = ?";
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
            vendedor.setSalario(rs.getDouble("salario"));
            vendedor.setNumeroDeVendas(rs.getInt("numeroDeVendas"));
            vendedor.setTotalVendido(rs.getDouble("totalVendido"));   
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return vendedor;
    }

    public static ArrayList<Vendedor> pegarTodos() throws SQLException {
        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
        Vendedor vendedor = null;
        String sql = "SELECT id_vendedor, login, senha, nome, telefone, email, endereco, salario, numeroDeVendas, totalVendido from vendedor";
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
            vendedor.setSalario(rs.getDouble("salario"));
            vendedor.setNumeroDeVendas(rs.getInt("numeroDeVendas"));
            vendedor.setTotalVendido(rs.getDouble("totalVendido")); 

            vendedores.add(vendedor);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return vendedores;
    }

    public static int inserir(Vendedor vendedor) throws SQLException {
        String sql = "INSERT INTO vendedor (login, senha, nome, telefone, email, endereco, salario, numeroDeVendas, totalVendido) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vendedor.getLogin());
        ps.setString(2, vendedor.getSenha());
        ps.setString(3, vendedor.getNome());
        ps.setString(4, vendedor.getTelefone());
        ps.setString(5, vendedor.getEmail());
        ps.setString(6, vendedor.getEndereco());
        ps.setDouble(7, vendedor.getSalario());
        ps.setInt(8, vendedor.getNumeroDeVendas());
        ps.setDouble(9, vendedor.getTotalVendido());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static void get_id_vendedor(Vendedor vendedor) throws SQLException{
        String sql = "SELECT id_vendedor from vendedor WHERE login = ? and senha = ? and nome = ? and telefone = ? and email = ? and endereco = ? and salario = ? and numeroDeVendas = ? and totalVendido=";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vendedor.getLogin());
        ps.setString(2, vendedor.getSenha());
        ps.setString(3, vendedor.getNome());
        ps.setString(4, vendedor.getTelefone());
        ps.setString(5, vendedor.getEmail());
        ps.setString(6, vendedor.getEndereco());
        ps.setDouble(7, vendedor.getSalario());
        ps.setInt(8, vendedor.getNumeroDeVendas());
        ps.setDouble(9, vendedor.getTotalVendido());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            vendedor.setId(rs.getInt("id_vendedor"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);

    }

    public static int atualizar(Vendedor vendedor) throws SQLException {
        String sql = "UPDATE vendedor set login = ?, senha = ?, nome = ?, telefone = ?, email = ?, endereco = ?, salario = ?, numeroDeVendas = ?, totalVendido = ? WHERE id_vendedor = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vendedor.getLogin());
        ps.setString(2, vendedor.getSenha());
        ps.setString(3, vendedor.getNome());
        ps.setString(4, vendedor.getTelefone());
        ps.setString(5, vendedor.getEmail());
        ps.setString(6, vendedor.getEndereco());
        ps.setDouble(7, vendedor.getSalario());
        ps.setInt(8, vendedor.getNumeroDeVendas());
        ps.setDouble(9, vendedor.getTotalVendido());
        
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


    public static Vendedor pegar_por_login(String login) throws SQLException {
        Vendedor vendedor = null;
        String sql = "SELECT id_vendedor, login, senha, nome, telefone, email, endereco, salario, numeroDeVendas, totalVendido from vendedor where login = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, login);

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
            vendedor.setSalario(rs.getDouble("salario"));
            vendedor.setNumeroDeVendas(rs.getInt("numeroDeVendas"));
            vendedor.setTotalVendido(rs.getDouble("totalVendido"));   
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return vendedor;
    }

}
