

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
    SalaryIncreaseDocument siDoc = null;
    TerminationDoument tmDoc = null;
    
    /**
     * Defdblt constructor for test class DatabaseTest
     */
    public DatabaseTest()
    {
        System.out.println("Starting db Tests");
        db = new Database();
        db.deleteAll();
        db.close();
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
        db = new Database();
    }
    
    @Test
    public void setupCorrect()
    {
        System.out.println("Test: setupCorrect");
        assertTrue("Not Viable",db.isViable());
    }
    
    @Test
    public void getAll()
    {
        System.out.println("Test: getAll");
        String[] results;
        assertTrue("Did not add AR",db.addDocument(TestData.defaultTestDoc(AnnualReviewDocument.class)));
        results = db.search(null,null,AnnualReviewDocument.class);
        assertTrue("AR_Document not listed",results.length==1 && results[0].equals("123457"));
        assertTrue("Did not add IE",db.addDocument(TestData.defaultTestDoc(InitialEmploymentDocument.class)));
        results = db.search(null,null,InitialEmploymentDocument.class);
        assertTrue("IE_Document not listed",results.length==1 && results[0].equals("123456"));
        assertTrue("Did not add PD",db.addDocument(TestData.defaultTestDoc(PersonalDetailsDocument.class)));
        results = db.search(null,null,PersonalDetailsDocument.class);
        assertTrue("PD_Document not listed",results.length==1 && results[0].equals("123456"));
        assertTrue("Did not add PB",db.addDocument(TestData.defaultTestDoc(ProbationDocument.class)));
        results = db.search(null,null,ProbationDocument.class);
        assertTrue("PB_Document not listed",results.length==1 && results[0].equals("123457"));
        assertTrue("Did not add PM",db.addDocument(TestData.defaultTestDoc(PromotionDocument.class)));
        results = db.search(null,null,PromotionDocument.class);
        assertTrue("PM_Document not listed",results.length==1 && results[0].equals("123456"));
        assertTrue("Did not add SI",db.addDocument(TestData.defaultTestDoc(SalaryIncreaseDocument.class)));
        results = db.search(null,null,SalaryIncreaseDocument.class);
        assertTrue("SI_Document not listed",results.length==1 && results[0].equals("123456"));
        assertTrue("Did not add TD",db.addDocument(TestData.defaultTestDoc(TerminationDoument.class)));
        results = db.search(null,null,TerminationDoument.class);
        assertTrue("TD_Document not listed",results.length==1 && results[0].equals("123457"));
    }
    
    
    /**
     * Annual Review Document
     */
    @Test
    public void addARDocument()
    {
        arDoc = TestData.defaultTestDoc(AnnualReviewDocument.class);
        System.out.println("Test: addARDocument");
        assertTrue("Did not add",db.addDocument(arDoc));
    }
    @Test
    public void getARDocument()
    {
        arDoc = TestData.defaultTestDoc(AnnualReviewDocument.class);
        System.out.println("Test: getARDocument");
        db.addDocument(arDoc);
        AnnualReviewDocument fromDB = db.getDocument("123457",AnnualReviewDocument.class);
        assertTrue("Added AR_Document did not match",fromDB.equals(arDoc));
    }
    @Test
    public void updateARDocument()
    {
        arDoc = TestData.defaultTestDoc(AnnualReviewDocument.class);
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
        ieDoc = TestData.defaultTestDoc(InitialEmploymentDocument.class);
        System.out.println("Test: addIEDocument");
        assertTrue("Did not add",db.addDocument(ieDoc));
    }
    @Test
    public void getIEDocument()
    {
        ieDoc = TestData.defaultTestDoc(InitialEmploymentDocument.class);
        System.out.println("Test: getIEDocument");
        db.addDocument(ieDoc);
        InitialEmploymentDocument fromDB = db.getDocument("123456",InitialEmploymentDocument.class);
        assertTrue("Added IE_Document did not match",fromDB.equals(ieDoc));
    }
    @Test
    public void updateIEDocument()
    {
        ieDoc = TestData.defaultTestDoc(InitialEmploymentDocument.class);
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
        pdDoc = TestData.defaultTestDoc(PersonalDetailsDocument.class);
        System.out.println("Test: addPDDocument");
        assertTrue("Did not add",db.addDocument(pdDoc));
    }
    @Test
    public void getPDDocument()
    {
        pdDoc = TestData.defaultTestDoc(PersonalDetailsDocument.class);
        System.out.println("Test: getPDDocument");
        db.addDocument(pdDoc);
        PersonalDetailsDocument fromDB = db.getDocument("123456",PersonalDetailsDocument.class);
        assertTrue("Added PD_Document did not match",fromDB.equals(pdDoc));
    }
    @Test
    public void updatePDDocument()
    {
        pdDoc = TestData.defaultTestDoc(PersonalDetailsDocument.class);
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
        prDoc = TestData.defaultTestDoc(ProbationDocument.class);
        System.out.println("Test: addPRDocument");
        assertTrue("Did not add",db.addDocument(prDoc));
    }
    @Test
    public void getPRDocument()
    {
        prDoc = TestData.defaultTestDoc(ProbationDocument.class);
        System.out.println("Test: getPRDocument");
        assertTrue("Did not add",db.addDocument(prDoc));
        ProbationDocument fromDB = db.getDocument("123457",ProbationDocument.class);
        assertTrue("Added PR_Document did not match",fromDB.equals(prDoc));
    }
    @Test
    public void updatePRDocument()
    {
        prDoc = TestData.defaultTestDoc(ProbationDocument.class);
        System.out.println("Test: updatePRDocument");
        assertTrue("Did not add",db.addDocument(prDoc));
        prDoc.setValue("probation_end_date","14/03/2015");
        db.updateDocument(prDoc);
        ProbationDocument fromDB = db.getDocument("123457",ProbationDocument.class);
        assertTrue("Updated PR_Document did not match",fromDB.equals(prDoc));
    }
    
    /**
     * Promotion Document
     */
    @Test
    public void addPMDocument()
    {
        pmDoc = TestData.defaultTestDoc(PromotionDocument.class);
        System.out.println("Test: addPMDocument");
        assertTrue("Did not add",db.addDocument(pmDoc));
    }
    @Test
    public void getPMDocument()
    {
        pmDoc = TestData.defaultTestDoc(PromotionDocument.class);
        System.out.println("Test: getPMDocument");
        assertTrue("Did not add",db.addDocument(pmDoc));
        PromotionDocument fromDB = db.getDocument("123456",PromotionDocument.class);
        assertTrue("Added PM_Document did not match",fromDB.equals(pmDoc));
    }
    @Test
    public void updatePMDocument()
    {
        pmDoc = TestData.defaultTestDoc(PromotionDocument.class);
        System.out.println("Test: updatePMDocument");
        assertTrue("Did not add",db.addDocument(pmDoc));
        pmDoc.setValue("new_job_title","Other Manager");
        db.updateDocument(pmDoc);
        PromotionDocument fromDB = db.getDocument("123456",PromotionDocument.class);
        assertTrue("Updated PM_Document did not match",fromDB.equals(pmDoc));
    }
    
    /**
     * Salary Increase Document
     */
    @Test
    public void addSIDocument()
    {
        siDoc = TestData.defaultTestDoc(SalaryIncreaseDocument.class);
        System.out.println("Test: addSIDocument");
        assertTrue("Did not add",db.addDocument(siDoc));
    }
    @Test
    public void getSIDocument()
    {
        siDoc = TestData.defaultTestDoc(SalaryIncreaseDocument.class);
        System.out.println("Test: getSIDocument");
        assertTrue("Did not add",db.addDocument(siDoc));
        SalaryIncreaseDocument fromDB = db.getDocument("123456",SalaryIncreaseDocument.class);
        assertTrue("Added SI_Document did not match",fromDB.equals(siDoc));
    }
    @Test
    public void updateSIDocument()
    {
        siDoc = TestData.defaultTestDoc(SalaryIncreaseDocument.class);
        System.out.println("Test: updateSIDocument");
        assertTrue("Did not add",db.addDocument(siDoc));
        siDoc.setValue("new_salary","£20.00ph");
        db.updateDocument(siDoc);
        SalaryIncreaseDocument fromDB = db.getDocument("123456",SalaryIncreaseDocument.class);
        assertTrue("Updated SI_Document did not match",fromDB.equals(siDoc));
    }
    
    /**
     * Termination Document
     */
    @Test
    public void addTMDocument()
    {
        tmDoc = TestData.defaultTestDoc(TerminationDoument.class);
        System.out.println("Test: addTMDocument");
        assertTrue("Did not add",db.addDocument(tmDoc));
    }
    @Test
    public void getTMDocument()
    {
        tmDoc = TestData.defaultTestDoc(TerminationDoument.class);
        System.out.println("Test: getTMDocument");
        assertTrue("Did not add",db.addDocument(tmDoc));
        TerminationDoument fromDB = db.getDocument("123457",TerminationDoument.class);
        assertTrue("Added TM_Document did not match",fromDB.equals(tmDoc));
    }
    @Test
    public void updateTMDocument()
    {
        tmDoc = TestData.defaultTestDoc(TerminationDoument.class);
        System.out.println("Test: updateTMDocument");
        assertTrue("Did not add",db.addDocument(tmDoc));
        tmDoc.setValue("termination_date","01/02/2015");
        db.updateDocument(tmDoc);
        TerminationDoument fromDB = db.getDocument("123457",TerminationDoument.class);
        assertTrue("Updated TM_Document did not match",fromDB.equals(tmDoc));
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
        db.close();
    }
}
