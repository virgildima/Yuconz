
import java.sql.*;
/**
 * Write a description of class DB_PersonalDetails here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DB_PersonalDetails extends DB_TableHandler
{
    private String tableName = "personal";
    private String createTableStr = 
        "CREATE TABLE "+tableName+" ("
            +"STAFFID   CHAR(6) NOT NULL PRIMARY KEY, "
            +"FIRSTNAME   VARCHAR(50) NOT NULL, "
            +"SURNAME   VARCHAR(50) NOT NULL, "
            +"DOB       CHAR(10) NOT NULL, "
            +"ADDRESS1  VARCHAR(50) NOT NULL, "
            +"ADDRESS2  VARCHAR(50) NOT NULL, "
            +"TOWN      VARCHAR(50) NOT NULL, "
            +"COUNTY    VARCHAR(50) NOT NULL, "
            +"POSTCODE  VARCHAR(50) NOT NULL, "
            +"PHONE     VARCHAR(50) NOT NULL, "
            +"MOBILE    VARCHAR(50) NOT NULL, "
            +"NOK       VARCHAR(50) NOT NULL, "
            +"NOKPHONE  VARCHAR(50) NOT NULL "
            +")";
    
    public DB_PersonalDetails(Connection conn)
    {
        this.conn = conn;
    }
    
    /**
     * Creates a prepared statement for adding the document to the table
     * 
     * @param doc The document to add to the table.
     * @return the preparedStatement for the document.
     */
    public PreparedStatement addDocument(PersonalDetailsDocument doc)
    {
        PreparedStatement prepStmt = prepStmt(
            "INSERT INTO personal VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)",
            new String[] {doc.getValue("staffID"),doc.getValue("firstname"),
            doc.getValue("surname"),doc.getValue("DOB"),
            doc.getValue("address_1"),doc.getValue("address_2"),
            doc.getValue("town"),doc.getValue("county"),
            doc.getValue("postcode"),doc.getValue("telephone"),
            doc.getValue("mobile"),doc.getValue("next_of_kin"),
            doc.getValue("next_of_kin_CN")}
            );
        
        return prepStmt;
    }
}
