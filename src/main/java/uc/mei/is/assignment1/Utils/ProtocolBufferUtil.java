package uc.mei.is.assignment1.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ProtocolBuf.OwnerProtocolBuffer;
import ProtocolBuf.OwnerProtocolBuffer.Root;
import ProtocolBuf.OwnerProtocolBuffer.Root.Owner;
import uc.mei.is.assignment1.Pet;

public class ProtocolBufferUtil {

	public static Root loadOwners(List<uc.mei.is.assignment1.Owner> owners) {
		ProtocolBuf.OwnerProtocolBuffer.Root.Builder root = OwnerProtocolBuffer.Root.newBuilder();		

		for(uc.mei.is.assignment1.Owner owner : owners) {
			OwnerProtocolBuffer.Root.Owner.Builder ownerProBuf = OwnerProtocolBuffer.Root.Owner.newBuilder();
			ownerProBuf.setId(owner.Id);
			ownerProBuf.setName(owner.Name);
			ownerProBuf.setAddress(owner.Address);
			ownerProBuf.setBirthDate(owner.BirthDate.toString());
			ownerProBuf.setPhone(owner.Phone);
			
			for(Pet pet : owner.getPets()) {
				ownerProBuf.addPets(loadPets(pet));				
			}			
			root.addOwners(ownerProBuf);
		}
		
	    return root.build();
	}
	
	public static ProtocolBuf.OwnerProtocolBuffer.Root.Owner.Pet.Builder loadPets(Pet ownerPet) {
		
			ProtocolBuf.OwnerProtocolBuffer.Root.Owner.Pet.Builder pet = OwnerProtocolBuffer.Root.Owner.Pet.newBuilder();		
			
			pet.setId(ownerPet.getId());
			pet.setName(ownerPet.getName());
	    	pet.setSpecies(ownerPet.getSpecies());
	    	pet.setGender(ownerPet.getSpecies());
	    	pet.setWeight(ownerPet.getWeight());
	    	pet.setDescription(ownerPet.getDescription());
	    	pet.setBirthDate(ownerPet.getBirthDate().toString());
	    	pet.build();
	    	
	    	return pet;
	}
		

	public static Root loadData(List<uc.mei.is.assignment1.Owner> owners) {			
		return loadOwners(owners);
	}
	
	public static void serializeData(FileOutputStream output, ProtocolBuf.OwnerProtocolBuffer.Root root) {
		
		try {
			root.writeTo(output);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Root deserializeData(FileInputStream output) {
		
		try {
			return Root.parseFrom(output);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
