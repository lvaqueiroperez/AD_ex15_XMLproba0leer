package ex15_xmlproba0ler;

import java.io.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Ex15_XMLproba0ler {

    //DUDA NULL
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        //leer el documento anterior
        File fich1 = new File("/home/oracle/Desktop/ex14/xmlproba0.xml");

        FileReader fich1FR = new FileReader(fich1);

        XMLInputFactory xmlIF1 = XMLInputFactory.newInstance();
        XMLStreamReader xmlSR1 = xmlIF1.createXMLStreamReader(fich1FR);

        /*
         next() solo se usa para avanzar posicion
         hasNext() solo para preguntar si queda algo por leer
        
        
         */
        //PRUEBAS!! COMENTAR LO QUE HACE CADA MÉTODO, YA QUE HAY VARIOS
        //getLocalName para leer etiquetas
//        xmlSR1.next();
//        System.out.println(xmlSR1.getLocalName());
//        //
//        xmlSR1.next();
//        System.out.println(xmlSR1.getLocalName());
//        xmlSR1.next();
//        System.out.println(xmlSR1.getLocalName());
//        //get text para el texto entre elementos
//        xmlSR1.next();
//        System.out.println(xmlSR1.getText());
        //CADA FUNCIÓN SE USA PARA LEER UN TIPO DE ELEMENTO XML !!!
        //Leeremos el documento xml y lo iremos mostrando por el terminal
        //almacenaremos el valor de "getEventType" para saber el método que tenemos
        //que usar
        int tipoE = 0;

        
        /*
        LO HACEMOS SOLO LEYENDO START_ELEMENTS
        Y
        USANDO SOLO getLocalName,getAttributeValue y getElementText
        */
        while (xmlSR1.hasNext()) {

            tipoE = xmlSR1.getEventType();

            if (tipoE == XMLStreamConstants.START_ELEMENT) {

                //LOS ATRIBUTOS VAN DENTRO DE START ELEMENT !
                String localName = xmlSR1.getLocalName();
                if (localName == "autor") {

                    System.out.println(xmlSR1.getAttributeValue(0));

                }
                else if (localName=="nome"){
                System.out.println(xmlSR1.getElementText());
                }
                else if (localName=="titulo"){
                System.out.println(xmlSR1.getElementText());
                }

            }
            xmlSR1.next();
        }
        xmlSR1.close();

    }
}
