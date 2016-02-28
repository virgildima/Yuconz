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
    private HashMap<String, String> documentData = new HashMap<String, String>();
            
    
     /**
     * public method setValue()
     * 
     * Method gets the value to a documents attribute.
     * 
     * @param attributeName: The name of the attribute you wish to change thea value of.
     * 
     * Returns a String as a return type.
     */
    @SuppressWarnings("unchecked")
    protected void setValue(String[] attributeList, String attributeName, String newValue){
        
        for(int i = 0; i < attributeList.length; i++){
        
            if(attributeName == attributeList[i]){
            
                    documentData.put(attributeName, newValue);
            }
            else System.out.println("ERROR: no valid attribute named: " + attributeName + ".");
        }
    }
    
     /**
     * public method getData()
     * 
     * Gets data of document.
     * 
     * Returns data in as a String.
     */
    protected String getValue(String[] attributeList, String attributeName){
   
        for(int i = 0; i < attributeList.length; i++){
        
            if(attributeName == attributeList[i]){
            
                    documentData.get(attributeName);
            }
            else return "ERROR: no valid attribute named: " + attributeName + ".";
        }
        
        return "ERROR: no valid attribute named: " + attributeName + ".";
    }
    

    protected HashMap getData(){
    
        return documentData;
    }
    
}
