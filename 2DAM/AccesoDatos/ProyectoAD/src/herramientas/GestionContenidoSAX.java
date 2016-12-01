/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Lucas
 */
public class GestionContenidoSAX extends DefaultHandler {

    boolean id = false;
    boolean nombre = false;
    boolean apellidos = false;
    boolean email = false;
    boolean telefono = false;
    boolean aprobadas = false;
    boolean suspendidas = false;

    public GestionContenidoSAX() {
        super();
    }

    public void startDocument(String uri, String localName, String qName,
            Attributes attributes) {

      
    }

    @Override
    public void endDocument() {

    }

    @Override
    public void startElement(String uri, String qName, String nombreC, Attributes atts) {

        if (qName.equalsIgnoreCase("principal")) {
            nombre = true;
        }
        if (qName.equalsIgnoreCase("apellidos")) {
            apellidos = true;
        }
        if (qName.equalsIgnoreCase("mail")) {
            email = true;
        }
        if (qName.equalsIgnoreCase("telefono")) {
            telefono = true;
        }
        if (qName.equalsIgnoreCase("aprobadas")) {
            aprobadas = true;
        }
        if (qName.equalsIgnoreCase("suspendidas")) {
            suspendidas = true;
        }

    }

    @Override
    public void endElement(String uri, String nombre, String nombreC) {
        if (nombre.equalsIgnoreCase("suspendidas")) {
            System.out.println("");
        }
        
    }

    @Override
    public void characters(char[] ch, int inicio, int longitud) {

        if (nombre) {
            System.out.print("nombre: " + new String(ch, inicio, longitud));
            nombre = false;
        }
        if (apellidos) {
            System.out.print(" apellidos: " + new String(ch, inicio, longitud));
            apellidos = false;
        }
        if (email) {
            System.out.print(" email: " + new String(ch, inicio, longitud));
            email = false;
        }
        if (telefono) {
            System.out.print(" telefono: " + new String(ch, inicio, longitud));
            telefono = false;
        }
        if (aprobadas) {
            System.out.print(" aprobadas: " + new String(ch, inicio, longitud));
            aprobadas = false;
        }
        if (suspendidas) {
            System.out.print(" suspendidas: " + new String(ch, inicio, longitud));
            suspendidas = false;

        }

    }
}

