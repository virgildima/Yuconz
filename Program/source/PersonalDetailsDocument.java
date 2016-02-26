import java.util.HashMap;
/**
 * Write a description of class PersonalDetailsDocument here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PersonalDetailsDocument extends Document
{

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
 
        switch(attributeName){
        
            case "firstname":
                returnMap().put(attributeName, newValue);
                break;
            case "surname":
                returnMap().put(attributeName, newValue);
                break;
            case "DOB":
                returnMap().put(attributeName, newValue);
                break;
            case "address_1":
                returnMap().put(attributeName, newValue);
                break;
            case "address_2":
                returnMap().put(attributeName, newValue);
                break;
            case "town":
                returnMap().put(attributeName, newValue);
                break;
            case "county":
                returnMap().put(attributeName, newValue);
                break;
            case "postcode":
                returnMap().put(attributeName, newValue);
                break;
            case "telephone":
                returnMap().put(attributeName, newValue);
                break;
            case "mobile":
                returnMap().put(attributeName, newValue);
                break;
            case "next_of_kin":
                returnMap().put(attributeName, newValue);
                break;
            case "next_of_kin_CN":
                returnMap().put(attributeName, newValue);
                break;
            default: 
                System.out.println("ERROR: no valid attribute named: " + attributeName + ".");
        }
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
    public String getData(String attributeName){
    
        switch(attributeName){
        
            case "firstname":
                return returnMap().get(attributeName).toString();
            case "surname":
                return returnMap().get(attributeName).toString();
            case "DOB":
                return returnMap().get(attributeName).toString();
            case "address_1":
                return returnMap().get(attributeName).toString();
            case "address_2":
                return returnMap().get(attributeName).toString();
            case "town":
                return returnMap().get(attributeName).toString();
            case "county":
                return returnMap().get(attributeName).toString();
            case "postcode":
                return returnMap().get(attributeName).toString();
            case "telephone":
                return returnMap().get(attributeName).toString();
            case "mobile":
                return returnMap().get(attributeName).toString();
            case "next_of_kin":
                return returnMap().get(attributeName).toString();
            case "next_of_kin_CN":
                return returnMap().get(attributeName).toString();
            default: 
                return "ERROR: no valid attribute named: " + attributeName + ".";
        }
    }
}
