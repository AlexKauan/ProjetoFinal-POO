package com.project.controller;


import com.project.model.DAO.VendedorDAO;
import com.project.model.entidades.Vendedor;
import com.project.view.VendedorView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorControle {
    private Vendedor vendedor;
    private VendedorView vendedorView;

    // Construtor
    public VendedorControle(Vendedor vendedor, VendedorView vendedorView) {
        this.vendedor = vendedor;
        this.vendedorView = vendedorView;
    }

    public static void cadastraVendedor(double salario, int numeroDeVendas, double totalVendido, String login,
            String senha,
            String nome, String telefone, String email, String endereco) {
        Vendedor vendedor = Vendedor.criarVendedor(salario, numeroDeVendas, totalVendido, login, senha, nome, telefone,
                email, endereco);
        try {
            VendedorDAO.salvar(vendedor);
            System.out.println("\nCLiente cadastrado com sucesso\n");
        } catch (SQLException e) {
            System.out.println("Erro ao criar o Cliente");
        }
    }

    public static void atualizarVendedor(int idVendedor, double salario, int numeroDeVendas, double totalVendido,
            String login, String senha,
            String nome, String telefone, String email, String endereco) {
        try {
            Vendedor vendedor = VendedorDAO.pegar(idVendedor);
            if (vendedor == null) {
                System.out.println("Esse Vendedor não existe\n");
            } else {
                vendedor.editarVendedor(salario, numeroDeVendas, totalVendido, login, senha,
                        nome, telefone, email, endereco);
                VendedorDAO.salvar(vendedor);
                System.out.println("\nVendeodr editado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar o Cliente");
        }
    }

    public static void mostrarVendedor(int idVendedor) {
        Vendedor vendedor;
        try {
            vendedor = VendedorDAO.pegar(idVendedor);
            if (vendedor == null) {
                System.out.println("Esse vendedor não existe\n");
            } else {
                System.out.println("\nInformações do vendedor:\n");
                System.out.println(vendedor);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar o Vendedor");
        }
    }

    public static void editarVendedor(int idVendedor, String nome, String endereco, String telefone, String senha) {
        try {
            Vendedor vendedor = VendedorDAO.pegar(idVendedor);
            if (vendedor == null) {
                System.out.println("Esse cliente não existe\n");
            } else {
                vendedor.editarVendedor(nome, endereco, telefone, senha);
             VendedorDAO.salvar(vendedor);
                System.out.println("\n Vendedor editado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar o Vendedor");
        }
    }

    public static void listarVendedores() {
        try {
            ArrayList<Vendedor>  vendedores = VendedorDAO.pegarTodos();
            if (vendedores.size() == 0) {
                System.out.println("Ainda não há vendedores no sistema\n");
            } else {
                for (Vendedor vendedor : vendedores)
                    System.out.println(vendedor);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao Listar os vendedores");
        }

    }

    public void removerCliente(List<Vendedor> vendedores) {
        vendedores.remove(this);
    }

    public static void logarVendedor(String login, String senha) {

        Vendedor vendedor;
        boolean esta_logado;
        try {
            vendedor = VendedorDAO.pegar_por_login(login);
            if (vendedor != null) {
                esta_logado = vendedor.logarPessoa(login, senha);
                if (esta_logado) {
                    System.out.println("Vendedor logado com sucesso!!!");
                } else {
                    System.out.println("Senha incorreta!");

                }
            } else {
                System.out.println("Login incorreto");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void removerVendedor(int idVendedor) {
        try {
            Vendedor vendedor = VendedorDAO.pegar(idVendedor);
            if (vendedor == null) {
                System.out.println("Esse cliente não existe\n");
            } else {
                VendedorDAO.deletar(vendedor);
                System.out.println("\n Vendedor deletado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o Vendedor");
        }
    }

    public static Vendedor buscarVendedor(int idVendedor) {
        Vendedor vendedor;
        try {
            vendedor = VendedorDAO.pegar(idVendedor);
            if (vendedor == null) {
                System.out.println("Esse vendedor não existe\n");
                return vendedor;
            } else {
                return vendedor;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar um vendedor");
            return null;
        }
    }



    public void salvar() {
        try {
            VendedorDAO.salvar(this.vendedor);
            System.out.println("Vendedor Salvo Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Vendedor Não Salvo!!!");
        }
    }

    public void deletar() {
        try {
            VendedorDAO.deletar(this.vendedor);
            System.out.println("Vendedor Deletado Com sucesso!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Vendedor Não Deletado Com sucesso!!!");
        }
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public VendedorView getVendedorView() {
        return vendedorView;
    }

    public void setVendedorView(VendedorView vendedorView) {
        this.vendedorView = vendedorView;
    }

}
