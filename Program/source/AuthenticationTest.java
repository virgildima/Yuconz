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
    Authentication au = null;
    
    /**
     * Default constructor for test class AuthenticationTest
     */
    public AuthenticationTest()
    {
        System.out.println("1");
        System.out.println("Starting Authentication Tests");
        au = new Authentication();
        System.out.println("    au created");
        au.deleteAll();
        System.out.println("    au deleted");
        au.close();
        System.out.println("    au closed");
    }
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        System.out.println("2");
        System.out.println("Setting up au");
        au = new Authentication();
        System.out.println("    au created");
    }
    
    @Test
    public void setupCorrect()
    {
        System.out.println("3");
        System.out.println("Test: setupCorrect");
        assertTrue("Not Viable",au.isViable());
    }
    @Test
    public void addUser()
    {
        System.out.println("4");
        System.out.println("Test: addUser");
        assertTrue("Did not add",au.addNewUser("123457","passwordsShouldBeHashedBeforeGoingInHere",AccessRights.Basic_User,Department.HR,"Smith","John"));
    }
    @Test
    public void login()
    {
        System.out.println("5");
        System.out.println("Test: login");
        au.addNewUser("123457","passwordsShouldBeHashedBeforeGoingInHere",AccessRights.Basic_User,Department.HR,"Smith","John");
        assertTrue("Could not log in",      au.login("123457","passwordsShouldBeHashedBeforeGoingInHere",AccessRights.Basic_User)           );
    }
    @Test
    public void logout()
    {
        System.out.println("6");
        System.out.println("Test: logout");
        au.addNewUser("123457","passwordsShouldBeHashedBeforeGoingInHere",AccessRights.Basic_User,Department.HR,"Smith","John");
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
        System.out.println("7");
        au.deleteAll();
        System.out.println("    au deleted");
        au.close();
        System.out.println("    au closed");
    }
}
