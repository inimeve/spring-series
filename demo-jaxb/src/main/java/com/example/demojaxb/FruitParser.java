package com.example.demojaxb;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class FruitParser {

	static Fruit parseFruitXML(String fruitXML) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Fruit.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return (Fruit) jaxbUnmarshaller.unmarshal(new StringReader(fruitXML));
	}
	
}
