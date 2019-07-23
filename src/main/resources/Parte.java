package es.unican.ss.SegurosDomain;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @authors Daniel Arranz, Fernando González
 *
 */
@SuppressWarnings("serial")
@XmlType(name = "Parte")
@XmlAccessorType(XmlAccessType.FIELD)
public class Parte implements Serializable {
	
	@XmlAttribute
	@XmlID
	private String id;

	@XmlElement(required = true)
	private Date fecha;

	@XmlElement(required = true)
	private double importeArreglo;

	@XmlIDREF
	private Seguro seguro;

	public Parte() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getImporteArreglo() {
		return importeArreglo;
	}

	public void setImporteArreglo(double importeArreglo) {
		this.importeArreglo = importeArreglo;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

}
