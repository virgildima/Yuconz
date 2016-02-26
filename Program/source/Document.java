import java.util.HashMap;

/**
 * Document class. 
 * Written as an abstract class.
 * 
 * @author Chris Wing 
 * @version 0.2
 */
public abstract class Document
{  
    private HashMap<String, String> documentAttributes = new HashMap<String, String>();
            
    
    public HashMap returnMap(){
    
        return documentAttributes;
    }
    
     /**
     * public method getData()
     * 
     * Gets data of document.
     * 
     * Returns data in as a String.
     */
    public String getData(String attributeName){
   
        if(attributeName != "" && attributeName != null && doesExist(attributeName) == true)
            return documentAttributes.get(attributeName);
        else
            return "ERROR: whitespace not a valid source of input, or no valid attribute named: " + attributeName + ".";
    }
    
    /**
     * private method doesExist()
     * 
     * Checks whether or not a String entered in exixts as a attribute within the 
     * documentAttributes HashMap.
     */
    private boolean doesExist(String attribute){
        
        if(documentAttributes.containsKey(attribute) == true){
        
            return true;
        }
        else return false;
    }
    
}
