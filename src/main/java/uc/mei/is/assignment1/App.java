package uc.mei.is.assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import uc.mei.is.assignment1.Utils.Marshal;
import uc.mei.is.assignment1.Utils.ProtocolBufferUtil;
import uc.mei.is.assignment1.Utils.Seed;

public class App 
{	
    public static void main( String[] args ) throws ParseException, IOException
    {    	    	
    	
        File directoryPathPets = new File("C:\\Users\\lbpais\\OneDrive - dei.uc.pt\\Documentos\\MEI\\IS\\Assignment_1\\is_assignment1-main\\pets");
        File directoryPathOwners = new File("C:\\Users\\lbpais\\OneDrive - dei.uc.pt\\Documentos\\MEI\\IS\\Assignment_1\\is_assignment1-main\\owners");
       
        int ntests = 11;
        
        //List of all files and directories
        String contentsPets[] = directoryPathPets.list();
        String contentsOwners[] = directoryPathOwners.list();
        
     
        PrintWriter writerTimeMarshalling = new PrintWriter("test_data_xml_unmarshalling.out", "UTF-8");
        PrintWriter writerTimeUnMarshalling = new PrintWriter("test_data_xml_unmarshalling.out", "UTF-8");
        PrintWriter writerSize = new PrintWriter("test_data_xml_unmarshalling.out", "UTF-8");

        
        for(int i=0; i<contentsPets.length; i++) {
           for(int j=0; j<contentsOwners.length; j++) {
        	   
        	   	writerTimeMarshalling.println(""+ contentsPets[i] + " " + contentsOwners[j]);
        	   	writerTimeUnMarshalling.println(""+ contentsPets[i] + " " + contentsOwners[j]);
        	   	writerSize.println(""+ contentsPets[i] + " " + contentsOwners[j]);

        	   	Root root = Seed.initializeData(contentsPets[i], contentsOwners[j]);	        	

        	        for(int k = 0 ; k < ntests; k++) {
          	      
        	        long start = System.currentTimeMillis();    	  

    	        	Marshaller marshaller = Marshal.doMarshal();
    	        	try {
    	            	marshaller.marshal(root, new FileOutputStream("./root.xml"));
    	        	}
    	        	catch(Exception e) {
    	        		e.printStackTrace();
    	        	}
    	        	long end = System.currentTimeMillis();
    	   
    	        	writerTimeMarshalling.println((end-start));
    	        	
    	        	start = System.currentTimeMillis();    	  
    	        	
    	        	Unmarshaller unmarshaller = Marshal.unMarshal();
    	        	try {
    	        		InputStream inStream = new FileInputStream( "root.xml" ); 
						Root rootUnmarshalled = (Root) unmarshaller.unmarshal( inStream );
    	        	} catch (JAXBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	        	
    	        	end = System.currentTimeMillis();
    	        	writerTimeUnMarshalling.println((end-start));
    	            
        	        Path path = Paths.get("root.xml");
    	        	long bytes = Files.size(path);
       	        	 	        	
    	        	writerSize.println((bytes));
	
        	   	}	        	
             }
        }
        
        writerTimeMarshalling.close();
        writerTimeUnMarshalling.close();
        writerSize.close();


        
        /*
        PrintWriter writerSerialize = new PrintWriter("test_data_protobuff_protoc_size.out", "UTF-8");        
       // PrintWriter writerDeSerialize = new PrintWriter("test_data_protobuff_deser.out", "UTF-8");        
        
        
        for(int i=0; i<contentsPets.length; i++) {
            for(int j=0; j<contentsOwners.length; j++) {
         	   
            	writerSerialize.println(""+ contentsPets[i] + " " + contentsOwners[j]);
            	//writerDeSerialize.println(""+ contentsPets[i] + " " + contentsOwners[j]);
            	Root root = Seed.initializeData(contentsPets[i], contentsOwners[j]);	        	
         	   	
         	//   	for(int k = 0 ; k < ntests; k++) {
         	    	// Google Protocol Buffer 
         	    	ProtocolBuf.OwnerProtocolBuffer.Root rootProtocolBuffer = ProtocolBufferUtil.loadData(root.owners);
         	    	
         	    	long start = System.currentTimeMillis();
         	    	ProtocolBufferUtil.serializeData(new FileOutputStream("./protoc"), rootProtocolBuffer);    	
         	    	long end = System.currentTimeMillis();
         	    	
    	        	Path path = Paths.get("protoc");
    	        	long bytes = Files.size(path);
       	            	        	
         	    	writerSerialize.println(bytes/1024);
         	    	
//         	    	start = System.currentTimeMillis();
  //       	    	ProtocolBuf.OwnerProtocolBuffer.Root deserialized = ProtocolBufferUtil.deserializeData(new FileInputStream("./protoc"));
    //     	    	end = System.currentTimeMillis();
         	    	//writerDeSerialize.println((end-start));

         //	    	System.out.println(deserialized);         	    	
//         	   	}
              }
         }
        writerSerialize.close();
        //writerDeSerialize.close();     	
         
         */
    }
}
