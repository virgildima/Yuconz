
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
    public static DocumentC defaultTestDoc(DocType type)
    {
        DocumentC doc = new DocumentC(type);
        if(type == DocType.AnnualReview)
        {
            doc.setValue("staffID","123457");
            doc.setValue("name","James Doe");
            doc.setValue("manager","John Doe");
            doc.setValue("second_manager","Jeff Doe");
            doc.setValue("section","Some Section");
            doc.setValue("job_title","Minion");
            doc.setValue("performance_summary","Could do much better.");
            doc.setValue("personal_goals_achieved","None.");
            doc.setValue("future_goals_set","Arrive at work on time.");
            doc.setValue("reviewer_comments","James does not seem interested in working.");
            doc.setValue("reviewer_recommendation","Probation");
            doc.setValue("reviewee_signature","J_Doe");
            doc.setValue("manager_signature","J_Doe");
            doc.setValue("second_manager_signatue","J%D");
            doc.setValue("date_of_reviewee_signature","05/01/2015");
            doc.setValue("date_of_manager_signature","05/01/2015");
            doc.setValue("date_of_second_manager_signature","05/01/2015");
        } else if(type == DocType.InitialEmployment)
        {
            doc.setValue("staffID","123456");
            doc.setValue("cv_filePath","../CVs/123456.docx");
            doc.setValue("interview_Notes","Cool Guy");
            doc.setValue("interviewers","Jeff Doe");
            doc.setValue("section","Some Section");
            doc.setValue("role","Worker");
            doc.setValue("initial_job_title","Minion");
            doc.setValue("initial_salary","£10.00ph");
            doc.setValue("start_date","21/03/2016");
        } else if(type == DocType.PersonalDetails)
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
        } else if(type == DocType.Probation)
        {
            doc.setValue("staffID","123457");
            doc.setValue("firstname","James");
            doc.setValue("surname","Doe");
            doc.setValue("probation_reason","Put an electromagnet next to the office door.");
            doc.setValue("probation_start_date","14/01/2015");
            doc.setValue("probation_end_date","14/02/2015");
            doc.setValue("manager_signature","J_Doe");
        } else if(type == DocType.Promotion)
        {
            doc.setValue("staffID","123456");
            doc.setValue("firstname","John");
            doc.setValue("surname","Doe");
            doc.setValue("current_job_title","Lower Manager");
            doc.setValue("current_section","Sales");
            doc.setValue("new_job_title","Middle Manager");
            doc.setValue("new_job_section","Sales");
            doc.setValue("starting_date","01/04/2016");
        } else if(type == DocType.SalaryIncrease)
        {
            doc.setValue("staffID","123456");
            doc.setValue("firstname","John");
            doc.setValue("surname","Doe");
            doc.setValue("current_salary","£10.00ph");
            doc.setValue("new_salary","£16.00ph");
            doc.setValue("start_date","01/04/2016");
        } else if(type == DocType.Termination)
        {
            doc.setValue("staffID","123457");
            doc.setValue("firstname","James");
            doc.setValue("surname","Doe");
            doc.setValue("termination_reason","Put paint in the sprinkler system.");
            doc.setValue("termination_date","07/02/2015");
            doc.setValue("manager_name","John Doe");
            doc.setValue("second_manager_name","Jeff Doe");
            doc.setValue("manager_comment","It was inevitable.");
            doc.setValue("second_manager_comment","It could have been worse.");
            doc.setValue("manager_signature","J_Doe");
            doc.setValue("second_manager_signature","J%D");
        }
        return doc;
    }
    
    
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
            if(type == AnnualReviewDocument.class)
            {
                doc.setValue("staffID","123457");
                doc.setValue("name","James Doe");
                doc.setValue("manager","John Doe");
                doc.setValue("second_manager","Jeff Doe");
                doc.setValue("section","Some Section");
                doc.setValue("job_title","Minion");
                doc.setValue("performance_summary","Could do much better.");
                doc.setValue("personal_goals_achieved","None.");
                doc.setValue("future_goals_set","Arrive at work on time.");
                doc.setValue("reviewer_comments","James does not seem interested in working.");
                doc.setValue("reviewer_recommendation","Probation");
                doc.setValue("reviewee_signature","J_Doe");
                doc.setValue("manager_signature","J_Doe");
                doc.setValue("second_manager_signatue","J%D");
                doc.setValue("date_of_reviewee_signature","05/01/2015");
                doc.setValue("date_of_manager_signature","05/01/2015");
                doc.setValue("date_of_second_manager_signature","05/01/2015");
            } else if(type == InitialEmploymentDocument.class)
            {
                doc.setValue("staffID","123456");
                doc.setValue("cv_filePath","../CVs/123456.docx");
                doc.setValue("interview_Notes","Cool Guy");
                doc.setValue("interviewers","Jeff Doe");
                doc.setValue("section","Some Section");
                doc.setValue("role","Worker");
                doc.setValue("initial_job_title","Minion");
                doc.setValue("initial_salary","£10.00ph");
                doc.setValue("start_date","21/03/2016");
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
            } else if(type == ProbationDocument.class)
            {
                doc.setValue("staffID","123457");
                doc.setValue("firstname","James");
                doc.setValue("surname","Doe");
                doc.setValue("probation_reason","Put an electromagnet next to the office door.");
                doc.setValue("probation_start_date","14/01/2015");
                doc.setValue("probation_end_date","14/02/2015");
                doc.setValue("manager_signature","J_Doe");
            } else if(type == PromotionDocument.class)
            {
                doc.setValue("staffID","123456");
                doc.setValue("firstname","John");
                doc.setValue("surname","Doe");
                doc.setValue("current_job_title","Lower Manager");
                doc.setValue("current_section","Sales");
                doc.setValue("new_job_title","Middle Manager");
                doc.setValue("new_job_section","Sales");
                doc.setValue("starting_date","01/04/2016");
            } else if(type == SalaryIncreaseDocument.class)
            {
                doc.setValue("staffID","123456");
                doc.setValue("firstname","John");
                doc.setValue("surname","Doe");
                doc.setValue("current_salary","£10.00ph");
                doc.setValue("new_salary","£16.00ph");
                doc.setValue("start_date","01/04/2016");
            } else if(type == TerminationDoument.class)
            {
                doc.setValue("staffID","123457");
                doc.setValue("firstname","James");
                doc.setValue("surname","Doe");
                doc.setValue("termination_reason","Put paint in the sprinkler system.");
                doc.setValue("termination_date","07/02/2015");
                doc.setValue("manager_name","John Doe");
                doc.setValue("second_manager_name","Jeff Doe");
                doc.setValue("manager_comment","It was inevitable.");
                doc.setValue("second_manager_comment","It could have been worse.");
                doc.setValue("manager_signature","J_Doe");
                doc.setValue("second_manager_signature","J%D");
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
