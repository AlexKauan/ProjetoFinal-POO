package com.project.controller;

import com.project.model.Cliente;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Cliente pessoa1 = new Cliente(1, "null", "null", "Alex", "null", "null", "null", 12, 1.0);
        System.out.println(pessoa1);
        ArrayList<Cliente> clientes = new ArrayList<>();

        // buscar pelo nome do cliente
        // retorna o objeto
        clientes.remove(pessoa1);
    }
}
