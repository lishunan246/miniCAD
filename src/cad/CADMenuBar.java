package cad;

import javax.swing.*;

/**
 * Created by lishunan on 14-12-13.
 */
public class CADMenuBar extends JMenuBar {
    CADMenuBar()
    {
        JMenu fileMenu=new JMenu("FILE");
        this.add(fileMenu);
        JMenuItem add=new JMenu("add");

        fileMenu.add(add);

        this.setVisible(true);
    }
}
