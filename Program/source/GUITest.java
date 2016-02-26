import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The test class GUITest.
 *
 * @author  (Gavin Porter)
 * @version (1.4)
 */
public class GUITest
{

   
    GUI gui = new GUI();
    Authentication auth = new Authentication();

    /**
     * Default constructor for test class GUITest
     */
    public GUITest()
    {

    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
       
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {

    }

    @Test
    public void test()
    {
        
        InterfaceBackend interfac2 = new InterfaceBackend();
        java.lang.String string2 = interfac2.passwordSHA512("123456");
        gui.passwordField.setText(string2);
        gui.usernameField.setText("1234567");
 
        InterfaceBackend ib = new InterfaceBackend();
        AccessRights access = AccessRights.Basic_User;
        
       
            if(auth.login(gui.usernameField.getText() ,string2 , access))
            {

                JOptionPane.showMessageDialog(gui.frame,
                    "Logged in",
                    "User Details Accepted.", 
                    JOptionPane.INFORMATION_MESSAGE);
                gui.frame.setVisible(false);
                gui.frame.dispose();
                gui.afterLoginFrame();
                System.out.println("Successful login");

            }
        
        else
        {
            JOptionPane.showMessageDialog(gui.frame,
                "Incorrect Login Details",
                "User details are incorrect.", 
                JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Login not successful");
        }
    }

    @Test
    /**
     * Tests using a password which is less than a length of 6 or more than.
     */
    public void passwordNullIfNotLength6()
    {
        InterfaceBackend interfac1 = new InterfaceBackend();
        assertEquals(null, interfac1.passwordSHA512("1"));
        assertEquals(null, interfac1.passwordSHA512("1234567"));
    }

    @Test
    /**
     * Test a password which is 6 in length and see if it is accepted.
     * and its not null
     */
    public void passwordAcceptedIfLength6()
    {
        InterfaceBackend interfac1 = new InterfaceBackend();
        java.lang.String string1 = interfac1.passwordSHA512("123456");
        assertNotNull(string1);

    }
}

