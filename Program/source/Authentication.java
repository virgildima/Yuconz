import java.sql.*;
import java.util.*;
public class Authentication extends DB_Core
{
    static final String dbName = "authenticationDB";
    static Connection conn = null;
    static Statement stmt = null;
    static PreparedStatement prepStmt = null;
    static ResultSet rs = null;
    
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
                                +"DEPARTMENT     INT NOT NULL, "
                                +"SURNAME       VARCHAR(50) NOT NULL, "
                                +"FIRSTNAME     VARCHAR(30) NOT NULL, "
                                +"LOCKED        BOOLEAN NOT NULL)";
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
        return conn!=null;
    }
    
    public static void deleteDB()
    {
        try{
            conn.close();
        } catch (Exception e) {
           System.out.println("Could not close connection");
           e.printStackTrace();
        }
        try{
            stmt.executeQuery("DROP TABLE users");
        } catch (Exception e) {
           System.out.println("Could not drop users");
           e.printStackTrace();
        }
        try{
            stmt.executeQuery("DROP TABLE givenPermission");
        } catch (Exception e) {
           System.out.println("Could not drop givenPermission");
           e.printStackTrace();
        }
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
