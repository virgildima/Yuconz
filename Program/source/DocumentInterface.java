import java.io.File;
import java.io.IOException;

import java.nio.file.Path;
/**
 * Write a description of interface DocumentInterface here.
 * 
 * @author Chris Wing
 * @version 0.2
 */
public interface DocumentInterface
{
    static String stringPath = "";
    static File filePath = new File("");
    static Path path = filePath.toPath();
   
    
    /**
     * public method setValue()
     * 
     * Method sets a new value to a documents attribute based on attributeName paramater
     * that is passed to it.
     * 
     * @param attributeName: The name of the attribute you wish to change the value of.
     * @param value: The new value you wish to set attributeName as.
     * 
     * No meaningful return type. Either True or Void.
     */
    public void setValue(String artibuteName, String newValue);
    
    /**
     * public method getData()
     * 
     * Gets data of document.
     * 
     * Returns data in a as a String.
     */
    public String getData(String dataType);
}
