/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Familia extends Amigo{
    private int fondosEconomicos;
    public Familia(){
        super();
        Scanner teclado = new Scanner(System.in);
        System.out.println("fondos economicos: ");
        this.fondosEconomicos = teclado.nextInt();
    }

    @Override
    public String toString() {
        return super.toString() + "\nfondos economicos: "+fondosEconomicos;
    }
    
    
}
