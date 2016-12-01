/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import herramientas.CargadorRecursos;
import herramientas.GestionContenidoSAX;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
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
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Lucas
 */
public class Principal {

    public static void crearDocumentoXML() throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        DOMImplementation implementacion = builder.getDOMImplementation();

        Document document = implementacion.createDocument(null, "alumnos", null);
        document.setXmlVersion("1.0");

        //Contenido fichero alumnos
        String contenido = CargadorRecursos.leerArchivoTexto("/datos.txt");

        String[] partes = contenido.split("\n"); //Partes datos alumnos enteros [id, nombre, apellidos, asignaturas...]

        int contador = 0;

        while (contador < partes.length - 1) {
            contador++;
            //Lectura del primer alumno
            String alumno = partes[contador];
            String[] partesAlumno = alumno.split(",");

            Element raiz = document.createElement("alumno");
            document.getDocumentElement().appendChild(raiz);

            //Escritura XML;
            escribirXML(partesAlumno, raiz, document);

        }

        //Proceso para guardar xml y mostrarlo
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM\\AccesoDatos\\ProyectoAD\\datos.xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);

    }

    public static void escribirXML(String[] partesAlumno, Element raiz, Document document) {
        crearID("id", partesAlumno[0], raiz);
        Element elementoVacioNombre = crearElementoVacio("nombre", raiz, document); //Recojo el elemento para añadirle las etiquetas hijas despues
        crearElemento("principal", partesAlumno[1], elementoVacioNombre, document);
        crearElemento("apellidos", partesAlumno[2], elementoVacioNombre, document);
        crearElemento("mail", partesAlumno[3], raiz, document);
        crearElemento("telefono", partesAlumno[4], raiz, document);
        Element elementoVacioAsignaturas = crearElementoVacio("asignaturas", raiz, document); //Recojo el elemento para añadirle las etiquetas hijas despues
        crearElemento("aprobadas", partesAlumno[5], elementoVacioAsignaturas, document);
        crearElemento("suspendidas", partesAlumno[6], elementoVacioAsignaturas, document);
    }

    public static void modificarXML() throws SAXException, ParserConfigurationException, IOException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM\\AccesoDatos\\ProyectoAD\\datos.xml"));

        NodeList alumnos = document.getElementsByTagName("alumno");

        //Fichero de modificaciones txt
        String modificaciones = CargadorRecursos.leerArchivoTexto("/modificaciones.txt");
        String[] alumnosModificados = modificaciones.split("\n");

        int contador = 1;
        boolean encontrado = false;

        String[] alumnosOriginalesID = new String[alumnos.getLength()];
        String[] alumnosOriginalesDatos = new String[alumnos.getLength()];

        for (int i = 0; i < alumnosOriginalesID.length; i++) {
            alumnosOriginalesID[i] = alumnos.item(i).getAttributes().item(0).getNodeValue(); //Meto todos los ids originales en un array

            alumnosOriginalesDatos[i] = alumnosOriginalesID[i] + "," + alumnos.item(i).getFirstChild().getChildNodes().item(0).getTextContent()
                    + "," + alumnos.item(i).getFirstChild().getChildNodes().item(1).getTextContent() + "," + alumnos.item(i).getChildNodes().item(1).getTextContent()
                    + "," + alumnos.item(i).getChildNodes().item(2).getTextContent() + "," + alumnos.item(i).getLastChild().getChildNodes().item(0).getTextContent()
                    + "," + alumnos.item(i).getLastChild().getChildNodes().item(1).getTextContent();
        }

        List<String> alumnosOriginalesListaID = Arrays.asList(alumnosOriginalesID); // convierto el array id originales en lista

        for (int i = 1; i < alumnosModificados.length; i++) {
            String alumnoModificado = alumnosModificados[i];
            String[] partesAlumnoModificado = alumnoModificado.split(",");

            encontrado = alumnosOriginalesListaID.contains(partesAlumnoModificado[0]); //Comparo las lista con los id orirginales con los id

            if (encontrado) {
                for (int j = 0; j < alumnosOriginalesDatos.length; j++) {
                    String alumnosOriginales = alumnosOriginalesDatos[j];
                    String[] partesAlumnosOriginales = alumnosOriginales.split(",");
                    Element obtenerRaiz = (Element) alumnos.item(j);
                    if (partesAlumnoModificado[0].equals(partesAlumnosOriginales[0])) { //Compruebo ID
                        if (!partesAlumnoModificado[1].equals(partesAlumnosOriginales[1])) { //Compruebo NOMBRE
                            System.out.println(partesAlumnoModificado[1] + "," + partesAlumnosOriginales[1]);
                            alumnos.item(j).getFirstChild().getChildNodes().item(0).setTextContent(partesAlumnoModificado[1]);
                        }
                        if (!partesAlumnoModificado[2].equals(partesAlumnosOriginales[2])) { //Compruebo APELLIDOS
                            alumnos.item(j).getFirstChild().getChildNodes().item(1).setTextContent(partesAlumnoModificado[2]);
                        }
                        if (!partesAlumnoModificado[3].equals(partesAlumnosOriginales[3])) { //Compruebo EMAIL
                            alumnos.item(j).getChildNodes().item(1).setTextContent(partesAlumnoModificado[3]);
                        }
                        if (!partesAlumnoModificado[4].equals(partesAlumnosOriginales[4])) { //Compruebo TELEFONO
                            alumnos.item(j).getChildNodes().item(2).setTextContent(partesAlumnoModificado[4]);
                        }
                        if (!partesAlumnoModificado[5].equals(partesAlumnosOriginales[5])) { //Compruebo ASIGNATURA APROBADA
                            alumnos.item(j).getLastChild().getChildNodes().item(0).setTextContent(partesAlumnoModificado[5]);
                        }
                        if (!partesAlumnoModificado[6].equals(partesAlumnosOriginales[6])) { //Compruebo ASIGNATURA SUSPENDIDA
                            alumnos.item(j).getLastChild().getChildNodes().item(1).setTextContent(partesAlumnoModificado[6]);
                        }
                    }
                }

            } else {
                //Escritura XML
                Element raiz = document.createElement("alumno");
                document.getDocumentElement().appendChild(raiz);

                escribirXML(partesAlumnoModificado, raiz, document);
            }

        }

        //Proceso para guardar xml y mostrarlo
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM\\AccesoDatos\\ProyectoAD\\datos.xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
    }

    public static void crearElemento(String datoEtiqueta, String valor, Element raiz, Document documento) {
        Element elemento = documento.createElement(datoEtiqueta);
        Text texto = documento.createTextNode(valor);
        raiz.appendChild(elemento);
        elemento.appendChild(texto);
    }

    public static Element crearElementoVacio(String datoEtiqueta, Element raiz, Document documento) {
        Element elemento = documento.createElement(datoEtiqueta);
        raiz.appendChild(elemento);

        return elemento;
    }

    public static void crearID(String datoAlumno, String valor, Element raiz) {
        raiz.setAttribute(datoAlumno, valor);
    }

    public static void leerXMLSAX() throws SAXException, IOException, ParserConfigurationException {
        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        GestionContenidoSAX gestor = new GestionContenidoSAX();
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM\\AccesoDatos\\ProyectoAD\\datos.xml");
        procesadorXML.parse(fileXML);
    }

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException {

        Scanner teclado = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("1.- CREAR XML");
            System.out.println("2.- MODIFICAR XML");
            System.out.println("3.- MOSTRAR XML SAX");
            System.out.println("4.- SALIR");
            System.out.println("Elegir opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    crearDocumentoXML();
                    break;
                case 2:
                    modificarXML();
                    break;
                case 3:
                    leerXMLSAX();
                    break;
                case 4:
                    System.out.println("Adios!");
                    break;
            }
        } while (opcion != 4);

    }
}
