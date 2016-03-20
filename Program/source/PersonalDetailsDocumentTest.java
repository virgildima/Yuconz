

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
        pdDoc = makeNew();
    }
    
    private PersonalDetailsDocument makeNew()
    {
        PersonalDetailsDocument doc = new PersonalDetailsDocument();
        
        doc.setValue("staffID","123456");
        doc.setValue("firstname","John");
        doc.setValue("surname","Doe");
        doc.setValue("DOB","21/12/1990");
        doc.setValue("address_1","1 Road Ln");
        doc.setValue("address_2","Somewhere");
        doc.setValue("town","Canterbury");
        doc.setValue("county","Kent");
        doc.setValue("postcode","CT2 7NR");
        doc.setValue("telephone","01234567890");
        doc.setValue("mobile","07734567890");
        doc.setValue("next_of_kin","James Doe");
        doc.setValue("next_of_kin_CN","01234567899");
        
        return doc;
    }
    
    @Test
    public void equals()
    {
        PersonalDetailsDocument doc = makeNew();
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
