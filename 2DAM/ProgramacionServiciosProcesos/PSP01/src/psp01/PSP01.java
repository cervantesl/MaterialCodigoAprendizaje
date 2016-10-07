/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lucas
 */
public class PSP01 {

    //Ejemplo proceso
    public static void main(String[] args) throws InterruptedException {
        Process p;
        
        try {
            p = Runtime.getRuntime().exec("ipconfig");
            p.waitFor();
            
            InputStream entradaBytes = p.getInputStream();
            
            BufferedReader lector = new BufferedReader(new InputStreamReader(entradaBytes));
            
            String linea;
            
            while((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println(p.exitValue());
        } catch (IOException ex) {
            Logger.getLogger(PSP01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
