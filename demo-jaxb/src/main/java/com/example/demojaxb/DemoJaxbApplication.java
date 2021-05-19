package com.example.demojaxb;

import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
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
			Thread.sleep(3000);
			
			// Get XML
            String xmlEntityString = Files.readString(Paths.get("src/main/resources/sample-xmls/fruit.xml"));
            
            // Parse once            
            long startTime = System.nanoTime();
            FruitParser.parseFruitXML(xmlEntityString);
            long stopTime = System.nanoTime();
            System.out.println("Parse once -> " + (Math.floor((double) (stopTime - startTime)/1_000_000) + " ms"));
            
            
            // Parse 10
            startTime = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
            	FruitParser.parseFruitXML(xmlEntityString);
            }
            stopTime = System.nanoTime();
            System.out.println("Parse 1000 -> " +  (Math.floor((double) (stopTime - startTime)/1_000_000) + " ms"));
            
            
            // With one JAXB instance
    		JAXBContext jaxbContext = JAXBContext.newInstance(Fruit.class);
    		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    		
            startTime = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
            	jaxbUnmarshaller.unmarshal(new StringReader(xmlEntityString));
            }
            stopTime = System.nanoTime();
            System.out.println("Parse 1000 with on JAXB instance -> " +  (Math.floor((double) (stopTime - startTime)/1_000_000) + " ms"));
            
            startTime = System.nanoTime();
            for (int i = 0; i < 100000; i++) {
            	jaxbUnmarshaller.unmarshal(new StringReader(xmlEntityString));
            }
            stopTime = System.nanoTime();
            System.out.println("Parse 1000000 with on JAXB instance -> " +  (Math.floor((double) (stopTime - startTime)/1_000_000) + " ms"));
            
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
