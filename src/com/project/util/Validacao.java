package com.project.util;

public class Validacao {

    // Valida o formato do email
    public static boolean validarEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(regex);
    }

    // Valida o formato do telefone (apenas números)
   /* */ public static boolean validarTelefone(String telefone) {
        return telefone.matches("\\d{10,11}");
    }
}