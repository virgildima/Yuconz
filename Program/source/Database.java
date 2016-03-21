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
    
    /**
     * This creates the Documents Database
     */
    private void createDB()
    {
        System.out.println("Creating "+dbName+".");
        super.createDB(new String[] {
            DB_TableHandlers.personal.createTableStr
        });
    }
    
    private String[] getAttributeValues(String[] attributes,Document doc)
    {
        String[] values = new String[attributes.length];
        for(int i=0;i<values.length;i++)
        {
            values[i] = doc.getValue(attributes[i]);
        }
        return values;
    }
    
    /**
     * Adds a new document to the database.
     * 
     * @param doc The document to add to the database.
     * @return if the document was added to the database successfuly.
     */
    public boolean addDocument(Document doc)
    {
        boolean success = false;
        DB_TableHandlers handler = DB_TableHandlers.forDocType(doc);
        prepStmt = prepStmt(handler.addDocStr,getAttributeValues(handler.columnOrder,doc));
        success = execPrepStmt(prepStmt);
        return success;
    }
    
    /**
     * Updates an existing document in the database.
     * 
     * @param doc The document to update, containing the new data.
     * @return if the document was updated successfuly.
     */
    public boolean updateDocument(Document doc)
    {
        boolean success = false;
        DB_TableHandlers handler = DB_TableHandlers.forDocType(doc);
        prepStmt = prepStmt(handler.updateDocStr,getAttributeValues(handler.updateDocAttributes,doc));
        success = execPrepStmt(prepStmt);
        return success;
    }
    
    /**
     * Returns a document from the database.
     * 
     * @param staffID The staff ID on the personal Details document to get.
     * @return The document requested or null.
     */
    public <T extends Document> T getDocument(String staffID,Class<T> type)
    {
        DB_TableHandlers handler = DB_TableHandlers.forDocType(type);
        prepStmt = prepStmt(handler.getDocStr,new String[] {staffID} );
        rs = getData(prepStmt);
        try
        {
            rs.next();
            T doc = null;
            try{
                doc = type.newInstance();
            }catch(Exception e)
            {
               System.out.println("Type error in getDocument");
               e.printStackTrace();
               return null;
            }
            
            for(int i=0;i<handler.columnOrder.length;i++)
            {
                doc.setValue(handler.columnOrder[i],rs.getString(i+1));
            }
            return doc;
        }catch(SQLException e)
        {
            //Document not found
        }
        return null;
    }
    
    private PreparedStatement prepStmt(String str,String[] vals)
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
    
    private boolean execPrepStmt(PreparedStatement prepStmt)
    {
        boolean success = false;
        try{
            success = (prepStmt.executeUpdate()==1);
        } catch (Exception e) {
           System.out.println("Execute Statement encountered an error.");
           e.printStackTrace();
           success = false;
        }
        return success;
    }
    private ResultSet getData(PreparedStatement prepStmt)
    {
        ResultSet rs = null;
        try{
            rs = prepStmt.executeQuery();
        } catch (Exception e) {
           System.out.println("Execute Statement encountered an error.");
           e.printStackTrace();
        }
        return rs;
    }
    
    /**
     * Returns if the database exists and a connection has been made.
     * 
     * @return If the database can be used.
     */
    public boolean isViable()
    {
        return (conn!=null)&&(isTableCount(conn,1));
    }
    public void deleteAll()
    {
       deleteTables(new String[] {DB_TableHandlers.personal.tableName});
    }
}
