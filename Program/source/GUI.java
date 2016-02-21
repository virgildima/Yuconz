import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.applet.Applet;

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

    protected JButton loginButton;

    /**
     * The username field and the password field to login the system.
     */
    public JTextField usernameField;
    public JPasswordField passwordField;

    /**
     * Create the frame for the GUI.
     */
    public GUI()

    {
        makeFrame();
        InterfaceBackend UI = new InterfaceBackend(GUI.this);

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
        JPanel loggedIn = new JPanel(new GridLayout(15,15));

        /**
         * The layout of the frame
         */
        afterLoginFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        /**
         * Labels for the text fields
         */

        JLabel forenameLabel = new JLabel("Name: ");
        JLabel suspendedLabel = new JLabel("Suspended: ");
        JLabel lastReviewLabel = new JLabel("Last Review: ");
        JLabel employeeRaiseRecommendationLabel = new JLabel("Raise Recommendation: ");
        JLabel employeeFiredLabel = new JLabel("Fired: ");

        /**
         * Textfields
         */

        JTextField employeeSearch = new JTextField(20);
        JTextField employeeForename = new JTextField(20);
        JTextField employeeSurname = new JTextField(20);
        JTextField employeeLastReview = new JTextField(20);
        JTextField employeeRaiseRecommendation = new JTextField(20);
        JTextField employeeSuspended = new JTextField(20);
        JTextField employeeFired = new JTextField(20);
        JTextField employeeBirthDate = new JTextField(20);

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
        loggedIn.add(suspendedLabel);
        loggedIn.add(employeeSuspended);
        loggedIn.add(employeeFiredLabel);
        loggedIn.add(employeeFired);

        /**
         * Disabling editing on some of the textfields
         */

        employeeSearch.setText("Replace and type to search");
        employeeForename.setEditable(false);
        employeeSurname.setEditable(false);  
        employeeBirthDate.setEditable(false);
        employeeLastReview.setEditable(false);
        employeeSuspended.setEditable(false);  
        employeeFired.setEditable(false);

        /**
         * Setting the size and postion of the frame
         */

        afterLoginFrame.setSize(1000, 500);
        afterLoginFrame.setVisible(true);
        afterLoginFrame.getContentPane().add(loggedIn);
        afterLoginFrame.setResizable(false);
        afterLoginFrame.setLocationRelativeTo(null);

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
         * The creation and display of the frame
         */

        actionListeners(frame);
        frame.setVisible(true);
        frame.getContentPane().add(ptext);
        frame.setResizable(false);

        frame.pack();
        frame.setLocationRelativeTo(null);
        
        /**
         * Checkes the username and refuses entery to teh system if it is wrong.
         */

        loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { 
                    //&& passwordString.equals(passwordField.getPassword())
                    if(usernameField.getText().equals("username"))
                    {
                        JOptionPane.showMessageDialog(frame,
                            "Logged in",
                            "User Details Accepted.", 
                            JOptionPane.INFORMATION_MESSAGE);
                        frame.setVisible(false);
                        frame.dispose();
                        afterLoginFrame();
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(frame,
                            "Incorrect Login Details",
                            "User details are incorrect.", 
                            JOptionPane.INFORMATION_MESSAGE);
                    } }
            });

    }

    /**
     * Referencing to methods in the interfacebackend class
     * 
     */

    public void actionListeners(JFrame frame)
    {
        InterfaceBackend ib = new InterfaceBackend(GUI.this);

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