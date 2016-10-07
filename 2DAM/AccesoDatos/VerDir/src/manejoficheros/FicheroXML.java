/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Lucas
 */
public class FicheroXML {

    public static void main(String[] args) {

        int id, dep, posicion = 0;
        double salario;
        char[] apellido = new char[10];
        char aux;
        RandomAccessFile raf = null;
        try {
            File fichero = new File("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM\\AccesoDatos\\VerDir\\Recursos\\texto\\empleados.dat");
            raf = new RandomAccessFile(fichero, "r");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheroXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementacion = builder.getDOMImplementation();
            documento = implementacion.createDocument(null, "Empleados", null);
            documento.setXmlVersion("1.0");
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FicheroXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (raf.getFilePointer() < raf.length()) {
                raf.seek(posicion);
                id = raf.readInt();

                for (int i = 0; i < apellido.length; i++) {
                    aux = raf.readChar();
                    apellido[i] = aux;
                }

                String apellidos = new String(apellido);
                dep = raf.readInt();
                salario = raf.readDouble();

                if (id > 0) {
                    Element raiz = documento.createElement("empleado");
                    documento.getDocumentElement().appendChild(raiz);
                    crearElemento("id", Integer.toString(id), raiz, documento);
                    crearElemento("apellido", apellidos.trim(), raiz, documento);
                    crearElemento("Dep", Integer.toString(dep), raiz, documento);
                    crearElemento("salario", Double.toString(salario), raiz, documento);
                }

                posicion += 36;
            }

            Source source = new DOMSource(documento);
            Result result = new StreamResult(new java.io.File("Empleados.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        } catch (IOException ex) {
            Logger.getLogger(FicheroXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(FicheroXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(FicheroXML.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                raf.close();
            } catch (IOException ex) {
                Logger.getLogger(FicheroXML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    static void crearElemento(String datoEmpleado, String valor, Element raiz, Document documento) {

        Element elemento = documento.createElement(datoEmpleado);
        Text texto = documento.createTextNode(valor);
        raiz.appendChild(elemento);
        elemento.appendChild(texto);
    }
}
