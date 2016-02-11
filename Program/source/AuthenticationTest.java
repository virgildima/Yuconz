
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
    @Test
    public void addUser()
    {
        assertTrue("Did not add",au.addNewUser("123457","passwordsShouldBeHashedBeforeGoingInHere",AccessRights.Basic_User,Department.HR,"Smith","John"));
    }
    @Test
    public void login()
    {
        assertTrue("Could not log in",au.login("123457","passwordsShouldBeHashedBeforeGoingInHere",AccessRights.Basic_User));
    }
    @Test
    public void logout()
    {
        au.login("123457","passwordsShouldBeHashedBeforeGoingInHere",AccessRights.Basic_User);
        assertTrue("Did not log out",au.logout());
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        
        Authentication.deleteDB();
    }
}
