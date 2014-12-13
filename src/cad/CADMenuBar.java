package cad;

import javax.swing.*;

/**
 * Created by lishunan on 14-12-13.
 */
public class CADMenuBar extends JMenuBar {
    CADMenuBar(PaintPanel paintPanel)
    {
        JMenu fileMenu=new JMenu("FILE");
        this.add(fileMenu);
        JMenuItem add=new JMenuItem("add");
        add.setActionCommand("add");
        add.addActionListener(paintPanel);


        fileMenu.add(add);

        this.setVisible(true);
    }
}
