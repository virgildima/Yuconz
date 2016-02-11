
/**
 * Enumeration class AccessRights - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum AccessRights
{
    Basic_User(0), Manager(20), SeniorManager(40), Director(60), HR_User(80);
    private int value;
    
    private AccessRights(int value)
    {   
        this.value = value;
    }
    
    public int toInt()
    {
        return this.value;
    }
}
