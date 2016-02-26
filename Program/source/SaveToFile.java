
/**
 * Write a description of class SaveToFile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class SaveToFile
{
    private String path;
    private boolean append_to_file = false;

    public SaveToFile(String file_path) {
        path = file_path;
    }

    public SaveToFile(String file_path,boolean append_value) {
        path = file_path;
        append_to_file = append_value;
    }

    public void writeToFile( String textLine ) throws IOException {
        
            FileWriter write = new FileWriter( path , append_to_file);
            PrintWriter print_line = new PrintWriter( write );

            print_line.printf( "%s" + "%n" , textLine);

            print_line.close();
        }
        
    }

