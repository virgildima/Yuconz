import java.sql.*;
public class Authentication extends DB_Core
{
    /**
     * Constructor for objects of class Authentication
     */
    public Authentication()
    {
        setup();
    }
    public boolean login(int userID, String password, AccessRights accessRights)
    {
        return false;
    }
    public boolean logout()
    {
        return false;
    }
    public boolean givePermission(int userID, int documentID)
    {
        return false;
    }
    public boolean removePermission(int userID, int documentID)
    {
        return false;
    }
    public boolean lockAccount(int userID)
    {
        return false;
    }
}
