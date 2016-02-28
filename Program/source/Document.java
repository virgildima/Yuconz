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
    protected boolean setValue(String[] attributeList, String attributeName, String newValue){
        int i = getIndex(attributeList, attributeName);
        
        if(i<0){
            return false;
        }
        documentData.put(attributeName,newValue);
        return true;
    }
    
     /**
     * public method getData()
     * 
     * Gets data of document.
     * 
     * Returns data in as a String.
     */
    protected String getValue(String[] attributeList, String attributeName){
        int i = getIndex(attributeList, attributeName);
        
        if(i<0){
            return "ERROR: no valid attribute named: " + attributeName + ".";
        }
        return documentData.get(attributeName);
    }
        
    private int getIndex(String[] attributeList, String attributeName)
    {
        for(int i = 0; i < attributeList.length; i++){
        
            if(attributeName == attributeList[i]){
                    return i;
            }
        }
        return -1;
    }
    

    protected HashMap getData(){
    
        return documentData;
    }
    
}
