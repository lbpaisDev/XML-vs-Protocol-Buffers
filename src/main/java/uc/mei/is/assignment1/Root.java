package uc.mei.is.assignment1;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "owners")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {
	
	@XmlElement
	public List<Owner> owners;

	
	/* Constructors */
	public Root(List<Owner> owners) {
		super();
		this.owners = owners;
	}

	public Root() {
		
	}
	
	
	/* Getters */
	public List<Owner> getOwners() {
		return owners;
	}


	/* Setters */
	public void setOwners(List<Owner> owners) {
		this.owners = owners;
	}	
}
