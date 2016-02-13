import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.applet.Applet;
import java.util.Arrays;


/**
 *
 * @author  (Gavin Porter)
 * @version (1.0)
 */

public class GUI
{
    private JFrame frame;
    private JFrame afterLoginFrame;
    /**
     * These are buttons which are used in this class with action listeners so the player can click on the answer they want.
     */
    private JButton loginButton;

    private Container content;
    private Container tContent;

    public JTextField usernameField;
    public JPasswordField passwordField;
    char[] passArray = new char[] {'1'};
    public String passwordString;

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
    private void makeFrame()
    {
        GUI gui = new GUI();
        InterfaceBackend ib = new InterfaceBackend(gui);

        JPanel ptext = new JPanel();
        ptext.setLayout(new GridLayout(3,3));

        frame = new JFrame("Login");
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

        menuBar(frame);
        frame.setVisible(true);
        frame.getContentPane().add(ptext);
        frame.setResizable(false);

        frame.pack();
        frame.setLocationRelativeTo(null);

        loginButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) { ib.checkPasswordUsername(); }
            });
    }

    /**
     * 
     * 
     */

    public void menuBar(JFrame frame)
    {
        GUI gui = new GUI();
        InterfaceBackend ib = new InterfaceBackend(gui);

        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

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
