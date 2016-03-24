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
    JButton submitDocument = new JButton("Create Document");
    
    JButton updateDocument = new JButton("Update Document");

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
    // TAGGED JTextField employmentInitialrole = new JTextField(20);
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


    /**
     * Create the frame for the GUI.
     */
    public GUI()

    {
        makeFrame();

    }   

    String usrInput = employeeSearch.getText();
    String usrInput2 = usernameField.getText();


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
        JPanel loggedIn = new JPanel(new GridLayout(20,2));

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
        loggedIn.add(updateDocument);

        loggedIn.add(back);

     

        /**
         * Setting the size and postion of the frame
         */

        afterLoginFrame.setSize(500, 500);
        afterLoginFrame.setVisible(true);
        afterLoginFrame.getContentPane().add(loggedIn);
        afterLoginFrame.setResizable(false);
        afterLoginFrame.setLocationRelativeTo(null);
        /**
         * Checkes the username and refuses entery to the system if it is wrong.
         * 
         */
        
         updateDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    ib.updateDocPDD();
                    JOptionPane.showMessageDialog(frame,
                        "You have updated the document",
                        "Update.", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        submitDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    ib.createDocPDD();
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
        JPanel employmentD = new JPanel(new GridLayout(20,2));
        employmentDetails.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel eInterviewer1 = new JLabel("Employee Interviewer: ");
        JLabel interviewNotepad = new JLabel("Notes: ");
        // TAGGED JLabel role = new JLabel("Initial Role: ");
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

        // TAGGED employmentD.add(role);
        // TAGGED employmentD.add(employmentInitialrole);

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
        employmentD.add(updateDocument);

        employmentD.add(open);
        employmentD.add(back);
        employmentDetails.setSize(500, 700);
        employmentDetails.setVisible(true);
        employmentDetails.getContentPane().add(employmentD);
        employmentDetails.setResizable(false);
        employmentDetails.setLocationRelativeTo(null);
        
         updateDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                     ib.updateDocIED();
                    JOptionPane.showMessageDialog(frame,
                        "You have updated the document",
                        "Update.", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        submitDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    ib.createDocIED();

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
        JPanel employmentS = new JPanel(new GridLayout(20,2));
        employmentSalary.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel eName = new JLabel("Employee Name: ");
        JLabel eName2 = new JLabel("Surname Name: ");
        JLabel currentSal = new JLabel("Current Salary: ");

        JLabel srtDate = new JLabel("Start Date: ");

        JLabel newAnnualSalary = new JLabel("New Annual Salary: ");

        JLabel staffIDL = new JLabel("Staff ID: ");

        JButton back = new JButton("Back");


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
        employmentS.add(updateDocument);
        employmentS.add(back);

        employmentSalary.setSize(500, 500);
        employmentSalary.setVisible(true);
        employmentSalary.getContentPane().add(employmentS);
        employmentSalary.setResizable(false);
        employmentSalary.setLocationRelativeTo(null);
        
         updateDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    ib.updateDocSID();
                    JOptionPane.showMessageDialog(frame,
                        "You have updated the document",
                        "Update.", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        submitDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                   ib.createDocSID();
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
        JPanel annualReviewsp = new JPanel(new GridLayout(20,2));
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
        annualReviewsp.add(updateDocument);

        annualReviewsp.add(back);
        annualReviews.setSize(500, 600);
        annualReviews.setVisible(true);
        annualReviews.getContentPane().add(annualReviewsp);
        annualReviews.setResizable(false);
        annualReviews.setLocationRelativeTo(null);
        
        updateDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    ib.updateDocARD();
                    JOptionPane.showMessageDialog(frame,
                        "You have updated the document",
                        "Update.", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        submitDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    ib.createDocARD();
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
        JPanel promotionS = new JPanel(new GridLayout(20,2));
        promotion.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel eName = new JLabel("Employee Name: ");
        JLabel eName2 = new JLabel("Surname Name: ");

        JLabel srtDate = new JLabel("Start Date: ");

        JLabel currentJobTitle = new JLabel("Current Job Title: ");

        JLabel newJobTitle = new JLabel("New Job Title: ");

        JLabel newJobSection = new JLabel("New Section: ");
        JLabel currentSection = new JLabel("Current Section: ");

        JButton back = new JButton("Back");


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
        promotionS.add(updateDocument);
        promotionS.add(back);
        promotion.setSize(500, 700);
        promotion.setVisible(true);
        promotion.getContentPane().add(promotionS);
        promotion.setResizable(false);
        promotion.setLocationRelativeTo(null);
        
         updateDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    ib.updateDocPD1();
                    JOptionPane.showMessageDialog(frame,
                        "You have updated the document",
                        "Update.", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        submitDocument.addActionListener(new ActionListener() 
            {
               

                public void actionPerformed(ActionEvent e) 
                { 
                     ib.createDocPD1();
                    ib.setPromotionDocument();
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
        JPanel terminationP = new JPanel(new GridLayout(20,2));
        termination.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel id = new JLabel("Staff ID: ");

        JLabel eName = new JLabel("Employee Name: ");
        JLabel eName2 = new JLabel("Employee Surname: ");

        JLabel reason = new JLabel("Reason for Termination: ");
        JLabel date = new JLabel("End Date: ");
        JLabel sign = new JLabel("Manager Signature: ");
        JLabel sign2 = new JLabel("Second Manager Signature: ");

        JButton back = new JButton("Back");
       

        JLabel managerNamel = new JLabel("Manager Name: ");
        JLabel managerName2l = new JLabel("Second Manager Name: ");
        JLabel managerCommentl = new JLabel("Manager Comment: ");

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
        terminationP.add(updateDocument);

        terminationP.add(back);
        termination.setSize(600, 700);
        termination.setVisible(true);
        termination.getContentPane().add(terminationP);
        termination.setResizable(false);
        termination.setLocationRelativeTo(null);
        
         updateDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    ib.createDocTD();
                    JOptionPane.showMessageDialog(frame,
                        "You have updated the document",
                        "Update.", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        submitDocument.addActionListener(new ActionListener() 
            {
                
                public void actionPerformed(ActionEvent e) 
                { 
                     ib.createDocTD();
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
        JPanel probationP = new JPanel(new GridLayout(20,2));
        probation.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel id = new JLabel("Staff ID: ");
        JLabel eName = new JLabel("Employee Name: ");
        JLabel eName2 = new JLabel("Employee Surname: ");

        JLabel reason = new JLabel("Reason for Probation: ");

        JLabel startDate = new JLabel("End Date: ");

        JLabel endDate = new JLabel("End Date: ");

        JLabel sign = new JLabel("Manager Signature: ");

        JButton back = new JButton("Back");

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
         probationP.add(updateDocument);

        probationP.add(back);
        probation.setSize(500, 700);
        probation.setVisible(true);
        probation.getContentPane().add(probationP);
        probation.setResizable(false);
        probation.setLocationRelativeTo(null);
        
         updateDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    ib.createDocPD();
                    JOptionPane.showMessageDialog(frame,
                        "You have updated the document",
                        "Update.", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

        submitDocument.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                     ib.createDocPD();
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
        JPanel chooseLoggedIn = new JPanel(new GridLayout(20,2));
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

        chooseFrame.setSize(500,700);;
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
        // TAGGED employmentInitialrole.setEditable(false);
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

                                                                                                                                