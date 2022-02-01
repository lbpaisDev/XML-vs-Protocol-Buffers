package uc.mei.is.assignment1.Utils;

import java.io.File;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import uc.mei.is.assignment1.Owner;
import uc.mei.is.assignment1.Pet;
import uc.mei.is.assignment1.Root;

public class Seed {

	// Populates mock data
	public static Root initializeData(String petFile, String ownerFile) throws ParseException{

		Root root = new Root();
		Random random = new Random();
		List<Pet> pets = new ArrayList<Pet>();
		List<Owner> owners = new ArrayList<Owner>();
		
		try {
		    // open file to read	
		    Scanner scanner_pet = new Scanner(new File("pets/"+petFile));

		    // read until end of file (EOF)
		    while (scanner_pet.hasNextLine()) {
		    	
		    	String line = scanner_pet.nextLine();
		    	String[] lineSplitted = line.split(" "); 

		    	float weight = Float.parseFloat(lineSplitted[4]);
		    	
		    	pets.add(new Pet(Integer.parseInt(lineSplitted[0]), lineSplitted[1], lineSplitted[2], lineSplitted[3].charAt(0) ,weight, new Date(), lineSplitted[5]));
		    }

			
			// open file to read
		    Scanner scanner = new Scanner(new File("owners/"+ownerFile));

		    // read until end of file (EOF)
		    while (scanner.hasNextLine()) {
		    	
		    	String line = scanner.nextLine();
		    	String[] lineSplitted = line.split(" "); 

		    	List<Pet> ownedPets = new ArrayList<Pet>();
		    	

		    	if(pets.size() == 0) {
	
			    	owners.add(new Owner(new ArrayList<Pet>(), new Date(), lineSplitted[0], lineSplitted[1], lineSplitted[2]));		
			    	continue;
		    	}
		    	
		    	int index = random.nextInt(pets.size());
		 	
		    	ownedPets.add(pets.get(index));	
		    	pets.remove(index);
		    	owners.add(new Owner(ownedPets, new Date(), lineSplitted[0], lineSplitted[1], lineSplitted[2]));		
		    	
		    }
		    
		    while(pets.size() > 0) {
		    	
		    	int chooseOwner = random.nextInt(owners.size());
		    	int choosePet = random.nextInt(pets.size());
		    			    	
		    	owners.get(chooseOwner).getPets().add(pets.get(choosePet));
		    	pets.remove(choosePet);
		    }

		    // close the scanner
		    scanner.close();
		    

		    // close the scanner
		    scanner_pet.close();
		        
		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		}
		
	
		root.setOwners(owners);		
		
		return root;
	}	
}
