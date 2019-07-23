package es.unican.ss.segurosDomain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings({ "serial" })
@XmlType(name = "Cliente")
@XmlAccessorType(XmlAccessType.FIELD)

public class Cliente implements Serializable{
	@XmlAttribute(required = true)
	private String nombre;
	@XmlAttribute(required = true)
	@XmlID
	private String dni;
	@XmlAttribute(required = true)
	private String email;
	
	@XmlElement(name = "seguro", type = Seguro.class, required=true)
	private List<Seguro> seguros = new ArrayList<Seguro>();
	
	@XmlElement(name="vehiculo", type=Vehiculo.class, required=true)
	private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	

	public Cliente(){

	}
	
	public boolean anadeSeguro(Seguro s){
		seguros.add(s);
		return true;
	}
	
	public double calculaPagar(){
		double deuda=0;
		for(Seguro s: seguros){
			deuda+=s.calculaPrecio();
		}
		return deuda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni=dni;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}
}
