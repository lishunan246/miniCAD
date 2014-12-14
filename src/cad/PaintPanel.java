package cad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by lishunan on 14-12-13.
 */
public class PaintPanel extends JPanel implements MouseListener{
    enum Mode{
        addString,addCircle,addRectangle,addLine,select,edit;
    }
    protected Point startPoint,endPoint;
    protected ArrayList <Target> arrayList=new ArrayList<Target>();
    public Mode mode=Mode.select;

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Target target=new Target();
        arrayList.add(target);

        for(Target target1:arrayList)
        {
            target1.draw(g);
        }

        this.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint=e.getPoint();
//        System.out.print("start: ");
//        System.out.println(startPoint);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint=e.getPoint();
//        System.out.print("end: ");
//        System.out.println(endPoint);
        switch (mode) {
            case addString:
                arrayList.add(new CADString(startPoint,endPoint));
                System.out.print("dd");
                break;
            case addCircle:
                arrayList.add(new CADCircle(startPoint,endPoint));
                break;
            case addRectangle:
                arrayList.add(new CADRectangle(startPoint,endPoint));
                break;
            case addLine:
                arrayList.add(new CADLine(startPoint,endPoint));
                break;
            case select:
                break;
            case edit:
                break;
        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
