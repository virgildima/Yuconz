import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.applet.Applet;
import java.util.*;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author  (Gavin Porter)
 * @version (1.4)
 * 
 * This is class is were most components of the GUI are.
 * This class ensures the create of a login screen and a example screen after login.
 * 
 */

public class GUI
{
    /**
     * The main frame.
     */
    protected JFrame frame;

    /**
     * Frame after login.
     */
    protected JFrame afterLoginFrame;

    /**
     * The username field and the password field to login the system.
     */

    Authentication auth = new Authentication();
    InterfaceBackend ib = new InterfaceBackend();

    /**
     * Textfields
     * 
     */

    /**
     * The username field and the password field to login the system.
     * 
     */
    JButton submitDocument = new JButton("Submit Document");

    JTextField employeeSearch = new JTextField(20);
    JTextField employeeFirstname = new JTextField(20);
    JTextField employeeSurname = new JTextField(20);
    JTextField employeeAddress = new JTextField(20);
    JTextField employeeAddress2 = new JTextField(20);
    JTextField employeeTown = new JTextField(20);
    JTextField employeeCounty = new JTextField(20);
    JTextField employeeMobile = new JTextField(20);
    JTextField employeeBirthDate = new JTextField(20);
    JTextField employeeHomephone = new JTextField(20);
    JTextField employeeHomeAddress = new JTextField(20);
    JTextField employeePostcode = new JTextField(20);
    JTextField employeeKin1 = new JTextField(20);
    JTextField employeeKin2 = new JTextField(20);

    JTextField currentSalary = new JTextField(20);
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JTextField employmentCV = new JTextField(20);

    JTextField staffID = new JTextField(20);
    JTextField employmentInterviewer1 = new JTextField(20);
    JTextField interviewNotes = new JTextField(20);
    JTextField employmentInitialrole = new JTextField(20);
    JTextField employmentAnnualSal = new JTextField(20);
    JTextField employmentStartDate = new JTextField(20);
    JTextField cvPath = new JTextField(20);
    JTextField jobTitle = new JTextField(20);
    JTextField section = new JTextField(20);

    JTextField salaryStartDate = new JTextField(20);
    JTextField salaryNewSalary = new JTextField(20);
    JTextField salaryNameText = new JTextField(20);
    JTextField probationStartDate = new JTextField(20);
    JTextField probationReason = new JTextField(20);

    JTextField newJobTitleTxt = new JTextField(20);
    JTextField currentJobTitleTxt = new JTextField(20);
    JTextField currentSectionTxt = new JTextField(20);
    JTextField newJobSectionTxt = new JTextField(20);
    JTextField srtDateTxt = new JTextField(20);

    JTextField reviewName = new JTextField(20);
    JTextField probationEndDate = new JTextField(20);
    JTextField dateReview = new JTextField(20);
    JTextField pGoalAch = new JTextField(20);
    JTextField fGoalS = new JTextField(20);
    JTextField rComments = new JTextField(20);
    JTextField rRecommendation = new JTextField(20);
    JTextField rSignature = new JTextField(20);
    JTextField mSignature = new JTextField(20);
    JTextField smSignature = new JTextField(20);
    JTextField drSignature = new JTextField(20);
    JTextField dmSignature = new JTextField(20);
    JTextField dsmSingature = new JTextField(20);
    JTextField manager = new JTextField(20);
    JTextField sManager = new JTextField(20);  
    JTextField summary = new JTextField(20);

    JTextField managerComment = new JTextField(20);

    JTextField managerName = new JTextField(20);
    JTextField managerName2 = new JTextField(20);
    JTextField managerComment2 = new JTextField(20);

    JTextField termExplaination = new JTextField();
    JTextField termDate = new JTextField();

    //Accessrights for user
    AccessRights userRights = null;

    Database DB = new Database();

    ProbationDocument PD = new ProbationDocument();
    PromotionDocument PD1 = new PromotionDocument();
    SalaryIncreaseDocument  SID = new SalaryIncreaseDocument();
    PersonalDetailsDocument PDD = new PersonalDetailsDocument();
    TerminationDoument TD = new TerminationDoument();
    AnnualReviewDocument ARD = new AnnualReviewDocument();
    InitialEmploymentDocument IED = new InitialEmploymentDocument();

    /**
     * Create the frame for the GUI.
     */
    public GUI()

    {
        makeFrame();

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

    public void setProbationDocument()
    {

        PD.setValue("staffID", staffID.getText());
        PD.setValue("firstname", employeeFirstname.getText());
        PD.setValue("surname", employeeSurname.getText());
        PD.setValue("probation_reason", probationReason.getText());
        PD.setValue("probation_start_date", probationStartDate.getText());
        PD.setValue("probation_end_date", probationEndDate.getText());
        PD.setValue("manager_signature", mSignature.getText());

    }
    public void setPromotionDocument()
    {

        PD1.setValue("firstname", employeeFirstname.getText());
        PD1.setValue("surname", employeeSurname.getText());
        PD1.setValue("current_job_title", currentJobTitleTxt.getText());
        PD1.setValue("current_section", currentSectionTxt.getText());
        PD1.setValue("new_job_title", newJobTitleTxt.getText());
        PD1.setValue("new_job_section", newJobSectionTxt.getText());
        PD1.setValue("starting_date", srtDateTxt.getText());
        PD1.setValue("staffID", staffID.getText());

    }

    public void setSalaryIncreaseDocument()
    { 

        SID.setValue("firstname", employeeFirstname.getText());
        SID.setValue("surname", employeeSurname.getText());
        SID.setValue("current_salary", currentSalary.getText());
        SID.setValue("new_salary", salaryNewSalary.getText());
        SID.setValue("start_date", salaryStartDate.getText());

    }

    public void setTerminationDocument()
    {

        TD.setValue("firstname", employeeFirstname.getText());
        TD.setValue("surname", employeeSurname.getText());
        TD.setValue("staffID", staffID.getText());
        TD.setValue("termination_reason", termExplaination.getText());
        TD.setValue("termination_date", termDate.getText());
        TD.setValue("manager_name", managerName.getText());
        TD.setValue("second_manager_name", managerName2.getText());
        TD.setValue("manager_comment", managerComment.getText());
        TD.setValue("second_manager_comment", managerComment2.getText());
        TD.setValue("manager_signature", mSignature.getText());
        TD.setValue("second_manager_signature", smSignature.getText());

    }

    public void setPersonalDetails()
    {

        PDD.setValue("firstname",  employeeFirstname.getText());
        PDD.setValue("surname", employeeSurname.getText());
        PDD.setValue("DOB", employeeBirthDate.getText());
        PDD.setValue("address_1", employeeAddress.getText());
        PDD.setValue("address_2", employeeAddress2.getText());
        PDD.setValue("town", employeeTown.getText());
        PDD.setValue("county", employeeCounty.getText());
        PDD.setValue("postcode", employeePostcode.getText());
        PDD.setValue("telephone", employeeHomephone.getText());
        PDD.setValue("mobile", employeeMobile.getText());
        PDD.setValue("next_of_kin", employeeKin1.getText());
        PDD.setValue("next_of_kin_CN", employeeKin2.getText());
        PDD.setValue("staffID", staffID.getText());

    }

    public void setAnnualReview()
    {

        ARD.setValue("staffID", staffID.getText());
        ARD.setValue("name", reviewName.getText());
        ARD.setValue("manager", manager.getText());
        ARD.setValue("second_manager", sManager.getText());
        ARD.setValue("section", section.getText());
        ARD.setValue("job_title", jobTitle.getText());
        ARD.setValue("performance_summary", summary.getText());
        ARD.setValue("personal_goals_achieved", pGoalAch.getText());
        ARD.setValue("future_goals_set", fGoalS.getText());
        ARD.setValue("reviewer_comments", rComments.getText());
        ARD.setValue("reviewer_recommendation", rRecommendation.getText());
        ARD.setValue("reviewee_signature", rSignature.getText());
        ARD.setValue("manager_signature", mSignature.getText());
        ARD.setValue("second_manager_signatue", smSignature.getText());
        ARD.setValue("date_of_reviewee_signature", drSignature.getText());
        ARD.setValue("date_of_manager_signature", dmSignature.getText());
        ARD.setValue("date_of_second_manager_signature", dsmSingature.getText());

    }

    public void setEmploymentDetails()
    {

        IED.setValue("staffID", staffID.getText());
        IED.setValue("cv_filePath", cvPath.getText());
        IED.setValue("interview_Notes", interviewNotes.getText());
        IED.setValue("interviewers", employmentInterviewer1.getText());
        IED.setValue("section", section.getText());
        IED.setValue("role", employmentInitialrole.getText());
        IED.setValue("initial_job_title", jobTitle.getText());
        IED.setValue("initial_salary", employmentAnnualSal.getText());
        IED.setValue("start_date", employmentStartDate.getText());

    }

    String usrInput = employeeSearch.getText();
    String usrInput2 = usernameField.getText();

    String[] searchResults = new String[] {"123456"}; 

    /**
     * Search for users documents
     */

    public static void searchDocuments(String[] searchResults,  String targetValue) {
        for(String s: searchResults){
            if(s.equals(targetValue))
            {

            }

        }
    }

    /**
     * Search for users documents for user who has just logged in
     */
    public static void loginUserDetailsSearch(String[] searchResults,  String targetValue) {
        for(String s: searchResults){
            if(s.equals(targetValue))
            {

            }

        }
    }

    /**
     * The creation of all textfields and labels.
     * Please not that this exists purely for example and testing the login. 
     * At this current build, this is no way the final after login screen
     */
    protected void afterLoginFrame()
    {
        /**
         * Frame appears after login.
         */

        JFrame afterLoginFrame = new JFrame("Yuconz Employee System");
        JPanel loggedIn = new JPanel(new GridLayout(50,30));

        /**
         * The layout of the frame
         */
        afterLoginFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        /**
         * Labels for the text fields
         */

        JLabel forenameLabel = new JLabel("Name: ");
        JLabel addressLabel = new JLabel("Address 1: ");
        JLabel address2Label = new JLabel("Address 2: ");
        JLabel townLabel = new JLabel("Town: ");
        JLabel countyLabel = new JLabel("County: ");

        JLabel postCodeLabel = new JLabel("Post Code: ");
        JLabel employeeHomeLabel = new JLabel("Homephone Number: ");
        JLabel mobileLabel = new JLabel("Mobile Number: ");
        JLabel kinLabel = new JLabel("Next of Kin: ");
        JLabel kinLabel2 = new JLabel("Next of Kin_CN: ");
        JLabel surnameLabel = new JLabel("Surname: ");
        JLabel employeeNumberLabel = new JLabel("staffID: ");
        JLabel employeeBirthDateLabel = new JLabel("Date of birth: ");

        /**
         * adding the labels and fields to the panel called loggedIn
         */

        JButton back = new JButton("Back");
        loggedIn.add(employeeSearch);
        loggedIn.add(forenameLabel);
        loggedIn.add(employeeFirstname);

        loggedIn.add(surnameLabel);
        loggedIn.add(employeeSurname);

        loggedIn.add(employeeBirthDateLabel);
        loggedIn.add(employeeBirthDate);

        loggedIn.add(addressLabel);
        loggedIn.add(employeeAddress);

        loggedIn.add(address2Label);
        loggedIn.add(employeeAddress2);

        loggedIn.add(townLabel);
        loggedIn.add(employeeTown);

        loggedIn.add(countyLabel);
        loggedIn.add(employeeCounty);

        loggedIn.add(postCodeLabel);
        loggedIn.add(employeePostcode);

        loggedIn.add(employeeHomeLabel);
        loggedIn.add(employeeHomephone);

        loggedIn.add(mobileLabel);
        loggedIn.add(employeeMobile);

        loggedIn.add(kinLabel);
        loggedIn.add(employeeKin1);

        loggedIn.add(kinLabel2);
        loggedIn.add(employeeKin2);

        loggedIn.add(employeeNumberLabel);
        loggedIn.add(staffID);

        loggedIn.add(submitDocument);

        loggedIn.add(back);

        /**
         * Disabling editing on some of the textfields
         */

        employeeSearch.setText("Replace and type to search");

        /**
         * Setting the size and postion of the frame
         */

        afterLoginFrame.setSize(300, 1000);
        afterLoginFrame.setVisible(true);
        afterLoginFrame.getContentPane().add(loggedIn);
        afterLoginFrame.setResizable(false);
        afterLoginFrame.setLocationRelativeTo(null);
        /**
         * Checkes the username and refuses entery to the system if it is wrong.
         * 
         */

        submitDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    createDocPDD();
                    JOptionPane.showMessageDialog(frame,
                        "You have submitted the document",
                        "Submit.", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    afterLoginFrame.setVisible(false);
                }
            });

    }

    /**
     * Employment frame
     */

    protected void employmentDetails()
    {
        JFrame employmentDetails = new JFrame("Yuconz Employee System");
        JPanel employmentD = new JPanel(new GridLayout(25,15));
        employmentDetails.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel eInterviewer1 = new JLabel("Employee Interviewer: ");
        JLabel interviewNotepad = new JLabel("Notes: ");
        JLabel role = new JLabel("Initial Role: ");
        JLabel annualSalary = new JLabel("Annual Salary: ");
        JLabel srtDate = new JLabel("Start Date: ");

        JLabel jobTitleL = new JLabel("Job Title: ");
        JLabel sectn = new JLabel("Section: ");
        JLabel cv = new JLabel("CV Path: ");
        JLabel ID = new JLabel("Employee ID: ");

        JButton open = new JButton("Open file");

        JButton back = new JButton("Back");

        employmentD.add(ID);
        employmentD.add(staffID);

        employmentD.add(eInterviewer1);

        employmentD.add(employmentInterviewer1);

        employmentD.add(interviewNotepad);
        employmentD.add(interviewNotes);

        employmentD.add(role);
        employmentD.add(employmentInitialrole);

        employmentD.add(jobTitleL);
        employmentD.add(jobTitle);

        employmentD.add(sectn);
        employmentD.add(section);

        employmentD.add(annualSalary);
        employmentD.add(employmentAnnualSal);

        employmentD.add(srtDate);
        employmentD.add(employmentStartDate);

        employmentD.add(cv);
        employmentD.add(cvPath);

        employmentD.add(submitDocument);

        employmentD.add(open);
        employmentD.add(back);
        employmentDetails.setSize(300, 700);
        employmentDetails.setVisible(true);
        employmentDetails.getContentPane().add(employmentD);
        employmentDetails.setResizable(false);
        employmentDetails.setLocationRelativeTo(null);

        submitDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    createDocIED();

                    JOptionPane.showMessageDialog(frame,
                        "You have submitted the document",
                        "Submit.", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        open.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    try {
                        Runtime.getRuntime().exec("explorer.exe C:\\..\\..\\..\\..\\..\\..\\..\\EmployDetails");
                    } catch(IOException a) {
                        a.printStackTrace();
                    }
                }
            });

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    employmentDetails.setVisible(false);
                }
            });

    }

    /**
     * Salay increase frame
     */

    protected void salaryIncrease()
    {
        JFrame employmentSalary = new JFrame("Yuconz Employee System");
        JPanel employmentS = new JPanel(new GridLayout(25,15));
        employmentSalary.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel eName = new JLabel("Employee Name: ");
        JLabel eName2 = new JLabel("Surname Name: ");
        JLabel currentSal = new JLabel("Current Salary: ");

        JLabel srtDate = new JLabel("Start Date: ");

        JLabel newAnnualSalary = new JLabel("New Annual Salary: ");

        JLabel staffIDL = new JLabel("Staff ID: ");

        JButton back = new JButton("Back");
        employeeSearch.setText("Replace and type to search");

        employmentS.add(eName);
        employmentS.add(employeeFirstname);
        employmentS.add(eName2);
        employmentS.add(employeeSurname);

        employmentS.add(staffIDL);
        employmentS.add(staffID);

        employmentS.add(currentSal);
        employmentS.add(currentSalary);

        employmentS.add(srtDate);
        employmentS.add(salaryStartDate);

        employmentS.add(newAnnualSalary);
        employmentS.add(salaryNewSalary);

        employmentS.add(submitDocument);
        employmentS.add(back);

        employmentSalary.setSize(300, 700);
        employmentSalary.setVisible(true);
        employmentSalary.getContentPane().add(employmentS);
        employmentSalary.setResizable(false);
        employmentSalary.setLocationRelativeTo(null);

        submitDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                   createDocSID();
                    JOptionPane.showMessageDialog(frame,
                        "You have submitted the document",
                        "Submit.", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    employmentSalary.setVisible(false);
                }
            });

    }

    /**
     * Annual Review frame
     */
    protected void annualreviews()
    {
        JFrame annualReviews = new JFrame("Yuconz Employee System");
        JPanel annualReviewsp = new JPanel(new GridLayout(40,15));
        annualReviews.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel sectn = new JLabel("Section: ");
        JLabel eName = new JLabel("Employee Name: ");
        JLabel signed = new JLabel("Signed by: ");
        JLabel date = new JLabel("Date: ");
        JLabel staffIDL = new JLabel("Staff ID: ");
        JLabel managerL = new JLabel("Manager: ");
        JLabel manager2L = new JLabel("Second Manager: ");
        JLabel jobTitleL = new JLabel("Job Title: ");
        JLabel perSummL = new JLabel("Performance Summary: ");
        JLabel perGoalsL = new JLabel("Personal Goals Achieved: ");
        JLabel perFGoalsL = new JLabel("Future Goals Set: ");
        JLabel rCommentsL = new JLabel("Review Comments: ");
        JLabel rRecommendationL = new JLabel("Reviewer Recommendation: ");
        JLabel rSign = new JLabel("Reviewee Signature: ");
        JLabel mSign = new JLabel("Manager Signature: ");
        JLabel smSign = new JLabel("Second Manager Signature: ");
        JLabel dateSign = new JLabel("Date of Reviewee Signature: ");
        JLabel datemSign = new JLabel("Date of Manager Signature: ");
        JLabel datesmSign = new JLabel("Date of Second Manager Signature: ");

        JButton back = new JButton("Back");
        employeeSearch.setText("Replace and type to search");

        annualReviewsp.add(employeeSearch);
        annualReviewsp.add(staffIDL);
        annualReviewsp.add(staffID);

        annualReviewsp.add(eName);
        annualReviewsp.add(reviewName);

        annualReviewsp.add(managerL);
        annualReviewsp.add(manager);

        annualReviewsp.add(manager2L);
        annualReviewsp.add(sManager);

        annualReviewsp.add(sectn);
        annualReviewsp.add(section);

        annualReviewsp.add(jobTitleL);
        annualReviewsp.add(jobTitle);

        annualReviewsp.add(perSummL);
        annualReviewsp.add(summary);

        annualReviewsp.add(perGoalsL);
        annualReviewsp.add(pGoalAch);

        annualReviewsp.add(perFGoalsL);
        annualReviewsp.add(fGoalS); 

        annualReviewsp.add(rCommentsL);
        annualReviewsp.add(rComments);

        annualReviewsp.add(rRecommendationL);
        annualReviewsp.add(rRecommendation);

        annualReviewsp.add(rSign);
        annualReviewsp.add(rSignature);

        annualReviewsp.add(mSign);
        annualReviewsp.add(mSignature);

        annualReviewsp.add(smSign);
        annualReviewsp.add(smSignature);

        annualReviewsp.add(dateSign);
        annualReviewsp.add(drSignature);

        annualReviewsp.add(datemSign);
        annualReviewsp.add(dmSignature);

        annualReviewsp.add(datesmSign);
        annualReviewsp.add(dsmSingature);
        annualReviewsp.add(submitDocument);

        annualReviewsp.add(back);
        annualReviews.setSize(300, 1000);
        annualReviews.setVisible(true);
        annualReviews.getContentPane().add(annualReviewsp);
        annualReviews.setResizable(false);
        annualReviews.setLocationRelativeTo(null);

        submitDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    createDocARD();
                    JOptionPane.showMessageDialog(frame,
                        "You have submitted the document",
                        "Submit.", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    annualReviews.setVisible(false);
                }
            });

    }

    /**
     * Promotion frame
     */

    protected void promotion()
    {
        JFrame promotion = new JFrame("Yuconz Employee System");
        JPanel promotionS = new JPanel(new GridLayout(25,15));
        promotion.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel eName = new JLabel("Employee Name: ");
        JLabel eName2 = new JLabel("Surname Name: ");

        JLabel srtDate = new JLabel("Start Date: ");

        JLabel currentJobTitle = new JLabel("Current Job Title: ");

        JLabel newJobTitle = new JLabel("New Job Title: ");

        JLabel newJobSection = new JLabel("New Section: ");
        JLabel currentSection = new JLabel("Current Section: ");

        JButton back = new JButton("Back");

        employeeSearch.setText("Replace and type to search");

        promotionS.add(employeeSearch);

        promotionS.add(eName);
        promotionS.add(employeeFirstname);

        promotionS.add(eName2);
        promotionS.add(employeeSurname);

        promotionS.add(currentJobTitle);
        promotionS.add(currentJobTitleTxt);

        promotionS.add(currentSection);
        promotionS.add(currentSectionTxt);

        promotionS.add(newJobTitle);
        promotionS.add(newJobTitleTxt);

        promotionS.add(newJobSection);
        promotionS.add(newJobSectionTxt);

        promotionS.add(srtDate);
        promotionS.add(srtDateTxt);

        promotionS.add(submitDocument);
        promotionS.add(back);
        promotion.setSize(300, 700);
        promotion.setVisible(true);
        promotion.getContentPane().add(promotionS);
        promotion.setResizable(false);
        promotion.setLocationRelativeTo(null);

        submitDocument.addActionListener(new ActionListener() 
            {
               

                public void actionPerformed(ActionEvent e) 
                { 
                     createDocPD1();
                    setPromotionDocument();
                    JOptionPane.showMessageDialog(frame,
                        "You have submitted the document",
                        "Submit.",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    promotion.setVisible(false);
                }
            });

    }

    /**
     * Termination Frame
     */

    protected void Termination()
    {
        JFrame termination = new JFrame("Yuconz Employee System");
        JPanel terminationP = new JPanel(new GridLayout(25,15));
        termination.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel id = new JLabel("Staff ID: ");

        JLabel eName = new JLabel("Employee Name: ");
        JLabel eName2 = new JLabel("Employee Surname: ");

        JLabel reason = new JLabel("Reason for Termination: ");
        JLabel date = new JLabel("End Date: ");
        JLabel sign = new JLabel("Manager Signature: ");
        JLabel sign2 = new JLabel("Second Manager Signature: ");

        JButton back = new JButton("Back");
        employeeSearch.setText("Replace and type to search");

        JLabel managerNamel = new JLabel("Manager Name: ");
        JLabel managerName2l = new JLabel("Second Manager Name: ");
        JLabel managerCommentl = new JLabel("Manager Comment: ");

        terminationP.add(employeeSearch);
        terminationP.add(id);
        terminationP.add(staffID);

        terminationP.add(eName);
        terminationP.add(employeeFirstname);
        terminationP.add(eName2);
        terminationP.add(employeeSurname);

        terminationP.add(managerNamel);
        terminationP.add(managerName);

        terminationP.add(managerName2l);
        terminationP.add(managerName2);

        terminationP.add(reason);
        terminationP.add(termExplaination);

        terminationP.add(managerCommentl);
        terminationP.add(managerComment);

        terminationP.add(sign);
        terminationP.add(mSignature);

        terminationP.add(sign2);
        terminationP.add(smSignature);

        terminationP.add(submitDocument);

        terminationP.add(back);
        termination.setSize(300, 700);
        termination.setVisible(true);
        termination.getContentPane().add(terminationP);
        termination.setResizable(false);
        termination.setLocationRelativeTo(null);

        submitDocument.addActionListener(new ActionListener() 
            {
                
                public void actionPerformed(ActionEvent e) 
                { 
                     createDocTD();
                    JOptionPane.showMessageDialog(frame,
                        "You have submitted the document",
                        "Submit.",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    termination.setVisible(false);
                }
            });

    }

    /**
     * Probation Frame
     */

    protected void Probation()
    {
        JFrame probation = new JFrame("Yuconz Employee System");
        JPanel probationP = new JPanel(new GridLayout(25,15));
        probation.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel id = new JLabel("Staff ID: ");
        JLabel eName = new JLabel("Employee Name: ");
        JLabel eName2 = new JLabel("Employee Surname: ");

        JLabel reason = new JLabel("Reason for Probation: ");

        JLabel startDate = new JLabel("End Date: ");

        JLabel endDate = new JLabel("End Date: ");

        JLabel sign = new JLabel("Manager Signature: ");

        JButton back = new JButton("Back");
        employeeSearch.setText("Replace and type to search");

        probationP.add(employeeSearch);

        probationP.add(id);
        probationP.add(staffID);

        probationP.add(eName);
        probationP.add(employeeFirstname);
        probationP.add(eName2);
        probationP.add(employeeSurname);

        probationP.add(reason);
        probationP.add(probationStartDate);

        probationP.add(endDate);
        probationP.add(probationEndDate);

        probationP.add(sign);
        probationP.add(mSignature);

        probationP.add(submitDocument);

        probationP.add(back);
        probation.setSize(300, 700);
        probation.setVisible(true);
        probation.getContentPane().add(probationP);
        probation.setResizable(false);
        probation.setLocationRelativeTo(null);

        submitDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                     createDocPD();
                    JOptionPane.showMessageDialog(frame,
                        "You have submitted the document",
                        "Submit.",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    probation.setVisible(false);
                }
            });

    }

    /**
     * This is the frame which appears to users who have access to all documents read or write depending 
     * on the accessrights
     */
    protected void chooseFrame(){                      
        JFrame chooseFrame = new JFrame("Yuconz Employee System");
        JPanel chooseLoggedIn = new JPanel(new GridLayout(25,15));
        chooseFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton personalButton = new JButton("Personal Details");
        JButton employmenDetails = new JButton("Employment Details");
        JButton salaryIncrease = new JButton("Salary increase records");
        JButton promotionRecords = new JButton("Promotion Records");
        JButton probationRecords = new JButton("Probation Records");
        JButton terminationRecords = new JButton("Termination Records");
        JButton annualReviewRecords = new JButton("Annual Review Records");

        chooseLoggedIn.add(personalButton);
        chooseLoggedIn.add(employmenDetails);
        chooseLoggedIn.add(salaryIncrease);
        chooseLoggedIn.add(promotionRecords);
        chooseLoggedIn.add(probationRecords);
        chooseLoggedIn.add(terminationRecords);
        chooseLoggedIn.add(annualReviewRecords);

        chooseFrame.setSize(300, 700);;
        chooseFrame.setVisible(true);
        chooseFrame.getContentPane().add(chooseLoggedIn);
        chooseFrame.setResizable(false);
        chooseFrame.setLocationRelativeTo(null);

        //Load personal Details frame
        personalButton.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    afterLoginFrame();
                    chooseFrame.setVisible(false);
                }
            });

        //Load employment details frame
        employmenDetails.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    employmentDetails();
                    chooseFrame.setVisible(false);

                }
            });

        //salary increase frame
        salaryIncrease.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    salaryIncrease();
                    chooseFrame.setVisible(false);
                }
            });

        //promotion records frame
        promotionRecords.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    promotion();
                    chooseFrame.setVisible(false);
                }
            });

        //load probation records frame

        probationRecords.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    Probation();
                    chooseFrame.setVisible(false);
                }
            });

        //load termination records frame
        terminationRecords.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    Termination();
                    chooseFrame.setVisible(false);
                }
            });

        //load annual reviews frame
        annualReviewRecords.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    annualreviews();
                    chooseFrame.setVisible(false);
                }
            });
    }

    /**
     * 
     * This is the creation of the login frame
     * 
     * 
     */
    protected void makeFrame()
    {
        frame = new JFrame("Login");

        /**
         * Creating the panel and its layout.
         */

        JPanel ptext = new JPanel();
        ptext.setLayout(new GridLayout(3,3));

        /**
         * setting the size of the text field and password field
         */
        Dimension textSize = new Dimension(140, 21);

        passwordField.setPreferredSize(textSize);

        /**
         * labels for the username and passwordfields
         */
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");

        JButton loginButton = new JButton("Login");
        /**
         * adding buttons, labels and fields to the panel
         */

        ptext.add(usernameLabel);
        ptext.add(usernameField);
        ptext.add(passwordLabel);
        ptext.add(passwordField);
        ptext.add(loginButton);

        /**
         * Creating the combobox for the user login
         */

        String[] access = AccessRights.names();
        JComboBox rights = new JComboBox(AccessRights.names());
        ptext.add(rights);

        /**
         * The creation and display of the frame
         */

        actionListeners(frame);
        frame.setVisible(true);
        frame.getContentPane().add(ptext);
        frame.setResizable(false);

        frame.pack();
        frame.setLocationRelativeTo(null);

        loginButton.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    userRights = AccessRights.fromString((String)rights.getSelectedItem());
                    String passHash = ib.passwordSHA512(String.valueOf(passwordField.getPassword()));
                    /**
                     * Logging in
                     */
                    if(auth.login(usernameField.getText(), passHash , userRights))
                    {

                        if(userRights == AccessRights.Basic_User)
                        {
                            successfulLogin();
                            afterLoginFrame();

                            notEditable();
                        }

                        else if(userRights == AccessRights.HR_User)
                        {
                            successfulLogin();
                            chooseFrame();

                        }
                        else if(userRights == AccessRights.Director)
                        {
                            successfulLogin();
                            chooseFrame();
                            notEditable();

                        }

                        else if(userRights == AccessRights.Manager)
                        {
                            successfulLogin();
                            chooseFrame();
                            notEditable();

                        }

                        else if(userRights == AccessRights.SeniorManager)
                        {
                            successfulLogin();
                            chooseFrame();
                            notEditable();

                        }
                        else 
                        {
                            successfulLogin();
                            afterLoginFrame();

                            notEditable();
                        }
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(frame,
                            "Incorrect Login Details",
                            "User details are incorrect.", 
                            JOptionPane.INFORMATION_MESSAGE);

                    }
                }

            });

    }

    public void successfulLogin()
    {
        JOptionPane.showMessageDialog(frame,
            "Logged in",
            "User Details Accepted.", 
            JOptionPane.INFORMATION_MESSAGE);
        frame.setVisible(false);
        frame.dispose();

    }

    public void notEditable()
    {
        staffID.setEditable(false);

        employeeFirstname.setEditable(false);
        employeeSurname.setEditable(false);  
        employeeBirthDate.setEditable(false);
        employeeTown.setEditable(false);
        employeeAddress.setEditable(false);  
        employeeAddress2.setEditable(false); 
        employeeKin1.setEditable(false); 
        employeeKin2.setEditable(false);
        employeeMobile.setEditable(false);
        employeeHomephone.setEditable(false);
        employeeHomeAddress.setEditable(false);

        employeePostcode.setEditable(false);

        srtDateTxt.setEditable(false);

        employmentCV.setEditable(false);
        employmentInterviewer1.setEditable(false);
        interviewNotes.setEditable(false);
        employmentInitialrole.setEditable(false);
        employmentAnnualSal.setEditable(false);
        employmentStartDate.setEditable(false);

        salaryStartDate.setEditable(false);
        salaryNewSalary.setEditable(false);
        salaryNameText.setEditable(false);

        srtDateTxt.setEditable(false);

        employeeFirstname.setEditable(false);
        employeeSurname.setEditable(false);
        probationReason.setEditable(false);

        probationStartDate.setEditable(false);
        probationEndDate.setEditable(false);

        reviewName.setEditable(false);
        probationEndDate.setEditable(false);
        dateReview.setEditable(false);

        pGoalAch.setEditable(false);
        fGoalS.setEditable(false);
        rComments.setEditable(false);
        rRecommendation.setEditable(false);
        rSignature.setEditable(false);
        mSignature.setEditable(false);
        smSignature.setEditable(false);
        drSignature.setEditable(false);
        dmSignature.setEditable(false);
        dsmSingature.setEditable(false);
        manager.setEditable(false);
        sManager.setEditable(false);
        employeeCounty.setEditable(false);

        jobTitle.setEditable(false);
        currentSalary.setEditable(false);

        section.setEditable(false);
        currentJobTitleTxt.setEditable(false);

        currentSectionTxt.setEditable(false);

        newJobTitleTxt.setEditable(false);

        newJobSectionTxt.setEditable(false);

        managerName.setEditable(false);

        managerName2.setEditable(false);

        termExplaination.setEditable(false);

        managerComment.setEditable(false);

        summary.setEditable(false);
    }

    /**
     * Referencing to methods in the interfacebackend class
     * 
     */

    public void actionListeners(JFrame frame)
    {

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu menu;
        JMenuItem item;

        menu = new JMenu("Menu");
        menubar.add(menu);

        item = new JMenuItem("About");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { ib.about(); }
            });
        menu.add(item);

        item = new JMenuItem("help");

        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { ib.help(); }
            });
        menu.add(item);

        item = new JMenuItem("Quit");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { ib.quit(); }
            });
        menu.add(item);

    }
}

                                                                                                                                