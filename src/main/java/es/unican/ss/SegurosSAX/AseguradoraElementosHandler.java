package es.unican.ss.SegurosSAX;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AseguradoraElementosHandler extends DefaultHandler{
	
	private String texto = null;
	private String dni = null;
	private String idSeguro = null;
	private String idSeguroParte = null;
	private String fecha = null;
	private String tipoSeguro = null;
	private double potencia;
	private boolean usoProfesional = false;
	private double precioTotal;

	private List<String> idsSeguros = new ArrayList<>();

	// Este método en realidad no hace falta, se pone a modo
	// de ejemplo
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Empiezo a parsear");
	}

	// Este método en realidad no hace falta, se pone a modo
	// de ejemplo
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Finalizo el parseo");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName) {
		case "tns:cliente":
			//	Nueva persona se renueva lista de ids de seguros
			idsSeguros.clear(); 
			precioTotal=0;
			dni = attributes.getValue("dni");
			break;
		case "tns:seguro":
			//	Cogemos el id del seguro, que, al ser un atributo, lo obtenemos como un atributo
			idSeguro = attributes.getValue("id");
			idsSeguros.add(idSeguro);
			tipoSeguro = attributes.getValue("xsi:type");
			break;
		case "tns:parte":
			fecha = attributes.getValue("fecha");
			break;
		case "tns:vehiculo":
			potencia = Integer.parseInt(attributes.getValue("cv"));
			usoProfesional = Boolean.parseBoolean(attributes.getValue("esProfesional"));
			break;
		default:
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {		
		case "tns:parte":
			// Comprobamos si el parte se corresponde con el seguro
			if (!(idsSeguros.contains(idSeguroParte))) {
				System.out.println("El parte de accidente con fecha " + fecha + " no pertenece a ningún seguro.");
			}
			break;
		case "tns:seguro":
			precioTotal += getPrecio();
			break;
		case "tns:cliente":
			System.out.println("DNI: " + dni + " Precio: " + precioTotal);
			break;
		case "tns:seguroRef":
			idSeguroParte = texto;
			break;
		default:
		}		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		texto = new String(ch, start, length).trim();
	}

	public List<String> getIdsSeguros() {
		return idsSeguros;
	}

	public void setIdsSeguros(List<String> idsSeguros) {
		this.idsSeguros = idsSeguros;
	}
	
	public double getPrecio() {
		double precio = 0;
		if (tipoSeguro == "Terceros") {
			precio = 200.0;
		} else if (tipoSeguro == "TodoRiesgo" || tipoSeguro == "TRFranquicia") {
			precio = 600.0;
		}

		precio = 1.5 * potencia;

		if (usoProfesional) {
			precio += 100.0;
		}

		return precio;
	}
}
