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
    public JTextField usernameField;
    public JPasswordField passwordField;

    Authentication auth = new Authentication();
    InterfaceBackend ib = new InterfaceBackend();

    /**
     * Textfields
     */

    JTextField employeeSearch = new JTextField(20);
    JTextField employeeForename = new JTextField(20);
    JTextField employeeSurname = new JTextField(20);
    JTextField employeeLastReview = new JTextField(20);
    JTextField employeeRaiseRecommendation = new JTextField(20);
    JTextField employeeEmailAddress = new JTextField(20);
    JTextField employeeMobile = new JTextField(20);
    JTextField employeeBirthDate = new JTextField(20);
    JTextField employeeHomephone = new JTextField(20);
    JTextField employeeHomeAddress = new JTextField(20);
    JTextField employeeGender = new JTextField(20);
    JTextField employeePostcode = new JTextField(20);

    JTextField promotionStartDate = new JTextField(20);
    JTextField promotionSalary = new JTextField(20);
    JTextField promotionNameText = new JTextField(20);
    JTextField promotionRole = new JTextField(20);
    JTextField employmentCV = new JTextField(20);

    JTextField employmentInterviewer1 = new JTextField(20);
    JTextField employmentInterviewer2 = new JTextField(20);
    JTextField employmentInitialrole = new JTextField(20);
    JTextField employmentAnnualSal = new JTextField(20);
    JTextField employmentStartDate = new JTextField(20);

    JTextField salaryStartDate = new JTextField(20);
    JTextField salaryNewSalary = new JTextField(20);
    JTextField salaryNameText = new JTextField(20);
    JTextField probationNameText = new JTextField(20);
    JTextField probationStartDate = new JTextField(20);

    JTextField reviewName = new JTextField(20);
    JTextField probationEndDate = new JTextField(20);
    JTextField dateReview = new JTextField(20);
    JTextField newSalaryReview = new JTextField(20);
    JTextField promotionReview = new JTextField(20);
    JTextField ProbationReview = new JTextField(20);
    JTextField terminationReview = new JTextField(20);
    JTextField signedBy1 = new JTextField(20);
    JTextField signedBy2 = new JTextField(20);

    //Accessrights for user
    AccessRights userRights = null;

    /**
     * Create the frame for the GUI.
     */
    public GUI()

    {
        makeFrame();

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
        JPanel loggedIn = new JPanel(new GridLayout(25,30));

        /**
         * The layout of the frame
         */
        afterLoginFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        /**
         * Labels for the text fields
         */

        JLabel forenameLabel = new JLabel("Name: ");
        JLabel emailAddressLabel = new JLabel("E-mail: ");
        JLabel lastReviewLabel = new JLabel("Last Review: ");
        JLabel employeeRaiseRecommendationLabel = new JLabel("Raise Recommendation: ");
        JLabel employeeMobileLabel = new JLabel("Mobile Number: ");
        JLabel employeeHomeLabel = new JLabel("Homephone Number: ");
        JLabel employeeHomeAddressLabel = new JLabel("Home Address: ");
        JLabel employeeGenderLabel = new JLabel("Gender: ");
        JLabel employeePostcodeLabel = new JLabel("Postcode: ");

        /**
         * Labels for the text fields
         */

        JLabel surnameLabel = new JLabel("Surname: ");
        JLabel employeeNumberLabel = new JLabel("Employee Number: ");
        JLabel employeeBirthDateLabel = new JLabel("Date of birth: ");

        /**
         * adding the labels and fields to the panel called loggedIn
         */

        JButton back = new JButton("Back");

        loggedIn.add(employeeSearch);

        loggedIn.add(forenameLabel);
        loggedIn.add(employeeForename);

        loggedIn.add(surnameLabel);
        loggedIn.add(employeeSurname);

        loggedIn.add(employeeBirthDateLabel);
        loggedIn.add(employeeBirthDate);

        loggedIn.add(lastReviewLabel);
        loggedIn.add(employeeLastReview);

        loggedIn.add(emailAddressLabel);
        loggedIn.add(employeeEmailAddress);

        loggedIn.add(employeeMobileLabel);
        loggedIn.add(employeeMobile);

        loggedIn.add(employeeHomeLabel);
        loggedIn.add(employeeHomephone);

        loggedIn.add(employeeHomeAddressLabel);
        loggedIn.add(employeeHomeAddress);

        loggedIn.add(employeeGenderLabel);
        loggedIn.add(employeeGender);

        loggedIn.add(employeePostcodeLabel);
        loggedIn.add(employeePostcode);

        loggedIn.add(back);

        /**
         * Disabling editing on some of the textfields
         */

        employeeSearch.setText("Replace and type to search");

        /**
         * Setting the size and postion of the frame
         */

        afterLoginFrame.setSize(300, 700);
        afterLoginFrame.setVisible(true);
        afterLoginFrame.getContentPane().add(loggedIn);
        afterLoginFrame.setResizable(false);
        afterLoginFrame.setLocationRelativeTo(null);
        /**
         * Checkes the username and refuses entery to the system if it is wrong.
         * 
         */

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    afterLoginFrame.setVisible(false);
                }
            });

    }

    protected void employmentDetails()
    {
        JFrame employmentDetails = new JFrame("Yuconz Employee System");
        JPanel employmentD = new JPanel(new GridLayout(25,15));
        employmentDetails.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel eInterviewer1 = new JLabel("Employee Interviewer1: ");
        JLabel eInterviewer2 = new JLabel("Employee Interviewer2: ");
        JLabel role = new JLabel("Initial Role: ");
        JLabel annualSalary = new JLabel("Annual Salary: ");
        JLabel srtDate = new JLabel("Start Date: ");

        JButton open = new JButton("Open file");

        JButton back = new JButton("Back");

        employeeSearch.setText("Replace and type to search");
        employmentD.add(employeeSearch);
        employmentD.add(employmentInterviewer1);

        employmentD.add(employmentInterviewer2);
        employmentD.add(role);
        employmentD.add(employmentInitialrole);

        employmentD.add(annualSalary);
        employmentD.add(employmentAnnualSal);

        employmentD.add(srtDate);
        employmentD.add(employmentStartDate);

        employmentD.add(open);
        employmentD.add(back);
        employmentDetails.setSize(300, 700);
        employmentDetails.setVisible(true);
        employmentDetails.getContentPane().add(employmentD);
        employmentDetails.setResizable(false);
        employmentDetails.setLocationRelativeTo(null);

        open.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    try {
                        Runtime.getRuntime().exec("explorer.exe C:\\Users");
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

    protected void salaryIncrease()
    {
        JFrame employmentSalary = new JFrame("Yuconz Employee System");
        JPanel employmentS = new JPanel(new GridLayout(25,15));
        employmentSalary.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel eName = new JLabel("Employee Name: ");

        JLabel srtDate = new JLabel("Start Date: ");

        JLabel newAnnualSalary = new JLabel("New Annual Salary: ");

        JButton back = new JButton("Back");
        employeeSearch.setText("Replace and type to search");
        employmentS.add(employeeSearch);
        employmentS.add(eName);
        employmentS.add(salaryNameText);

        employmentS.add(srtDate);
        employmentS.add(salaryStartDate);

        employmentS.add(newAnnualSalary);
        employmentS.add(salaryNewSalary);

        employmentS.add(back);

        employmentSalary.setSize(300, 700);
        employmentSalary.setVisible(true);
        employmentSalary.getContentPane().add(employmentS);
        employmentSalary.setResizable(false);
        employmentSalary.setLocationRelativeTo(null);

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    employmentSalary.setVisible(false);
                }
            });

    }

    protected void annualreviews()
    {
        JFrame annualReviews = new JFrame("Yuconz Employee System");
        JPanel annualReviewsp = new JPanel(new GridLayout(25,15));
        annualReviews.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel eName = new JLabel("Employee Name: ");

        JLabel signed = new JLabel("Signed by: ");

        JLabel date = new JLabel("Date: ");

        JLabel startDate = new JLabel("Start Date: ");

        JLabel newAnnualSalaryReview = new JLabel("New Annual Salary: ");

        JLabel newPromotionReview = new JLabel("Promotion: ");

        JLabel newProbationReview = new JLabel("Probation: ");

        JLabel newTerminationReview = new JLabel("Termination: ");

        JButton back = new JButton("Back");
        employeeSearch.setText("Replace and type to search");

        annualReviewsp.add(employeeSearch);

        annualReviewsp.add(eName);
        annualReviewsp.add(reviewName);

        annualReviewsp.add(date);
        annualReviewsp.add(dateReview);

        annualReviewsp.add(newAnnualSalaryReview);
        annualReviewsp.add(salaryNewSalary);

        annualReviewsp.add(newPromotionReview);
        annualReviewsp.add(promotionReview);

        annualReviewsp.add(newProbationReview);
        annualReviewsp.add(ProbationReview);

        annualReviewsp.add(newTerminationReview);
        annualReviewsp.add(terminationReview);

        annualReviewsp.add(date);
        annualReviewsp.add(dateReview);

        annualReviewsp.add(signed);
        annualReviewsp.add(signedBy1);
        annualReviewsp.add(signedBy2);

        annualReviewsp.add(back);
        annualReviews.setSize(300, 700);
        annualReviews.setVisible(true);
        annualReviews.getContentPane().add(annualReviewsp);
        annualReviews.setResizable(false);
        annualReviews.setLocationRelativeTo(null);

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    annualReviews.setVisible(false);
                }
            });

    }

    protected void promotion()
    {
        JFrame promotion = new JFrame("Yuconz Employee System");
        JPanel promotionS = new JPanel(new GridLayout(25,15));
        promotion.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel eName = new JLabel("Employee Name: ");

        JLabel srtDate = new JLabel("Start Date: ");

        JLabel newAnnualSalary = new JLabel("New Annual Salary: ");

        JLabel newRole = new JLabel("New Role: ");

        JButton back = new JButton("Back");

        employeeSearch.setText("Replace and type to search");

        promotionS.add(employeeSearch);

        promotionS.add(eName);
        promotionS.add(promotionNameText);

        promotionS.add(srtDate);
        promotionS.add(promotionStartDate);

        promotionS.add(newAnnualSalary);
        promotionS.add(promotionSalary);

        promotionS.add(newRole);
        promotionS.add(promotionRole);

        promotionS.add(back);

        promotion.setSize(300, 700);
        promotion.setVisible(true);
        promotion.getContentPane().add(promotionS);
        promotion.setResizable(false);
        promotion.setLocationRelativeTo(null);

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    promotion.setVisible(false);
                }
            });

    }

    protected void Termination()
    {
        JFrame termination = new JFrame("Yuconz Employee System");
        JPanel terminationP = new JPanel(new GridLayout(25,15));
        termination.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel eName = new JLabel("Employee Name: ");

        JLabel reason = new JLabel("Reason for Termination: ");

        JLabel endDate = new JLabel("End Date: ");

        JButton back = new JButton("Back");
        employeeSearch.setText("Replace and type to search");

        terminationP.add(employeeSearch);
        terminationP.add(eName);
        terminationP.add(probationNameText);

        terminationP.add(reason);
        terminationP.add(probationStartDate);

        terminationP.add(endDate);
        terminationP.add(probationEndDate);

        terminationP.add(back);
        termination.setSize(300, 700);
        termination.setVisible(true);
        termination.getContentPane().add(terminationP);
        termination.setResizable(false);
        termination.setLocationRelativeTo(null);

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    termination.setVisible(false);
                }
            });

    }

    protected void Probation()
    {
        JFrame probation = new JFrame("Yuconz Employee System");
        JPanel probationP = new JPanel(new GridLayout(25,15));
        probation.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel eName = new JLabel("Employee Name: ");

        JLabel srtDate = new JLabel("Start Date: ");

        JLabel endDate = new JLabel("End Date: ");

        JButton back = new JButton("Back");
        employeeSearch.setText("Replace and type to search");

        probationP.add(employeeSearch);
        probationP.add(eName);
        probationP.add(probationNameText);

        probationP.add(srtDate);
        probationP.add(probationStartDate);

        probationP.add(endDate);
        probationP.add(probationEndDate);

        probationP.add(back);
        probation.setSize(300, 700);
        probation.setVisible(true);
        probation.getContentPane().add(probationP);
        probation.setResizable(false);
        probation.setLocationRelativeTo(null);

        back.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 
                    chooseFrame();
                    probation.setVisible(false);
                }
            });

    }

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

        personalButton.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    afterLoginFrame();
                    chooseFrame.setVisible(false);
                }
            });

        employmenDetails.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    employmentDetails();
                    chooseFrame.setVisible(false);

                }
            });
        salaryIncrease.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    salaryIncrease();
                    chooseFrame.setVisible(false);
                }
            });
        promotionRecords.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    promotion();
                    chooseFrame.setVisible(false);
                }
            });

        probationRecords.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    Probation();
                    chooseFrame.setVisible(false);
                }
            });

        terminationRecords.addActionListener(new ActionListener() 
            {

                public void actionPerformed(ActionEvent e) 
                { 

                    Termination();
                    chooseFrame.setVisible(false);
                }
            });

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
        usernameField = new JTextField();
        passwordField = new JPasswordField();
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
                            isEditable();

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
        employeeForename.setEditable(false);
        employeeSurname.setEditable(false);  
        employeeBirthDate.setEditable(false);
        employeeLastReview.setEditable(false);
        employeeEmailAddress.setEditable(false);  
        employeeMobile.setEditable(false);
        employeeHomephone.setEditable(false);
        employeeHomeAddress.setEditable(false);
        employeeGender.setEditable(false);
        employeePostcode.setEditable(false);

        promotionStartDate.setEditable(false);
        promotionSalary.setEditable(false);
        promotionNameText.setEditable(false);
        promotionRole.setEditable(false);

        employmentCV.setEditable(false);
        employmentInterviewer1.setEditable(false);
        employmentInterviewer2.setEditable(false);
        employmentInitialrole.setEditable(false);
        employmentAnnualSal.setEditable(false);
        employmentStartDate.setEditable(false);

        salaryStartDate.setEditable(false);
        salaryNewSalary.setEditable(false);
        salaryNameText.setEditable(false);

        promotionStartDate.setEditable(false);
        promotionSalary.setEditable(false);
        promotionNameText.setEditable(false);
        promotionRole.setEditable(false);

        probationNameText.setEditable(false);
        probationStartDate.setEditable(false);
        probationEndDate.setEditable(false);

        probationEndDate.setEditable(false);
        dateReview.setEditable(false);
        salaryNewSalary.setEditable(false);
        promotionReview.setEditable(false);
        ProbationReview.setEditable(false);
        terminationReview.setEditable(false);
        signedBy1.setEditable(false);
        signedBy2.setEditable(false);

    }

    public void isEditable()
    {
        employeeForename.setEditable(true);
        employeeSurname.setEditable(true);  
        employeeBirthDate.setEditable(true);
        employeeLastReview.setEditable(true);
        employeeEmailAddress.setEditable(true);  
        employeeMobile.setEditable(true);
        employeeHomephone.setEditable(true);
        employeeHomeAddress.setEditable(true);
        employeeGender.setEditable(true);
        employeePostcode.setEditable(true);

        promotionStartDate.setEditable(true);
        promotionSalary.setEditable(true);
        promotionNameText.setEditable(true);
        promotionRole.setEditable(true);

        employmentCV.setEditable(true);
        employmentInterviewer1.setEditable(true);
        employmentInterviewer2.setEditable(true);
        employmentInitialrole.setEditable(true);
        employmentAnnualSal.setEditable(true);
        employmentStartDate.setEditable(true);

        salaryStartDate.setEditable(true);
        salaryNewSalary.setEditable(true);
        salaryNameText.setEditable(true);

        promotionStartDate.setEditable(true);
        promotionSalary.setEditable(true);
        promotionNameText.setEditable(true);
        promotionRole.setEditable(true);

        probationNameText.setEditable(true);
        probationStartDate.setEditable(true);
        probationEndDate.setEditable(true);

        probationEndDate.setEditable(true);
        dateReview.setEditable(true);
        salaryNewSalary.setEditable(true);
        promotionReview.setEditable(true);
        ProbationReview.setEditable(true);
        terminationReview.setEditable(true);
        signedBy1.setEditable(true);
        signedBy2.setEditable(true);

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

                                                                                                                                