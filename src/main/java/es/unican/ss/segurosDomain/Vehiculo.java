package es.unican.ss.segurosDomain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@SuppressWarnings({ "serial" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vehiculo")
public class Vehiculo implements Serializable{
	@XmlAttribute(required = true)
	@XmlID
	private String matricula;
	@XmlAttribute(required = true)
	private int cv;
	@XmlAttribute(required = true)
	private boolean esProfesional;
	
	public Vehiculo(String mat, int cv, boolean esPro){
		this.matricula=mat;
		this.cv=cv;
		this.esProfesional=esPro;
	}
	
	public Vehiculo(){}

	public int getCv() {
		return cv;
	}

	public void setCv(int cv) {
		this.cv = cv;
	}

	public boolean esProfesional() {
		return esProfesional;
	}

	public void setEsProfesional(boolean esProfesional) {
		this.esProfesional = esProfesional;
	}

	public String getMatricula() {
		return matricula;
	}
}
