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
        Target target=new Target(g);
        arrayList.add(target);

        for(Target target1:arrayList)
        {
            target1.draw();
        }

        g.drawString("bannwe",0,40);
    }

    public void actionPerformed(ActionEvent e)
    {
        if("add".equals(e.getActionCommand()))
        {
            System.exit(0);
        }
    }


}
