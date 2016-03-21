

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DatabaseTest.
 *
 * @dbthor  (your name)
 * @version (a version number or a date)
 */
public class DatabaseTest
{
    Database db = null;
    
    PersonalDetailsDocument pdDoc = null;
    
    /**
     * Defdblt constructor for test class DatabaseTest
     */
    public DatabaseTest()
    {
        System.out.println("Starting db Tests");
        db = new Database();
        System.out.println("    db created");
        db.deleteAll();
        System.out.println("    db deleted");
        db.close();
        System.out.println("    db closed");
        db = null;
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        System.out.println("Setting up db");
        db = new Database();
        System.out.println("    db created");
        
        pdDoc = TestData.defaultTestDoc(PersonalDetailsDocument.class);
        
    }
    
    @Test
    public void setupCorrect()
    {
        System.out.println("Test: setupCorrect");
        assertTrue("Not Viable",db.isViable());
    }
    @Test
    public void addPDDocument()
    {
        System.out.println("Test: addPDDocument");
        assertTrue("Did not add",db.addDocument(pdDoc));
        System.out.println("Test: addPDDocument 1");
        PersonalDetailsDocument fromDB = db.getDocument("123456",PersonalDetailsDocument.class);
        System.out.println("Test: addPDDocument 2");
        assertTrue("Added PD_Document did not match",fromDB.equals(pdDoc));
        System.out.println("Test: addPDDocument 3");
    }
    @Test
    public void getPDDocument()
    {
        System.out.println("Test: getPDDocument");
        db.addDocument(pdDoc);
        PersonalDetailsDocument fromDB = db.getDocument("123456",PersonalDetailsDocument.class);
        assertTrue("Added PD_Document did not match",fromDB.equals(pdDoc));
    }
    @Test
    public void updatePDDocument()
    {
        System.out.println("Test: updatePDDocument");
        db.addDocument(pdDoc);
        pdDoc.setValue("mobile","07734567895");
        db.updateDocument(pdDoc);
        PersonalDetailsDocument fromDB = db.getDocument("123456",PersonalDetailsDocument.class);
        assertTrue("Updated PD_Document did not match",fromDB.equals(pdDoc));
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        db.deleteAll();
        System.out.println("    db deleted");
        db.close();
        System.out.println("    db closed");
        pdDoc = null;
    }
}
