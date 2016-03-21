

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
        pdDoc = TestData.defaultTestDoc(PersonalDetailsDocument.class);
    }
    
    @Test
    public void equals()
    {
        PersonalDetailsDocument doc = TestData.defaultTestDoc(PersonalDetailsDocument.class);
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
