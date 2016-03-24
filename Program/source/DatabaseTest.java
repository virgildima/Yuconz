

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
    Document doc = null;
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
        assertTrue("Did not add AR",db.addDocument(TestData.defaultTestDoc(DocType.AnnualReview)));
        results = db.search(null,null,DocType.AnnualReview);
        assertTrue("AR_Document not listed",results.length==1 && results[0].equals("123457"));
        assertTrue("Did not add IE",db.addDocument(TestData.defaultTestDoc(DocType.InitialEmployment)));
        results = db.search(null,null,DocType.InitialEmployment);
        assertTrue("IE_Document not listed",results.length==1 && results[0].equals("123456"));
        assertTrue("Did not add PD",db.addDocument(TestData.defaultTestDoc(DocType.PersonalDetails)));
        results = db.search(null,null,DocType.PersonalDetails);
        assertTrue("PD_Document not listed",results.length==1 && results[0].equals("123456"));
        assertTrue("Did not add PB",db.addDocument(TestData.defaultTestDoc(DocType.Probation)));
        results = db.search(null,null,DocType.Probation);
        assertTrue("PB_Document not listed",results.length==1 && results[0].equals("123457"));
        assertTrue("Did not add PM",db.addDocument(TestData.defaultTestDoc(DocType.Promotion)));
        results = db.search(null,null,DocType.Promotion);
        assertTrue("PM_Document not listed",results.length==1 && results[0].equals("123456"));
        assertTrue("Did not add SI",db.addDocument(TestData.defaultTestDoc(DocType.SalaryIncrease)));
        results = db.search(null,null,DocType.SalaryIncrease);
        assertTrue("SI_Document not listed",results.length==1 && results[0].equals("123456"));
        assertTrue("Did not add TD",db.addDocument(TestData.defaultTestDoc(DocType.Termination)));
        results = db.search(null,null,DocType.Termination);
        assertTrue("TD_Document not listed",results.length==1 && results[0].equals("123457"));
    }
    
    
    /**
     * Annual Review Document
     */
    @Test
    public void addDocument()
    {
        System.out.println("Test: addDocument");
        assertTrue("Did not add AnnualReview",db.addDocument(TestData.defaultTestDoc(DocType.AnnualReview)));
        assertTrue("Did not add InitialEmployment",db.addDocument(TestData.defaultTestDoc(DocType.InitialEmployment)));
        assertTrue("Did not add PersonalDetails",db.addDocument(TestData.defaultTestDoc(DocType.PersonalDetails)));
        assertTrue("Did not add Probation",db.addDocument(TestData.defaultTestDoc(DocType.Probation)));
        assertTrue("Did not add Promotion",db.addDocument(TestData.defaultTestDoc(DocType.Promotion)));
        assertTrue("Did not add SalaryIncrease",db.addDocument(TestData.defaultTestDoc(DocType.SalaryIncrease)));
        assertTrue("Did not add Termination",db.addDocument(TestData.defaultTestDoc(DocType.Termination)));
    }
    
    private boolean testGet(String staffID,DocType type)
    {
        doc = TestData.defaultTestDoc(type);
        db.addDocument(doc);
        Document fromDB = db.getDocument(staffID,type);
        return doc.equals(fromDB);
    }
    @Test
    public void getDocument()
    {
        System.out.println("Test: getDocument");
        assertTrue("Added AnnualReview Document did not match",testGet("123457",DocType.AnnualReview));
        assertTrue("Added InitialEmployment Document did not match",testGet("123456",DocType.InitialEmployment));
        assertTrue("Added PersonalDetails Document did not match",testGet("123456",DocType.PersonalDetails));
        assertTrue("Added Probation Document did not match",testGet("123457",DocType.Probation));
        assertTrue("Added Promotion Document did not match",testGet("123456",DocType.Promotion));
        assertTrue("Added SalaryIncrease Document did not match",testGet("123456",DocType.SalaryIncrease));
        assertTrue("Added Termination Document did not match",testGet("123457",DocType.Termination));
    }
    
    private boolean testUpdate(String staffID,String attribute,String value,DocType type)
    {
        doc = TestData.defaultTestDoc(type);
        db.addDocument(doc);
        doc.setValue(attribute,value);
        db.updateDocument(doc);
        Document fromDB = db.getDocument(staffID,type);
        return doc.equals(fromDB);
    }
    @Test
    public void updateARDocument()
    {
        System.out.println("Test: updateARDocument");
        assertTrue("Updated AnnualReview        Document did not match",testUpdate("123457","section","SomeOtherSection",DocType.AnnualReview));
        assertTrue("Updated InitialEmployment   Document did not match",testUpdate("123456","section","SomeOtherSection",DocType.InitialEmployment));
        assertTrue("Updated PersonalDetails     Document did not match",testUpdate("123456","mobile","07734567895"      ,DocType.PersonalDetails));
        assertTrue("Updated Probation           Document did not match",testUpdate("123457","probation_end_date","14/03/2015",DocType.Probation));
        assertTrue("Updated Promotion           Document did not match",testUpdate("123456","new_job_title","Other Manager",DocType.Promotion));
        assertTrue("Updated SalaryIncrease      Document did not match",testUpdate("123456","new_salary","£20.00ph",DocType.SalaryIncrease));
        assertTrue("Updated Termination         Document did not match",testUpdate("123457","termination_date","01/02/2015",DocType.Termination));
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
