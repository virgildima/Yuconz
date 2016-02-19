import java.sql.*;
import java.util.*;
public class Authentication extends DB_Core
{
    String currentUser = null;
    
    /**
     * Constructor for objects of class Authentication
     */
    public Authentication()
    {
        dbName = "authenticationDB";
        if(setup()){
            if(connect())
            {
                if(!isTableCount(conn,2))
                {
                    createDB();
                }
            }
        }
    }
    private void createDB()
    {
        System.out.println("Creating "+dbName+".");
        super.createDB(new String[] {
            "CREATE TABLE users ("
                +"ID            CHAR(6) NOT NULL PRIMARY KEY, "
                +"PASSHASH      VARCHAR(128) NOT NULL, "
                +"AUTHLEVEL     INT NOT NULL, "
                +"DEPARTMENT     INT NOT NULL, "
                +"SURNAME       VARCHAR(50) NOT NULL, "
                +"FIRSTNAME     VARCHAR(30) NOT NULL, "
                +"LOCKED        BOOLEAN NOT NULL)",
            "CREATE TABLE givenPermission ("
                +"ID        VARCHAR(6) NOT NULL, "
                +"DOCID     INT NOT NULL,"
                +"GIVENBYID VARCHAR(6) NOT NULL,"
                +"PRIMARY KEY (ID, DOCID))"
            }
        );
    }
    
    public boolean addNewUser(String userID, String passhash, AccessRights accessRights, Department department, String surname, String firstname)
    {
        Boolean success = false;
        try{
            String str = "INSERT INTO users (ID, PASSHASH, AUTHLEVEL, DEPARTMENT, SURNAME, FIRSTNAME, LOCKED) VALUES (?,?,?,?,?,?,false)";
            prepStmt = conn.prepareStatement(str);
            
            prepStmt.setString(1,userID);
            prepStmt.setString(2,passhash);
            prepStmt.setInt(3,accessRights.toInt());
            prepStmt.setInt(4,department.toInt());
            prepStmt.setString(5,surname);
            prepStmt.setString(6,firstname);
            
            
            success = (prepStmt.executeUpdate()==1);
        } catch (Exception e) {
           System.out.println("Insert user encountered an error.");
           e.printStackTrace();
           return false;
        }
        return success;
    }
    public boolean login(String userID, String passhash, AccessRights accessRights)
    {
        Boolean success = false;
        try{
            String str = "SELECT COUNT(*) FROM users WHERE ID=? AND PASSHASH=? AND AUTHLEVEL=? AND LOCKED=false";
            prepStmt = conn.prepareStatement(str);
            
            prepStmt.setString(1,userID);
            prepStmt.setString(2,passhash);
            prepStmt.setInt(3,accessRights.toInt());
            
            rs = prepStmt.executeQuery();
            rs.next();
            if(rs.getInt(1)==1){
                currentUser = userID;
                success = true;
            }
        } catch (Exception e) {
           System.out.println("Insert user encountered an error.");
           e.printStackTrace();
           return false;
        }
        
        return success;
    }
    public boolean logout()
    {
        currentUser = null;
        return true;
    }
    public boolean givePermission(String userID, int documentID)
    {
        return false;
    }
    public boolean removePermission(String userID, int documentID)
    {
        return false;
    }
    public boolean lockAccount(String userID)
    {
        return false;
    }
    public boolean unlockAccount(String userID)
    {
        return false;
    }
    public boolean isViable()
    {
        return (conn!=null)&&(isTableCount(conn,2));
    }
    public void close()
    {
        try{
            conn.close();
        } catch (Exception e) {
           System.out.println("Could not close connection");
           e.printStackTrace();
        }
    }
    
    public void deleteAll()
    {
        try{
            if(rs!=null)
            {
                rs.close();
                rs = null;
            }
            try{
                String str = "DROP TABLE users";
                    stmt.execute(str);
            } catch (Exception e) {
                System.out.println("users could not be deleted properly.");
                e.printStackTrace();
            }
            try{
                String str = "DROP TABLE givenPermission";
                    stmt.execute(str);
            } catch (Exception e) {
                System.out.println("givenPermission could not be deleted properly.");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("database could not be deleted properly.");
            e.printStackTrace();
        }
        
    }
    
}
