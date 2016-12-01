/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labarberia;

/**
 *
 * @author Joan Gerard
 */
public class Client {
    int temps;
    
    public Client(int treball){
        temps=fer_temps(treball);
        
    }
    
    public int getTemps(){
        return temps;
    }
    
    private int fer_temps(int opcio){
        int res=0;
        switch (opcio){
            case 1:
                res=LaBarberia.getAleatorio(300,500);
                System.out.println("Intenta entrar un client a tallar-se els cabells");
                break;
            case 2:
                res=LaBarberia.getAleatorio(600,700);
                System.out.println("Intenta entrar un client a tenyir-se els cabells");
                break;
            case 3:
                res=LaBarberia.getAleatorio(150,200);
                System.out.println("Intenta entrar un client a afaitar-se");
                break;
                
        }
        return res;
        
    }
    
   
}
