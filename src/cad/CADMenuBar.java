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

        JMenuItem add=new JMenuItem("Quit");
        add.setActionCommand("quit");
        add.addActionListener(paintPanel);
        fileMenu.add(add);

        JMenu addMenu=new JMenu("Add");
        this.add(addMenu);

        JMenuItem jMenuItem=new JMenuItem("String");
        jMenuItem.setActionCommand("addString");
        jMenuItem.addActionListener(paintPanel);
        addMenu.add(jMenuItem);

        this.setVisible(true);
    }
}
