import java.sql.*;
import java.util.*;
public class Database extends DB_Core
{
    /**
     * Constructor for objects of class Database
     */
    public Database()
    {
        dbName = "documentsDB";
        if(setup()){
            if(connect())
            {
                if(!isTableCount(conn,1))
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
            "CREATE TABLE personal ("
                +"DOCID     INT NOT NULL PRIMARY KEY,"
                +"STAFFID   CHAR(6) NOT NULL, "
                +"SURNAME   VARCHAR(50) NOT NULL, "
                +"NAME      VARCHAR(50) NOT NULL, "
                +"DOB       CHAR(10) NOT NULL, "
                +"ADDRESS1  VARCHAR(50) NOT NULL, "
                +"ADDRESS2  VARCHAR(50) NOT NULL, "
                +"TOWN      VARCHAR(50) NOT NULL, "
                +"COUNTY    VARCHAR(50) NOT NULL, "
                +"POSTCODE  VARCHAR(50) NOT NULL, "
                +"PHONE     VARCHAR(50) NOT NULL, "
                +"MOBILE    VARCHAR(50) NOT NULL, "
                +"NOK       VARCHAR(50) NOT NULL, "
                +"NOKPHONE  VARCHAR(50) NOT NULL, "
            }
        );
    }
    
    public boolean addDocument(Document doc)
    {
        Boolean success = false;
        try{
            String str = "INSERT INTO personal (ID, PASSHASH, AUTHLEVEL, DEPARTMENT, SURNAME, FIRSTNAME, LOCKED) VALUES (?,?,?,?,?,?,false)";
            prepStmt = conn.prepareStatement(str);
            
            //prepStmt.setString(1,userID);
            
            
            //success = (prepStmt.executeUpdate()==1);
        } catch (Exception e) {
           System.out.println("Add document encountered an error.");
           e.printStackTrace();
           return false;
        }
        return success;
    }
    
    public Document getPersonalDetails(String staffID)
    {
        Boolean success = false;
        try{
            String str = "SELECT * FROM personal WHERE STAFFID=?";
            prepStmt = conn.prepareStatement(str);
            
            prepStmt.setString(1,staffID);
            
            rs = prepStmt.executeQuery();
            
            if(rs.next()){
                //Document doc = new DocumentAttributes
                //(
                
                //);
            }
        } catch (Exception e) {
           System.out.println("Insert user encountered an error.");
           e.printStackTrace();
           return null;
        }
        
        return null;
    }
    
    public boolean isViable()
    {
        return (conn!=null)&&(isTableCount(conn,1));
    }
    public void deleteAll()
    {
       deleteTables(new String[] {"personal"});
    }
}
