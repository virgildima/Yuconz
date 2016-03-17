
import java.sql.*;
/**
 * Abstract class DB_TableHandler - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class DB_TableHandler<DocType>
{
    
    protected Connection conn;
    
    protected PreparedStatement prepStmt(String str,String[] vals)
    {
        PreparedStatement prepStmt;
        try{
            prepStmt = conn.prepareStatement(str);
            
            for(int i = 1;i<=vals.length;i++)
            {
                prepStmt.setString(i,vals[i-1]);
            }
        } catch (Exception e) {
           System.out.println("Prepare Statement encountered an error.");
           e.printStackTrace();
           return null;
        }
        return prepStmt;
    }
    
    protected boolean execPrepStmt(PreparedStatement prepStmt)
    {
        Boolean success = false;
        try{
            success = (prepStmt.executeUpdate()==1);
        } catch (Exception e) {
           System.out.println("Execute Statement encountered an error.");
           e.printStackTrace();
           success = false;
        }
        return success;
    }
    
    /**
     * The SQL string to create the table
     * 
     * @return the SQL string.
     */
    abstract public String createTableStr();
    
    /**
     * add the document to the table
     * 
     * @param doc The document to add to the table.
     * @return if the document was added.
     */
    abstract public boolean addDocument(DocType doc);
}
