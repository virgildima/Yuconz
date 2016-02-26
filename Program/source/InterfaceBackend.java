import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author  (Gavin Porter)
 * @version (1.4)
 * 
 * This handles some of the logic and the actions of components in the GUI class
 */
public class InterfaceBackend
{

    
    protected JFrame frame;
    public String password;

    /**
     * These refer to instance varibles or fields thus this allows me to use some in this class.
     */
    public InterfaceBackend()
    {
        
        this.frame = frame;

    }

    public String passwordSHA512(String password)
    {
        

        /**
         * This checks if the pasword length is 6 characters long
         * if its not then the password is set to null.
         */

        if(password.length() != 6  )
        {
            password = null;
            JOptionPane.showMessageDialog(frame,
                "The password must be 6 characters long",
                "Password length incorrect", 
                JOptionPane.INFORMATION_MESSAGE);

        }
        else 
        {
            /**
             * this uses the algorithmn SHA-512 to hide the password.
             * This adds some security to the login.
             * Create a byte array and get the bytes equal to the password.
             * MessageDigest is a one way , and hash outputs a fixed length hash value
             * 
             * CodeReference:
             * http://stackoverflow.com/questions/33085493/hash-a-password-with-sha-512-in-java
             * 
             * password returns a string of numbers.
             */
            byte[] array = password.getBytes();

            try {
                MessageDigest mDigest = MessageDigest.getInstance("SHA-512");
                byte[] bytes  = mDigest.digest(password.getBytes());
                StringBuilder strBuild = new StringBuilder();
                for(int i=0; i< bytes.length ;i++)
                {
                    strBuild.append(Integer.toString((bytes[i] & 0xff) + 0x100, 6).substring(1));
                }
                password = strBuild.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new UnsupportedOperationException(e);
            }
        }
        return password;
    }  

    /**
     * Method which closes the program
     */

    public void quit()
    {
        System.exit(0);
    }

    /**
     * Tells the user informatiob about the login page
     */

    public void about()
    {
        JOptionPane.showMessageDialog(frame,
            "This is the user interface for the Yuconz user review system.",
            "About.", 
            JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * Tells the user what they need to do.
     */

    public void help()
    {
        JOptionPane.showMessageDialog(frame,
            "In order for you to login, you must enter your username in the text field labelled "+ " 'username' " + "and the password in the text field labelled" + " 'password'.",
            "Help.", 
            JOptionPane.INFORMATION_MESSAGE);
    }

    

}
