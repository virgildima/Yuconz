import java.util.HashMap;

/**
 * SalaryIncreaseDocument implementation document.
 * 
 * @author Chris Wing 
 * @version 0.1
 */
public class SalaryIncreaseDocument extends Document
{
    private String[] attributeList = {"staffID","firstname","surname","current_salary","new_salary"};
    
     /**
     * public method setValue()
     * 
     * Method sets a new value to a documents attribute.
     * 
     * @param attributeName: The name of the attribute you wish to change thea value of.
     * @param newValue: The new value you wish to set attributeName as.
     * 
     * No meaningful return type. Either True or Void.
     */
    @SuppressWarnings("unchecked")
    public void setValue(String attributeName, String newValue){
        
        setValue(attributeList, attributeName, newValue);
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
    public String getValue(String attributeName){
    
        return getValue(attributeList, attributeName);
    }
    
    /**
     * public method getData()
     * 
     * Returns all data in form of HashMap. 
     */
    public HashMap getData(){
    
        return super.getData();
    }
    
    /**
     * public method equals()
     * 
     * Checks equality between two Document (any type) objects.
     */
    @Override public boolean equals(Object doc)
    {
        return super.equals((Document)doc);
    }
}
