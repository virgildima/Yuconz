
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestDataTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestDataTest
{
    /**
     * Default constructor for test class TestDataTest
     */
    public TestDataTest()
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
    
    @Test
    public void annualReview()
    {
        assertTrue("Could not create Annual Review Document",null != TestData.defaultTestDoc(DocType.AnnualReview));
    }
    @Test
    public void initialEmployment()
    {
        assertTrue("Could not create Initial Employment Document",null != TestData.defaultTestDoc(DocType.InitialEmployment));
    }
    @Test
    public void personal()
    {
        assertTrue("Could not create Personal Details Document",null != TestData.defaultTestDoc(DocType.PersonalDetails));
    }
    @Test
    public void probation()
    {
        assertTrue("Could not create Probation Document",null != TestData.defaultTestDoc(DocType.Probation));
    }
    @Test
    public void promotion()
    {
        assertTrue("Could not create Promotion Document",null != TestData.defaultTestDoc(DocType.Promotion));
    }
    @Test
    public void salaryIncrease()
    {
        assertTrue("Could not create Salary Increase Document",null != TestData.defaultTestDoc(DocType.SalaryIncrease));
    }
    @Test
    public void termination()
    {
        assertTrue("Could not create Termination Document",null != TestData.defaultTestDoc(DocType.Termination));
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
