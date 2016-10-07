/*
A partir del fichero cd_catalog.xml
1. Crear una aplicación en Java que recorra el XML mostrando por la salida estándar toda la información de cada uno de los CD.
2. Añadir al XML la i nformación de un nuevo CD: Abbey Road (The Batles) al final. utilizando DOM
3. Guardar el nuevo fichero XML como cd_catalog_plus.xml
4. Subir el fichero .java y el nuevo xml (en un zip)
 */
package manejoficheros;

import java.io.File;
import java.io.IOException;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author Lucas
 */
public class EjercicioManipulacionXML {

    static void lecturaXML() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM\\AccesoDatos\\VerDir\\cd_catalog.xml"));

        System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());

        NodeList cds = document.getElementsByTagName("CD");

        for (int i = 0; i < cds.getLength(); i++) {
            Node CD = cds.item(i);

            if (CD.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) CD;
                System.out.println("Titulo: " + getNodo("TITLE", elemento));
                System.out.println("Artista: " + getNodo("ARTIST", elemento));
                System.out.println("Pais: " + getNodo("COUNTRY", elemento));
                System.out.println("Compania: " + getNodo("COMPANY", elemento));
                System.out.println("Precio: " + getNodo("PRICE", elemento));
                System.out.println("Año: " + getNodo("YEAR", elemento));
            }
        }
    }

    static String getNodo(String etiqueta, Element element) {
        NodeList nodo = element.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valorNodo = (Node) nodo.item(0);

        return valorNodo.getNodeValue();
    }

    static void añadirElementoXML() throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM\\AccesoDatos\\VerDir\\cd_catalog.xml"));

        Element CD = document.createElement("CD");
        document.getDocumentElement().appendChild(CD);

        crearElemento("TITLE", "Abbey Road", CD, document);
        crearElemento("ARTIST", "The Beatles", CD, document);
        crearElemento("COUNTRY", "UK", CD, document);
        crearElemento("COMPANY", "-", CD, document);
        crearElemento("PRICE", Integer.toString(50), CD, document);
        crearElemento("YEAR", Integer.toString(1980), CD, document);

        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File("C:\\Users\\Lucas\\Documents\\MaterialCodigoAprendizaje\\2DAM\\AccesoDatos\\VerDir\\cd_catalog_plus.xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);

        Result console = new StreamResult(System.out);
        transformer.transform(source, console);
    }

    static void crearElemento(String datoCD, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoCD);
        Text text = document.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(text);
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        lecturaXML();

        añadirElementoXML();

    }
}
