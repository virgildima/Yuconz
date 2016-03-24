

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DocumentCTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DocumentCTest
{
    DocumentC doc = null;
    /**
     * Default constructor for test class DocumentCTest
     */
    public DocumentCTest()
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
        doc = TestData.defaultTestDoc(DocType.PersonalDetails);
    }
    
    @Test
    public void equals()
    {
        DocumentC otherDoc = TestData.defaultTestDoc(DocType.PersonalDetails);
        assertTrue("Not Equal",doc.equals(otherDoc));
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
