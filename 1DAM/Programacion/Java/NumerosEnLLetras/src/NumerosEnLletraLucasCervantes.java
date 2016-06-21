import java.util.Scanner;
public class NumerosEnLletraLucasCervantes{
      public static void main(String[] args) {
          Scanner teclado = new Scanner(System.in);
          int numero = 0;
           System.out.println("Dime un numero (de hasta 9 digitos) y lo pasare a letras. "
                   + "Para salir pulse: 0");
          do {              
              System.out.print("Introduce el numero: ");
              try {
                    numero = teclado.nextInt();

              } catch (Exception e) {
                  System.out.println("Numero demasiado grande");
              }
              if(numero > 999999999 || numero < 0){
                  System.out.println("Error, numero invalido.");
              }
              else{
                  
              if(numero != 0){
                  System.out.print("Numero en letra: ");
                 System.out.println(noudigitsEnLletres(numero)); 
              }
              else{
                  System.out.println("Adeu!");
              }
              }
              
          } while (numero != 0);

    
    }
    //funcion para coger el digito de las unidades
    static int digitUnitats(int q){
        int unidades = q % 10;
        
    return unidades;
    }
    //funcion para coger el digito de las decenas
    static int digitDecenes(int q){
        int unidades = (q % 100)/10;
       
    return unidades;
    }
    //funcion para coger el digito de las centenas
    static int digitCentenes(int q){
          int unidades = (q % 1000)/100;
            
    return unidades;
    }
    
    //Para millares
    static int digitUnitatsMillars(int q){
        int unidades = (q % 10000)/1000;
        return unidades;
    }
    static int digitDecenesMillars(int q){
       int unidades = (q % 100000)/10000;
       return unidades;
    }
     static int digitCentenesMillars(int q){
       int unidades = (q % 1000000)/100000;
       return unidades;
    }
     
     //Para Millones
      static int digitUnitatsMillons(int q){
        int unidades = (q % 10000000)/1000000;
        return unidades;
    }
    static int digitDecenesMillons(int q){
       int unidades = (q % 100000000)/10000000;
       return unidades;
    }
     static int digitCentenesMillons(int q){
       int unidades = (q %1000000000)/100000000;
       return unidades;
    }
    
    //funcion para coger el digito de las decenas y tranformarlo en letra
    static String desenaEnLletres(int dig){
        String numero="";
        switch(dig){
            case 0: numero = ""; break;
            case 1: numero = "deu"; break;
            case 2: numero = "vint"; break;
            case 3: numero = "trenta"; break;
            case 4: numero = "quaranta"; break;
            case 5: numero = "cinquanta"; break;
            case 6: numero = "seixanta"; break;
            case 7: numero = "setanta"; break;
            case 8: numero = "huitanta"; break;
            case 9: numero = "noranta"; break;
            default: numero = "error";break;
        }
        return numero;
    }
    
    //funcion para coger el digito de las unidades y tranformarlo en letra
    static String digitEnLletres(int dig){
        String numero="";
        switch(dig){
            case 0: numero = "cero"; break;
            case 1: numero = "un"; break;
            case 2: numero = "dos"; break;
            case 3: numero = "tres"; break;
            case 4: numero = "quatre"; break;
            case 5: numero = "cinc"; break;
            case 6: numero = "sis"; break;
            case 7: numero = "set"; break;
            case 8: numero = "huit"; break;
            case 9: numero = "nou"; break;
        }
        return numero;
    }
    
    
    //Funcion excepciones  de las Centenas
    static String excepcionsCentenes(int q3){
        
        //Declaracion de variables
        String digitCentenaEnLletra= "";
      
        
        //Convertir numero centena a letra
        String centenaEnLletra = digitEnLletres(digitCentenes(q3));
        int digitCentena = digitCentenes(q3);
       
        //Si es distinto de vacio,"un" y "cero" que ponga "-cent" al final de las Centenas
        if(digitCentena != 0 && digitCentena != 1){
            digitCentenaEnLletra = centenaEnLletra+"-cents ";
        }
        else if(digitCentena == 1){
            digitCentenaEnLletra = "cent ";
        }
        return digitCentenaEnLletra;
        
    }
    
    //Funcion excepciones de las Decenas
    static String excepcionsDecenes(int q3){
        String digitDecenaEnLletra = "";
        String decenaEnLletra = desenaEnLletres(digitDecenes(q3));
        //Guardar funciones en variables
        int digitDecena = digitDecenes(q3);
        int digitUnitat = digitUnitats(q3);
        
        
        if(digitDecena == 1){
            switch(digitUnitat){
                case 0: digitDecenaEnLletra = " deu ";break;
                case 1: digitDecenaEnLletra = " onze ";break;
                case 2: digitDecenaEnLletra = " dotze ";break;
                case 3: digitDecenaEnLletra = " tretze ";break;
                case 4: digitDecenaEnLletra = " catorze ";break;
                case 5: digitDecenaEnLletra = " quintze ";break;
                case 6: digitDecenaEnLletra = " setze ";break;
                case 7: digitDecenaEnLletra = " deset ";break;
                case 8: digitDecenaEnLletra = " dihuit ";break;
                case 9: digitDecenaEnLletra = " denou ";break;
            }
            
        }
        //Si las decenas es 2 y las unidades es distinto de 0 que ponga -i-
        else if(digitDecena == 2 && digitUnitat != 0){
             digitDecenaEnLletra = decenaEnLletra+"-i-"; 
        }
       //Si las decenas es 0 y las unidades es distinto de 0 que ponga "-"
        else if(digitDecena != 0 && digitDecena != 1){
            digitDecenaEnLletra = decenaEnLletra+"-";
        }
     
        return digitDecenaEnLletra;
    }
    

    static String excepcionsUnitats(int q3){
        
        String digitUnitatEnLletra = "";

        int digitDecena = digitDecenes(q3);
        int digitUnidad = digitUnitats(q3);
        
        String unitatEnLletra = digitEnLletres(digitUnitats(q3));
        
      
        //si unidad no es cero y decena es distinto de 1
        if(digitUnidad !=0 && digitDecena != 1){
            digitUnitatEnLletra = unitatEnLletra;    
        }
        
        return digitUnitatEnLletra;
    }
    
    
    //Funcion para unir en letras las centenas,decenas y unidades a letras.
    static String tresDigitsEnLletres(int q3){
            
        //Numero en letra
        String numeroEnLletra3 = excepcionsCentenes(q3)+excepcionsDecenes(q3)+excepcionsUnitats(q3);
       
        
        return  numeroEnLletra3;   
    }
    
    //Funcion para unir en letras las centenas,decenas y unidades a letras de 9 digitos.
    static String noudigitsEnLletres(int q9){
        //millones
       int digitCentenaMillo = digitCentenesMillons(q9)*100;
       int digitDecenaMillo = digitDecenesMillons(q9)*10;
       int digitUnitatMillo = digitUnitatsMillons(q9);
       int milions = q9/1000000;
       
       //millares
       int digitCentenaMillar = digitCentenesMillars(q9)*100;
       int digitDecenaMillar = digitDecenesMillars(q9)*10;
       int digitUnidadMillar = digitUnitatsMillars(q9);
       
       //Si millon no esta vacio que ponga "millon" al final
       String millons ="";
       String tresDigitsEnLletresMillons = tresDigitsEnLletres(milions);
       
       if(digitCentenaMillo+digitDecenaMillo+digitUnitatMillo != 0){
           millons = tresDigitsEnLletresMillons+" milions "; 
       }
       if(digitCentenaMillo+digitDecenaMillo+digitUnitatMillo == 1){
           millons = tresDigitsEnLletresMillons+" milió "; 
       }
       
       
       //Si millar no esta vacio que ponga "mil" al final
       String mil ="";
       
       if(digitCentenaMillar+digitDecenaMillar+digitUnidadMillar != 0){
           mil = tresDigitsEnLletres(digitCentenaMillar+digitDecenaMillar+digitUnidadMillar)+" mil ";
       }
       //Si millar es uno que no ponga "un mil"
       if(digitCentenaMillar+digitDecenaMillar+digitUnidadMillar == 1){
           mil = tresDigitsEnLletres(digitCentenaMillar+digitDecenaMillar)+" mil ";
       }
     
        String numeroEnLletra9 = millons+mil+tresDigitsEnLletres(q9);
       
 
        return numeroEnLletra9;
    }
}