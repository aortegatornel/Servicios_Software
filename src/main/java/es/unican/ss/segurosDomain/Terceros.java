package es.unican.ss.segurosDomain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings({ "serial" })
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