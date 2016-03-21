
/**
 * Abstract class TestData - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class TestData
{
    /**
     * Create a default test document
     * 
     * @param  type   The type of the document to create.
     * @return        The document created.
     */
    public static <T extends Document> T defaultTestDoc(Class<T> type)
    {
        T doc = null;
        try{
            doc = type.newInstance();
            if(type == InitialEmploymentDocument.class)
            {
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
                doc.setValue("section","SomeSection");
                doc.setValue("role","Worker");
                doc.setValue("initial_job_title","Minion");
                doc.setValue("initial_salary","£10.00ph");
                doc.setValue("start_date","21/03/2016");
            } else if(type == SalaryIncreaseDocument.class)
            {
                doc.setValue("staffID","123456");
                doc.setValue("firstname","John");
                doc.setValue("surname","Doe");
                doc.setValue("current_salary","£10.00ph");
                doc.setValue("new_salary","£16.00ph");
            } else if(type == PersonalDetailsDocument.class)
            {
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
            }
            return doc;
        }catch(Exception e)
        {
            System.out.println("Create Test Document encountered an error");
            e.printStackTrace();
        }
        return null;
    }
}
