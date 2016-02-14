import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

/**
 * Document class. 
 * Written as an abstract class.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Document implements DocumentInterface
{
    private static int documentID;
    private static File filePath = new File("C:\\Users\\Chris\\Desktop\\test.txt");
    private static Path path = filePath.toPath();
    
    private static BasicFileAttributes attributes = null;
    
     /**
     * public method setValue()
     * 
     * Method sets a new value to a documents attribute based on attributeName paramater
     * that is passed to it.
     * 
     * @param attributeName: The name of the attribute you wish to change the value of.
     * @param newValue: The new value you wish to set attributeName as.
     * 
     * No meaningful return type. Either True or Void.
     */
    public void setValue(String attributeName, String newValue){
    
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
    
    private String getExtension(File file){
    
        String name = file.getName();
        
        try{
            return name.substring(name.lastIndexOf(".") + 1);
        }
        catch(Exception e){
            return "";
        }
    }
}
