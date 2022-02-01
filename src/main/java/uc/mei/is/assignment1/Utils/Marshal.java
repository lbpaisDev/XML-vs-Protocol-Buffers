package uc.mei.is.assignment1.Utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import uc.mei.is.assignment1.Root;

public class Marshal {

	private static JAXBContext JAXBContext;
	private static Marshaller marshaller;
	
	public static Marshaller doMarshal() {		
		try {
			JAXBContext = jakarta.xml.bind.JAXBContext.newInstance(Root.class);

			marshaller = JAXBContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return marshaller;		
	}
	
	public static Unmarshaller unMarshal() {
		try {
			return JAXBContext.createUnmarshaller();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
