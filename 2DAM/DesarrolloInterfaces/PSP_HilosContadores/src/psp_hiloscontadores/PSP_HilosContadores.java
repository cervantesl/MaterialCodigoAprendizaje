
package psp_hiloscontadores;

public class PSP_HilosContadores {
     //Programa que le pasas archivos.txt, y diga las lineas, caracteres y palabras
    
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        
        Resultado resultado = new Resultado();
        
        for(String fichero : args) {
            new HiloContador(resultado, fichero).start();
        }
        
        while(Thread.activeCount() < 1) {
            
        }
        
        System.out.println("Hay un total de " + resultado.obtenerTotalLineas() + " lineas");
        System.out.println("Hay un total de " + resultado.obtenerTotalPalabras() + " palabras");
        System.out.println("Hay un total de " +resultado.obtenerTotalCaracteres() + " caracteres");
        
        long fin = System.currentTimeMillis();
        
        System.out.println("He tardado: " + (fin - inicio) + " milisegundos");
    }
    
}
