package es.unican.ss.segurosDomain;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlType(name="Parte")
public class Parte implements Serializable{
	@XmlAttribute(required=true)
	private double importe;
	@XmlAttribute(required=true)
	private String IdSeguro;
	@XmlAttribute(required=true)
	private Date fecha;
	@XmlAttribute(required=true)
	@XmlID
	private String idParte;
	
	public Parte (double importe, String idSeguro, Date fecha, String idParte) {
		this.importe=importe;
		this.IdSeguro=idSeguro;
		this.fecha=fecha;
		this.idParte=idParte;
	}
	
	public Parte() {}

	public double getImporte() {
		return importe;
	}

	public String getIdSeguro() {
		return IdSeguro;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getIdParte() {
		return idParte;
	}
}
