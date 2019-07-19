package es.unican.ss.SegurosSAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import es.unican.ss.SegurosSAX.AseguradoraElementosHandler;

public class ProcesaAseguradoraElementos {
	
	public static void main(String[] args) {

		try {

			// Instanciar el parser
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			// Crear el manejador
			AseguradoraElementosHandler handler = new AseguradoraElementosHandler();
			
			// Parsear el fichero
			saxParser.parse("src/main/resources/aseguradora.xml", handler);

			
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
