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
            "section","role","initial_job_title","initial_salary","start_date"}
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
    public boolean saveToFile(String filePath,DocumentC docC)
    {
        if(this == DocType.AnnualReview)
        {
            try {
                XWPFRun tempRun = null;
                XWPFDocument doc = new XWPFDocument();
                
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Annual Review.",true);
                
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Staff No: "+  docC.getValue("staffID"),false);
                writeParagraph(doc,ParagraphAlignment.CENTER, true,   18,"Name: "+ docC.getValue("name"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Manager/Director: "+ docC.getValue("manager"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Second Manager/Director: "+ docC.getValue("second_manager"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Section: " + docC.getValue("section"),false);
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Job Title: "+ docC.getValue("job_title"),false);
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"A review of the annual past performance: achievements and outcomes",false);
                //create table
                XWPFTable table = doc.createTable();
                //create first row
                XWPFTableRow tableRowOne = table.getRow(0);
                table.setRowBandSize(1);
                table.setWidth(1);
                table.setColBandSize(1); 
                table.setCellMargins(200, 200, 2500, 1700);
                tableRowOne.getCell(0).setText("No:");
                tableRowOne.addNewTableCell().setText("Objectives");
                tableRowOne.addNewTableCell().setText("Achievement: "+ docC.getValue("personal_goals_achieved"));
                // Add a break between the tables
                doc.createParagraph().createRun().addBreak();
                //Create another table for performance sumary
                XWPFTable table2 = doc.createTable();
                //create first row
                XWPFTableRow tableRowOne2 = table2.getRow(0);
                table2.setRowBandSize(1);
                table2.setWidth(1);
                table2.setColBandSize(1); 
                table2.setCellMargins(200, 200, 3500, 1700);
                tableRowOne2.getCell(0).setText("Performance summary: "+ docC.getValue("performance_summary"));
                // Add a break between the tables
                doc.createParagraph().createRun().addBreak();
                //paragraph for preview of future performances
                XWPFParagraph tempParagraph10=doc.createParagraph();
                tempParagraph10.setPageBreak(true);
                tempParagraph10.setAlignment(ParagraphAlignment.LEFT);
                XWPFRun tempRun10 = tempParagraph10.createRun();
                tempRun10.setText("A preview of future performance:  goals/planned outcomes");
                //create table
                XWPFTable table10 = doc.createTable();
                //create first row
                XWPFTableRow tableRowOne10 = table10.getRow(0);
                table10.setRowBandSize(1);
                table10.setWidth(1);
                table10.setColBandSize(1); 
                table10.setCellMargins(200, 200, 2500, 1700);
                tableRowOne10.getCell(0).setText("No.");
                tableRowOne10.addNewTableCell().setText(docC.getValue("future_goals_set"));
                // Add a break between the tables
                doc.createParagraph().createRun().addBreak();
                //Create another table for reviewer comments
                XWPFTable table4 = doc.createTable();
                //create first row
                XWPFTableRow tableRowOne4 = table4.getRow(0);
                table4.setRowBandSize(1);
                table4.setWidth(1);
                table4.setColBandSize(1); 
                table4.setCellMargins(200, 200, 3500, 1700);
                tableRowOne4.getCell(0).setText("Reviewer comments: " + docC.getValue("reviewer_comments"));
                // Add a break between the tables
                doc.createParagraph().createRun().addBreak();
                //paragraph for preview of future Recommandation
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  12,"Recommendation:  "+ docC.getValue("reviewer_recommendation"),false);
    
                //create table
                XWPFTable table5 = doc.createTable();
                //create first row
                XWPFTableRow tableRowOne5 = table5.getRow(0);
                table5.setRowBandSize(1);
                table5.setWidth(1);
                table5.setColBandSize(1);
                table5.setCellMargins(100, 100, 800, 1200);
                tableRowOne5.getCell(0).setText("Reviewee signature  "+ docC.getValue("reviewee_signature"));
                tableRowOne5.addNewTableCell().setText("                 ");
                tableRowOne5.addNewTableCell().setText("Date  "+ docC.getValue("date_of_review"));
                //create second row
                XWPFTableRow tableRowOne6 = table5.createRow();
                table5.setRowBandSize(1);
                table5.setWidth(1);
                table5.setColBandSize(1);
                table5.setCellMargins(100, 100, 800, 1200);
                tableRowOne6.getCell(0).setText("Manager/Director signature     "+ docC.getValue("manager_signature"));
                tableRowOne6.getCell(1).setText("                 ");
                tableRowOne6.getCell(2).setText("Date  "+ docC.getValue("date_of_review"));
    
                //create third row
                XWPFTableRow tableRowOne7 = table5.createRow();
                table5.setRowBandSize(1);
                table5.setWidth(1);
                table5.setColBandSize(1);
                table5.setCellMargins(100, 100, 800, 1200);
                tableRowOne7.getCell(0).setText("Second reviewer signature     "+ docC.getValue("second_manager_signatue"));
                tableRowOne7.getCell(1).setText("                 ");
                tableRowOne7.getCell(2).setText("Date  "+ docC.getValue("date_of_review"));
    
                createDoc(filePath,doc);
            } catch (Exception e) {
                return false;
            }
            return true;
        } else if(this == DocType.InitialEmployment)
        {
            return false;
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
                
                writeParagraph(doc,ParagraphAlignment.LEFT,   false,  14,"Surname: "+  docC.getValue("surname"),true);
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
            return false;
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
            return false;
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
