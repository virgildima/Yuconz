

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
    
    AnnualReviewDocument arDoc = null;
    InitialEmploymentDocument ieDoc = null;
    PersonalDetailsDocument pdDoc = null;
    ProbationDocument prDoc = null;
    PromotionDocument pmDoc = null;
    
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
        
        arDoc = TestData.defaultTestDoc(AnnualReviewDocument.class);
        ieDoc = TestData.defaultTestDoc(InitialEmploymentDocument.class);
        pdDoc = TestData.defaultTestDoc(PersonalDetailsDocument.class);
        prDoc = TestData.defaultTestDoc(ProbationDocument.class);
        pmDoc = TestData.defaultTestDoc(PromotionDocument.class);
        
    }
    
    @Test
    public void setupCorrect()
    {
        System.out.println("Test: setupCorrect");
        assertTrue("Not Viable",db.isViable());
    }
    
    
    /**
     * Annual Review Document
     */
    @Test
    public void addARDocument()
    {
        System.out.println("Test: addARDocument");
        assertTrue("Did not add",db.addDocument(arDoc));
    }
    @Test
    public void getARDocument()
    {
        System.out.println("Test: getARDocument");
        db.addDocument(arDoc);
        AnnualReviewDocument fromDB = db.getDocument("123457",AnnualReviewDocument.class);
        assertTrue("Added AR_Document did not match",fromDB.equals(arDoc));
    }
    @Test
    public void updateARDocument()
    {
        System.out.println("Test: updateARDocument");
        db.addDocument(arDoc);
        arDoc.setValue("section","SomeOtherSection");
        db.updateDocument(arDoc);
        AnnualReviewDocument fromDB = db.getDocument("123457",AnnualReviewDocument.class);
        assertTrue("Updated AR_Document did not match",fromDB.equals(arDoc));
    }
    
    /**
     * Initial Employment Document
     */
    @Test
    public void addIEDocument()
    {
        System.out.println("Test: addIEDocument");
        assertTrue("Did not add",db.addDocument(ieDoc));
    }
    @Test
    public void getIEDocument()
    {
        System.out.println("Test: getIEDocument");
        db.addDocument(ieDoc);
        InitialEmploymentDocument fromDB = db.getDocument("123456",InitialEmploymentDocument.class);
        assertTrue("Added IE_Document did not match",fromDB.equals(ieDoc));
    }
    @Test
    public void updateIEDocument()
    {
        System.out.println("Test: updateIEDocument");
        db.addDocument(ieDoc);
        ieDoc.setValue("section","SomeOtherSection");
        db.updateDocument(ieDoc);
        InitialEmploymentDocument fromDB = db.getDocument("123456",InitialEmploymentDocument.class);
        assertTrue("Updated IE_Document did not match",fromDB.equals(ieDoc));
    }
    
    /**
     * Personal Details Document
     */
    @Test
    public void addPDDocument()
    {
        System.out.println("Test: addPDDocument");
        assertTrue("Did not add",db.addDocument(pdDoc));
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
     * Probation Document
     */
    @Test
    public void addPRDocument()
    {
        System.out.println("Test: addPRDocument");
        assertTrue("Did not add",db.addDocument(prDoc));
    }
    @Test
    public void getPRDocument()
    {
        System.out.println("Test: getPRDocument");
        assertTrue("Did not add",db.addDocument(prDoc));
        ProbationDocument fromDB = db.getDocument("123457",ProbationDocument.class);
        assertTrue("Added PR_Document did not match",fromDB.equals(prDoc));
    }
    @Test
    public void updatePRDocument()
    {
        System.out.println("Test: updatePRDocument");
        assertTrue("Did not add",db.addDocument(prDoc));
        prDoc.setValue("probation_end_date","14/03/2015");
        db.updateDocument(prDoc);
        ProbationDocument fromDB = db.getDocument("123457",ProbationDocument.class);
        assertTrue("Updated PR_Document did not match",fromDB.equals(prDoc));
    }
    
    /**
     * Probation Document
     */
    @Test
    public void addPMDocument()
    {
        System.out.println("Test: addPMDocument");
        assertTrue("Did not add",db.addDocument(pmDoc));
    }
    @Test
    public void getPMDocument()
    {
        System.out.println("Test: getPMDocument");
        assertTrue("Did not add",db.addDocument(pmDoc));
        PromotionDocument fromDB = db.getDocument("123456",PromotionDocument.class);
        assertTrue("Added PM_Document did not match",fromDB.equals(pmDoc));
    }
    @Test
    public void updatePMDocument()
    {
        System.out.println("Test: updatePMDocument");
        assertTrue("Did not add",db.addDocument(pmDoc));
        pmDoc.setValue("new_job_title","Other Manager");
        db.updateDocument(pmDoc);
        PromotionDocument fromDB = db.getDocument("123456",PromotionDocument.class);
        assertTrue("Updated PM_Document did not match",fromDB.equals(pmDoc));
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
