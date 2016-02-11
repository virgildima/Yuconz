
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AuthenticationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AuthenticationTest
{
    /**
     * Default constructor for test class AuthenticationTest
     */
    public AuthenticationTest()
    {
    }
    Authentication au = null;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        Authentication.deleteDB();
        au = new Authentication();
    }
    
    @Test
    public void setupCorrect()
    {
        assertTrue("Not Viable",au.isViable());
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
}
