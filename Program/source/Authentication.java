import java.sql.*;
import java.util.*;
public class Authentication extends DB_Core
{
    static final String dbName = "authenticationDB";
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement prepStmt = null;
    ResultSet rs = null;
    
    String currentUser = null;
    
    /**
     * Constructor for objects of class Authentication
     */
    public Authentication()
    {
        if(setup()){
            try {
                conn = DriverManager.getConnection("jdbc:derby:"+dbName+";create=true");
                stmt = conn.createStatement();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Unable to connect to database.");
            }
            if(!isTableCount(conn,2))
            {
                createDB();
            }
        }
    }
    private void createDB()
    {
        System.out.println("Creating "+dbName+".");
        try{
            String str = "CREATE TABLE users ("
                                +"ID            CHAR(6) NOT NULL PRIMARY KEY, "
                                +"PASSHASH      VARCHAR(128) NOT NULL, "
                                +"AUTHLEVEL     INT NOT NULL, "
                                +"SURNAME       VARCHAR(50) NOT NULL, "
                                +"FIRSTNAME     VARCHAR(30) NOT NULL, "
                                +"LOCKED        SMALLINT NOT NULL)";
            stmt.execute(str);
            str = "CREATE TABLE givenPermission ("
                                +"ID        VARCHAR(6) NOT NULL, "
                                +"DOCID     INT NOT NULL,"
                                +"GIVENBYID VARCHAR(6) NOT NULL,"
                                +"PRIMARY KEY (ID, DOCID))";
            stmt.execute(str);
            
            System.out.println(dbName+" ready.");
        } catch (Exception e) {
            System.out.println(dbName+" could not be created properly.");
            e.printStackTrace();
        }
    }
    
    public boolean addNewUser(String userID, String passhash, AccessRights accessRights, String surname, String firstname)
    {
        Boolean success = false;
        try{
            String str = "INSERT INTO users (ID, PASSHASH, AUTHLEVEL, SURNAME, FIRSTNAME, LOCKED) VALUES (?,?,?,?,?,false)";
            prepStmt = conn.prepareStatement(str);
            
            prepStmt.setString(1,userID);
            prepStmt.setString(2,passhash);
            prepStmt.setInt(3,accessRights.toInt());
            prepStmt.setString(4,surname);
            prepStmt.setString(5,firstname);
            
            
            success = prepStmt.execute(str);
            System.out.println(dbName+" ready.");
        } catch (Exception e) {
            System.out.println("Insert user encountered an error.");
            e.printStackTrace();
        }
        return success;
    }
    public boolean login(int userID, String passhash, AccessRights accessRights)
    {
        return false;
    }
    public boolean logout()
    {
        return false;
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
        return conn!=null;
    }
    
    public static void deleteDB()
    {
        DB_Core.deleteDB(dbName);
    }
    
    public void printMetaData(String table)
    {
        try{
            rs = stmt.executeQuery("SELECT * FROM "+table);
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Columns:");
            for(int i=1;i<=rsmd.getColumnCount();i++)
            {
                System.out.println(rsmd.getColumnLabel(i)+"; "+rsmd.getColumnTypeName(i)+"; "+rsmd.getPrecision(i));
            }
        } catch (Exception e) {
            
        }
    }
    public void printTables()
    {
        try{
            rs = stmt.executeQuery("SELECT TABLENAME FROM SYS.SYSTABLES WHERE TABLETYPE='T'");
            System.out.println("Tables:");
            while(rs.next())
            {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            
        }
    }
    
    
    
    
    
    
    
}
