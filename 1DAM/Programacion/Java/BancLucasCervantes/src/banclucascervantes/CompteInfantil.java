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
public class CompteInfantil extends Compte{
    private String nomTutor;
    private int comptador;

    public CompteInfantil(String nomTutor, int numCompte, String nom, int telefon) {
        super(numCompte, nom, telefon);
        this.nomTutor = nomTutor;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+"Tutor/a: "+nomTutor;
    }
    
    
}
