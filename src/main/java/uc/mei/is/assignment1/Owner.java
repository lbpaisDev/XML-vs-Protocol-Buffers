package uc.mei.is.assignment1;

import java.util.Date;
import java.util.List;
import java.util.Random;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Owner {

	/* Fields */
	
	@XmlAttribute
	public int Id;

	@XmlElement
	public String Name;
	
	@XmlElement	
	public List<Pet> Pets;
	
	@XmlElement
	public Date BirthDate;
	
	@XmlElement
	public String Phone;
	
	@XmlElement
	public String Address;
	
	/* Constructor */
	public Owner() {
		
	}
	
	public Owner(String name) {
		this.Name = name;
	}
	
	public Owner(List<Pet> pets, Date birthDate, String phone, String address, String name) {
		super();
		Id = new Random().nextInt(999999999);
		Name = name;
		Pets = pets;
		BirthDate = birthDate;
		Phone = phone;
		Address = address;
	}

	/* Getters */
	public int getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}
	
	public String getPhone() {
		return Phone;
	}

	public Date getBirthDate() {
		return BirthDate;
	}
	
	public String getAddress() {
		return Address;
	}

	public List<Pet> getPets() {
		return Pets;
	}
	

	/* Setters */

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}

	public void setName(String name){
		Name = name;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public void setAddress(String address) {
		Address = address;
	}	
	
	public void setPets(List<Pet> pets) {
		Pets = pets;
	}
	
	@Override
	public String toString() {
		return this.Name;
		
	}
}
