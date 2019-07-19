package es.unican.ss.segurosDomain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@SuppressWarnings({ "serial" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Seguro")
public abstract class Seguro implements Serializable{
	@XmlAttribute(required = true)
	@XmlID
	private String id;
	@XmlElement(required = true)
	protected Vehiculo vehiculo;
	@XmlAttribute(required = true)
	protected double precioBase;
	
	public Seguro(){}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public abstract double calculaPrecio();

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void asignaVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getId() {
		return id;
	}

}
