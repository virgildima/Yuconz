
/**
 * Enumeration class DB_TableData - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum DB_TableHandlers
{
    personal
    (
        "personal",
        "CREATE TABLE personal ("
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
            +")",
            
        "INSERT INTO personal VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)",
        "SELECT * FROM personal WHERE STAFFID=?",
        "UPDATE personal SET FIRSTNAME=?,SURNAME=?,DOB=?,ADDRESS1=?,"
        +"ADDRESS2=?,TOWN=?,COUNTY=?,POSTCODE=?,PHONE=?,MOBILE=?,"
        +"NOK=?,NOKPHONE=? WHERE STAFFID=?",
        
        new String[] {"staffID","firstname","surname","DOB","address_1",
            "address_2","town","county","postcode","telephone","mobile",
            "next_of_kin","next_of_kin_CN"},
        "staffID",
        new String[] {"firstname","surname","DOB","address_1",
            "address_2","town","county","postcode","telephone","mobile",
            "next_of_kin","next_of_kin_CN","staffID"}
            
    );
    
    public final String tableName;
    public final String createTableStr;
    
    public final String addDocStr;
    public final String getDocStr;
    public final String updateDocStr;
    
    public final String[] columnOrder;
    public final String key;
    public final String[] updateDocAttributes;
    
    private DB_TableHandlers(String tableName,String createTableStr,
            String addDocStr,String getDocStr,String updateDocStr,
            String[] columnOrder,String key,String[] updateDocAttributes)
    {
        this.tableName = tableName;
        this.createTableStr = createTableStr;
        
        this.addDocStr = addDocStr;
        this.getDocStr = getDocStr;
        this.updateDocStr = updateDocStr;
        
        this.columnOrder = columnOrder;
        this.key = key;
        this.updateDocAttributes = updateDocAttributes;
    }
    
    public static DB_TableHandlers[] listTD()
    {
        return new DB_TableHandlers[] {
            DB_TableHandlers.personal
        };
    }
    
    public static DB_TableHandlers forDocType(Document doc)
    {
        return forDocType(doc.getClass());
    }
    public static DB_TableHandlers forDocType(Class type)
    {
        if(type == PersonalDetailsDocument.class)
        {
            return DB_TableHandlers.personal;
        }
        return null;
    }
}
