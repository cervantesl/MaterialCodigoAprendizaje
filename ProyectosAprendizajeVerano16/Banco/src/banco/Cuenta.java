/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

public class Cuenta {

    private String nombre;
    private String apellido;
    private int edad;
    private final int numCuenta;
    private int saldo;
    private int ultimoMovimiento;

    public Cuenta(String nombre, String apellido, int edad, int numCuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.numCuenta = numCuenta;
        this.saldo = 0;
        this.ultimoMovimiento = 0;
    }

    public Cuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    @Override
    public boolean equals(Object obj) {
        Cuenta c = (Cuenta) obj;
        return this.numCuenta == c.numCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta: " + this.numCuenta + "\n -Nombre: " + this.nombre + "\n -Apellido: "
                + this.apellido + "\n -Edad: " + this.edad;

    }

    public void hacerIngreso(int importe) {
        this.saldo += importe;
        this.ultimoMovimiento = importe;
    }

    public boolean retirar(int importe) {
        if (this.saldo >= importe) {
            this.saldo -= importe;
            this.ultimoMovimiento = importe;
            return true;
        } else {
            return false;
        }
    }
    
    public void transferir(int importe, Cuenta cuentaTransferir) {
        if (this.saldo >= importe && !cuentaTransferir.equals(this)) {
            cuentaTransferir.hacerIngreso(importe);
            this.retirar(importe);
        }
    }
    
    //SET & GET
    public int obtenerSaldo() {
        return saldo;
    }
    
    public int obtenerUltimoMovimiento() {
        return ultimoMovimiento;
    }
    
    public String obtenerApellido() {
        return apellido;
    }
    
    public int obtenerEdad() {
        return edad;
    }
    
    
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void asignarEdad(int edad) {
        this.edad = edad;
    }


}
