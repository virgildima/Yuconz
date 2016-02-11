
/**
 * Enumeration class AccessRights - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum AccessRights
{
    Basic_User(0), Manager(1), HR_Employee(2), Director(3);
    private int value;
    
    private AccessRights(int value)
    {   
        this.value = value;
    }
}
