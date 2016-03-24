import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author  (Gavin Porter)
 * @version (1.4)
 * 
 * This handles some of the logic and the actions of components in the GUI class
 */
public class InterfaceBackend
{

    
    protected JFrame frame;
    public String password;
    public  String encryptPass;
    public GUI gui;
    
    Database DB = new Database();

    Document ARD    = new Document(DocType.AnnualReview);
    Document IED    = new Document(DocType.InitialEmployment);
    Document PDD    = new Document(DocType.PersonalDetails);
    Document PD     = new Document(DocType.Probation);
    Document PD1    = new Document(DocType.Promotion);
    Document SID    = new Document(DocType.SalaryIncrease);
    Document TD     = new Document(DocType.Termination);
    
    

    /**
     * These refer to instance varibles or fields thus this allows me to use some in this class.
     */
    public InterfaceBackend()
    {
        
       
      

    }
    
    
    /**
     * Create documents
     */

    public void createDocPD()
    {
        DB.addDocument(PD);
    }

    public void createDocPD1()
    {
        DB.addDocument(PD1);
    }

    public void createDocSID()
    {
        DB.addDocument(SID);
    }

    public void createDocPDD()
    {
        DB.addDocument(PDD);
    }

    public void createDocTD()
    {
        DB.addDocument(TD);
    }

    public void createDocARD()
    {
        DB.addDocument(ARD);
    }

    public void createDocIED()
    {
        DB.addDocument(IED);
    }

    /**
     * Update existing documents
     */

    public void updateDocPD()
    {
        DB.updateDocument(PD);
    }

    public void updateDocPD1()
    {
        DB.updateDocument(PD1);
    }

    public void updateDocSID()
    {
        DB.updateDocument(SID);
    }

    public void updateDocPDD()
    {
        DB.updateDocument(PDD);
    }

    public void updateDocTD()
    {
        DB.updateDocument(TD);
    }

    public void updateDocARD()
    {
        DB.updateDocument(ARD);
    }

    public void updateDocIED()
    {
        DB.updateDocument(IED);
    }
    
    /**
     * Set Attributes to their respetive fields
     */

    public void setProbationDocument()
    {

        PD.setValue("staffID", gui.staffID.getText());
        PD.setValue("firstname", gui.employeeFirstname.getText());
        PD.setValue("surname", gui.employeeSurname.getText());
        PD.setValue("probation_reason", gui.probationReason.getText());
        PD.setValue("probation_start_date", gui.probationStartDate.getText());
        PD.setValue("probation_end_date", gui.probationEndDate.getText());
        PD.setValue("manager_signature", gui.mSignature.getText());

    }
    public void setPromotionDocument()
    {

        PD1.setValue("firstname", gui.employeeFirstname.getText());
        PD1.setValue("surname", gui.employeeSurname.getText());
        PD1.setValue("current_job_title", gui.currentJobTitleTxt.getText());
        PD1.setValue("current_section", gui.currentSectionTxt.getText());
        PD1.setValue("new_job_title", gui.newJobTitleTxt.getText());
        PD1.setValue("new_job_section", gui.newJobSectionTxt.getText());
        PD1.setValue("starting_date", gui.srtDateTxt.getText());
        PD1.setValue("staffID", gui.staffID.getText());

    }

    public void setSalaryIncreaseDocument()
    { 

        SID.setValue("firstname", gui.employeeFirstname.getText());
        SID.setValue("surname", gui.employeeSurname.getText());
        SID.setValue("current_salary", gui.currentSalary.getText());
        SID.setValue("new_salary", gui.salaryNewSalary.getText());
        SID.setValue("start_date", gui.salaryStartDate.getText());

    }

    public void setTerminationDocument()
    {

        TD.setValue("firstname", gui.employeeFirstname.getText());
        TD.setValue("surname", gui.employeeSurname.getText());
        TD.setValue("staffID", gui.staffID.getText());
        TD.setValue("termination_reason", gui.termExplaination.getText());
        TD.setValue("termination_date", gui.termDate.getText());
        TD.setValue("manager_name", gui.managerName.getText());
        TD.setValue("second_manager_name", gui.managerName2.getText());
        TD.setValue("manager_comment", gui.managerComment.getText());
        TD.setValue("second_manager_comment", gui.managerComment2.getText());
        TD.setValue("manager_signature", gui.mSignature.getText());
        TD.setValue("second_manager_signature", gui.smSignature.getText());

    }

    public void setPersonalDetails()
    {

        PDD.setValue("firstname",  gui.employeeFirstname.getText());
        PDD.setValue("surname", gui.employeeSurname.getText());
        PDD.setValue("DOB", gui.employeeBirthDate.getText());
        PDD.setValue("address_1", gui.employeeAddress.getText());
        PDD.setValue("address_2", gui.employeeAddress2.getText());
        PDD.setValue("town", gui.employeeTown.getText());
        PDD.setValue("county", gui.employeeCounty.getText());
        PDD.setValue("postcode", gui.employeePostcode.getText());
        PDD.setValue("telephone", gui.employeeHomephone.getText());
        PDD.setValue("mobile", gui.employeeMobile.getText());
        PDD.setValue("next_of_kin", gui.employeeKin1.getText());
        PDD.setValue("next_of_kin_CN", gui.employeeKin2.getText());
        PDD.setValue("staffID", gui.staffID.getText());

    }

    public void setAnnualReview()
    {

        ARD.setValue("staffID", gui.staffID.getText());
        ARD.setValue("name", gui.reviewName.getText());
        ARD.setValue("manager", gui.manager.getText());
        ARD.setValue("second_manager", gui.sManager.getText());
        ARD.setValue("section", gui.section.getText());
        ARD.setValue("job_title", gui.jobTitle.getText());
        ARD.setValue("performance_summary", gui.summary.getText());
        ARD.setValue("personal_goals_achieved", gui.pGoalAch.getText());
        ARD.setValue("future_goals_set", gui.fGoalS.getText());
        ARD.setValue("reviewer_comments", gui.rComments.getText());
        ARD.setValue("reviewer_recommendation", gui.rRecommendation.getText());
        ARD.setValue("reviewee_signature", gui.rSignature.getText());
        ARD.setValue("manager_signature",gui.mSignature.getText());
        ARD.setValue("second_manager_signatue", gui.smSignature.getText());
        ARD.setValue("date_of_reviewee_signature", gui.drSignature.getText());
        ARD.setValue("date_of_manager_signature", gui.dmSignature.getText());
        ARD.setValue("date_of_second_manager_signature", gui.dsmSingature.getText());

    }

    public void setEmploymentDetails()
    {

        IED.setValue("staffID", gui.staffID.getText());
        IED.setValue("cv_filePath", gui.cvPath.getText());
        IED.setValue("interview_Notes", gui.interviewNotes.getText());
        IED.setValue("interviewers", gui.employmentInterviewer1.getText());
        IED.setValue("section", gui.section.getText());
        //TAGGED IED.setValue("role", employmentInitialrole.getText());
        IED.setValue("initial_job_title", gui.jobTitle.getText());
        IED.setValue("initial_salary", gui.employmentAnnualSal.getText());
        IED.setValue("start_date", gui.employmentStartDate.getText());

    }


    public String passwordSHA512(String password)
    {
        this.password = password;

        /**
         * This checks if the pasword length is 6 characters long
         * if its not then the password is set to null.
         */

        if(password.length() == 0  )
        {
            password = null;
            JOptionPane.showMessageDialog(frame,
                "The password must be 6 characters long",
                "Password length incorrect", 
                JOptionPane.INFORMATION_MESSAGE);

        }
        else 
        {
            /**
             * this uses the algorithmn SHA-512 to hide the password.
             * This adds some security to the login.
             * Create a byte array and get the bytes equal to the password.
             * MessageDigest is a one way , and hash outputs a fixed length hash value
             * 
             * CodeReference:
             * http://stackoverflow.com/questions/33085493/hash-a-password-with-sha-512-in-java
             * 
             * password returns a string of numbers.
             */
            byte[] array = password.getBytes();

            try {
                MessageDigest mDigest = MessageDigest.getInstance("SHA-512");
                byte[] bytes  = mDigest.digest(password.getBytes());
                StringBuilder strBuild = new StringBuilder();
                for(int i=0; i< bytes.length ;i++)
                {
                    strBuild.append(Integer.toString((bytes[i] & 0xff) + 0x100, 6).substring(1));
                }
                password = strBuild.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new UnsupportedOperationException(e);
            }
        }
        
        return  encryptPass = password;
    }  
    
    public  String getEncrypted()
    {
        return this.encryptPass = encryptPass;
    }
    
 

    /**
     * Method which closes the program
     */

    public void quit()
    {
        System.exit(0);
        
       
    }

    /**
     * Tells the user informatiob about the login page
     */

    public void about()
    {
        JOptionPane.showMessageDialog(frame,
            "This is the user interface for the Yuconz user review system.",
            "About.", 
            JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * Tells the user what they need to do.
     */

    public void help()
    {
        JOptionPane.showMessageDialog(frame,
            "In order for you to login, you must enter your username in the text field labelled "+ " 'username' " + "and the password in the text field labelled" + " 'password'.",
            "Help.", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    

    

    

}
