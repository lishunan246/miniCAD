package cad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by lishunan on 14-12-13.
 */
public class PaintPanel extends JPanel implements ActionListener{
    ArrayList <Target> arrayList=new ArrayList<Target>();
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Target target=new Target();
        arrayList.add(target);

        for(Target target1:arrayList)
        {
            target1.draw(g);
        }


    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());
        if("quit".equals(e.getActionCommand()))
        {
            System.exit(0);
        }
        else if("addString".equals(e.getActionCommand()))
        {
            arrayList.add(new CADString());
        }
        this.repaint();
    }


}
