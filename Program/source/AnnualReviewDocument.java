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
    public void SaveToFile(String filePath){
        try {
            File file = new File(filePath);
            //Write the Document in file system
            FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
            //Blank Document
            XWPFDocument doc = new XWPFDocument();
            //create paragraph for Annual Review
            XWPFParagraph tempParagraph = doc.createParagraph();
            tempParagraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun paragraphOneRunOne = tempParagraph.createRun();
            paragraphOneRunOne.setBold(true);
            paragraphOneRunOne.setFontSize(18);
            XWPFRun tempRun = tempParagraph.createRun();
            tempRun.setText("Annual Review.");
            //Create Another paragraph for staffID
            tempParagraph=doc.createParagraph();
            paragraphOneRunOne = tempParagraph.createRun();
            tempRun = tempParagraph.createRun();
            tempRun.setText("Staff No:" +  getValue("staffID"));
            //Create Another paragraph for Name
            tempParagraph=doc.createParagraph();
            tempRun.setText("Name:"+ getValue("firstname")+"  "+ getValue("surname"));
            paragraphOneRunOne.addBreak();
            //Create Another paragraph for Manager/Director
            XWPFRun paragraphOneRunTwo = tempParagraph.createRun();
            tempParagraph.setAlignment(ParagraphAlignment.LEFT);
            paragraphOneRunTwo = tempParagraph.createRun();
            tempRun = tempParagraph.createRun();
            paragraphOneRunTwo.setFontSize(12);
            tempRun.setText("Manager/Director:"+  getValue("manager"));
            //Create Another paragraph for Second Manager
            tempParagraph=doc.createParagraph();
            tempRun.setText("Second Manager/Director:"+ getValue("second_manager"));
            //Create Another paragraph for section
            tempParagraph=doc.createParagraph();
            tempRun.setText("Section:"+ getValue("section"));
            //Create Another paragraph for Job Title
            tempParagraph=doc.createParagraph();
            tempRun.setText("Job Title:"+ getValue("job_title"));
            //Create Another paragraph for review
            tempParagraph=doc.createParagraph();
            tempRun.setText("A review of the annual past performance: achievements and outcomes");
            //create table paragraph for the review
            XWPFRun paragraphOneRunThree2 = tempParagraph.createRun();
            tempParagraph.setAlignment(ParagraphAlignment.CENTER);
            //create table
            XWPFTable table = doc.createTable();
            //create first row
            XWPFTableRow tableRowOne = table.getRow(0);
            table.setRowBandSize(1);
            table.setWidth(1);
            table.setColBandSize(1);
            table.setCellMargins(1, 1, 100, 30);
            tableRowOne.getCell(0).setText("No:");
            tableRowOne.addNewTableCell().setText("Objectives");
            tableRowOne.addNewTableCell().setText("Achievement"+ getValue("personal_goals_achieved"));

            //create table paragraph
            XWPFRun paragraphOneRunThree = tempParagraph.createRun();
            tempParagraph.setAlignment(ParagraphAlignment.CENTER);
            //create table
            XWPFTable table2 = doc.createTable();
            //create first row
            XWPFTableRow tableRowOne2 = table2.getRow(0);
            table2.setRowBandSize(1);
            table2.setWidth(1);
            table2.setColBandSize(1);
            table2.setCellMargins(1, 1, 100, 30);
            tableRowOne2.getCell(0).setText("Performance summary"+ getValue("performance_summary"));

            //paragraph for preview of future performances
            XWPFRun paragraphOneRunThree1 = tempParagraph.createRun();
            tempParagraph.setAlignment(ParagraphAlignment.LEFT);
            paragraphOneRunThree1 = tempParagraph.createRun();
            tempRun = tempParagraph.createRun();
            paragraphOneRunThree.setFontSize(12);
            tempRun.setText("A preview of future performance :  goals/planned outcomes");
            //create table paragraph
            XWPFRun paragraphOneRunFour = tempParagraph.createRun();
            tempParagraph.setAlignment(ParagraphAlignment.CENTER);
            //create table
            XWPFTable table3 = doc.createTable();
            //create first row
            XWPFTableRow tableRowOne3 = table3.getRow(0);
            table3.setRowBandSize(1);
            table3.setWidth(1);
            table3.setColBandSize(1);
            table3.setCellMargins(1, 1, 100, 30);
            tableRowOne3.getCell(0).setText("No.");
            tableRowOne3.getCell(1).setText(getValue("future_goals_set")); 
            table.setWidth(120);        // width of table

            //create table paragraph for reviewer_comments
            XWPFRun paragraphOneRunFour1 = tempParagraph.createRun();
            tempParagraph.setAlignment(ParagraphAlignment.CENTER);
            //create table
            XWPFTable table4 = doc.createTable();
            //create first row
            XWPFTableRow tableRowOne4 = table4.getRow(0);
            table4.setRowBandSize(1);
            table4.setWidth(1);  
            table4.setColBandSize(1);
            table4.setCellMargins(1, 1, 100, 30);
            tableRowOne4.getCell(0).setText("Reviewer comments"+ getValue("reviewer_comments"));

            //paragraph for preview of future Recommandation
            XWPFRun paragraphOneRunFive = tempParagraph.createRun();
            tempParagraph.setAlignment(ParagraphAlignment.LEFT);
            paragraphOneRunFour = tempParagraph.createRun();
            tempRun = tempParagraph.createRun();
            paragraphOneRunFour.setFontSize(12);
            tempRun.setText("Recommendation: stay in post / salary increase / promotion / probation / termination."+ getValue("reviewer_recommendation"));

            //create table paragraph for reviewee signature
            XWPFRun paragraphOneRunSix = tempParagraph.createRun();
            tempParagraph.setAlignment(ParagraphAlignment.CENTER);
            //create table
            XWPFTable table5 = doc.createTable();
            //create first row
            XWPFTableRow tableRowOne5 = table5.getRow(0);
            table5.setRowBandSize(1);
            table5.setWidth(1);
            table5.setColBandSize(1);
            table5.setCellMargins(1, 1, 100, 30);
            tableRowOne5.getCell(0).setText("Reviewee signature");
            tableRowOne5.addNewTableCell().setText("");
            tableRowOne5.addNewTableCell().setText("Date"+ getValue("date_of_review"));
            //create second row
            XWPFTableRow tableRowOne6 = table5.getRow(1);
            table5.setRowBandSize(1);
            table5.setWidth(1);
            table5.setColBandSize(1);
            table5.setCellMargins(1, 1, 100, 30);
            tableRowOne6.getCell(0).setText("Manager/Director signature"+ getValue("manager_signature"));
            tableRowOne6.addNewTableCell().setText("");
            tableRowOne6.addNewTableCell().setText("Date"+ getValue("date_of_review"));

            //create third row
            XWPFTableRow tableRowOne7 = table5.getRow(1);
            table5.setRowBandSize(1);
            table5.setWidth(1);
            table5.setColBandSize(1);
            table5.setCellMargins(1, 1, 100, 30);
            tableRowOne7.getCell(0).setText("Second reviewer signature"+ getValue("second_manager_signatue"));
            tableRowOne7.addNewTableCell().setText("");
            tableRowOne7.addNewTableCell().setText("Date"+ getValue("date_of_review"));

            doc.write(fos);
            fos.close();
        } catch (Exception e) {

        }
    }

    public  void main(String[] args) {

        //create docx file
        SaveToFile("C:\\DocxFile.docx");

    }
}
