/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Lucas
 */
public class Dao {

    private static String[] usuarios = {"user", "user1"};
    private static String[] passwords = {"user", "user1"};


    public static void autentificarse(String usuario, String password) throws Excepciones {

        boolean encontrado = false;
        for (int i = 0; i < usuarios.length; i++) {
            
            if (usuario.equals(usuarios[i]) && password.equals(passwords[i])) {
                encontrado =  true;
            }
        }
        
        if (encontrado ==false) {
            throw new Excepciones("usuario y password no coincide");
        }
    }

}
