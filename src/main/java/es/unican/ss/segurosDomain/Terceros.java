package es.unican.ss.segurosDomain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@SuppressWarnings({ "serial" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Terceros")
public class Terceros extends Seguro implements Serializable{
	
	public Terceros(){
		super();
		this.precioBase=200.0;
	}

	@Override
	public double calculaPrecio() {
		return precioBase+vehiculo.getCv()*1.5;
	}
}