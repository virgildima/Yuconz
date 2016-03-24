import java.util.HashMap;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
/**
 * InitialEmploymentDocument implementation document.
 * 
 * @author Chris Wing
 * @version 0.1
 */
public class InitialEmploymentDocument extends Document
{
    private String[] attributeList = {"staffID","cv_filePath","interview_Notes","interviewers",
                            "section","role","initial_job_title","initial_salary","start_date"};
    
     /**
     * public method setValue()
     * 
     * Method sets a new value to a documents attribute.
     * 
     * @param attributeName: The name of the attribute you wish to change thea value of.
     * @param newValue: The new value you wish to set attributeName as.
     * 
     * No meaningful return type. Either True or Void.
     */
    @SuppressWarnings("unchecked")
    public void setValue(String attributeName, String newValue){
        
        setValue(attributeList, attributeName, newValue);
    }
    
     /**
     * public method setValue()
     * 
     * Method gets the value to a documents attribute.
     * 
     * @param attributeName: The name of the attribute you wish to change thea value of.
     * 
     * Returns a String as a return type.
     */
    public String getValue(String attributeName){
    
        return getValue(attributeList, attributeName);
    }
    
    /**
     * public method getData()
     * 
     * Returns all data in form of HashMap. 
     */
    public HashMap getData(){
    
        return super.getData();
    }
    
    /**
     * public method equals()
     * 
     * Checks equality between two Document (any type) objects.
     */
    @Override public boolean equals(Object doc)
    {
        return super.equals((Document)doc);
    }

    /**
     * Method that takes the class HashMap content and creates a .docx file from it
     */
    public void saveToFile(String filePath){
        try {
            //Blank Document
            XWPFDocument doc = new XWPFDocument();
            //create paragraph for Initial Employement Document
            XWPFParagraph tempParagraph0 = doc.createParagraph();
            tempParagraph0.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun tempRun0 = tempParagraph0.createRun();
            tempRun0.setBold(true);
            tempRun0.setFontSize(18);
            tempRun0.setText("Initial Employement Document.");
            //Create Another paragraph for staffID
            XWPFParagraph tempParagraph1 = doc.createParagraph();
            tempParagraph1.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun tempRun1 = tempParagraph1.createRun();
            tempRun1.setBold(true);
            tempRun1.setFontSize(18);
            tempRun1.setText("Staff No: "+  getValue("staffID") );
            tempRun1.addBreak();
            //Create Another paragraph for cv path
            XWPFParagraph tempParagraph2 = doc.createParagraph();
            XWPFRun tempRun2 = tempParagraph2.createRun();
            tempParagraph2.setAlignment(ParagraphAlignment.LEFT);
            tempRun2.setFontSize(14);
            tempRun2.setText("CV is located at: "+  getValue("cv_filePath"));
            tempRun2.addBreak();
            //Create Another paragraph for interview notes
            XWPFParagraph tempParagraph3=doc.createParagraph();
            XWPFRun tempRun3 = tempParagraph2.createRun();
            tempRun3.setFontSize(14);
            tempRun3.setText("Interview notes: "+ getValue("interview_Notes"));
            tempRun3.addBreak();
            //Create Another paragraph for interviewrs
            XWPFParagraph tempParagraph4=doc.createParagraph();
            XWPFRun tempRun4 = tempParagraph2.createRun();
            tempRun4.setFontSize(14);
            tempRun4.setText("Interviewers: "+ getValue("interviewers"));
            tempRun4.addBreak();
            //Create Another paragraph for adress 1
            XWPFParagraph tempParagraph5=doc.createParagraph();
            XWPFRun tempRun5 = tempParagraph2.createRun();
            tempRun5.setFontSize(14);
            tempRun5.setText("Section: "+ getValue("section"));
            tempRun5.addBreak();
            //Create Another paragraph for address 2
            XWPFParagraph tempParagraph6=doc.createParagraph();
            XWPFRun tempRun6 = tempParagraph2.createRun();
            tempRun6.setFontSize(14);
            tempRun6.setText("Role: "+ getValue("role"));
            tempRun6.addBreak();
            //Create Another paragraph for initial job title
            XWPFParagraph tempParagraph7=doc.createParagraph();
            XWPFRun tempRun7 = tempParagraph2.createRun();
            tempRun7.setFontSize(14);
            tempRun7.setText("Initial job title: "+ getValue("initial_job_title"));
            tempRun7.addBreak();
            //Create Another paragraph for initial salary
            XWPFParagraph tempParagraph8=doc.createParagraph();
            XWPFRun tempRun8 = tempParagraph2.createRun();
            tempRun8.setFontSize(14);
            tempRun8.setText("Initial Salary: "+ getValue("initial_salary"));
            tempRun8.addBreak();
            //Create Another paragraph for start date
            XWPFParagraph tempParagraph9=doc.createParagraph();
            XWPFRun tempRun9 = tempParagraph2.createRun();
            tempRun9.setFontSize(14);
            tempRun9.setText("Starting date: "+ getValue("starting_date"));
            tempRun9.addBreak();
            
            createDoc(filePath,doc);

        } catch (Exception e) {

        }
    }
}
