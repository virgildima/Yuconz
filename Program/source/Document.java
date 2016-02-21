import java.io.File;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Document class. 
 * Written as an abstract class.
 * 
 * @author Chris Wing 
 * @version 0.2
 */
public abstract class Document extends DocumentAttributes implements DocumentInterface
{
    private static String stringPath = "C:\\Users\\Chris\\Desktop\\test.txt";
    private static File filePath = new File("C:\\Users\\Chris\\Desktop\\test.txt");
    private static Path path = filePath.toPath();
    private static BasicFileAttributes attributes = null;
        
     /**
     * public method setValue()
     * 
     * Method sets a new value to a documents attribute.
     * 
     * @param attributeName: The name of the attribute you wish to change the value of.
     * @param newValue: The new value you wish to set attributeName as.
     * 
     * No meaningful return type. Either True or Void.
     */
    public void setValue(String attributeName, String newValue){
        
        switch(attributeName){
        
            case "name":
                setName(newValue);
                break;
            case "age":
                setAge(newValue);
                break;
            case "gender":
                setGender(newValue);
                break;
            case "email_address":
                setEmailAddress(newValue);
                break;
            case "mobile_number":
                setMobileNumber(newValue);
                break;
            case "home_number":
                setHomeNumber(newValue);
                break;
            case "home_address":
                setHomeAddress(newValue);
                break;
            case "postcode":
                setPostcode(newValue);
                break;
            default: break;
        }
    }
    
     /**
     * public method getData()
     * 
     * Gets data of document.
     * 
     * Returns data in as a String.
     */
    
    @SuppressWarnings("deprecation")
    public String getData(String dataType){
        
        if(dataType == "size"){
            return String.valueOf(filePath.length());
        }
        if(dataType == "name"){
                return filePath.getAbsolutePath().substring(filePath.getAbsolutePath().lastIndexOf("\\") + 1);
        }
        if (dataType == "created"){
            
            try{
            
                attributes = Files.readAttributes(path, BasicFileAttributes.class);
            }
            catch(IOException exception){
            
                return "Exception handled when trying to get file attributes: " + exception.getMessage();
            }
           
            long milliseconds = attributes.creationTime().to(TimeUnit.MILLISECONDS);
            if((milliseconds > Long.MIN_VALUE) && (milliseconds < Long.MAX_VALUE)){
            
                // Creates date based off of milliseconds.
                Date creationDate = new Date(attributes.creationTime().to(TimeUnit.MILLISECONDS));
               
                return "Document: " + path.toString() + "created: " + creationDate.getDate() + "/" + 
                        (creationDate.getMonth() + 1) + "/" + (creationDate.getYear() + 1900);
            }
        }
        if(dataType == "type"){
                return getExtension(filePath);
        }
        else
            throw new IllegalArgumentException("Invalid data type: " + dataType);
    }
    
     /**
     * private method getExtension()
     * 
     * Method used to get extension of active document/ file.
     * 
     * @param file: The name (more specifically the path) of the active file.
     * 
     * Returns String.
     */
    private String getExtension(File file){
    
        // Gets file name.
        String name = file.getName();
        
        try{
            // Returns a string subset of which is before the last '.'.
            return name.substring(name.lastIndexOf(".") + 1);
        }
        catch(Exception e){
            return "";
        }
    }
}
