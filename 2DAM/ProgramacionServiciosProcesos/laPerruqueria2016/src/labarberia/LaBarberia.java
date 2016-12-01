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
public class LaBarberia {

    /**
     * @param args the command line arguments
     */
    private static final int NUM_BARBERS = 2;
    private static final int NUM_CLIENTS = 6;
    private static final int TEMPS_ENTRADA = 200;

    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("----------------------------------------PERRUQUERIA OBERTA");
        // fem lloc per a seure els clients
        Banc elBanc = new Banc(NUM_CLIENTS);

        // Creem el carrer que determinarà el que tardaran en entrar cada client
        Porta laPorta = new Porta(elBanc, TEMPS_ENTRADA);

        // Comencen a entrar clients a la perruqueria
        laPorta.start();

        Perruquer elsPerruquers[] = new Perruquer[NUM_BARBERS];
        for (int i = 0; i < NUM_BARBERS; i++) {
            elsPerruquers[i] = new Perruquer(elBanc,"Perruquer " + (i+1));
            elsPerruquers[i].start();
        }

        long ara=System.currentTimeMillis();
        while(System.currentTimeMillis()<ara+5000){
            Thread.sleep(1000);
            System.out.println("BARBERIA:   En vida " + Thread.activeCount());
        }
        

        //deixen d'entrar clients. Tancar la porta
        laPorta.acabar();
        System.out.println("----------------------------------------PORTA TANCADA");
        System.out.println("PORTA TANCADA:   En vida " + Thread.activeCount());
        // esperem a que no queden clients per aturar els perruquers
        while(elBanc.quants()>0){
            
        }


        //acabem els perruquers
        for (int i = 0; i < NUM_BARBERS; i++) {
            elsPerruquers[i].fi();
        }
        
        System.out.println("BARBERS ACABATS:   En vida " + Thread.activeCount());
        
        System.out.println("----------------------------------------BARBERIA TANCADA");
        
    }
    
     public static int getAleatorio(int min, int max){
        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }
}
