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
                if(!isViable())
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
        String[] tableStrs = new String[DB_TableHandlers.listTD().length];
        for(int i=0;i<tableStrs.length;i++)
        {
            tableStrs[i] = DB_TableHandlers.listTD()[i].createTableStr;
        }
        super.createDB(tableStrs);
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
     * @param staffID The staff ID on the document to get.
     * @param type The type of document to get.
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
    /**
     * Returns a document from the database.
     * 
     * @param staffID The staff ID on the document to get.
     * @param type The type of document to get.
     * @return The document requested or null.
     */
    public DocumentC getDocument(String staffID,DocType type)
    {
        DB_TableHandlers handler = DB_TableHandlers.forDocType(type);
        prepStmt = prepStmt(handler.getDocStr,new String[] {staffID} );
        rs = getData(prepStmt);
        try
        {
            rs.next();
            DocumentC doc = new DocumentC(type);
            
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
    
    /**
     * Returns an array of staffIDs from the database.
     * 
     * @param type The type of document to list.
     * @return An array of staffIDs for the requested document type.
     */
    public <T extends Document> String[] search(String attribute,String value,Class<T> type)
    {
        DB_TableHandlers handler = DB_TableHandlers.forDocType(type);
        prepStmt = prepStmt(handler.getAllStr,new String[] {} );
        rs = getData(prepStmt);
        ArrayList<String> al = new ArrayList<String>();
        String[] results = new String[0];
        try
        {
            while(rs.next())
            {
                al.add(rs.getString(1));
            }
            results = new String[al.size()];
            for(int i=0;i<al.size();i++)
            {
                results[i] = al.get(i);
            }
        }catch(SQLException e)
        {
           System.out.println("Prepare Statement encountered an error.");
           e.printStackTrace();
           return null;
        }
        return results;
    }
    /**
     * Returns an array of staffIDs from the database.
     * 
     * @param type The type of document to list.
     * @return An array of staffIDs for the requested document type.
     */
    public String[] search(String attribute,String value,DocType type)
    {
        DB_TableHandlers handler = DB_TableHandlers.forDocType(type);
        prepStmt = prepStmt(handler.getAllStr,new String[] {} );
        rs = getData(prepStmt);
        ArrayList<String> al = new ArrayList<String>();
        String[] results = new String[0];
        try
        {
            while(rs.next())
            {
                al.add(rs.getString(1));
            }
            results = new String[al.size()];
            for(int i=0;i<al.size();i++)
            {
                results[i] = al.get(i);
            }
        }catch(SQLException e)
        {
           System.out.println("Prepare Statement encountered an error.");
           e.printStackTrace();
           return null;
        }
        return results;
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
        return (conn!=null)&&(isTableCount(conn,DB_TableHandlers.listTD().length));
    }
    public void deleteAll()
    {
        String[] tableNames = new String[DB_TableHandlers.listTD().length];
        for(int i=0;i<tableNames.length;i++)
        {
            tableNames[i] = DB_TableHandlers.listTD()[i].tableName;
        }
        deleteTables(tableNames);
    }
}
