import java.util.HashMap;
/**
 * Enumeration class DocumentE - Used for all documents.
 * Refactor of classes from Chris and Virgil
 * 
 * @author Andrew Johnson
 * @version 0.1
 */
public class Document
{
    private HashMap<String, String> documentData = new HashMap<String, String>();
    private DocType type;
    /**
     * Constructor for objects of class Document
     */
    public Document(DocType type)
    {
        this.type = type;
    }
    
    public DocType type()
    {
        return type;
    }
    
    /**
     * public method getValue()
     * 
     * Gets data of document.
     * 
     * Returns data in as a String.
     */
    public String getValue(String attributeName){
        int i = type.getIndex(attributeName);

        if(i<0){
            return "ERROR: no valid attribute named: " + attributeName + ".";
        }
        return documentData.get(attributeName);
    }
    
    /**
      * public method setValue()
      * 
      * Method gets the value to a documents attribute.
      * 
      * @param attributeName: The name of the attribute you wish to change thea value of.
      * 
      * Returns a String as a return type.
    */
    public boolean setValue(String attributeName, String newValue){
        int i = type.getIndex(attributeName);
        if(i<0){
            return false;
        }
        documentData.put(attributeName,newValue);
        return true;
    }
    
    /**
     * public method equals()
     * 
     * Checks equality between two Document (any type) objects.
     */
    @Override public boolean equals(Object doc)
    {
        HashMap compData = ((Document)doc).getData();
        boolean equal = true;
        for(String attr : documentData.keySet())
        {
            if(!documentData.get(attr).equals(compData.get(attr)))
            {
                equal = false;
                break;
            }
        }
        return equal;
    }
    
    public HashMap getData(){
        return documentData;
    }
    
    /**
     * Method that creates a Microsoft .docx from the document data at 
     */
    public void saveToFile(String filePath)
    {
        type.saveToFile(filePath,this);
    }
}
