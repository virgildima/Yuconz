import java.util.HashMap;

/**
 * AnnualReview implementaion document
 * 
 * @author Chris Wing 
 * @version 0.1
 */
public class AnnualReviewDocument extends Document
{
    
    private String[] attributeList = {"staffID", "name", "manager", "second_manager", "section", "job_title", "performance_summary", "personal_goals_achieved", "future_goals_set", 
                                        "reviewer_comments", "reviewer_recommendation", "reviewer_signature", "manager_signature", "second_manager_signatue", "date_of_review"};
                                        
    
                                        
     /**
     * public method setValue()
     * 
     * Method sets a new value to a documents attribute.
     * 
     * @param attributeName: The name of the attribute you wish to change thea value of.
     * @param newValue: The new value you wish to set attributeName as.
     * 
     * No meaningful return type. Either True or Void.
     */
    @SuppressWarnings("unchecked")
    public void setValue(String attributeName, String newValue){
        
        setValue(attributeList, attributeName, newValue);
    }
    
     /**
     * public method setValue()
     * 
     * Method gets the value to a documents attribute.
     * 
     * @param attributeName: The name of the attribute you wish to change thea value of.
     * 
     * Returns a String as a return type.
     */
    public void getValue(String attributeName){
    
        getValue(attributeList, attributeName);
    }
    
    public HashMap getData(){
    
        return getData();
    }
}
