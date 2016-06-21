
package registronotaslucascervantes;

/**
 *
 * @author Lucas
 */
public class Alumno {
    private String nombre = "";
    private int telefono;
    private Direccion direccion = new Direccion();
    private Cualificacion[] cualificacion = new Cualificacion[3];
    
    //Constructor
    public Alumno(){
        
    }
    
    //Metodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Cualificacion[] getCualificacion() {
        return cualificacion;
    }

    public void setCualificacion(Cualificacion[] cualificacion) {
        this.cualificacion = cualificacion;
    }
    
}
