import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.applet.Applet;

/**
 *
 * @author  (Gavin Porter)
 * @version (1.0)
 */

public class GUI
{
    protected JFrame frame;
    protected JFrame afterLoginFrame;

    private JButton loginButton;

    private Container content;
    private Container tContent;

    public JTextField usernameField;
    public JPasswordField passwordField;

   

    public GUI()
    {
        makeFrame();
        InterfaceBackend UI = new InterfaceBackend(GUI.this);

    }

    protected void afterLoginFrame()
    {

        JFrame afterLoginFrame = new JFrame("Yuconz Employee System");
        JPanel loggedIn = new JPanel(new GridLayout(15,15));
        afterLoginFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel forenameLabel = new JLabel("Name: ");
        JLabel suspendedLabel = new JLabel("Suspended: ");
        JLabel lastReviewLabel = new JLabel("Last Review: ");
        JLabel employeeRaiseRecommendationLabel = new JLabel("Raise Recommendation: ");
        JLabel employeeFiredLabel = new JLabel("Fired: ");

        JTextField employeeSearch = new JTextField(20);
        JTextField employeeForename = new JTextField(20);
        JTextField employeeSurname = new JTextField(20);
        JTextField employeeLastReview = new JTextField(20);
        JTextField employeeRaiseRecommendation = new JTextField(20);
        JTextField employeeSuspended = new JTextField(20);
        JTextField employeeFired = new JTextField(20);
        JTextField employeeBirthDate = new JTextField(20);

        JLabel surnameLabel = new JLabel("Surname: ");
        JLabel employeeNumberLabel = new JLabel("Employee Number: ");
        JLabel employeeBirthDateLabel = new JLabel("Date of birth: ");

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

        employeeSearch.setText("Replace and type to search");
        employeeForename.setEditable(false);
        employeeSurname.setEditable(false);  
        employeeBirthDate.setEditable(false);
        employeeLastReview.setEditable(false);
        employeeSuspended.setEditable(false);  
        employeeFired.setEditable(false);

        afterLoginFrame.setSize(1000, 500);
        afterLoginFrame.setVisible(true);
        afterLoginFrame.getContentPane().add(loggedIn);
        afterLoginFrame.setResizable(false);
        afterLoginFrame.setLocationRelativeTo(null);

    }

    /**
     * 
     * 
     * 
     */
    protected void makeFrame()
    {
        frame = new JFrame("Login");

        JPanel ptext = new JPanel();
        ptext.setLayout(new GridLayout(3,3));

        Dimension textDimension = new Dimension(140, 21);
        usernameField = new JTextField();
        usernameField.setPreferredSize(textDimension);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(textDimension);

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");

        JButton loginButton = new JButton("Login");

        ptext.add(usernameLabel);
        ptext.add(usernameField);
        ptext.add(passwordLabel);
        ptext.add(passwordField);
        ptext.add(loginButton);

        actionListeners(frame);
        frame.setVisible(true);
        frame.getContentPane().add(ptext);
        frame.setResizable(false);

        frame.pack();
        frame.setLocationRelativeTo(null);
        
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
     * 
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