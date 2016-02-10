import java.sql.*;
public abstract class DB_Core
{
   //  Database credentials
   static final String USER = "username";
   static final String PASS = "password";

   Connection conn = null;
   Statement stmt = null;
        
    protected boolean setup(String db_URL)
    {
        
        try {
            conn = DriverManager.getConnection(db_URL,USER,PASS);
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            System.out.println("Connecting to database...");
        }
        return false;
    }
    public boolean isViable()
    {
        return false;
    }
    public boolean deleteDB()
    {
        return false;
    }
}
