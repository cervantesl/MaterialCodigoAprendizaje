/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.awt.Point;

public class Nodo {

    public Point posicion;

    public double puntoX;
    public double puntoY;

    public Nodo(final Point posicion) {
        this.posicion = posicion;
    }

    public Nodo(final double puntoX, final double puntoY) {
        this.puntoX = puntoX;
        this.puntoY = puntoY;
    }

    public Point obtenerPosicion() {
        return posicion;
    }

    public double obtenerPosicionX() {
        return puntoX;
    }

    public double obtenerPosicionY() {
        return puntoY;
    }
}
