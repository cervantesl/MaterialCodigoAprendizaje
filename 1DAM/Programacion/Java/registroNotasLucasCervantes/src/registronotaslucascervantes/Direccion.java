
package registronotaslucascervantes;

/**
 *
 * @author Lucas
 */
public class Direccion {
    private String calle = "";
    private int numero;
    private int codigoPostal;
    
    //Constructor
    public Direccion(){
       
    }

    //Metodos
    public void setCalle(String calle){
        this.calle = calle;
    }
    public String getCalle(){
        return calle;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
