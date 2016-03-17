
import java.sql.*;
/**
 * Abstract class DB_TableHandler - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class DB_TableHandler
{
    
    protected Connection conn;
    
    protected PreparedStatement prepStmt(String str,String[] vals)
    {
        PreparedStatement prepStmt;
        try{
            prepStmt = conn.prepareStatement(str);
            
            for(int i = 1;i<=vals.length;i++)
            {
                prepStmt.setString(i,vals[i]);
            }
        } catch (Exception e) {
           System.out.println("Prepare Statement encountered an error.");
           e.printStackTrace();
           return null;
        }
        return prepStmt;
    }
    
    
    /**
     * Creates a prepared statement for adding the document to the table
     * 
     * @param doc The document to add to the table.
     * @return the preparedStatement for the document.
     */
    abstract public PreparedStatement addDocument(PersonalDetailsDocument doc);
}
