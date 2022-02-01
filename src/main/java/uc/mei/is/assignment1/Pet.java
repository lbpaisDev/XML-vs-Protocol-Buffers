/**
 * 
 */
package uc.mei.is.assignment1;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Pet {

	/* Fields */
	
	@XmlAttribute
	public int Id;	

	@XmlElement
	public String Name;
	
	@XmlElement
	public String Species;
	
	@XmlElement
	public char Gender;
	
	@XmlElement
	public float Weight;
	
	@XmlElement
	public Date BirthDate;
	
	@XmlElement
	public String Description;
	
	/* Constructors */
	public Pet() {
		
	}
	
	public Pet(int id, String name, String species, char gender, float weight, Date birthDate,
			String description) {
		super();
		Id = id;
		Name = name;
		Species = species;
		Gender = gender;
		Weight = weight;
		BirthDate = birthDate;
		Description = description;
	}
	
	
	/* Getters */
	public int getId() {
		return Id;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getSpecies() {
		return Species;
	}

	public char getGender() {
		return Gender;
	}

	public float getWeight() {
		return Weight;
	}
	
	public Date getBirthDate() {
		return BirthDate;
	}
	
	public String getDescription() {
		return Description;
	}	


	/* Setters */
	
	public void setName(String name) {
		Name = name;
	}	

	public void setSpecies(String species) {
		Species = species;
	}
	
	public void setGender(char gender) {
		Gender = gender;
	}	

	public void setWeight(float weight) {
		Weight = weight;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}	

	public void setDescription(String description) {
		Description = description;
	}

}
