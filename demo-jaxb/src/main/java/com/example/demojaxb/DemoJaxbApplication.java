package com.example.demojaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJaxbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoJaxbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			// Create marshaller
			JAXBContext jaxbContext = JAXBContext.newInstance(Fruit.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			Fruit o = new Fruit();
			o.setId(1);
			o.setName("Banana");
			o.setPrice("9.99");

            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(o, sw);
            String xmlContent = sw.toString();
            System.out.println( xmlContent );
			
			// Create unmarshaller
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
            Fruit fruit = (Fruit) jaxbUnmarshaller.unmarshal(new StringReader(xmlContent));
            System.out.println(fruit);
			
			

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
