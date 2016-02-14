

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InterfaceBackendTest.
 *
 * @author  (Gavin Porter)
 * @version (1.4)
 */
public class InterfaceBackendTest
{
    /**
     * Default constructor for test class InterfaceBackendTest
     */
    public InterfaceBackendTest()
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
    /**
     * Check that the gui is not null
     */
    public void guiTest()
    {
        GUI gUI2 = new GUI();
        InterfaceBackend interfac1 = new InterfaceBackend(gUI2); 
        assertNotNull(interfac1.gui());
       
    }
}

