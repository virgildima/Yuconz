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
 * @version (1.0)
 */
public class InterfaceBackend
{

    private GUI gui;
    private JFrame frame;


    /**
     * These refer to instance varibles or fields thus this allows me to use some in this class.
     */
    public InterfaceBackend(GUI gui)
    {
        this.gui = gui;
        this.frame = frame;
        

    }
    
    
    public String passwordSHA512(String password)
    {
        GUI gui = new GUI();
        gui.passwordString = password;
        if(password.length() > 6 || password.length() < 6  )
        {
            JOptionPane.showMessageDialog(frame,
                "The password must be 6 characters long",
                "Password length incorrect", 
                JOptionPane.INFORMATION_MESSAGE);

        }
        else
        {
            byte[] array = gui.passwordString.getBytes();

            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-512");
                byte[] bytes  = digest.digest(gui.passwordString.getBytes());
                StringBuilder strBuild = new StringBuilder();
                for(int i=0; i< bytes.length ;i++)
                {
                    strBuild.append(Integer.toString((bytes[i] & 0xff) + 0x100, 6).substring(1));
                }
                gui.passwordString = strBuild.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new UnsupportedOperationException(e);
            }
        }
        return gui.passwordString;
    }

    public void checkPasswordUsername()
    {
        
        
        if(gui.usernameField.getText().equals("username")&& gui.passwordString.equals(gui.passwordField.getPassword()))
        {
            JOptionPane.showMessageDialog(frame,
                "Logged in",
                "User Details Accepted.", 
                JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(false);
            frame.dispose();
            gui.afterLoginFrame();
        }

        else
        {
            JOptionPane.showMessageDialog(frame,
                "Incorrect Login Details",
                "User details are incorrect.", 
                JOptionPane.INFORMATION_MESSAGE);
        }

    }


    public GUI gui()
    {
        return gui;
    }

    /**
     * Method which closes the program
     */

    public void quit()
    {
        System.exit(0);
    }

    /**
     * 
     */

    public void about()
    {
        JOptionPane.showMessageDialog(frame,
            "This is the user interface for the Yuconz user review system.",
            "About.", 
            JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * 
     */

    public void help()
    {
        JOptionPane.showMessageDialog(frame,
            "In order for you to login, you must enter your username in the text field labelled "+ " 'username' " + "and the password in the text field labelled" + " 'password'.",
            "Help.", 
            JOptionPane.INFORMATION_MESSAGE);
    }

}
