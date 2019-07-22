package es.unican.ss.SegurosSAX;

import java.util.ArrayList;
import java.util.List;

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
		case "cliente":
			//	Nueva persona se renueva lista de ids de seguros
			idsSeguros.clear(); 
			precioTotal=0;
			dni = attributes.getValue("dni");
			break;
		case "seguro":
			//	Cogemos el id del seguro, que, al ser un atributo, lo obtenemos como un atributo
			idSeguro = attributes.getValue("id");
			idsSeguros.add(idSeguro);
			tipoSeguro = attributes.getValue("xsi:type");
			break;
		case "parte":
			fecha = attributes.getValue("fecha");
			break;
		case "vehiculo":
			potencia = Double.parseDouble(attributes.getValue("potencia"));
			usoProfesional = Boolean.parseBoolean(attributes.getValue("esProfesional"));
			break;
		default:
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {		
		case "parte":
			// Comprobamos si el parte se corresponde con el seguro
			if (!(idsSeguros.contains(idSeguroParte))) {
				System.out.println("El parte de accidente con fecha " + fecha + " no pertenece a ningún seguro.");
			}
			break;
		case "seguro":
			precioTotal += getPrecio();
			break;
		case "cliente":
			System.out.println("DNI: " + dni + "Precio: " + precioTotal);
			break;
		case "seguroRef":
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
