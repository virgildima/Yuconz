import java.util.HashMap;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
/**
 * Write a description of class PersonalDetailsDocument here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PersonalDetailsDocument extends Document
{

    private String[] attributeList = {"firstname","surname","DOB","address_1","address_2",
            "town","county","postcode","telephone","mobile","next_of_kin","next_of_kin_CN","staffID"};

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
            //create paragraph for Personal Details
            XWPFParagraph tempParagraph0 = doc.createParagraph();
            tempParagraph0.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun tempRun0 = tempParagraph0.createRun();
            tempRun0.setBold(true);
            tempRun0.setFontSize(18);
            tempRun0.setText("Personal details.");
            //Create Another paragraph for staffID
            XWPFParagraph tempParagraph1 = doc.createParagraph();
            tempParagraph1.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun tempRun1 = tempParagraph1.createRun();
            tempRun1.setBold(true);
            tempRun1.setFontSize(18);
            tempRun1.setText("Staff No: "+  getValue("staffID") );
            tempRun1.addBreak();
            //Create Another paragraph for Surname
            XWPFParagraph tempParagraph2 = doc.createParagraph();
            XWPFRun tempRun2 = tempParagraph2.createRun();
            tempParagraph2.setAlignment(ParagraphAlignment.LEFT);
            tempRun2.setFontSize(14);
            tempRun2.setText("Surname: "+  getValue("surname"));
            tempRun2.addBreak();
            //Create Another paragraph for Name
            XWPFParagraph tempParagraph3=doc.createParagraph();
            XWPFRun tempRun3 = tempParagraph2.createRun();
            tempRun3.setFontSize(14);
            tempRun3.setText("Name: "+ getValue("firstname"));
            tempRun3.addBreak();
            //Create Another paragraph for date of birth
            XWPFParagraph tempParagraph4=doc.createParagraph();
            XWPFRun tempRun4 = tempParagraph2.createRun();
            tempRun4.setFontSize(14);
            tempRun4.setText("Date Of Birth: "+ getValue("DOB"));
            tempRun4.addBreak();
            //Create Another paragraph for adress 1
            XWPFParagraph tempParagraph5=doc.createParagraph();
            XWPFRun tempRun5 = tempParagraph2.createRun();
            tempRun5.setFontSize(14);
            tempRun5.setText("Address: "+ getValue("address_1"));
            tempRun5.addBreak();
            //Create Another paragraph for address 2
            XWPFParagraph tempParagrap6h=doc.createParagraph();
            XWPFRun tempRun6 = tempParagraph2.createRun();
            tempRun6.setFontSize(14);
            tempRun6.setText( getValue("address_2"));
            tempRun6.addBreak();
            //Create Another paragraph for town
            XWPFParagraph tempParagraph7=doc.createParagraph();
            XWPFRun tempRun7 = tempParagraph2.createRun();
            tempRun7.setFontSize(14);
            tempRun7.setText("Town/City: "+ getValue("town"));
            tempRun7.addBreak();
            //Create Another paragraph for county
            XWPFParagraph tempParagraph8=doc.createParagraph();
            XWPFRun tempRun8 = tempParagraph2.createRun();
            tempRun8.setFontSize(14);
            tempRun8.setText("County: "+ getValue("county"));
            tempRun8.addBreak();
            //Create Another paragraph for postcode
            XWPFParagraph tempParagraph9=doc.createParagraph();
            XWPFRun tempRun9 = tempParagraph2.createRun();
            tempRun9.setFontSize(14);
            tempRun9.setText("Postcode: "+ getValue("postcode"));
            tempRun9.addBreak();
            //Create Another paragraph for telephone
            XWPFParagraph tempParagraph10=doc.createParagraph();
            XWPFRun tempRun10 = tempParagraph2.createRun();
            tempRun10.setFontSize(14);
            tempRun10.setText("Telephone Number: "+ getValue("telephone"));
            tempRun10.addBreak();
            //Create Another paragraph for mobile
            XWPFParagraph tempParagraph11=doc.createParagraph();
            XWPFRun tempRun11 = tempParagraph2.createRun();
            tempRun11.setFontSize(14);
            tempRun11.setText("Mobile number: "+ getValue("mobile"));
            tempRun11.addBreak();
            //Create Another paragraph for next of kin person
            XWPFParagraph tempParagraph12=doc.createParagraph();
            XWPFRun tempRun12 = tempParagraph2.createRun();
            tempRun12.setFontSize(14);
            tempRun12.setText("Next of Kin: "+ getValue("next_of_kin"));
            tempRun12.addBreak();
            //Create Another paragraph for next of kin contact number
            XWPFParagraph tempParagraph13=doc.createParagraph();
            XWPFRun tempRun13 = tempParagraph2.createRun();
            tempRun13.setFontSize(14);
            tempRun13.setText("Next of Kin contact number: "+ getValue("next_of_kin_CN"));
            tempRun13.addBreak();
            
            createDoc(filePath,doc);

        } catch (Exception e) {

        }
    }

}
