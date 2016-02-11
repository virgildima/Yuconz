
import java.io.IOException;
/**
 * Write a description of class FileData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileData
{
    public static void main(String[] args) throws IOException{
        String file_name = "C:/Users/Virgil/Desktop/test.txt";
        try{
            ReadFile file = new ReadFile(file_name);
            String[]aryLines = file.OpenFile();

            int i;
            for(i=0;i<aryLines.length;i++) {
                System.out.println(aryLines[i]);
            }
        }
        catch(IOException e) {
            System.out.println("Sorry, unable to open!");
        }

        // Write to a file

        try {
            SaveToFile data = new SaveToFile( file_name , true );
            data.writeToFile( "This is another line of text" );
        }
        catch (IOException e) {
            System.out.println( "Text File Written To" );
        }
    }
}