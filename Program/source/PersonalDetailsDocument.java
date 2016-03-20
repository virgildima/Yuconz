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

    @Override public boolean equals(Object doc)
    {
        return super.equals((Document)doc);
    }
    
    /**
     * Method that takes the class HashMap content and creates a .docx file from it
     */
    public void SaveToFile(String fileName){
        try {
            File file = new File(fileName);
            //Write the Document in file system
            FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
            //Blank Document
            XWPFDocument doc = new XWPFDocument();
            //create paragraph for Personal Details
            XWPFParagraph tempParagraph = doc.createParagraph();
            tempParagraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun paragraphOneRunOne = tempParagraph.createRun();
            paragraphOneRunOne.setBold(true);
            paragraphOneRunOne.setFontSize(18);
            XWPFRun tempRun = tempParagraph.createRun();
            tempRun.setText("Personal Details.");
            //Create Another paragraph for staffID
            tempParagraph=doc.createParagraph();
            paragraphOneRunOne = tempParagraph.createRun();
            tempRun = tempParagraph.createRun();
            tempRun.setText("Staff No:"+  getValue("staffID") );
            paragraphOneRunOne.addBreak();
            //Create Another paragraph for Surname
            XWPFRun paragraphOneRunTwo = tempParagraph.createRun();
            tempParagraph.setAlignment(ParagraphAlignment.LEFT);
            paragraphOneRunTwo = tempParagraph.createRun();
            tempRun = tempParagraph.createRun();
            paragraphOneRunTwo.setFontSize(12);
            tempRun.setText("Surname:"+  getValue("surname"));
            //Create Another paragraph for Name
            tempParagraph=doc.createParagraph();
            tempRun.setText("Name:"+ getValue("firstname"));
            //Create Another paragraph for date of birth
            tempParagraph=doc.createParagraph();
            tempRun.setText("Date Of Birth:"+ getValue("DOB"));
            //Create Another paragraph for adress 1
            tempParagraph=doc.createParagraph();
            tempRun.setText("Address:"+ getValue("address_1"));
            //Create Another paragraph for address 2
            tempParagraph=doc.createParagraph();
            tempRun.setText( getValue("address_2"));
            //Create Another paragraph for town
            tempParagraph=doc.createParagraph();
            tempRun.setText("Town/City:"+ getValue("town"));
            //Create Another paragraph for country
            tempParagraph=doc.createParagraph();
            tempRun.setText("Country:"+ getValue("country"));
            //Create Another paragraph for postcode
            tempParagraph=doc.createParagraph();
            tempRun.setText("Postcode:"+ getValue("postcode"));
            //Create Another paragraph for telephone
            tempParagraph=doc.createParagraph();
            tempRun.setText("Telephone Number:"+ getValue("telephone"));
            //Create Another paragraph for mobile
            tempParagraph=doc.createParagraph();
            tempRun.setText("Mobile number:"+ getValue("mobile"));
            //Create Another paragraph for next of kin person
            tempParagraph=doc.createParagraph();
            tempRun.setText("Next of Kin:"+ getValue("next_of_kin"));
            //Create Another paragraph for next of kin contact number
            tempParagraph=doc.createParagraph();
            tempRun.setText("Next of Kin contact number:"+ getValue("next_of_kin_CN"));
            doc.write(fos);
            fos.close();

            

        } catch (Exception e) {

        }
    }
}
