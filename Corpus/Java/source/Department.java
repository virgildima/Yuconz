
/**
 * Enumeration class Department - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Department
{
    Admin(0), Sales(20), Services(40), HR(60);
    private int value;
    
    private Department(int value)
    {   
        this.value = value;
    }
    
    public int toInt()
    {
        return this.value;
    }
    
    public static Department fromInt(int value)
    {
        switch (value)
        {
            case 0:
                return Department.Admin;
            case 20:
                return Department.Sales;
            case 40:
                return Department.Services;
            case 60:
                return Department.HR;
        }
        return null;
    }
}
