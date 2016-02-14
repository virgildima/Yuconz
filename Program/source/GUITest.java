
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
    private GUI gUI1;

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
        gUI1 = new GUI();

    }

    @Test
    public void testUI()
    {
        gUI1.afterLoginFrame();
        gUI1.makeFrame();

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
    /**
     * Tests using a password which is less than a length of 6 or more than.
     */
    public void passwordNullIfNotLength6()
    {
        InterfaceBackend interfac1 = new InterfaceBackend(gUI1);
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
        InterfaceBackend interfac1 = new InterfaceBackend(gUI1);
        java.lang.String string1 = interfac1.passwordSHA512("123456");
        assertNotNull(string1);

    }
    @Test
    public void MenuBarTest()
    {
        InterfaceBackend interfac1 = new InterfaceBackend(gUI1);
        interfac1.about();
        interfac1.help();

    }
}

