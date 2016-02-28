

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
    public void setupCorrect()
    {
        System.out.println("Test: setupCorrect");
        assertTrue("Not Viable",db.isViable());
    }
    @Test
    public void addPDDocument()
    {
        System.out.println("Test: addPDDocument");
        assertTrue("Did not add",db.addPersonalDetailsDocument(pdDoc));
        //assertTrue("Added PD_Document did not match",db.getPersonalDetailsDocument("123456").getData().equals(pdDoc.getData()));
    }
    @Test
    public void updateDocument()
    {
        System.out.println("Test: updateDocument");
        
        assertTrue("Did not update",db.updatePersonalDetailsDocument(pdDoc));
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
