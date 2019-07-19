package es.unican.ss.segurosDomain;

import java.io.Serializable; 
import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@SuppressWarnings({ "serial" })
@XmlAccessorType(value=XmlAccessType.FIELD)
@XmlType(name="Parte")
public class Parte implements Serializable{
	@XmlAttribute(required=true)
	private double importe;
	@XmlElement(required=true)
	@XmlIDREF
	private Seguro seguroRef;
	@XmlAttribute(required=true)
	private Date fecha;
	@XmlAttribute(required=true)
	private Integer idParte;
	
	public Parte (double importe,Seguro seguro, Date fecha, Integer idParte) {
		this.importe=importe;
		this.seguroRef=seguro;
		this.fecha=fecha;
		this.idParte=idParte;
	}

	public double getImporte() {
		return importe;
	}

	public String getIdSeguro() {
		return seguroRef.getId();
	}

	public Date getFecha() {
		return fecha;
	}

	public Integer getIdParte() {
		return idParte;
	}
}
