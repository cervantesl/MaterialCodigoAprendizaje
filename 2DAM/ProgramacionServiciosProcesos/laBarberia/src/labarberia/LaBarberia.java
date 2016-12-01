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
    private static final int TEMPS_ENTRADA = 100;

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
            elsPerruquers[i] = new Perruquer(elBanc);
            elsPerruquers[i].start();
        }

        Thread.sleep(15000);

        //deixen d'entrar clients
        laPorta.acabar();

        // esperem a que no queden clients per aturar els perruquers
        while(elBanc.quants() > 0) {
            Thread.sleep(150);
        }

        //acabem els perruquers
        for (int i = 0; i < NUM_BARBERS; i++) {
            elsPerruquers[i].fi();
        }
        
        System.out.println("----------------------------------------PERRUQUERIA TANCADA");
    }
    
     public static int getAleatorio(int min, int max){
        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }
}
