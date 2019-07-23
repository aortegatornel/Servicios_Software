package es.unican.ss.segurosDomain;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Jax_main {

	public static void main(String[] args) {
		JAXBContext jaxbContext;

		try {
			jaxbContext = JAXBContext.newInstance(Aseguradora.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Aseguradora aseguradora= (Aseguradora) unmarshaller.unmarshal(new File("src/main/resources/Aseguradora.xml"));


			Cliente c= new Cliente("Pepin martinez", "72358915G","pepinmartin@gmail.com");
			
			Seguro s = new Terceros();
			s.setId("AAA-1111");
			
			Vehiculo v = new Vehiculo("12345-SA",200,false);
			
			s.setVehiculo(v);
			
			c.getSeguros().add(s);
			
			aseguradora.getClientes().add(c);
			
			Marshaller marshaller=jaxbContext.createMarshaller();
			marshaller.marshal(aseguradora, new File("aseguradora_v2.xml"));
			
		}catch (JAXBException w) {
			
			System.out.println("error de JAXB");
			w.printStackTrace();
		}
	}

}
