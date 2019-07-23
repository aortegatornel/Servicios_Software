package es.unican.ss.segurosDomain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@SuppressWarnings({ "serial" })
@XmlRootElement(name="Aseguradora")
@XmlAccessorType(XmlAccessType.FIELD)
public class Aseguradora implements Serializable{
	
	@XmlElement(name = "cliente", type = Cliente.class, required=true)
	private List<Cliente> clientes=new LinkedList<Cliente>();
	
	
	public Aseguradora(){}
	
	
	public List<Cliente> getClientes(){
		return clientes;
	}


}