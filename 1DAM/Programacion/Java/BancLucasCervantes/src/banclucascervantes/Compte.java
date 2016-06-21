/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banclucascervantes;

/**
 *
 * @author Lucas
 */
public class Compte {
    //Atributos
    private int numCompte;
    private String nom;
    private int telefon;
    private int ultimMoviment;
    private int saldo;
    
    //Constructor
    public Compte(int numCompte, String nom, int telefon) {
        this.numCompte = numCompte;
        this.nom = nom;
        this.telefon = telefon;
    }
    
    //Constructor para elegir cuenta
    public Compte(int numCompte){
        this.numCompte = numCompte;
    }
    
    //Metodo ingresar
    public void ingressar(int importe){
        this.saldo += importe;
        this.ultimMoviment = importe;
    }
    
    //Metodo reintegrar
    public boolean reintegrar(int importe){
        if (importe <= this.saldo) {
            this.saldo -= importe;
            this.ultimMoviment = importe;
            return true;
        }
        else{
            return false;
        }
    }

    //Metodo equals
    @Override
    public boolean equals(Object obj) {
        Compte a = (Compte)obj;
        return this.numCompte == a.numCompte;
    }
    
    //Metodo tranferir
    public String transferir(Object obj, int importe){
        Compte desti = (Compte)obj;
        if (!desti.equals(this.numCompte) && this.saldo >= importe) {
            desti.ingressar(importe);
            this.reintegrar(importe);
            return "";
        }
        else{
            return "El numero de cuenta es igual o el saldo es menor al importe";
        }
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Compte: "+numCompte + " Nom: " + nom + " telefon: " + telefon + "\n"+"Saldo: "+saldo+" Ultim moviment: "+ultimMoviment;
    }
    
    
    
}
