package cad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lishunan on 14-12-13.
 */
public class CADMenuBar extends JMenuBar implements ActionListener{
    protected JMenu targetMenu;
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

        targetMenu=new JMenu("Items");
        this.add(targetMenu);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("addString".equals(e.getActionCommand()))
        {
            JMenuItem jMenu=new JMenuItem("dd");
            targetMenu.add(jMenu);
            targetMenu.revalidate();
        }
        this.revalidate();
    }
}
