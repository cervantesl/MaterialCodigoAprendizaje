/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoficheros;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Lucas
 */
public class LecturaFicheroXML {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM\\AccesoDatos\\VerDir\\Empleados.xml"));
            document.getDocumentElement().normalize();
            
            System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());
            
            NodeList empleados = document.getElementsByTagName("empleado");
            
            for (int i = 0; i < empleados.getLength(); i++) {
                Node empleado = empleados.item(i);
                
                if (empleado.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) empleado;
                    System.out.println("ID: " + getNodo("id", elemento));
                    System.out.println("Apellido: " + getNodo("apellido", elemento));
                    System.out.println("Departamento: " + getNodo("Dep", elemento));
                    System.out.println("Salario: " + getNodo("salario", elemento));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(LecturaFicheroXML.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    private static String getNodo(String etiqueta, Element elemento) {
        NodeList nodo = elemento.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valorNodo = (Node) nodo.item(0);
        
        return valorNodo.getNodeValue();
    }
}
