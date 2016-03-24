
/**
 * Enumeration class DB_TableData - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum DB_TableHandlers
{
    annual
    (
        "annual",
        "CREATE TABLE annual ("
            +"STAFFID           CHAR(6) NOT NULL PRIMARY KEY, "
            +"NAME              VARCHAR(100) NOT NULL, "
            
            +"MANAGER           VARCHAR(100) NOT NULL, "
            +"SECOND_MANAGER    VARCHAR(100) NOT NULL, "
            +"SECTION           VARCHAR(50) NOT NULL, "
            
            +"JOB_TITLE         VARCHAR(100) NOT NULL, "
            +"PERFORMANCE       VARCHAR(255) NOT NULL, "
            +"GOALS_ACHIEVED    VARCHAR(255) NOT NULL, "
            
            +"GOALS_SET         VARCHAR(255) NOT NULL, "
            +"REV_COMMENTS      VARCHAR(255) NOT NULL, "
            +"RECOMMENDATION    VARCHAR(255) NOT NULL, "
            
            +"REVIEWEE_SIG      VARCHAR(50) NOT NULL, "
            +"MANAGER_SIG       VARCHAR(50) NOT NULL, "
            +"SEC_MANAGER_SIG   VARCHAR(50) NOT NULL, "
            
            +"D_REVIEWEE_SIG    VARCHAR(10) NOT NULL, "
            +"D_MANAGER_SIG     VARCHAR(10) NOT NULL, "
            +"D_SEC_MANAGER_SIG VARCHAR(10) NOT NULL "
            +")",
            
        "INSERT INTO annual VALUES (?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?)",
        "SELECT STAFFID FROM annual",
        "SELECT * FROM annual WHERE STAFFID=?",
        "UPDATE annual SET NAME=?,"
        +"MANAGER=?,        SECOND_MANAGER=?,   SECTION=?,"
        +"JOB_TITLE=?,      PERFORMANCE=?,      GOALS_ACHIEVED=?,"
        +"GOALS_SET=?,      REV_COMMENTS=?,     RECOMMENDATION=?,"
        +"REVIEWEE_SIG=?,   MANAGER_SIG=?,      SEC_MANAGER_SIG=?,"
        +"D_REVIEWEE_SIG=?, D_MANAGER_SIG=?,    D_SEC_MANAGER_SIG=?"
        +"WHERE STAFFID=?",
        
        new String[] {"staffID", "name", "manager", "second_manager", "section", "job_title",
            "performance_summary", "personal_goals_achieved", "future_goals_set", "reviewer_comments",
            "reviewer_recommendation", "reviewee_signature", "manager_signature", "second_manager_signatue",
            "date_of_reviewee_signature", "date_of_manager_signature", "date_of_second_manager_signature"},
        "staffID",
        new String[] {"name", "manager", "second_manager", "section", "job_title",
            "performance_summary", "personal_goals_achieved", "future_goals_set", "reviewer_comments",
            "reviewer_recommendation", "reviewee_signature", "manager_signature", "second_manager_signatue",
            "date_of_reviewee_signature", "date_of_manager_signature", "date_of_second_manager_signature","staffID"}
            
    ),
    initial
    (
        "initial",
        "CREATE TABLE initial ("
            +"STAFFID           CHAR(6) NOT NULL PRIMARY KEY, "
            +"CV_PATH           VARCHAR(255) NOT NULL, "
            
            +"INTERVIEW_NOTES   VARCHAR(255) NOT NULL, "
            +"INTERVIEWERS      VARCHAR(255) NOT NULL, "
            +"SECTION           VARCHAR(50) NOT NULL, "
            
            +"INIT_JOB_TITLE    VARCHAR(100) NOT NULL, "
            +"INIT_SALARY       VARCHAR(50) NOT NULL, "
            +"START_DATE        CHAR(10) NOT NULL "
            +")",
            
        "INSERT INTO initial VALUES (?,?,   ?,?,?,  ?,?,?)",
        "SELECT STAFFID FROM initial",
        "SELECT * FROM initial WHERE STAFFID=?",
        "UPDATE initial SET CV_PATH=?,"
        +"INTERVIEW_NOTES=?,INTERVIEWERS=?,     SECTION=?,"
        +"INIT_JOB_TITLE=?, INIT_SALARY=?,      START_DATE=?"
        +"WHERE STAFFID=?",
        
        new String[] {"staffID","cv_filePath","interview_Notes","interviewers",
                            "section","initial_job_title","initial_salary","start_date"},
        "staffID",
        new String[] {"cv_filePath","interview_Notes","interviewers",
                            "section","initial_job_title","initial_salary","start_date","staffID"}
            
    ),
    personal
    (
        "personal",
        "CREATE TABLE personal ("
            +"STAFFID   CHAR(6) NOT NULL PRIMARY KEY, "
            +"FIRSTNAME VARCHAR(50) NOT NULL, "
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
        "SELECT STAFFID FROM personal",
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
            
    ),
    probation
    (
        "probation",
        "CREATE TABLE probation ("
            +"STAFFID       CHAR(6) NOT NULL PRIMARY KEY, "
            
            +"FIRSTNAME     VARCHAR(50) NOT NULL, "
            +"SURNAME       VARCHAR(50) NOT NULL, "
            +"PROB_REASON   VARCHAR(255) NOT NULL, "
            
            +"START_DATE    CHAR(10) NOT NULL, "
            +"END_DATE      CHAR(10) NOT NULL, "
            +"MANAGER_SIG   VARCHAR(10) NOT NULL "
            +")",
            
        "INSERT INTO probation VALUES (?,  ?,?,?,  ?,?,?)",
        "SELECT STAFFID FROM probation",
        "SELECT * FROM probation WHERE STAFFID=?",
        "UPDATE probation SET FIRSTNAME=?,SURNAME=?,PROB_REASON=?,"
        +"START_DATE=?,END_DATE=?,MANAGER_SIG=?"
        +"WHERE STAFFID=?",
        
        new String[] {"staffID","firstname","surname","probation_reason",
            "probation_start_date","probation_end_date","manager_signature"},
        "staffID",
        new String[] {"firstname","surname","probation_reason","probation_start_date",
            "probation_end_date","manager_signature","staffID"}
            
    ),
    promotion
    (
        "promotion",
        "CREATE TABLE promotion ("
            +"STAFFID       CHAR(6) NOT NULL PRIMARY KEY, "
            
            +"FIRSTNAME     VARCHAR(50) NOT NULL, "
            +"SURNAME       VARCHAR(50) NOT NULL, "
            +"C_JOB_TITLE   VARCHAR(100) NOT NULL, "
            
            +"C_SECTION     VARCHAR(50) NOT NULL, "
            +"N_JOB_TITLE   VARCHAR(100) NOT NULL, "
            +"N_SECTION     VARCHAR(50) NOT NULL, "
            
            +"START_DATE    CHAR(10) NOT NULL "
            +")",
            
        "INSERT INTO promotion VALUES (?,  ?,?,?,  ?,?,?, ?)",
        "SELECT STAFFID FROM promotion",
        "SELECT * FROM promotion WHERE STAFFID=?",
        "UPDATE promotion SET FIRSTNAME=?,SURNAME=?,C_JOB_TITLE=?,"
        +"C_SECTION=?,N_JOB_TITLE=?,N_SECTION=?,START_DATE=?"
        +"WHERE STAFFID=?",
        
        new String[] {"staffID","firstname","surname","current_job_title",
            "current_section","new_job_title","new_job_section","starting_date"},
        "staffID",
        new String[] {"firstname","surname","current_job_title","current_section",
            "new_job_title","new_job_section","starting_date","staffID"}
            
    ),
    salary
    (
        "salary",
        "CREATE TABLE salary ("
            +"STAFFID       CHAR(6) NOT NULL PRIMARY KEY, "
            
            +"FIRSTNAME     VARCHAR(50) NOT NULL, "
            +"SURNAME       VARCHAR(50) NOT NULL, "
            +"C_SALLARY     VARCHAR(50) NOT NULL, "
            
            +"N_SALLARY     VARCHAR(50) NOT NULL, "
            +"START_DATE    CHAR(10) NOT NULL "
            +")",
            
        "INSERT INTO salary VALUES (?,  ?,?,?,  ?,?)",
        "SELECT STAFFID FROM salary",
        "SELECT * FROM salary WHERE STAFFID=?",
        "UPDATE salary SET FIRSTNAME=?,SURNAME=?,C_SALLARY=?,"
        +"N_SALLARY=?,START_DATE=?"
        +"WHERE STAFFID=?",
        
        new String[] {"staffID","firstname","surname","current_salary","new_salary","start_date"},
        "staffID",
        new String[] {"firstname","surname","current_salary","new_salary","start_date","staffID"}
            
    ),
    termination
    (
        "termination",
        "CREATE TABLE termination ("
            +"STAFFID           CHAR(6) NOT NULL PRIMARY KEY, "
            
            +"FIRSTNAME     VARCHAR(50) NOT NULL, "
            +"SURNAME       VARCHAR(50) NOT NULL, "
            +"T_REASON  VARCHAR(255) NOT NULL, "
            
            +"T_DATE    CHAR(10) NOT NULL, "
            +"MANAGER           VARCHAR(100) NOT NULL, "
            +"SECOND_MANAGER    VARCHAR(100) NOT NULL, "
            
            +"MANAGER_COMMENT   VARCHAR(100) NOT NULL, "
            +"SECOND_MANAGER_COMMENT    VARCHAR(100) NOT NULL, "
            +"MANAGER_SIG       VARCHAR(50) NOT NULL, "
            
            +"SEC_MANAGER_SIG   VARCHAR(50) NOT NULL "
            +")",
            
        "INSERT INTO termination VALUES (?,  ?,?,?,  ?,?,?,  ?,?,?,  ?)",
        "SELECT STAFFID FROM termination",
        "SELECT * FROM termination WHERE STAFFID=?",
        "UPDATE termination SET FIRSTNAME=?,SURNAME=?,"
        +"T_REASON=?,       T_DATE=?,           MANAGER=?,"
        +"SECOND_MANAGER=?, MANAGER_COMMENT=?,  SECOND_MANAGER_COMMENT=?,"
        +"MANAGER_SIG=?,    SEC_MANAGER_SIG=?"
        +"WHERE STAFFID=?",
        
        new String[] {"staffID","firstname","surname","termination_reason","termination_date",
                "manager_name","second_manager_name","manager_comment","second_manager_comment",
                "manager_signature","second_manager_signature"},
        "staffID",
        new String[] {"firstname","surname","termination_reason","termination_date",
                "manager_name","second_manager_name","manager_comment","second_manager_comment",
                "manager_signature","second_manager_signature","staffID"}
            
    );
    
    public final String tableName;
    public final String createTableStr;
    
    public final String addDocStr;
    public final String getAllStr;
    public final String getDocStr;
    public final String updateDocStr;
    
    public final String[] columnOrder;
    public final String key;
    public final String[] updateDocAttributes;
    
    private DB_TableHandlers(String tableName,String createTableStr,
            String addDocStr,String getAllStr,String getDocStr,String updateDocStr,
            String[] columnOrder,String key,String[] updateDocAttributes)
    {
        this.tableName = tableName;
        this.createTableStr = createTableStr;
        
        this.addDocStr = addDocStr;
        this.getAllStr = getAllStr;
        this.getDocStr = getDocStr;
        this.updateDocStr = updateDocStr;
        
        this.columnOrder = columnOrder;
        this.key = key;
        this.updateDocAttributes = updateDocAttributes;
    }
    
    public static DB_TableHandlers[] listTD()
    {
        return new DB_TableHandlers[] {
            DB_TableHandlers.annual,
            DB_TableHandlers.initial,
            DB_TableHandlers.personal,
            DB_TableHandlers.probation,
            DB_TableHandlers.promotion,
            DB_TableHandlers.salary,
            DB_TableHandlers.termination
        };
    }
    
    public static DB_TableHandlers forDocType(Document doc)
    {
        return forDocType(doc.type());
    }
    public static DB_TableHandlers forDocType(DocType type)
    {
        if(type == DocType.AnnualReview)
        {
            return DB_TableHandlers.annual;
        }else if(type == DocType.InitialEmployment)
        {
            return DB_TableHandlers.initial;
        }else if(type == DocType.PersonalDetails)
        {
            return DB_TableHandlers.personal;
        }else if(type == DocType.Probation)
        {
            return DB_TableHandlers.probation;
        }else if(type == DocType.Promotion)
        {
            return DB_TableHandlers.promotion;
        }else if(type == DocType.SalaryIncrease)
        {
            return DB_TableHandlers.salary;
        }else if(type == DocType.Termination)
        {
            return DB_TableHandlers.termination;
        }
        return null;
    }
}
