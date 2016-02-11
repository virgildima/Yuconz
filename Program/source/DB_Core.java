import java.io.File;
import java.sql.*;
public abstract class DB_Core
{
   //  Database credentials
   static final String USER = "username";
   static final String PASS = "password";
   static boolean isSetup = false;

        
    protected static boolean setup()
    {
        if(!isSetup){
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                isSetup = true;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return isSetup;
    }
    public boolean isViable()
    {
        return false;
    }
    protected static void deleteDB(String dbName)
    {
        deleteDirectory(new File(dbName));
    }
    protected static boolean isTableCount(Connection conn,int expected)
    {
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Count(TABLENAME) FROM SYS.SYSTABLES WHERE TABLETYPE='T'");
            rs.next();
            int count = rs.getInt(1);
            Boolean res = (count==expected);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    static private boolean deleteDirectory(File path) {
    if( path.exists() ) {
      File[] files = path.listFiles();
      for(int i=0; i<files.length; i++) {
         if(files[i].isDirectory()) {
           deleteDirectory(files[i]);
         }
         else {
           files[i].delete();
         }
      }
    }
    return( path.delete() );
  }
}
