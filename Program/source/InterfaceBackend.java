import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

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

    public GUI gui()
    {
        return gui;
    }

}
