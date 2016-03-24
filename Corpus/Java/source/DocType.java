import java.util.HashMap;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFRun;
/**
 * Enumeration class DocumentE - Used for all documents.
 * Refactor of classes from Chris and Virgil
 * 
 * @author Andrew Johnson
 * @version 0.1
 */
public enum DocType
{
    AnnualReview
    (
        new String[] {"staffID", "name", "manager", "second_manager", "section", "job_title",
            "performance_summary", "personal_goals_achieved", "future_goals_set", "reviewer_comments",
            "reviewer_recommendation", "reviewee_signature", "manager_signature", "second_manager_signatue",
            "date_of_reviewee_signature", "date_of_manager_signature", "date_of_second_manager_signature"}
    ),
    InitialEmployment
    (
        new String[]{"staffID","cv_filePath","interview_Notes","interviewers",
            "section","initial_job_title","initial_salary","start_date"}
    ),
    PersonalDetails
    (
        new String[]{"staffID","firstname","surname","DOB","address_1","address_2",
            "town","county","postcode","telephone","mobile","next_of_kin","next_of_kin_CN"}
    ),
    Probation
    (
        new String[]{"staffID","firstname","surname","probation_reason","probation_start_date",
            "probation_end_date","manager_signature"}
    ),
    Promotion
    (
        new String[]{"staffID","firstname","surname","current_job_title","current_section",
            "new_job_title","new_job_section","starting_date"}
    ),
    SalaryIncrease
    (
        new String[]{"staffID","firstname","surname","current_salary","new_salary","start_date"}
    ),
    Termination
    (
        new String[]{"staffID","firstname","surname","termination_reason","termination_date",
            "manager_name","second_manager_name","manager_comment","second_manager_comment",
            "manager_signature","second_manager_signature"}
    );
    
    private String[] attributeList;
    
    private DocType(String[] attributeList)
    {
        this.attributeList = attributeList;
    }
    
    
    public int getIndex(String attributeName)
    {
        for(int i = 0; i < attributeList.length; i++){

            if(attributeName == attributeList[i]){
                return i;
            }
        }
        return -1;
    }

    private static void createDoc(String filePath, XWPFDocument doc)throws IOException{
        FileOutputStream fos = new FileOutputStream(new File(filePath).getAbsolutePath());
        doc.write(fos);
        fos.close();
    }
    
    /**
     * Method that creates a Microsoft .docx from the document data at 
     */
    public boolean saveToFile(String filePath,Document docC)
    {
        if(this == DocType.AnnualReview)
        {
            try {
                XWPFRun tempRun = null;
                XWPFDocument doc = new XWPFDocument();
                
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Annual Review.",true);
                
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Staff No: "+  docC.getValue("staffID"),true);
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Name: "+ docC.getValue("name"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Manager/Director: "+ docC.getValue("manager"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Second Manager/Director: "+ docC.getValue("second_manager"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Section: " + docC.getValue("section"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Job Title: "+ docC.getValue("job_title"),true);
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"A review of the annual past performance: achievements and outcomes",false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,docC.getValue("personal_goals_achieved"),true);
                doc.createParagraph().createRun().addBreak();
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Performance summary:",false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,docC.getValue("performance_summary"),true);
                doc.createParagraph().createRun().addBreak();
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"A preview of future performance:  goals/planned outcomes",false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,docC.getValue("future_goals_set"),true);
                doc.createParagraph().createRun().addBreak();
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Reviewer comments: ",false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,docC.getValue("reviewer_comments"),true);
                doc.createParagraph().createRun().addBreak();
                
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Recommendation:  "+ docC.getValue("reviewer_recommendation"),true);
                
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Reviewee signature",false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,docC.getValue("reviewee_signature"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,docC.getValue("date_of_reviewee_signature"),true);
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Reviewer signature",false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,docC.getValue("manager_signature"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,docC.getValue("date_of_manager_signature"),true);
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Second reviewer signature",false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,docC.getValue("second_manager_signatue"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,docC.getValue("date_of_second_manager_signature"),true);
                
                createDoc(filePath,doc);
            } catch (Exception e) {
                return false;
            }
            return true;
        } else if(this == DocType.InitialEmployment)
        {
            try {
                XWPFRun tempRun = null;
                XWPFDocument doc = new XWPFDocument();
                
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Initial Employment.",true);
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Staff No: "+  docC.getValue("staffID"),true);
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"The CV is located at: "+ new File(docC.getValue("cv_filePath")).getAbsolutePath(),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Interview Notes: "+ docC.getValue("interview_Notes"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Interviewers: "+ docC.getValue("interviewers"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Section: "+ docC.getValue("section"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Initial Job Title: "+ docC.getValue("initial_job_title"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Initial Salary: "+ docC.getValue("initial_salary"),false);
                 writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Starting Date: "+ docC.getValue("start_date"),false);
                
                createDoc(filePath,doc);
            } catch (Exception e) {
                return false;
            }
            return true;
        } else if(this == DocType.PersonalDetails)
        {
            try {
                XWPFRun tempRun = null;
                XWPFDocument doc = new XWPFDocument();
                
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Personal details.",true);
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Staff No: "+  docC.getValue("staffID"),true);
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Surname: "+  docC.getValue("surname"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"First Name: "+ docC.getValue("firstname"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Date Of Birth: "+ docC.getValue("DOB"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Address: "+ docC.getValue("address_1"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"         "+ docC.getValue("address_2"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Town/City: "+ docC.getValue("town"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"County: "+ docC.getValue("county"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Postcode: "+ docC.getValue("postcode"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Telephone Number: "+ docC.getValue("telephone"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Mobile number: "+ docC.getValue("mobile"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Next of Kin: "+ docC.getValue("next_of_kin"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Next of Kin contact number: "+ docC.getValue("next_of_kin_CN"),false);
                
                createDoc(filePath,doc);
            } catch (Exception e) {
                return false;
            }
            return true;
        } else if(this == DocType.Probation)
        {
            try {
                XWPFRun tempRun = null;
                XWPFDocument doc = new XWPFDocument();
                
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Probation Document.",true);
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Staff No: "+  docC.getValue("staffID"),true);
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Surname: "+  docC.getValue("surname"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"First Name: "+ docC.getValue("firstname"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Probation reason: "+ docC.getValue("probation_reason"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Probation Start Date: "+ docC.getValue("probation_start_date"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Probation End Date: "+ docC.getValue("probation_end_date"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Manager Signature: "+ docC.getValue("manager_signature"),false);
                
                createDoc(filePath,doc);
            } catch (Exception e) {
                return false;
            }
            return true;
        } else if(this == DocType.Promotion)
        {
            try {
                XWPFRun tempRun = null;
                XWPFDocument doc = new XWPFDocument();
                
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Promotion Document.",true);
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Staff No: "+  docC.getValue("staffID"),true);
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Surname: "+  docC.getValue("surname"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"First Name: "+ docC.getValue("firstname"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Current Job Title: "+ docC.getValue("current_job_title"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Current Section: "+ docC.getValue("current_section"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"New Job Title: "+ docC.getValue("new_job_title"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"New Job Section: "+ docC.getValue("new_job_section"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Starting Date: "+ docC.getValue("starting_date"),false);
                
                createDoc(filePath,doc);
            } catch (Exception e) {
                return false;
            }
            return true;
        } else if(this == DocType.SalaryIncrease)
        {
            try {
                XWPFRun tempRun = null;
                XWPFDocument doc = new XWPFDocument();
                
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Salary Increase.",true);
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Staff No: "+  docC.getValue("staffID"),true);
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Surname: "+  docC.getValue("surname"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"First Name: "+ docC.getValue("firstname"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Current Salary: "+ docC.getValue("current_salary"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"New Salary: "+ docC.getValue("new_salary"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Start Date: "+ docC.getValue("start_date"),false);
                
                createDoc(filePath,doc);
            } catch (Exception e) {
                return false;
            }
            return true;
        } else if(this == DocType.Termination)
        {
            try {
                XWPFRun tempRun = null;
                XWPFDocument doc = new XWPFDocument();
                
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Termination Document.",true);
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Staff No: "+  docC.getValue("staffID"),true);
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Surname: "+  docC.getValue("surname"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"First Name: "+ docC.getValue("firstname"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Termination reason: "+ docC.getValue("termination_reason"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Termination Date: "+ docC.getValue("termination_date"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Manager: "+ docC.getValue("manager_name"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Comment: "+ docC.getValue("manager_comment"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Manager Signature: "+ docC.getValue("manager_signature"),true);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Second Manager: "+ docC.getValue("second_manager_name"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Second Comment: "+ docC.getValue("second_manager_comment"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Second Manager Signature: "+ docC.getValue("second_manager_signature"),true);
                
                createDoc(filePath,doc);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }
    
    
    private void writeParagraph(XWPFDocument doc,ParagraphAlignment alignment,boolean bold,int fontSize,String text,boolean breakAtEnd)
    {
        XWPFParagraph paragraph = doc.createParagraph();
        paragraph.setAlignment(alignment);
        XWPFRun run = paragraph.createRun();
        run.setBold(bold);
        run.setFontSize(fontSize);
        run.setText(text);
        if(breakAtEnd)
            run.addBreak();
    }
}
