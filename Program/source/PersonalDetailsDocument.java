import java.util.HashMap;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
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

    public void SaveToFile(String fileName){
        try {
          File file = new File(fileName);
          FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());

            XWPFDocument doc = new XWPFDocument();
            XWPFParagraph tempParagraph = doc.createParagraph();
            XWPFRun tempRun = tempParagraph.createRun();

            tempRun.setText("Personal Details.");
          //  tempRun.setAlignment(tempRun.ALIGN_CENTER);
           // tempRun.setText("Staff No:"+ doc.getstaffID() );
          //  tempRun.setAlignment(tempRun.ALIGN_CENTER);
            tempRun.setText("Surname:"+ doc.getSurname());
            tempRun.setText("Name:"+ doc.getName());
            tempRun.setText("Date Of Birth:"+ doc.getSurname());
            tempRun.setText("Address:"+ doc.getSurname());
            tempRun.setText("Town/City:"+ doc.getSurname());
            tempRun.setText("Country:"+ doc.getSurname());
            tempRun.setText("Postcode:"+ doc.getSurname());
            tempRun.setText("Postcode:"+ doc.getSurname());
            tempRun.setText("Postcode:"+ doc.getSurname());
            tempRun.setText("Postcode:"+ doc.getSurname());
            tempRun.setText("Postcode:"+ doc.getSurname());
            tempRun.setFontSize(18);
            doc.write(fos);
            fos.close();

            System.out.println(file.getAbsolutePath()+ " created successfully!");

        } catch (Exception e) {

        }
    }
    
	public static void main(String[] args) {
		
		//create docx file
		createDocFile("C:\\DocxFile.docx");
		
		//create doc file
		createDocFile("C:\\DocFile.doc");

	}
}
