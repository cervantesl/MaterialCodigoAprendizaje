/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banclucascervantes;

import java.util.ArrayList;
import banclucascervantes.EE;

/**
 *
 * @author Lucas
 */
public class BancLucasCervantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList <Compte> comptes = new ArrayList<>();
        
        int opcion;
        do {            
            System.out.println("===MENU PRINCIPAL===");
            System.out.println("1.-Crear un compte nou");
            System.out.println("2.-Eliminar un compte");
            System.out.println("3.-Llistar els comptes creats");
            System.out.println("4.-Fer un ingres");
            System.out.println("5.-Fer un reitegrament(traure diners)");
            System.out.println("6.-Fer una transferencia entre dos comptes");
            System.out.println("7.-Eixir");
            System.out.println("");
            System.out.print("Elige una opcion: ");
            opcion = Leer.leerInt();
            
            switch(opcion){
                case 1: crearCompte(comptes);break;
//                case 2: eliminarCompte(comptes);break;
                case 3: cuentasCreadas(comptes);break;
                case 4: hacerIngreso(comptes);break;
                case 5: hacerReintegro(comptes);break;
                case 6: tranferencia(comptes); break;
                case 7: System.out.println("Adios!");break;
                case 8: default:System.out.println("La opcion no existe");break;
            }
        } while (opcion != 7);

    }

        
    static Object triaCompte(ArrayList comptes){
        Object conte = new Object();
        System.out.println("Dime el num de cuenta: ");
        int numCuenta = Leer.leerInt();

        for (int i = 0; i < comptes.size(); i++) {
            if (comptes.indexOf(new Compte(numCuenta)) == -1) {
            conte = comptes.get(i);
        }
            else{
                return null;
            }
        }
        return conte;
    }
    
    //Crear una cuenta
    static void crearCompte(ArrayList comptes){
        System.out.print("Dime el num de cuenta:");
        int numCuenta = Leer.leerInt();
        
        System.out.print("Dime el nombre: ");
        String nomCuenta = Leer.leerString();
        
        System.out.println("Dime el telefono");
        int telefono = Leer.leerInt();
        
        System.out.println("¿Es infantil?(s/n)");
        String infantil = Leer.leerString();
        if (infantil.equals("s")) {
            System.out.println("Dime el nombre del tutor");
            String nomTutor = Leer.leerString();
            comptes.add(new CompteInfantil(nomTutor,numCuenta,nomCuenta,telefono));
        }
        else{
            comptes.add(new Compte(numCuenta,nomCuenta,telefono));
        }
    }
    
    //Eliminar una cuenta
//    static void eliminarCompte(ArrayList comptes){
//        Object c = new Compte(triaCompte(comptes));
//        if (comptes.get(new triaCompte(comptes) ) != null) {
//            System.out.println(comptes.toString());
//            comptes.remove(triaCompte(comptes));
//            
//        }
//        else{
//            System.out.println("No existe");
//        }
//        
//    }
    
    //Mostrar cuentas creadas
    static void cuentasCreadas(ArrayList comptes){
        //Mostrar todas las cuentas creadas
        for (Object Compte : comptes) {
            System.out.println(comptes);
        }
        
        //Mostrar la cantidad de cuentas
        System.out.println("Cantidad de cuentas: "+comptes.size());
        
        //Cantidad de cuentas infantiles
        
        
    }
    
    static void hacerIngreso(ArrayList comptes){
        
        System.out.println("Dime el numero de cuenta: ");
        int numCuenta = Leer.leerInt();
        
        if (comptes.indexOf(new Compte(numCuenta)) != -1) {
            Compte c = new Compte(numCuenta);
            
            System.out.println("Dime el importe: ");
            int importe = Leer.leerInt();
            
            
            comptes.add(c); //Ya que no me funciona la funcion triarCompte, creo de nuevo el objeto y lo meto de nuevo en el array
            c.ingressar(importe);
            
        }
        else{
            System.out.println("No existe");
        }
    }
    
    static void hacerReintegro(ArrayList comptes){
        System.out.println("Dime el numero de cuenta: ");
        int numCuenta = Leer.leerInt();
        
        if (comptes.indexOf(new Compte(numCuenta)) != -1) {
            Compte c = new Compte(numCuenta);
            
            System.out.println("Dime el importe: ");
            int importe = Leer.leerInt();
            
            
            if (c.reintegrar(importe) == false) {
                System.out.println("No se ha podido hacer el reintegro");
            }
        }
    }
    
    static void tranferencia(ArrayList comptes){
        System.out.println("Dime tu numero de cuenta: ");
        int numCuenta = Leer.leerInt();
        
        System.out.println("Dime el numero de cuenta destino: ");
        int numCuentaDestino = Leer.leerInt();
        
        if (comptes.indexOf(new Compte(numCuenta)) != -1 && comptes.indexOf(new Compte(numCuentaDestino)) != -1){
            System.out.println("Dime el importe");
            int importe = Leer.leerInt();
            
            Compte desti = new Compte(numCuentaDestino);
            
            desti.transferir(desti, importe);
        }
        else{
            System.out.println("Error");
        }
            
    }
    
    
    
    
}
