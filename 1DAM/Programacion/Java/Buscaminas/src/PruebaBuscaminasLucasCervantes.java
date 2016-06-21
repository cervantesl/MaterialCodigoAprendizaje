import java.util.Scanner;
import java.util.Random;
public class PruebaBuscaminasLucasCervantes{
    public static Scanner teclado = new Scanner(System.in);
    public static Random aleatorio = new Random();
    public static char[][] tableroPublico = new char[10][10];
    public static char[][] tableroPrivado = new char[10][10];
    final static char TAPAT = 'X';
    final static char BANDERETA = 'P';
    final static char RES = '_';
    final static char SEPARADOR = '|';
    final static char MINA = '*';
    public static void main(String[] args) {
        System.out.println("=======BIENVENIDO AL BUSCAMINAS=======");

        int cantidadMinas = minar();
     
        System.out.println("Dime si quieres mostrar las minas en el tablero: (s/n)");
        char respuesta = teclado.next().charAt(0);
        boolean minasTablero = false;
        if (respuesta == 'S' || respuesta == 's') {
            minasTablero = true;
        }
        else{
            minasTablero = false;
        }
        

        boolean minat = false;
        int qdestapat = 100 - cantidadMinas;
        boolean totDestapat = false;
        boolean posIncorrecto = false;
        boolean casillaDestapada = false;
        boolean salir = false;
        do {
            mostrarTauler(minasTablero);
            System.out.println("=====MENU====");
            System.out.println("(1). Destapar");
            System.out.println("(2). Poner bandera");
            System.out.println("(3. Salir");
            System.out.print("Dime lo que quieres hacer: ");
            int menu = teclado.nextInt();
            switch(menu){
                case 1:
                    
                    System.out.println("Dime la posicion donde quieras destapar:");
                    System.out.print("fila:");
                    int fila = teclado.nextInt();
                    System.out.print("Columna:");
                    int col = teclado.nextInt();
                    picar(fila,col);
                    minat = minat(fila,col);
                    posIncorrecto = incorrecte(fila,col);
                    casillaDestapada = destapat(fila,col);
                    break;
          
                case 2:
                    System.out.println("Dime la posicion donde quieras poner bandera:");
                    System.out.print("fila:");
                    fila = teclado.nextInt();
                    System.out.print("Columna:");
                    col = teclado.nextInt();
                    bandereta(fila,col);
                    break;
                
                case 3:
                    salir = true;break;
            }
  
            if (qdestapats() == qdestapat) {
                totDestapat = true;
                System.out.println("Has ganado, enhorabuena!");
            }
            else{
                totDestapat = false;
            }
            
            if (minat == true) {
                System.out.println("Has picado en una mina. GAME OVER!");
            }
            
            if (posIncorrecto == true) {
                System.out.println("La posicion es incorrecta");
            }
            if (casillaDestapada == true) {
                System.out.println("Esa casilla ya esta destapada, prueba otra!");
            }
        } while (minat == false && totDestapat == false && salir == false);
      
        
    }
    static int minar(){
        //Inicializamos la matriz.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableroPrivado[i][j] = RES;
                tableroPublico[i][j] = TAPAT;
            }
        }
        
        //Pedimos la cantidad de minas. 
        System.out.print("Dime la cantidad de minas que quieres: ");
        int cantidadMinas = teclado.nextInt();

        int minasColocadas = 0;
        //Colocamos minas
        while(minasColocadas < cantidadMinas){
            //Generamos posiciones aleatorias.
            int[] posicion =  generarPosicion();
            if (tableroPrivado[posicion[0]][posicion[1]] != MINA) {
                tableroPrivado[posicion[0]][posicion[1]] = MINA;
            }
            minasColocadas++;
        }

        return cantidadMinas;
        
    }
    //Funcion herramienta para generar posicion
    static int[] generarPosicion(){
        int[] generarPosiciones = new int[2];
        generarPosiciones[0] = aleatorio.nextInt(10);
        generarPosiciones[1] = aleatorio.nextInt(10);
        
        return generarPosiciones;
    }
    
    static int qma(int f, int c){
        
        int minasAlrededor = 0;
        for (int i = f-1; i <= f+1; i++) {
            for (int j = c-1; j <= c+1; j++) {
                try {
                 if (tableroPrivado[i][j] == MINA) {
                    minasAlrededor++;
                 }   
                } catch (Exception e) {
                }
            }
        }
        return minasAlrededor;
    }
    
    static void mostrarTauler(boolean m){

            System.out.print("  ");
            for (int i = 0; i < 10; i++) {
                System.out.print(" "+i);

            }
            System.out.println("");
            for (int i = 0; i < 10; i++) {
                System.out.print(i+" ");
                for (int j = 0; j < 10; j++) {
                    System.out.print(SEPARADOR);
                    if (m == true) {
                        
                     if (tableroPrivado[i][j] == MINA) { 
                        System.out.print(MINA);
                     }
                        else{
                           int minasAlrededor = qma(i,j);
                        
                            if(tableroPublico[i][j] == RES && minasAlrededor != 0){
                                System.out.print(qma(i, j));
                            }else {
                                System.out.print(tableroPublico[i][j]);
                            }
                        }
                    }
                    else{
                        int minasAlrededor = qma(i,j);
                        
                        if(tableroPublico[i][j] == RES && minasAlrededor != 0){
                            System.out.print(qma(i, j));
                        }else {
                            System.out.print(tableroPublico[i][j]);
                        }
                    }
                }
                System.out.println("");
            }
            System.out.print("  ");
            for (int i = 0; i < 10; i++) {
                System.out.print(" "+i);
            }
            System.out.println("");
        }
    
    static boolean minat(int f, int c){
       //comprobar posicion en tablero y si tiene mina true, de lo contrario false
        if (incorrecte(f,c)) 
            return false;
  
        if (tableroPrivado[f][c] == MINA)
            return true;
        else
            return false;
    }
    
    static boolean incorrecte(int f, int c){
        return !(tableroPublico.length > f && f >= 0 && tableroPublico[0].length > c && c >= 0);
    }
    
    static boolean destapat(int f, int c){
        if (tableroPublico[f][c] != TAPAT) {
            return true;
        }
        else{
            return false;
        }
    }
    
    static int qdestapats(){
        int contadorDestapado = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tableroPublico[i][j] != TAPAT) {
                    contadorDestapado++;
                }
            }
        }
        return contadorDestapado;
    }
    
    static boolean picar(int f, int c){
        if (tableroPrivado[f][c] != MINA) {
            destapar(f,c);
            return true;
        }
        else{
            return false;
        }
    }
    
    static void bandereta(int f, int c){
         if (tableroPrivado[f][c] == MINA || tableroPublico[f][c] == TAPAT) {
              tableroPublico[f][c] = BANDERETA;
            }

    }
    
    static void destapar(int f, int c){
        
        boolean incorrecte = incorrecte(f,c);

        if (!incorrecte) {
            
            boolean destapado = destapat(f,c);
            int minasAdyacentes = qma(f,c);
            
            if (destapado || minasAdyacentes > 0) {
            // Se para la recursion
                
            }
            
            else{
                 tableroPublico[f][c] = RES;
                 
                 destapar(f-1,c-1);
                 destapar(f-1,c);
                 destapar(f-1,c+1);
                 destapar(f,c-1);
                 destapar(f,c+1);
                 destapar(f+1,c-1);
                 destapar(f+1,c);
                 destapar(f+1,c+1);
                 
            }
        }
    }
}

 