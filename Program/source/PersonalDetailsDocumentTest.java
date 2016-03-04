

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PersonalDetailsDocumentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonalDetailsDocumentTest
{
    PersonalDetailsDocument pdDoc = null;
    /**
     * Default constructor for test class PersonalDetailsDocumentTest
     */
    public PersonalDetailsDocumentTest()
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
        pdDoc = new PersonalDetailsDocument();
        
        pdDoc.setValue("staffID","123456");
        pdDoc.setValue("firstname","John");
        pdDoc.setValue("surname","Doe");
        pdDoc.setValue("DOB","21/12/1990");
        pdDoc.setValue("address_1","1 Road Ln");
        pdDoc.setValue("address_2","Somewhere");
        pdDoc.setValue("town","Canterbury");
        pdDoc.setValue("county","Kent");
        pdDoc.setValue("postcode","CT2 7NR");
        pdDoc.setValue("telephone","01234567890");
        pdDoc.setValue("mobile","07734567890");
        pdDoc.setValue("next_of_kin","James Doe");
        pdDoc.setValue("next_of_kin_CN","01234567899");
        
    }
    
    @Test
    public void equals()
    {
        PersonalDetailsDocument doc = pdDoc;
        assertTrue("Not Equal",pdDoc.equals(doc));
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
