import java.util.HashMap;
/**
 * Write a description of class PersonalDetailsDocument here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PersonalDetailsDocument extends Document
{

    private String[] attributeList = {"firstname","surname","DOB","address_1","address_2",
                                        "town","county","postcode","telephone","mobile","next_of_kin","next_of_kin_CN","staffID"};
    
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
    
    public HashMap getData(){
    
        return super.getData();
    }
    
    @Override public boolean equals(Object doc)
    {
        return super.equals((Document)doc);
    }
}
