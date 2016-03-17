import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.applet.Applet;
import java.util.*;
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
     * The button used to login to the system.
     */

    protected JButton loginButto;

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
        JPanel loggedIn = new JPanel(new GridLayout(25,15));

        /**
         * The layout of the frame
         */
        afterLoginFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

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

        /**
         * Disabling editing on some of the textfields
         */

        employeeSearch.setText("Replace and type to search");

        /**
         * Setting the size and postion of the frame
         */

        afterLoginFrame.setSize(1000, 500);
        afterLoginFrame.setVisible(true);
        afterLoginFrame.getContentPane().add(loggedIn);
        afterLoginFrame.setResizable(false);
        afterLoginFrame.setLocationRelativeTo(null);
        /**
         * Checkes the username and refuses entery to the system if it is wrong.
         */

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
        

        JComboBox rights = new JComboBox(AccessRights.values());
        rights.setMaximumRowCount(5);
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

                   
                    
                    String passHash = ib.passwordSHA512(String.valueOf( passwordField.getPassword()));

                    if(auth.login(usernameField.getText(), passHash , AccessRights.Basic_User))
                    {
                        successfulLogin();
                        afterLoginFrame();
                        
                        notEditable();
                    }
                    else if(auth.login(usernameField.getText(), passHash ,  AccessRights.Manager))
                    {
                        successfulLogin();
                        afterLoginFrame();

                       isEditable();
                    }
                    else if(auth.login(usernameField.getText(), passHash , AccessRights.SeniorManager))
                    {
                        successfulLogin();
                        afterLoginFrame();

                        isEditable();
                    }
                    else if(auth.login(usernameField.getText(), passHash , AccessRights.Director))
                    {
                        successfulLogin();
                        afterLoginFrame();

                        isEditable();
                    }
                    else if(auth.login(usernameField.getText(), passHash , AccessRights.HR_User))
                    {
                        successfulLogin();
                        afterLoginFrame();

                        isEditable();
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