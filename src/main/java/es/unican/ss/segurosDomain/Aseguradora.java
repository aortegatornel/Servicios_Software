package es.unican.ss.segurosDomain;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Aseguradora")
@XmlType(name = "Aseguradora")
public class Aseguradora {
	
	@XmlElement(name = "clientes", type = Cliente.class, required=true)
	private List<Cliente> clientes=new LinkedList<Cliente>();
		
	public Aseguradora(){}
}