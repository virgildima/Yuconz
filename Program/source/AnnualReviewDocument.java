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
 * AnnualReview implementaion document
 * 
 * @author Chris Wing 
 * @version 0.1
 */
public class AnnualReviewDocument extends Document
{

    private String[] attributeList = {"staffID", "name", "manager", "second_manager", "section", "job_title",
            "performance_summary", "personal_goals_achieved", "future_goals_set", "reviewer_comments",
            "reviewer_recommendation", "reviewee_signature", "manager_signature", "second_manager_signatue",
            "date_of_reviewee_signature", "date_of_manager_signature", "date_of_second_manager_signature"};

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
            //create paragraph for Annual Review
            XWPFParagraph tempParagraph0 = doc.createParagraph();
            tempParagraph0.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun tempRun0 = tempParagraph0.createRun();
            tempRun0.setBold(true);
            tempRun0.setFontSize(18);
            tempRun0.setText("Annual Review.");
            tempRun0.addBreak();
            //Create Another paragraph for staffID
            XWPFParagraph tempParagraph1 = doc.createParagraph();
            tempParagraph1.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun tempRun1 = tempParagraph1.createRun();
            tempRun1.setBold(true);
            tempRun1.setFontSize(18);
            tempRun1.setText("Staff No: "+  getValue("staffID") );
            //Create Another paragraph for Name
            XWPFParagraph tempParagraph3=doc.createParagraph();
            tempParagraph3.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun tempRun3 = tempParagraph3.createRun();
            tempRun3.setBold(true);
            tempRun3.setFontSize(18);
            tempRun3.setText("Name: "+ getValue("name"));
            //Create Another paragraph for Manager
            XWPFParagraph tempParagraph4=doc.createParagraph();
            XWPFRun tempRun4 = tempParagraph4.createRun();
            tempRun4.setFontSize(12);
            tempRun4.setText("Manager/Director: "+ getValue("manager"));
            //Create Another paragraph for second manager
            XWPFParagraph tempParagraph5=doc.createParagraph();
            XWPFRun tempRun5 = tempParagraph5.createRun();
            tempRun5.setFontSize(12);
            tempRun5.setText("Second Manager/Director: "+ getValue("second_manager"));
            //Create Another paragraph for section
            XWPFParagraph tempParagraph6=doc.createParagraph();
            XWPFRun tempRun6 = tempParagraph6.createRun();
            tempRun6.setFontSize(12);
            tempRun6.setText( "Section: " + getValue("section"));
            //Create Another paragraph for job title
            XWPFParagraph tempParagraph7=doc.createParagraph();
            XWPFRun tempRun7 = tempParagraph7.createRun();
            tempRun7.setFontSize(12);
            tempRun7.setText("Job Title: "+ getValue("job_title"));
            tempRun7.addBreak();
            //Create Another paragraph for review
            XWPFParagraph tempParagraph8=doc.createParagraph();
            tempParagraph8.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun tempRun8 = tempParagraph8.createRun();
            tempRun8.setText("A review of the annual past performance: achievements and outcomes");
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
            tableRowOne.addNewTableCell().setText("Achievement: "+ getValue("personal_goals_achieved"));
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
            tableRowOne2.getCell(0).setText("Performance summary: "+ getValue("performance_summary"));
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
            tableRowOne10.addNewTableCell().setText(getValue("future_goals_set"));
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
            tableRowOne4.getCell(0).setText("Reviewer comments: " + getValue("reviewer_comments"));
            // Add a break between the tables
            doc.createParagraph().createRun().addBreak();
            //paragraph for preview of future Recommandation
            XWPFParagraph tempParagraph11=doc.createParagraph();
            tempParagraph11.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun tempRun11 = tempParagraph11.createRun();
            tempRun11.setText("Recommendation: stay in post / salary increase / promotion / probation / termination.");

            //create table
            XWPFTable table5 = doc.createTable();
            //create first row
            XWPFTableRow tableRowOne5 = table5.getRow(0);
            table5.setRowBandSize(1);
            table5.setWidth(1);
            table5.setColBandSize(1);
            table5.setCellMargins(100, 100, 800, 1200);
            tableRowOne5.getCell(0).setText("Reviewee signature  ");
            tableRowOne5.addNewTableCell().setText("                 ");
            tableRowOne5.addNewTableCell().setText("Date  "+ getValue("date_of_review"));
            //create second row
            XWPFTableRow tableRowOne6 = table5.createRow();
            table5.setRowBandSize(1);
            table5.setWidth(1);
            table5.setColBandSize(1);
            table5.setCellMargins(100, 100, 800, 1200);
            tableRowOne6.getCell(0).setText("Manager/Director signature     "+ getValue("manager_signature"));
            tableRowOne6.getCell(1).setText("                 ");
            tableRowOne6.getCell(2).setText("Date  "+ getValue("date_of_review"));

            //create third row
            XWPFTableRow tableRowOne7 = table5.createRow();
            table5.setRowBandSize(1);
            table5.setWidth(1);
            table5.setColBandSize(1);
            table5.setCellMargins(100, 100, 800, 1200);
            tableRowOne7.getCell(0).setText("Second reviewer signature     "+ getValue("second_manager_signatue"));
            tableRowOne7.getCell(1).setText("                 ");
            tableRowOne7.getCell(2).setText("Date  "+ getValue("date_of_review"));

            createDoc(filePath,doc);

        } catch (Exception e) {

        }
    }

}
