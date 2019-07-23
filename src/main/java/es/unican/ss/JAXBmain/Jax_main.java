package es.unican.ss.JAXBmain;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.unican.ss.segurosDomain.Aseguradora;
import es.unican.ss.segurosDomain.Cliente;
import es.unican.ss.segurosDomain.Seguro;
import es.unican.ss.segurosDomain.Terceros;
import es.unican.ss.segurosDomain.Vehiculo;

public class Jax_main {

	public static void main(String[] args) {
		//creacion del JAXBContext
		JAXBContext jaxbContext;
		try {

			jaxbContext = JAXBContext.newInstance(Aseguradora.class);
			File file = new File("src/main/resources/aseguradora.xml");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			Aseguradora aseguradora= (Aseguradora) unmarshaller.unmarshal(file);

			
			double totalAPagar;
			
			for (Cliente p : aseguradora.getClientes()) {	
				 System.out.print("DNI: " + p.getDni());
				 totalAPagar = 0;
				 for (Seguro s : p.getSeguros()) {
					 totalAPagar += s.getPrecio();
					 
				 }
				 System.out.println(" // Precio: " + totalAPagar);
			 }
			

			Cliente c= new Cliente();
			
			c.setDni("72350115G");
			c.setEmail("pepin@gmail.com");
			c.setNombre("pepin");

			Seguro s = new Terceros();
			s.setId("AAA-1111");

			Vehiculo v = new Vehiculo("12345-SA",200,false);

			s.setVehiculo(v);

			c.getSeguros().add(s);

			aseguradora.getClientes().add(c);

			Marshaller marshaller=jaxbContext.createMarshaller();
			marshaller.marshal(aseguradora, new File("src/main/resources/aseguradora2.xml"));

		}catch (JAXBException w) {

			System.out.println("error de JAXB");
			w.printStackTrace();
		}
	}

}
