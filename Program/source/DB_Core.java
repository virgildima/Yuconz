import java.io.File;
import java.sql.*;
public abstract class DB_Core
{
    //  Database credentials
    protected static final String USER = "username";
    protected static final String PASS = "password";
    protected static boolean isSetup = false;
    
    protected Connection conn = null;
    protected Statement stmt = null;
    protected PreparedStatement prepStmt = null;
    protected ResultSet rs = null;
    
    
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
