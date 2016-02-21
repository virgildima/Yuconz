
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
}
