
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
    private static String[] names = new String[] {"Basic User","Manager","Senior Manager","Directior","HR User"};
    
    
    private AccessRights(int value)
    {   
        this.value = value;
    }
    
    public int toInt()
    {
        return this.value;
    }
    
    public static AccessRights fromInt(int value)
    {
        switch (value)
        {
            case 0:
                return AccessRights.Basic_User;
            case 20:
                return AccessRights.Manager;
            case 40:
                return AccessRights.SeniorManager;
            case 60:
                return AccessRights.Director;
            case 80:
                return AccessRights.HR_User;
        }
        return null;
    }
    
    
    public static String[] names()
    {
        return names;
    }
    
    public static AccessRights fromString(String value)
    {
        
        switch (value)
        {
            case "Basic User":
                return AccessRights.Basic_User;
            case "Manager":
                return AccessRights.Manager;
            case "Senior Manager":
                return AccessRights.SeniorManager;
            case "Directior":
                return AccessRights.Director;
            case "HR User":
                return AccessRights.HR_User;
        }
        return null;
    }
}
