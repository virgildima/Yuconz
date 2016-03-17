import java.sql.*;
import java.util.*;
public class Database extends DB_Core
{
    private DB_PersonalDetails db_PersonalDetails;
    
    
    
    /**
     * Constructor for objects of class Database
     */
    public Database()
    {
        dbName = "documentsDB";
        if(setup()){
            if(connect())
            {
                db_PersonalDetails = new DB_PersonalDetails(conn);
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
            db_PersonalDetails.createTableStr()
        });
    }
    
    /**
     * Adds a new document to the database.
     * 
     * @param doc The document to add to the database.
     * @return if the document was added to the database successfuly.
     */
    public boolean addPersonalDetailsDocument(PersonalDetailsDocument doc)
    {
        boolean success = db_PersonalDetails.addDocument(doc);
        return success;
    }
    
    /**
     * Updates an existing document in the database.
     * 
     * @param doc The document to update, containing the new data.
     * @return if the document was updated successfuly.
     */
    public boolean updatePersonalDetailsDocument(PersonalDetailsDocument doc)
    {
        Boolean success = false;
        try{
            String str = "UPDATE personal SET FIRSTNAME=?,SURNAME=?,DOB=?,ADDRESS1=?,ADDRESS2=?,TOWN=?,COUNTY=?,POSTCODE=?,PHONE=?,MOBILE=?,NOK=?,NOKPHONE? WHERE STAFFID=?";
            prepStmt = conn.prepareStatement(str);
            
            prepStmt.setString(1,doc.getValue("firstname"));
            prepStmt.setString(2,doc.getValue("surname"));
            prepStmt.setString(3,doc.getValue("DOB"));
            prepStmt.setString(4,doc.getValue("address_1"));
            prepStmt.setString(5,doc.getValue("address_2"));
            prepStmt.setString(6,doc.getValue("town"));
            prepStmt.setString(7,doc.getValue("county"));
            prepStmt.setString(8,doc.getValue("postcode"));
            prepStmt.setString(9,doc.getValue("telephone"));
            prepStmt.setString(10,doc.getValue("mobile"));
            prepStmt.setString(11,doc.getValue("next_of_kin"));
            prepStmt.setString(12,doc.getValue("next_of_kin_CN"));
            prepStmt.setString(13,doc.getValue("staffID"));
            
            success = (prepStmt.executeUpdate()==1);
        } catch (Exception e) {
           System.out.println("Add Document encountered an error.");
           e.printStackTrace();
           return false;
        }
        return success;
    }
    
    /**
     * Returns a document from the database.
     * 
     * @param staffID The staff ID on the personal Details document to get.
     * @return The document requested or null.
     */
    public PersonalDetailsDocument getPersonalDetailsDocument(String staffID)
    {
        try{
            String str = "SELECT * FROM personal WHERE STAFFID=?";
            prepStmt = conn.prepareStatement(str);
            
            prepStmt.setString(1,staffID);
            
            rs = prepStmt.executeQuery();
            
            if(rs.next()){
                PersonalDetailsDocument doc = new PersonalDetailsDocument();
                
                doc.setValue("staffID",rs.getString(1));
                doc.setValue("firstname",rs.getString(2));
                doc.setValue("surname",rs.getString(3));
                doc.setValue("DOB",rs.getString(4));
                doc.setValue("address_1",rs.getString(5));
                doc.setValue("address_2",rs.getString(6));
                doc.setValue("town",rs.getString(7));
                doc.setValue("county",rs.getString(8));
                doc.setValue("postcode",rs.getString(9));
                doc.setValue("telephone",rs.getString(10));
                doc.setValue("mobile",rs.getString(11));
                doc.setValue("next_of_kin",rs.getString(12));
                doc.setValue("next_of_kin_CN",rs.getString(13));
                
                return doc;
            }
        } catch (Exception e) {
           System.out.println("Get Document encountered an error.");
           e.printStackTrace();
           return null;
        }
        
        return null;
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
       deleteTables(new String[] {"personal"});
    }
}
